<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <style type="text/css">
  <%@include file="Style.css" %>
</style>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>
</head>
<body>

<form id="loginForm" action="Login" method="POST">
	<h1>Log In</h1>
	<h2>Admins Only</h2>
	<input type="text" name="username" placeholder="Username" required><br>
	<input type="password" name="password" placeholder ="Password" required><br>
	<input type="submit" value="Login"><br>
	<br>
	<a href="addAdmin">New Admin</a>
	${errorMessage}
</form>
</body>
</html>