<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.winit.model.SalesOrderLine,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #e0f7fa;
    margin: 0;
    padding: 20px;
    display: flex;
    flex-direction: column;
    align-items: center;
    height: 100vh;
}

table {
    border-collapse: collapse;
    width: 80%;
    margin: 20px 0;
    background-color: #fff;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

table th, table td {
    border: 1px solid #ddd;
    padding: 12px;
    text-align: center;
}

table th {
    background-color: #4CAF50;
    color: white;
}

table tr:nth-child(even) {
    background-color: #f2f2f2;
}

table tr:hover {
    background-color: #ddd;
}

a {
    text-decoration: none;
    color: #333;
}
	 #buttons{
	 	margin-left: 30%;
	 	margin-top: 3%;
	 	margin-righ: 20px;
	 	font-size:30px;
	 }
</style>
</head>
<body>
<% List<SalesOrderLine> itemslist = (List<SalesOrderLine>)session.getAttribute("items"); 
	if(itemslist != null){ %>
		<table>
			<tr>
				<th>S No</th>
				<th>item Code </th>
				<th>itemName </th>
				<th>unitPrice </th>
				<th>qty </th>
				<th>totolPrice </th>
				<th >Action</th>
			</tr>
			<% for(SalesOrderLine item : itemslist){ %>
			<tr>
				<td><%= item.getId() %></td>
				<td><%= item.getItemCode() %></td>
				<td><%= item.getItemName() %></td>
				<td><%= item.getUnitPrice() %></td>
				<td><form><input type="text" value="<%= item.getQty() %>"></form></td>
				<td><%= item.getTotolPrice() %></td>
				<td><a href="callingSevletdeleteitem?itemId=<%= item.getId() %>"><img src="imges/icons8-delete-100.png"  height="20px"; width="25px"; alt="image not found";></a> </td>
			</tr>
			<%} %>
		</table>
	<% }
%>
</body>
</html>