package com.ibm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/world";
	
	// Datebase Credentials
	static final String USERNAME = "root";
	static final String PASSWORD = "1234";
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		JDBCDemo jdbcdemo = new JDBCDemo();
		jdbcdemo.getCityInformation();
	}
	
	private void getCityInformation() throws SQLException, ClassNotFoundException {
		
		Connection connection = null;
		Statement stat = null;
		
		try {
			
			//Step 1: Register JDBC Driver
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step 2: Open a connection
			System.out.println("Connecting to database...");
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			
			//Step 3: Execute a query
			stat = connection.createStatement();
			String sql = "select ID,Name,CountryCode, District, Population from city where id<21";
			
			//Select * from city
			ResultSet rs = stat.executeQuery(sql);
			
			//Step 4: Extract data from result set
			while(rs.next())
				{
				// Retrieve by column name
				int id = rs.getInt("ID");
				String name = rs.getString("Name");
				String countryCode = rs.getString("CountryCode");
				String district = rs.getString("District");
				int population = rs.getInt("Population");
			
				// Display Values
				System.out.println("ID " + id);
				System.out.println("Name " + name);
				System.out.println("CountryCode " + countryCode);
				System.out.println("District " + district);
				System.out.println("Population " + population);
		}
		
		//Close Resources
		connection.close();
	} 
	
		catch(SQLException se) {
		se.printStackTrace();
	}
	
	finally {
		connection.close();	
		}
	}
}