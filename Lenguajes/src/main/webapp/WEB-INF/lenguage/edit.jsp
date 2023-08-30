<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
<h1>Edit Lenguage</h1>
<form:form action="/lenguage/${leng.id}" method="post" modelAttribute="leng">
    <input type="hidden" name="_method" value="put">
<div class="container p-2 m-2">
			<div class="row mb-2">
					<form:label path="name" class="col-sm-1">Name</form:label>
					<form:input path="name" class="col-sm-2"/>
					<form:errors path="name" class="col text-danger"/>
			</div>
			<div class="row mb-2">
					<form:label path="creator" class="col-sm-1">Creator</form:label>
					<form:input path="creator" class="col-sm-2"/>
					<form:errors path="creator" class="col text-danger"/>
			</div>
			<div class="row mb-2">
					<form:label path="currentVersion" class="col-sm-1">Version</form:label>
					<form:input type="number" path="currentVersion" class="col-sm-2"/>
					<form:errors path="currentVersion" class="col text-danger"/>
			</div>

			<input type="submit" value="Submit" />
		</div>
</form:form>


</body>
</html>