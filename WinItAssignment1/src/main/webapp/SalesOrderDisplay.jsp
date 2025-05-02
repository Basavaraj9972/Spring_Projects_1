<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.winit.model.SalesOrder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border-collapse: collapse;
}

table th, table td {
	border: 2px solid black;
	padding: 5px;
	font-size: 22px;
}

a {
	text-decoration: none;
	cursor: pointer;
}

#buttons {
	margin-left: 30%;
	margin-top: 3%;
	margin-righ: 20px;
	font-size: 30px;
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
			<th>SalseOrderNumber</th>
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
			<td><a href="callingCLearSevletEdit?id=<%=so.getId()%>"> <img
					src="imges/icons8-edit-50.png" height="20px" ; width="25px"; alt="image not found";>
			</a>
			 <a	href="callingSevletdeleteOrder?customerName=<%=so.getCustomerName()%>"><img
					src="imges/icons8-delete-100.png" height="20px" ; width="25px"
					; alt="image not found";></td>
			<td>
		</tr>
		<%
		}
		%>
	</table>
	<div id="buttons">

		<a href="callingCLearSevlet"><input
			style="font-size: 25px; background-color: red;" type="button"
			value="Clear"></a> <a href="callingSaveSevlet"><input
			style="font-size: 25px; background-color: green;" type="button"
			value="Save"></a>
	</div>
</body>
</html>