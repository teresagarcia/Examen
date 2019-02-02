<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Actor Details</title>
</head>
<body>
	<form action="/fillFilmActor" method="post">
		<input type="hidden" name="codFilm" value="${filmCod}"> 
		<input type="hidden" name="codActor" value="${actorCod}"> 
		<span>Cache:</span> <input type="text" name="cache"> <br /> 
		<span>Role:</span><input type="text" name="role"> <br /> 
		<input type="submit">
	</form>
	<br/>
	<a href="/index">Back to Index</a><br/>
</body>
</html>