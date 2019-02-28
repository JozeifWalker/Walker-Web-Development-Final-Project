<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <% String browse = (String)request.getAttribute("browse"); %>
    <style type="text/css">
  <%@include file="Style.css" %>
</style>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Drone Inventory</title>
</head>
<body>
<h1>View our Drone Inventory</h1>

<%= browse %>

</body>
</html>