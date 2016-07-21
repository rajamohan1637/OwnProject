<%@page import="java.util.ArrayList"%>
<%@page import="com.examportal.dto.QtonDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="http://localhost:8070/ExaminationPortal/AnswerChecker"
		method="post">
		<h2>
			<%
				ArrayList<QtonDTO> qdto = (ArrayList<QtonDTO>) request.getAttribute("QtonList");
				out.print(request.getAttribute("question"));
			%>
		</h2>
		<br> <br> A : <input type="radio" name="Options" id="A"
			value="A">
		<%
			
		%><br> B : <input type="radio" name="Options" id="B" value="B">
		<%
			
		%><br> C : <input type="radio" name="Options" id="C" value="C">
		<%
			
		%><br> D : <input type="radio" name="Options" id="D" value="D">
		<%
			
		%><br>
		<button type="submit" value="Submit">Submit</button>
	</form>

</body>
</html>