<%@page import="com.examportal.classes.QtonFetchClass"%>
<%@page import="com.examportal.dto.QtonCollDTO"%>
<%@page import="java.util.*"%>
<%@page import="com.examportal.dto.QtonDTO"%>
<%@page import="com.examportal.dto.UserLoginDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.examportal.jdbc.MyJDBCClass"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>

	<c:set var="qtonCount" value="0" scope="application" />
	<% 
	QtonFetchClass qFetch = new QtonFetchClass();
	int pri = 1;
	int groupId = 1;
	int qtonsGiven = 1;
	
	QtonDTO dto = new QtonDTO();
	Map<Integer, String> qtonAnsPair = new HashMap<Integer, String>();
	
	while(pri <= 3){
		Set<QtonDTO> qdto = qFetch.getQtonOnPriority(pri);
		
		Iterator<QtonDTO> it = qdto.iterator();
		while(it.hasNext()){
			dto = (QtonDTO) it.next();
			qtonAnsPair.put(dto.getNum(), dto.getAnswer());
		}
		
		pageContext.setAttribute("pri", pri);
		pageContext.setAttribute("groupId", groupId);
		pageContext.setAttribute("qdto", qdto);
		pageContext.setAttribute("qtonsGiven", qtonsGiven);
		
		application.setAttribute("qtonAnsPair", qtonAnsPair);
		application.setAttribute("qtonsGiven", qtonsGiven);
	%>
		<form id="form_qton" action="http://localhost:8070/ExaminationPortal/answer" method="post">
		
		<c:forEach var="row" begin="0" end="5" step="1" items="${qdto}" varStatus="loop" > 	
			<c:set var="qtonCount" value="${qtonCount+1}" /> 
		 	<fieldset id="${groupId}" >  
				<h2><c:out value="${row.qton}" /></h2><br />				
				A : <input type="radio" name="Options${groupId}${loop.count}" value="A"><c:out value="${row.opt1}"/><br />
				B : <input type="radio" name="Options${groupId}${loop.count}" value="B"><c:out value="${row.opt2}"/><br />
				C : <input type="radio" name="Options${groupId}${loop.count}" value="C"><c:out value="${row.opt3}"/><br />
				D : <input type="radio" name="Options${groupId}${loop.count}" value="D"><c:out value="${row.opt4}"/><br />
				<input type="hidden" name="qtonNo${groupId}${loop.count}" value="${row.num}" />
			</fieldset>
		</c:forEach>
	<% 
		pri++;
		groupId++;
	}
	%>
	Out Count : <c:out value="${qtonCount}"></c:out> 
	<input type="hidden" name="qtonCount" value="${qtonCount}" >
		<br><br><br><br>
 	<button type="submit" value="Submit"> Submit</button>
		</form>
			<br><br><br><br><br>
	<div>
		Registration closes in <span id="time"></span> minutes!
	</div>
	
</body>
</html>