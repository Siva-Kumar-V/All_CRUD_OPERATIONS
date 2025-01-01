<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Employee</h1>
<table border=1>
<tr>
<th>Name</th>
<th>Salary</th>
</tr>
<c:forEach var="st" items="${emp}">
<tr> 
<td>${st[0]}</td>
<td>${st[1]}</td>
</tr>
</c:forEach>
</table>
</body>
</html>