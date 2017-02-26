package com.project.db;

import java.sql.*;

public class DBUtils {
	static Connection conn = null;
	static Statement st = null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;

	public static Connection connectToDb() {
		try {
			String url = "jdbc:mysql://localhost:3306/student_registration_system_db";
			String username = "root";
			String password = "root123";

			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			System.out.println("Something is wrong with driver");

		} catch (SQLException e) {
			System.out.println("SQL Exception... check ur query");
		}
		return conn;
	}

	public static Statement getStatement(Connection con) {
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}

	public static PreparedStatement getPreparedStatement(Connection con,
			String query) {
		try {
			pst = con.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pst;
	}

	public static void closeConnections() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (pst != null)
				pst.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("Connection not closed properly...");
		}
	}
}
