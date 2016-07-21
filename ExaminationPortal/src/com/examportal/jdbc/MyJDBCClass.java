package com.examportal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyJDBCClass {

	static Connection conn;
	static String url;
	static ResultSet rs = null;
	static PreparedStatement pstmt = null;

	public static Connection getConnection() {

		try {
			String url = "jdbc:mysql://localhost/examination?";
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn = DriverManager.getConnection(url, "root", "root");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return conn;
	}

	public static void closeAlltheObjects() {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
			}
			rs = null;
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
			}
			pstmt = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
			}

			conn = null;
		}
	}
}
