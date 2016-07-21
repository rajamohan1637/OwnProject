<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="text-align: center;">
	<h1>Please register yourself to avail our services ...!</h1>
	<br>
	<br>
	<form action="http://localhost:8070/ExaminationPortal/RegisterServlet" method="POST">
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
				<td>Choose Password :</td>
				<td><input type="password" name="password"><br></td>
			</tr>
			<tr>
				<td>First Name :</td>
				<td><input type="text" name="fname" /><br></td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td><input type="text" name="lname" /><br></td>
			</tr>
			<tr>
				<td>Mobile Number :</td>
				<td><input type="text" name="mobnum" /><br></td>
			</tr>
			<tr>
				<td>Qualification :</td>
				<td><select name="qual" id="qual"> 
						<optgroup label="Qualification">
							<option>B.Tech - CSE</option>
							<option>B.Tech - ECE</option>
							<option>B.Tech - IT</option>
							<option>B.Tech - EEE</option>
							<option>B.Tech - EIE</option>
						</optgroup>
				</select><br></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td><br><button type="submit">Submit</button></td>
				<td><br><button type="reset">Reset</button></td>
			</tr>
		</table>
	</form>
</body>
</html>