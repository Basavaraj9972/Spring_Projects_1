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
	<h2>Login</h2>
    <form action="authenticate" method="post">
        Login ID: <input type="text" name="login_id" required> </input> <br>
        Password: <input type="password" name="password" required> </input> <br>
        <input type="submit" value="Login"></input>
    </form>

</body>
</html>