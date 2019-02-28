<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import = "model.Payables" %>
    
    <% Payables pay = (Payables)request.getAttribute("pay"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payable Form</title>
</head>
<body>
<h1>Update Accounts and Payables</h1>

<form name = "updateAccountsForm" action="" method = "get">
<label>
InvoiceID:
</label>
<input type=text name=InvoiceID value="<%= pay.getInvoiceID() %>" />
</br>
<label>
Amount:
</label>
<input type=text name=Amount_charged value="<%= pay.getAmountCharged()  %>" />
</br>
<label>
Due Date:
</label>
<input type=text name=due_date value="<%=pay.getDueDate()  %>" />
</br>
<label>
Date Paid:
</label>
<input type=text name=date_paid value="<%=pay.getDatePaid()  %>" />
</br>
<label>
Status
</label>
<input type=text name=status value="<%=pay.getStatus()  %>" /> 
</br>

 <input type=submit name=Submit value="Update Purchase" />
  
</form>
</body>
</html>