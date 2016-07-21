<%@page import="com.examportal.dto.QtonCollDTO"%>
<%@page import="java.util.*"%>
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
	<%
		QtonCollDTO l = new QtonCollDTO();
		Set<QtonDTO> list = l.getList();
		Iterator<QtonDTO> itr = list.iterator();
		int qcount = 0, pqcount = 0;
		while (itr.hasNext()) {
			QtonDTO dto = (QtonDTO) itr.next();
			if (dto.getPriority() == 1) {
				++qcount;
				++pqcount;
				out.println("<br>" + qcount + " " + pqcount);
				if (pqcount <= 5) {
	%>


	<h2>
		<%
			out.print(dto.getQton());
		%>
	</h2>
	<br>
	<br> A :
	<input type="radio" name="Options" id="A" value="A">
	<%
		out.print(dto.getOpt1());
	%><br> B :
	<input type="radio" name="Options" id="B" value="B">
	<%
		out.print(dto.getOpt2());
	%><br> C :
	<input type="radio" name="Options" id="C" value="C">
	<%
		out.print(dto.getOpt3());
	%><br> D :
	<input type="radio" name="Options" id="D" value="D">
	<%
		out.print(dto.getOpt4());
	%>
	<%
		}
			}
		}
	%>


</body>
</html>