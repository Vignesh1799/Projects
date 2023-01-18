<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1><center> About Us...</center></h1>
<p><b> <center> This website is mainly created to test the Servlet, Jsp and JDBC Features. The project we 
created was a Login page for the employee of a company. And we will try to improve the features furthur.</center></b></h2>

<p> <b><center> Thank you...</center></b></p>

<br> <br> <br>
<%
	if (session.getAttribute("userName") == null) {
		out.write("<form action = \"login.jsp\">");
		out.write("<h1> <center> To Login / SignUp : <Input type = \"submit\" value = \"Login / Sign up\"> </center> </h1>");
		out.write("</form> <br>");
	}
	else
	{out.write("<form action = \"logout\">");
	out.write("<h1> <center> To Logout :<Input type = \"submit\" value = \"Logout\"> </center> </h1>");
	out.write("</form> <br>");
	}
	
	%>
<form action = "Index.jsp">
<h1> <center>To Go Home : <Input type = "submit" value = "Home Page"/> </center></h1>
</form> <br>


</body>
</html>