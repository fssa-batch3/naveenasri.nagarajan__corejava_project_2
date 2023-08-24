package com.fssa.dynamicdesign.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {

	// connect to database
	public static Connection getConnection() throws SQLException {

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "123456");

	}
}
