<%@page import="com.example.dto.Expense"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	List<Expense> elist = (List<Expense>)request.getAttribute("list");

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense List</title>
<link href="my_style.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div id="header" ><h1>EXPENSE TRACKER</h1></div>
<div id="container">
	<table align="center"  >
		<%
			for(Expense e : elist){
		%>
		
		<tr>
			<td><%=e.getExpenseId()%></td>
			<td><%=e.getItemName()%></td>
			<td><%=e.getPrice()%></td>
			<td><%=e.getPurchaseDate()%></td>
			<td><a href="expense_delete.htm?expenseId=<%=e.getExpenseId()%>" >delete</a></td> 
			<td><a href="expense_update_form.htm?expenseId=<%=e.getExpenseId()%>" >update</a></td>
		</tr>
		<%
			}
		%>
		<tr><td><a href="home.htm" >Back</a></td></tr>
	</table>
	</div>
</body>
</html>