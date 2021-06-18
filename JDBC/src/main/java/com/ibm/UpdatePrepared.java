package com.ibm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.naming.spi.DirStateFactory.Result;

public class UpdatePrepared {

	public static void main(String[] args) {

		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/jdbc";
			String username = "root";
			String password = "1234";
			
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, username, password);
		
		//for update
		PreparedStatement stmt=con.prepareStatement("update emp set name=? where id=?");
		stmt.setString(1, "Suraj"); 	// 1 specifies the first parameter in the query i.e. name
		stmt.setString(2, 101);
		
		int i = stmt.executeUpdate();
		System.out.println(i + "records updated");
		
		//for retrieve
		
		PreparedStatement stmt=con.prepareStatement("select * from emp");
		
		Result rs = stmt.executeQuery();
		while(rs.next()) 
		{
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
		}
		
		
		//for delete
		PreparedStatement stmt=con.prepareStatement("delete from emp where id=?");
		stmt.setInt(1,101);
				
		int i = stmt.executeUpdate();
		System.out.println(i + "records deleted");
		
		
		con.close();
		
		} catch(Exception e) { System.out.println(e); }
	}		
}
