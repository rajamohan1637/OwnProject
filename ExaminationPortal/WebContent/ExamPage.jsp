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

	<form id="form_qton"
		action="http://localhost:8070/ExaminationPortal/AnswerCollector"
		method="post">
		
		<h2>
			<%
			    QtonDTO dto = (QtonDTO) session.getAttribute("qton");
				out.print(dto.getQton());
			%>
		</h2>
		<br> <br> A : <input type="radio" name="Options" id="A"
			value="A">
		<%
			out.print(dto.getOpt1());
		%><br> B : <input type="radio" name="Options" id="B" value="B">
		<%
			out.print(dto.getOpt2());
		%><br> C : <input type="radio" name="Options" id="C" value="C">
		<%
			out.print(dto.getOpt3());
		%><br> D : <input type="radio" name="Options" id="D" value="D">
		<%
			out.print(dto.getOpt4());
		%><br>
		
		<input type="submit" id="next" value="NEXT" />  
	</form>

</body>
</html>