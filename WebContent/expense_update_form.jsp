<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Expense</title>
<link href="my_style.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div id="header" ><h1>EXPENSE TRACKER</h1></div>
<div id="container">
	<spr:form action="expense_update.htm" method="post" commandName="expense" >
	
	<table align="center" border="0" >
		<thead>
			<tr><th colspan="2" >Update Expenses</th></tr>
		</thead>
		<tbody>
			<tr>
					<td>Expense ID:</td>
					<td>
						<spr:input path="expenseId" readonly="true" />
						
				</td>
			</tr>
			<tr>
					<td>Item Name:</td>
					<td>
						
						<spr:input path="itemName" />
				</td>
			</tr>
			<tr>
				<td>Price:</td>
				<td>
					<spr:input path="price" />
				</td>
			</tr>
			
			<tr>
				<td>Purchased Date:</td>
				<td>
					<spr:input path="purchaseDate" />
				</td>
			</tr>
			<tr>
				<td><a href="expense_list.htm" >Back</a></td>
				<td><input type="submit" value="Update" ></td>
			</tr>
		</tbody>
	</table>
	</spr:form>
	</div>
</body>
</html>
