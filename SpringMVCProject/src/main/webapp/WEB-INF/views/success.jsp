<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> hi <%= request.getAttribute("name") %> Registration Successfull</h1>
<% String name = (String)request.getAttribute("name");%><br>
<!-- < out.println(request.getAttribute("id"));%><br> -->
<% out.println(request.getAttribute("email"));%><br>
<% out.println(request.getAttribute("age"));%><br>
<% request.setAttribute("name1",name); %>
<!--  < session.setAttribute("name", name); -->
 <form action="nextPage" >
        <input type="hidden" name="name" value="${name}">  
        <input type="submit" value="Proceed">
    </form>
 </body>
</html>