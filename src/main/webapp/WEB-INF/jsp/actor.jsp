<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Actors</title>
</head>
<body>
	<form action="/insertActor" method="post">
		<span>Name:</span> <input type="text" name="name"><br/> 
		<span>Birth year:</span> <input type="text" name="birthYear"><br/> 
		<input type="submit">
	</form>
	<br/>
	
	<h3>Filter by birth year</h3>
	<form action="/filterActors" method="get">
		<span>From year:</span>
		<input type="text" name="startYear">
		<span>To:</span>
		<input type="text" name="endYear">
		<input type="submit">
	</form>
	<br/>	
	<table border="1">
		<thead>
			<tr>
				<td>Code</td>
				<td>Name</td>
				<td>Birth year</td>
				<td>Options</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="actor" items="${listAllActors}">
				<tr>
					<td><c:out value="${actor.cod}" /></td>
					<td><c:out value="${actor.name}" /></td>
					<td><c:out value="${actor.birthYear}" /></td>
					<td><a href="/deleteActor?cod=${actor.cod}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/>
	<a href="/index.jsp">Back to Index</a><br/>
</body>
</html>