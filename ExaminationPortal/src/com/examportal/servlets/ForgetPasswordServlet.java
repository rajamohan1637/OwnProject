package com.examportal.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examportal.jdbc.MyJDBCClass;

@WebServlet("/ForgetPasswordServlet")
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static Connection currentCon = null;
	static ResultSet rs = null;
	PreparedStatement stmt = null;
	int i = 0;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String un = request.getParameter("username");
		String email = request.getParameter("email");
		String mobnum = request.getParameter("mobnum");

		String query = "select * from examination.user_login where username = '" + un + "'";
		try {
			currentCon = MyJDBCClass.getConnection();
			stmt = currentCon.prepareStatement(query);
			rs = stmt.executeQuery();
				while (rs.next()) {
					if ((rs.getString("username").equals(un)) && (rs.getString("email").equals(email))
							&& (rs.getString("mobnum").equals(mobnum))) {
						String password = rs.getString("password");
						out.println("Congratulations..!. You recovered your account.");
						out.println("<br>Your current password is <h3> " + password + "</h3>. Now your can login.");
						RequestDispatcher rd = request.getRequestDispatcher("/intermediate.jsp");
						rd.include(request, response);
					} else {
						out.println(
								"<h4><font color='RED'>User does not exist. Please try again with correct details..!</font></h4>");
					}
			}
		} catch (

		Exception ex) {
			out.println(
					"<h4><font color='RED'>User does not exist. Please try again with correct details..!</font></h4>"
							+ ex);
		}

	}

}
