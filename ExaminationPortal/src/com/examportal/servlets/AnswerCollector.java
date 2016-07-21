package com.examportal.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.examportal.classes.AnswerChecker;

public class AnswerCollector extends HttpServlet{
	
	private List<Integer> qtonNum = new ArrayList<Integer>();
	private List<String> chkdAnsList = new ArrayList<String>();
	
	private static int count = 0;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
		
		Map<Integer, String> crtAnsList = (Map<Integer, String>) request.getServletContext().getAttribute("qtonAnsPair");
		String total =  request.getParameter("qtonCount"); 
		int totalQtonsGiven = Integer.parseInt(total);
		int qtonsOnPriorityBase = totalQtonsGiven / 3;
		int qtonNoCount = totalQtonsGiven;

		//List of qtons given in the exam
		for (int qtonActlNo = 1; qtonActlNo <= 3; qtonActlNo++) {
			for(int i=1;i<=qtonsOnPriorityBase;i++){
				String str = request.getParameter("qtonNo"+qtonActlNo+i);
				System.out.println(str+qtonActlNo+i); 
				int in = Integer.parseInt(str);
				qtonNum.add(in);
				out.println("<br>Picked Qton : "+in);
			}
		}
		//List of answers the user has selected
		for (int sletdAns = 1; sletdAns <= 3; sletdAns++) {
			for(int i=1;i<=qtonsOnPriorityBase;i++){
				String str = request.getParameter("Options"+sletdAns+i);
				chkdAnsList.add(str);
				out.println("<br>Picked Answer : "+str); 
			}
		}
		
		AnswerChecker checker = new AnswerChecker(crtAnsList, qtonNum, chkdAnsList);
		checker.getPickedQtonCorrectAnswers();
		checker.getPickedQtonSelectedAnswers();
		int crtAns = checker.getTotalMarks();
		out.println("<h3>You Got "+crtAns+" marks out off "+qtonNoCount+"</h3>");
		
		out.println("<br><br><br>Yes...! You made it. All The best. You have givens "+qtonNoCount+" number of questions." );
	}
}
