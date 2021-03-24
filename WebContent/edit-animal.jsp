<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Animal</title>
</head>
<body style="background-color:tan;">
	<h2><strong><em><u>Edit Animal</u></em></strong></h2>
	<form action = "editAnimalServlet" method="post">
	<font size="+2">Animal: <input type ="text" name = "animal" value= "${animalToEdit.animal}"><br>
	Gender <input type = "text" name = "gender" value= "${animalToEdit.gender}"><br>
	Age <input type = "number" name = "age" value= "${animalToEdit.age}"><br></font>
	<input type = "hidden" name = "id" value="${animalToEdit.id}">
	<input type = "submit" value="Save Edited Animal">
	</form>
</body>
</html>