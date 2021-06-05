<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
<link href="my_style.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div id="header" ><h1>EXPENSE TRACKER</h1></div>
<div id="container">
	<spr:form action="login.htm" method="post" commandName="user" >
	
	<table align="center" border="0" >
		<thead>
			<tr><th colspan="2" >Login Form</th></tr>
		</thead>
		<tbody>
			<tr>
				<td>Email:</td>
				<td>
					<spr:input path="email"/>
					<spr:errors path="email" ></spr:errors> 
				</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td>
					<spr:password path="password"/>
					<spr:errors path="password" ></spr:errors> 
				</td>
			</tr>
			<tr>
				<tr><td>Not Registered ?<a href="reg_form.htm" style="text-decoration: none;"> Click here</a></td></tr>
				<td><input type="submit" value="Login" ></td>
			</tr>
		</tbody>
	</table>
	</spr:form>
	</div>
</body>
</html>