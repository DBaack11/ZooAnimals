<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Zookeeper</title>
</head>
<body style="background-color:tan;">
	<h2><strong><em><u>Edit Zookeeper</u></em></strong></h2>
	<form action = "editZooKeeperServlet" method="post">
	<font size="+2">Name: <input type ="text" name = "name" value= "${zooKeeperToEdit.name}"><br>
	Department: <input type = "text" name = "department" value= "${zooKeeperToEdit.department}"><br>
	</font>
	<input type = "hidden" name = "id" value="${zooKeeperToEdit.id}">
	<input type = "submit" value="Save Edited Zookeeper">
	</form>
</body>
</html>