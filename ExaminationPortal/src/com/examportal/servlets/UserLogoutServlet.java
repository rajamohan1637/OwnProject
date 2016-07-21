package com.examportal.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.examportal.dto.UserLoginDTO;


@WebServlet("/UserLogoutServlet")
public class UserLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			UserLoginDTO user = new UserLoginDTO();
			user.removeUserName();
			user.removePassword();
			HttpSession session = request.getSession(false);
			session.removeAttribute("currentSessionUser");
			session.invalidate();
			response.sendRedirect("user_login.jsp");
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}

}
