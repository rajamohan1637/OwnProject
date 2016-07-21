<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="text-align: center;">
	<div>
		<h1>Please Login here ...!</h1>
		<br> <br> <br>
		<form
			action="http://localhost:8070/ExaminationPortal/UserLogInServlet"
			method="POST">
			<table align="center">
				<tr>
					<td>Enter User Name :</td>
					<td><input type="text" name="username" /><br></td>
				</tr>
				<tr>
					<td>Enter Password :</td>
					<td><input type="password" name="password"><br></td>
				</tr>
				<tr>
					<td><button type="submit">Submit</button></td>
					<td><button type="reset">Reset</button></td>
				</tr>
			</table>
		</form>
	</div>
	<br><br><br>
	<div>
		<table align="center">
			<tr>
				<td><a href="http://localhost:8070/ExaminationPortal/forgetPassword.jsp">Forgot Password?</a></td>
			</tr><tr><tr><tr>
			<tr>
				<td><a href="http://localhost:8070/ExaminationPortal/reg_form.jsp">SignUp Here</a></td>
			</tr>
		</table>
	</div>
</body>
</html>