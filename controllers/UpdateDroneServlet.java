package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.UpdateInventoryQuery;
import model.Inventory;

/**
 * Servlet implementation class UpdateDroneServlet
 */
@WebServlet(description = "Controller which starts the actual drone update to the database", urlPatterns = { "/updateDrone" })
public class UpdateDroneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDroneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int DroneID = Integer.parseInt(request.getParameter("DroneID"));
		String Make = request.getParameter("Make");
		String Model  = request.getParameter("Model");
		int year = Integer.parseInt(request.getParameter("Year"));
		String Last_Service_Date = request.getParameter("Last_Service_Date");
		String Last_Service_City = request.getParameter("Service_Location_City");
		String Last_Service_State = request.getParameter("Service_Location_State");
		String Vin = request.getParameter("Vin");
		
		Inventory drone = new Inventory();
		 drone.setDroneID(DroneID);
	     drone.setMake(Make);
	     drone.setModel(Model);
	     drone.setYear(year);
	     drone.setLast_Service_Date(Last_Service_Date);
	     drone.setService_Location_City(Last_Service_City);
	     drone.setService_Location_State(Last_Service_State);
	     drone.setVin(Vin);
	     
	     UpdateInventoryQuery ui = new UpdateInventoryQuery("drone_inventory","root","1234");
	     ui.doUpdate(drone);
	     
	     String url = "/inventory";
	     
	     RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
	}

}
