<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search directors</title>
</head>
<body>
	<%
		List<Director> listFilterDirector = (List<Director>) request.getAttribute("listFilterDirector");
	%>
	<form action="/searchDirector" method="post">
		<span>Search Actor: <input type="text" name="name"></span> <br />
		<input type="submit">
	</form>
	<br/>
	<table border="1">
		<thead>
			<tr>
				<td>Director</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach var="director" items="${listFilterDirector}">
					<tr>
						<td><c:out value="${director.name}" /></td>
					</tr>
				</c:forEach>
			</tr>
		</tbody>
	</table>
	<br/>
	<a href="/index.jsp">Back to Index</a><br/>
</body>
</html>