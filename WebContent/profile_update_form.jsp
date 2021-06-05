<%@page import="com.example.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="cach_control.jsp" %> 
<%
	User user = (User)session.getAttribute("user");
	if(user==null || user.getUserId()<=0){
		response.sendRedirect("login_form.htm");
	}else{
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Profile</title>
<link href="my_style.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div id="header" ><h1>EXPENSE TRACKER</h1></div>
<div id="container">
	
	<form action="upload_profile_pic.htm" method="post" enctype="multipart/form-data" >
	<table align="center" border="0" >
		
		<tbody>
			<tr>
				<td>Select Profile Pic:</td>
				<td>
					<input type="file" name="profilePic" />
				</td>
			</tr>
			
			<tr>
				<td><a href="home.htm" >Back</a></td>
				
				<td>
					<input type="submit" value="Upload" >
				</td>
			</tr>
			
		</tbody>
	</table>
	</form>
	</div>
</body>
</html>

<%
	}
%>