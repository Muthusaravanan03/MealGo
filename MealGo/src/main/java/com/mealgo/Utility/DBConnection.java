package com.mealgo.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String URL = "jdbc:mysql://localhost:3306/food_delivery_application";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Saravanan@9159";
	private static Connection con = null; 
	
	public static Connection getConnection() {

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver"); // FORCE LOAD

	        Connection con = DriverManager.getConnection(
	                URL,
	                USERNAME,
	                PASSWORD
	        );

	        System.out.println("DB CONNECTED SUCCESSFULLY");

	        return con;

	    } catch (ClassNotFoundException e) {
	        System.out.println("DRIVER NOT FOUND");
	        e.printStackTrace();

	    } catch (SQLException e) {
	        System.out.println("CONNECTION FAILED");
	        e.printStackTrace();
	    }

	    return null;
	}
}
