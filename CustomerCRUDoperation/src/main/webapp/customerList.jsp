<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>

	<table border="1">
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Street</th>
        <th>Address</th>
        <th>City</th>
        <th>State</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.street}</td>
            <td>${customer.address}</td>
            <td>${customer.city}</td>
            <td>${customer.state}</td>
            <td>${customer.email}</td>
            <td>${customer.phone}</td>
            <td>
                <a href="getCustomerById?id=${customer.id}">Edit</a>
                <form action="deleteCustomer" method="post" style="display: inline;">
                    <input type="hidden" name="id" value="${customer.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="customerForm.jsp">Create New Customer</a>
	

</body>
</html>