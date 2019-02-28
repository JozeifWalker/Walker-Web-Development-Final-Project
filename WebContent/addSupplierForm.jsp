<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <style type="text/css">
  <%@include file="Style.css" %>
</style>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier and Vendors</title>
</head>
<body>
<h1>Suppliers and Vendors</h1>
<form name = "Supplier Form "action="addVendor" method = "get">

<label>
SupplierID:
</label>
<input type=text name=SupplierID value="" />
</br>
<label>
DroneID:
</label>
<input type=text name=DroneID value="" />
</br>
<label>
Email:
</label>
<input type=text name=Email value="" />
</br>
<label>
Phone:
</label>
<input type=text name=Phone value="" />
</br>
<label>
Vendor First Name:
</label>
<input type=text name=VendorFirstName value="" />
</br>
<label>
Vendor Last Name:
</label>
<input type=text name=VendorLastName value="" />
</br>
<label>
Service Number:
</label>
<input type=text name=Service_Number value="" />
</br>
<input type=submit name=Submit value="Add Supplier" />

</form>

</body>
</html>