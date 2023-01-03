<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div = align = "center">
<h1> Employee Register Form </h1>
<form action ="<%= request.getContextPath()%>/register" method = "post">
<table style = "with: 80%">
<tr>
<td> FirstName </td>
<td><input type = "text" name = "firstName"/> </td>
</tr>
<tr>
<td> LastName </td>
<td><input type = "text" name = "lastName"/> </td>
</tr>
<tr>
<td> UserName </td>
<td><input type = "text" name = "userName"/> </td>
</tr>
<tr>
<td> Password</td>
<td><input type = "password" name = "password"/> </td>
</tr>
<tr>
<td> Location </td>
<td><input type = "text" name = "location"/> </td>
</tr>
<tr>
<td> Contact No </td>
<td><input type = "text" name = "contact"/> </td>
</tr>
<tr>
<td> Salary </td>
<td><input type = "text" name = "salary"/> </td>
</tr>
</table>
<input type = "Submit" value = "Submit" />

</form>
</body>
</html>