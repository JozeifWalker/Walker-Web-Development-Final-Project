<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
                <style type="text/css">
  <%@include file="Style.css" %>
</style>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Drone</title>
</head>
<body>

<h1>Add Drone</h1>

<form name=addDroneForm action=AddDrone method=get >

<label>
      DroneID:
   </label>
   <input type=text name=DroneID value="" /><br>
   <br />

   <label>
      Make:
   </label>
   <input type=text name=Make value="" /><br>
   <br />
   <label>
      Model:
   </label>
   <input type=text name=Model value="" /><br>
   <br />
   
   <label>
      Year:
   </label>
   <input type=text name=Year value="" /><br>
   <br />
   
   <label>
      Last Service Date:
   </label>
   <input type=text name=Last_Service_Date value="" /><br>
   <br />
   
   <label>
      Service Location City:
   </label>
   <input type=text name=Service_Location_City value="" /><br>
   <br />
   
   <label>
      Service Location State:
   </label>
   <input type=text name=Service_Location_State value="" /><br>
   </br>
   
   <label>
      VIN:
   </label>
   <input type=text name=Vin value="" /><br>
   <br />
   
   
   <input type=submit name=Submit value="AddDrone" />

</form>
</body>
</html>