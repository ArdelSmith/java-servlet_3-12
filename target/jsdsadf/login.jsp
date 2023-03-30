<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="icon" type="image/vnd.microsoft.icon" href="static/images/favicon.ico" />
    <meta charset="UTF-8"/>
    <title>Login</title>
</head>
<body>
<p>Enter you username and password</p>

<form action="${parent}/auth" method="POST">
    Username: <input type="text" name="username"/>
    Password: <input type="password" name="password"/>
    <input type="submit" value="Sign in">
</form>
<button><a href="${parent}/registration">Registration</a></button>
</body>
</html>