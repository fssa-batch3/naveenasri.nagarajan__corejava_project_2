package com.fssa.dynamicdesign.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.fssa.dynamicdesign.dao.exception.DatabaseDriverNotFoundException;

public class ConnectionUtil {

	// connect to database
	public static Connection getConnection() throws SQLException {

		// local host
//		final String dbUrl = "jdbc:mysql://localhost:3306/project";
//		final String dbUser = "root";
//		final String dbPassword ="123456";

		// Cloud DB
		final String DB_URL = System.getenv("DB_URL_1");
		final String DB_USER = System.getenv("DB_USER_1");
		final String DB_PASSWORD = System.getenv("DB_PASSWORD_1");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DatabaseDriverNotFoundException("Database driver class not found", e);
		}

		
	}
}
