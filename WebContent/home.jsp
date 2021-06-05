<%@page import="java.nio.file.Files"%>
<%@page import="java.io.File"%>
<%@page import="com.example.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="cach_control.jsp" %> 
<%
	User user = (User)session.getAttribute("user");
	if(user==null || user.getUserId()<=0){
		response.sendRedirect("login_form.htm");
	}else{
		String fileName = "";
		File file = new File(application.getRealPath("/images"));
		if(!file.exists()) {
			file.mkdir();
		}
		File files[] = file.listFiles();
		if(files!=null){
			for(File f : files){
				String fname = f.getName();
				System.out.println(fname);
				String id = fname.substring(0,fname.indexOf("."));
				
				System.out.println(id);
				if(id.equals(user.getUserId()+"")){
					fileName = fname;
					break;
				}
			}
		}
		
		
		
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link href="my_style.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div id="header" ><h1>EXPENSE TRACKER</h1></div>
<div id="container">
	
	
	<table align="center" border="0" >
		
		<tbody>
			<tr>
				<td rowspan="3" >
					<img alt="no image" src="images/<%=fileName%>" width="100" height="100">
				</td>
				<td>&nbsp;&nbsp;&nbsp;</td>
				<td>
					<a href="expense_add_form.htm" >Add Expenses</a>
				</td>
			</tr>
			<tr>
				<td>&nbsp;&nbsp;&nbsp;</td>	
				<td>
					<a href="expense_list.htm" >Expense List</a>
				</td>
			</tr>
			<tr>	
				 <td>&nbsp;&nbsp;&nbsp;</td>
				<td>
					<a href="profile_update_form.jsp" >Profile Update</a>
				</td>
			</tr> 
			<tr>
				<td><%="User : "+((User)session.getAttribute("user")).getEmail()%></td>
				<td>&nbsp;&nbsp;&nbsp;</td>	
				<td>
					<a href="logout.htm" >Logout</a>
				</td>
			</tr>
			
		</tbody>
	</table>
	
	</div>
</body>
</html>

<%
	}
%>