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
	<form action="createCustomer" method="post">
    First Name: <input type="text" name="firstName"> </input><br>
    Last Name: <input type="text" name="lastName"> </input><br>
    Street: <input type="text" name="street"> </input><br>
    Address: <input type="text" name="address"> </input><br>
    City: <input type="text" name="city"> </input><br>
    State: <input type="text" name="state"> </input><br>
    Email: <input type="text" name="email"> </input><br>
    Phone: <input type="text" name="phone"> </input><br>
    <input type="submit" value="Create Customer">
</form>
	

</body>
</html>