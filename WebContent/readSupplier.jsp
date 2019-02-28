<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String table =(String)request.getAttribute("table"); %>
    
        <style type="text/css">
  <%@include file="Style.css" %>
</style>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Suppliers and Vendors</title>
</head>
<body>
<h1><img alt="banner" src="siteBanner.png" style = "width: 100%"></h1>
<div class = "row">
<div class = "column left" style = "background-color:maroon;">
<ul>
<li>
<a href = "admin_Home.jsp" style="text-decoration: none; a:visited= white; color:white;">Home</a>
</li>
</br>
<li>
<a href = "inventory" style="text-decoration: none; a:visited= white; color:white;">Drone Inventory</a>
</li>
</br>
<li>
<a href = "supplier" style="text-decoration: none; a:visited= white; color:white;">Drone Suppliers and Vendors</a>
</li>
</br>
<li>
<a href = "purchases" style="text-decoration: none; a:visited= white; color:white;">Purchase History</a>
</li>
</br>
<li>
<a href = "accounts" style="text-decoration: none; a:visited= white; color:white;">Accounts and Payables</a>
</li>
</ul>
</div>
<%=table %>
</br>
<a href ="addSupplier">Add Supplier</a>

</body>
</html>