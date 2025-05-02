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
	<form action="protected/createCustomer" method="post">
    <input type="hidden" name="id" value="${customer.id}">
    First Name: <input type="text" name="firstName" value="${customer.firstName}"> </input><br>
    Last Name: <input type="text" name="lastName" value="${customer.lastName}"> </input> <br>
    Street: <input type="text" name="street" value="${customer.street}"> </input> <br>
    Address: <input type="text" name="address" value="${customer.address}"> </input> <br>
    City: <input type="text" name="city" value="${customer.city}"> </input> <br>
    State: <input type="text" name="state" value="${customer.state}"> </input> <br>
    Email: <input type="text" name="email" value="${customer.email}"> </input> <br>
    Phone: <input type="text" name="phone" value="${customer.phone}"> </input> <br>
    <input type="submit" value="Update Customer">
</form>
	
</body>
</html>