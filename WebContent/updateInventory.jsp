<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import = "model.Inventory" %>
    <%Inventory drone = (Inventory)request.getAttribute("drone");%>
    
              <style type="text/css">
  <%@include file="Style.css" %>
</style>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update an Existing Drone</title>
</head>
<h1>Update Drone</h1>

<form name=updateDroneForm action=updateDrone method=get >

<label>
      DroneID:
   </label>
   <input type=text name=DroneID value="<%=drone.getDroneID() %>" />
   <br />

   <label>
      Make:
   </label>
   <input type=text name=Make value="<%=drone.getMake()%>" />
   <br />
   <label>
      Model:
   </label>
   <input type=text name=Model value="<%=drone.getModel() %>" />
   <br />
   
   <label>
      Year:
   </label>
   <input type=text name=Year value="<%=drone.getYear() %>" />
   <br />
   
   <label>
      Last Service Date:
   </label>
   <input type=text name=Last_Service_Date value="<%=drone.getLast_Service_Date() %>" />
   <br />
   
   <label>
      Service Location City:
   </label>
   <input type=text name=Service_Location_City value="<%=drone.getService_Location_City() %>" />
   <br />
   
   <label>
      Service Location State:
   </label>
   <input type=text name=Service_Location_State value="<%=drone.getService_Location_State() %>" />
   </br>
   
   <label>
      VIN:
   </label>
   <input type=text name=Vin value="<%=drone.getVin() %>" />
   <br />
   
   
   <input type=submit name=Submit value="Update Drone" />

</form>
</body>
</html>