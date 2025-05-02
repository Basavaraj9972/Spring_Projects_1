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
		Hi
		<%=request.getParameter("name")%>
		resistration failed because user is already registered
	</h1>
	<%=request.getParameter("id")%>
	<%=request.getParameter("age")%>
	<%=request.getParameter("email")%>
</body>
</html>