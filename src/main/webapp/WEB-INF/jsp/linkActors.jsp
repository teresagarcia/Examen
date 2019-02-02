<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Link actors to films</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<td>Code</td>
				<td>Name</td>
				<td>Director</td>
				<td>Options</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="film" items="${listAllFilm}">
				<tr>
					<td><c:out value="${film.cod}" /></td>
					<td><c:out value="${film.title}" /></td>
					<td><c:out value="${film.codDirector}" /></td>
					<td><a href="/chooseActor?filmCod=${film.cod}">Link Actor</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/>
	<a href="/index">Back to Index</a><br/>
</body>
</html>