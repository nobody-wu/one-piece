<%@ page language="java" contentType="text/html; charset=UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
      <title>login</title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- 引入 Bootstrap -->
      <link href="/css/bootstrap.min.css" rel="stylesheet">
   </head>
   <body>
      <h1>login or register</h1>
 
      <form action="/login/login" method="post">
      	userName:<input name="username">
      	password:<input name="password" type="password">
      	<input type="submit">
      	
      </form>
   </body>
</html>
