<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="count" value="0" scope="application" />

	<%
		int i = 0;
		while (i < 3) {
	%>
	
	<c:forEach var="row" begin="0" end="1" step="1" varStatus="loop">
		<c:set var="count" value="${count+1}" />
		Count : <c:out value="${count}" />
	</c:forEach>
	<%
	i++;
		}
	%>
</body>
</html>