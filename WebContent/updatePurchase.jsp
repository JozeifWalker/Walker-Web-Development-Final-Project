<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import= "model.Purchases" %>
    
    <%Purchases p = (Purchases)request.getAttribute("p"); %>
    
    <style type="text/css">
  <%@include file="Style.css" %>
</style>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchases</title>
</head>
<body>
<h1>Drone Purchase Form</h1>
<form name = "updatePurchaseForm" action="UpdatePurchaseServlet" method = "get">
<label>
OrderID:
</label>
<input type=text name=OrderID value="<%=p.getOrderID()  %>" />
</br>
<label>
EmployeeID:
</label>
<input type=text name=EmployeeID value="<%= p.getEmployeeID()  %>" />
</br>
<label>
MSRP:
</label>
<input type=text name=MSRP value="<%= p.getMSRP()  %>" />
</br>
<label>
Tax:
</label>
<input type=text name=Tax value="<%= p.getTax() %>" />
</br>
<label>
Ship Date:
</label>
<input type=text name=ShipDate value="<%=p.getShip_Date()  %>" />
</br>
<label>
Received Date:
</label>
<input type=text name=ReceiveDate value="<%=p.getReceived_Date()  %>" />
</br>
<label>
InvoiceID:
</label>
<input type=text name=InvoiceID value="<%=p.getInvoiceID() %>" />
</br>
<label>
DroneID:
</label>
<input type=text name=DroneID value="<%=p.getDroneID() %>" />
</br>
<label>
SupplierID:
</label>
<input type=text name=SupplierID value="<%=p.getSupplierID()  %>" />
</br>

  <input type=submit name=Submit value="Update Purchase" />
</form>
</body>
</html>