package com.examportal.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examportal.dto.UserLoginDTO;
import com.examportal.jdbc.MyJDBCClass;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static Connection currentCon = null;
	static ResultSet rs = null;
	PreparedStatement stmt = null;
	
	int i=0;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("Registering code goes here ...");

		String un = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String mobnum = request.getParameter("mobnum");
		String qual = request.getParameter("qual");
		String address = request.getParameter("address");
		
		UserLoginDTO dto = new UserLoginDTO();
		dto.setfName(un);  

		String searchQuery = "insert into examination.user_login values (default,'" + un + "', '" + email + "' , '"+ password + "' , '"
				+ fname + "' , '" + lname + "' , '" + mobnum + "' , '" + qual + "' , '" + address + "');";
		System.out.println(searchQuery);
		try {
			currentCon = MyJDBCClass.getConnection();
			stmt = currentCon.prepareStatement(searchQuery);
			i = stmt.executeUpdate();
			out.print(i+ " rows effected.");

		} catch (Exception ex) {
			System.out.println("Registration failed .. Please try again later. Thank you...! " + ex);
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

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/intermediate.jsp");
		rd.forward(request, response);
	}
}
