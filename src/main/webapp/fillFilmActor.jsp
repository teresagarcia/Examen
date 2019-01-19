<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Actor Details</title>
</head>
<body>
	<%
		request.getAttribute("codFilm");
		request.getAttribute("codActor");
	%>
	<form action="/fillFilmActor?codFilm=${codFilm}&codActor=${codActor}" method="post">
		<span>Cache:</span> <input type="text" name="cache"> <br /> 
		<span>Role:</span><input type="text" name="role"> <br /> 
		<input type="submit">
</form>
</body>
</html>