package com.library.app.implemenations;
/**
 * @author SaranBayi
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	static Connection connection = null;

	public static Connection getDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=12345");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

}
