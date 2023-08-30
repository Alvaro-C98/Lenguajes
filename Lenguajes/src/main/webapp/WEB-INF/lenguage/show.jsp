<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lenguage</title>
</head>
<body>
	<p>Name:
		<c:out value="${leng.name}" />
	<p>
	<p>
		Creator:
		<c:out value="${leng.creator}" />
	</p>
	<p>
		Version:
		<c:out value="${leng.currentVersion}" />
	</p>

	<a href="/lenguage/${leng.id}/edit"><button>Edit</button></a>
	
	<form action="/lenguage/${leng.id}" method="post">
		<input type="hidden" name="_method" value="delete"> 
		<input type="submit" value="Delete" class="mt-2">
	</form>
</body>
</html>