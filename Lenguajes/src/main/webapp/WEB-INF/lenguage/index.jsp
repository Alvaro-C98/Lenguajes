<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<!-- your own local CSS-->
<link rel="stylesheet" href="/css/main.css"/>
<!-- for any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Lenguages</title>
</head>
<body>
	<h1>All Lenguages</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Creator</th>
				<th scope="col">Version</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lengs}" var="leng">
				<tr>
					<th scope="row"><a href="/lenguage/${leng.id}"><c:out value="${leng.name}"/></a></th>
					<td><c:out value="${leng.creator}" /></td>
					<td><c:out value="${leng.currentVersion}" /></td>
					<td>
						<a href="/lenguage/${leng.id}/edit"><button>Edit</button></a>
						<form action="/lenguage/${leng.id}" method="post">
    		 				<input type="hidden" name="_method" value="delete">
    						<input type="submit" value="Delete"></form></td>
    				
    				
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/lenguage/new"><button>New Lenguage</button></a>

</body>
</html>