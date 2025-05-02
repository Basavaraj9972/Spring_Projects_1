<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Hello,
		<%=request.getAttribute("name")%></h1>
	<p>You have successfully navigated to the next page.</p>
</body>
</html>