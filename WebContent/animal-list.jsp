<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Animal List</title>
</head>
<body style="background-color:tan;">
	<h2><strong><em><u>Animal List</u></em></strong></h2>
	<form method = "post" action = "navigationServlet">
	<table>
	<c:forEach items="${requestScope.allAnimals}" var="currentanimal">
	<tr>
	 <td><input type="radio" name="id" value="${currentanimal.id}"></td>
	 <td>${currentanimal.animal}</td>
	 <td>${currentanimal.gender}</td>
	 <td>${currentanimal.age}</td>
	 </tr>
	</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToAnimal">
<input type = "submit" value = "delete" name="doThisToAnimal">
<input type = "submit" value = "add" name = "doThisToAnimal">
</form>
</body>
</html>