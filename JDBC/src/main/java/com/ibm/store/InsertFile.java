package com.ibm.store;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InsertFile {
	
	//pick the file from particular location and save the content in database
	
	public static void main(String[] args) {
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/jdbc";
			String username = "root";
			String password = "1234";
			
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, username, password);
		
		//for insert file
		PreparedStatement stmt=con.prepareStatement("insert into filedb values(?,?)");
		File f = new File("C:\\Users\\dell\\eclipse-workspace-2021-06 JDBC\\JDBC\\src\\main\\resources\\textfile.txt");
		
		FileReader fr=new FileReader(f);
		ps.setInt(1,103);
		ps.setCharacterStream(2,fr,(int)f.length());
		
		int i=ps.executeUpdate();
		System.out.println(i+"records affected");
		
		//after running check database
		//for retrieve file
		//create filedb table
		
		PreparedStatement ps=con.prepareStatement("select * from filedb");
		ResultSet rs = ps.executeQuery();
		rs.next(); 			//now on 1st row		
		Clob r=c.getCharacterStream();
		Reader r=c.getCharacterStream();
		
		//just create a file content will store from db to file
		FileWriter fw=new FileWriter("C:\\Users\\dell\\eclipse-workspace-2021-06 JDBC\\JDBC\\src\\main\\resources\\recievedfile.txt");
		
		int i;

		while((i=r.red())!=-1)
			fw.close();
		
		
		System.out.println("success");
		
		con.close();
		} catch (Exception e) {e.printStackTrace();}
	}
}
