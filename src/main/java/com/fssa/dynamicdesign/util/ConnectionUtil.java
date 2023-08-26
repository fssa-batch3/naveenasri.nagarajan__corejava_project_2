package com.fssa.dynamicdesign.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	// connect to database
	public static Connection getConnection() throws SQLException {

		// Database URL and credentials
//		final String DB_URL;
//		final String DB_USER;
//		final String DB_PASSWORD;

//		final String DB_URL = System.getenv("DB_URL");
//		final String DB_USER = System.getenv("DB_USER");
//		final String DB_PASSWORD = System.getenv("DB_PASSWORD");
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new RuntimeException("Unable to connect Database", e);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			throw new RuntimeException("Database driver class not found", e);
//
//		}

//	
//		String DB_URL;
//		String DB_USER;
//		String DB_PASSWORD;
//		
//		if (System.getenv("CI") != null) {
//			DB_URL = System.getenv("DB_URL");
//			DB_USER = System.getenv("DB_USER");
//			DB_PASSWORD = System.getenv("DB_PASSWORD");
//		} else {
//			Dotenv env = Dotenv.load();
//			DB_URL = env.get("DB_URL");
//			DB_USER = env.get("DB_USER");
//			DB_PASSWORD = env.get("DB_PASSWORD");
//		}
//

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Database driver class not found", e);
		}
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "123456");

	}
}
