<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.winit.model.SalesOrderLine,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
	border-collapse : collapse;
	}
	 table th,table td {
	 border:2px solid black;
     padding: 5px;
     font-size:22px;
	 }
	 a{
	 	text-decoration: none;
	 	
	 	cursor: pointer;
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
				<td><a href="callingSaveSevletdeleteitem?itemId=<%= item.getId() %>"><img src="imges/icons8-delete-100.png"  height="20px"; width="25px"; alt="image not found";></a> </td>
			</tr>
			<%} %>
		</table>
	<% }
%>
</body>
</html>