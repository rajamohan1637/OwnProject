<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="text-align: center;">
	<h3>Please Enter the following details</h3>
	<br>
	<form action="http://localhost:8070/ExaminationPortal/ForgetPasswordServlet" method="post">
 		<table align="center">
			<tr>
				<td>User Name :</td>
				<td><input type="text" name="username" /><br></td>
			</tr>
			<tr>
				<td>Your Email ID :</td>
				<td><input type="text" name="email" /><br></td>
			</tr>
			<tr>
				<td>Mobile Number :</td>
				<td><input type="text" name="mobnum" /><br></td>
			</tr>
			<tr>
				<td><br><button type="submit">Submit</button></td>
				<td><br><button type="reset">Reset</button></td>
			</tr>
		</table>

	</form>
</body>
</html>