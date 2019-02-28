<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import = "model.Suppliers" %>
      
      <% Suppliers supplier = (Suppliers)request.getAttribute("supplier"); %>
      
                <style type="text/css">
  <%@include file="Style.css" %>
</style>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Suppliers and Vendors Update</title>
</head>
<body>
<h1>Suppliers and Vendors Update</h1>
<form name = "updateSupplierForm" action="supplierUpdate" method = "get">
<label>
SupplierID:
</label>
<input type=text name=SupplierID value="<%= supplier.getSupplierID() %>" />
</br>
<label>
DroneID:
</label>
<input type=text name=DroneID value="<%= supplier.getDroneID() %>" />
</br>
<label>
Email:
</label>
<input type=text name=Email value="<%=supplier.getEmail()%>" />
</br>
<label>
Phone:
</label>
<input type=text name=Phone value="<%=supplier.getPhone()%>" />
</br>
<label>
Vendor First Name:
</label>
<input type=text name=VendorFirstName value="<%=supplier.getVendorFirstName() %>" />
</br>
<label>
Vendor Last Name:
</label>
<input type=text name=VendorLastName value="<%=supplier.getVendorLastName() %>" />
</br>
<label>
Service Number:
</label>
<input type=text name=Service_Number value="<%=supplier.getService_Number() %>" />
</br>
<input type=submit name=Submit value="Add Supplier" />

</form>

</body>
</html>