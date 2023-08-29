package com.fssa.dynamicdesign.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	// connect to database
	public static Connection getConnection() throws SQLException {

		// local host
		final String dbUrl = System.getenv("jdbc:mysql://localhost:3306/project");
		final String dbUser = System.getenv("root");
		final String dbPassword = System.getenv("123456");

		// Cloud DB
//		final String dbUrl = System.getenv("DB_URL");
//		final String dbUser = System.getenv("DB_USER");
//		final String dbPassword = System.getenv("DB_PASSWORD");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Database driver class not found", e);
		}
		// return DriverManager.getConnection("jdbc:mysql://localhost:3306/project",
		// "root", "123456");
		return DriverManager.getConnection(dbUrl, dbUser, dbPassword);

	}
}
