<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Zookeeper List</title>
</head>
<body style="background-color:tan;">
	<h2><strong><em><u>Zookeeper List</u></em></strong></h2>
	<form method = "post" action = "zooKeeperNavigationServlet">
	<table>
	<c:forEach items="${requestScope.allZooKeepers}" var="currentzookeeper">
	<tr>
	 <td><input type="radio" name="id" value="${currentzookeeper.id}"></td>
	 <td>${currentzookeeper.name}  -  </td>
	 <td>${currentzookeeper.department}</td>
	 </tr>
	</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToZooKeeper">
<input type = "submit" value = "delete" name="doThisToZooKeeper">
<input type = "submit" value = "add" name = "doThisToZooKeeper">
</form>
</body>
</html>