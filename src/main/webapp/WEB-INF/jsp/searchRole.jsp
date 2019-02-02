<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search by role</title>
</head>
<body>
	<form action="/searchRole" method="post">
	<span>Search by role: <input type="text" name="role"></span>
	<br/>
	<input type="submit">
	</form>
	<br/>
	<table border="1">
		<thead>
			<tr>
				<td>Film</td>
				<td>Actor's Name</td>
				<td>Birth Year</td>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td><c:out value="${selectedActorFilm.title}" /></td>
					<td><c:out value="${selectedActorFilm.name}" /></td>
					<td><c:out value="${selectedActorFilm.birthYear}" /></td>
				</tr>
		</tbody>
	</table>
	<br/>
	<a href="/index">Back to Index</a><br/>
</body>
</html>