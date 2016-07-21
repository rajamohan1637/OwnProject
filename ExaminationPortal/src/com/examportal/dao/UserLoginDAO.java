package com.examportal.dao;

import java.sql.*;

import com.examportal.dto.UserLoginDTO;
import com.examportal.jdbc.MyJDBCClass;

public class UserLoginDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;

	public static UserLoginDTO login(UserLoginDTO user) {

		PreparedStatement pstmt = null;

		String username = user.getUsername();
		String password = user.getPassword();

		String searchQuery = "select * from examination.user_login where username='" + username + "' AND password='"
				+ password + "'";

		try {
			// connect to DB
			currentCon = MyJDBCClass.getConnection();
			pstmt = currentCon.prepareStatement(searchQuery);
			rs = pstmt.executeQuery();
			boolean more = rs.next();
			// if user does not exist set the isValid variable to false
			if (!more) {
				//System.out.println("Sorry, you are not a registered user! Please sign up first");
				user.setValid(false);
			}

			// if user exists set the isValid variable to true
			else if (more) {
				System.out.println("Wow...! Your account already exist.");
				String firstName = rs.getString("fname");
				String lastName = rs.getString("lname");

				System.out.println("Welcome " + firstName);
				user.setfName(firstName);
				user.setlName(lastName);
				user.setValid(true);
			}
		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}

		// some exception handling
		finally {
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

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return user;
	}
}