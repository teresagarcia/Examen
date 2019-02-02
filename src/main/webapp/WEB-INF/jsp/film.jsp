<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Films</title>
</head>
<body>
	<form action="/insertFilm" method="post">
		<span>Name:</span> <input type="text" name="title"> <br />
		<span>Director:</span> <input type="text" name="codDirector"> <br />
		<input type="submit">
	</form>
	<br/>
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
					<td><a href="/deleteFilm?cod=${film.cod}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/>
	<a href="/index">Back to Index</a><br/>
</body>
</html>