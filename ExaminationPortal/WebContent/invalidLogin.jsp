<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	response.setHeader("Cache-Control", "no-store,must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", -1);
	new java.util.Date();
%>
<html>

<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Invalid Login</title>
</head>

<body>

	<h4 align="center" style="color: RED;">Sorry, You are not user of
		ExaminationPortal..!. Please sign up first</h4>
	<%
		RequestDispatcher rd = request.getRequestDispatcher("reg_form.jsp");
		rd.include(request, response);
	%>

</body>

</html>
