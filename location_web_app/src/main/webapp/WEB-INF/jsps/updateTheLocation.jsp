<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Update Location</h2>
	<form action="updateLocationData" method="post">
		<!--  Id: <input type="text" name="id" value="${locations.id}"/>
		Name: <input type="text" name="name" value="${locations.name}"/>
		Code: <input type="text" name="code" value="${locations.code}"/>
		Type: Rural<input type="radio" name="type" value="rural"/>
			  Urban<input type="radio" name="type" value="urban"/> -->
			  
		Id: <input type="text" name="id" value="${id}" readonly />
		Name: <input type="text" name="name" value="${name}"/>
		Code: <input type="text" name="code" value="${code}"/>
		Type: Rural<input type="radio" name="type" value="rural"/>
			  Urban<input type="radio" name="type" value="urban"/>
		<input type="submit" value="Update"/>
		
	</form>
	${updateMsg }
</body>
</html>