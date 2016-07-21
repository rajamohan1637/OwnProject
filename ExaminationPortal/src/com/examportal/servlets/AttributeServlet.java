package com.examportal.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.examportal.classes.QtonFetchClass;
import com.examportal.dto.QtonDTO;

/**
 * Servlet implementation class AttributeServlet
 */
@WebServlet("/AttributeServlet")
public class AttributeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HashMap<Integer, QtonDTO> map = new QtonFetchClass().getQtonList(1);
		out.println(map.size());

		Collection<QtonDTO> in = map.values();
		HttpSession session = request.getSession();
		for (QtonDTO i : in) {
			session.setAttribute("qton", i);
		}
	}
}
