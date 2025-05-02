<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.winit.model.SalesOrder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sales Orders</title>
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

#buttons {
    margin-top: 20px;
}

#buttons a {
    margin: 0 10px;
}

#buttons input {
    font-size: 25px;
    padding: 10px 20px;
    border: none;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

#save1{
    background-color: green;
    color: white;
    
}
#delete{
    background-color: red;
    color: white;
}

#buttons input[type="button"]:nth-child(2) {
    background-color: green;
    color: white;
}

#buttons input:hover {
    opacity: 0.8;
}
</style>
</head>
<body>
	<%
	List<SalesOrder> getallSalesOrder = (List<SalesOrder>) session.getAttribute("getallSalesOrder");
	%>
	<table>
		<tr>
			<th>Select</th>
			<th>Sales Order Number</th>
			<th>Customer Name</th>
			<th>Order Date</th>
			<th>Total Price</th>
			<th colspan="2">Action</th>
		</tr>
		<%
		for (SalesOrder so : getallSalesOrder) {
		%>
		<tr>
			<td><%=so.getId()%></td>
			<td><%=so.getSalesOrderNumber()%></td>
			<td><%=so.getCustomerName()%></td>
			<td><%=so.getOrderDate()%></td>
			<td><%=so.getTotalAmout()%></td>
			<td><a href="callingSevletEdit?id=<%=so.getId()%>"> <img src="imges/icons8-edit-50.png" height="20px"; width="25px"; alt="image not found";></a>
			 <a	href="callingSevletdeleteOrder?id=<%= so.getId() %>"><img src="imges/icons8-delete-100.png" height="20px"; width="25px"; alt="image not found";></a>
			</td>
		</tr>
		<%
		}
		%>
	</table>
	<div id="buttons">
		<a href="callingClearSevlet"><input id ="delete" type="button" value="Clear"></a> 
		<a  href="callingSaveSevlet"><input id ="save1"  type="button" value="Save"></a>
	</div>
</body>
</html>
