package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.DeleteInventoryQuery;

/**
 * Servlet implementation class DeleteDroneServlet
 */
@WebServlet(description = "Deletes a record for a particular drone ID", urlPatterns = { "/delete" })
public class DeleteDroneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDroneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the Drone ID
		int droneID = Integer.parseInt(request.getParameter("DroneID"));
		
		//create a DeleteInventoryQuery
		
		DeleteInventoryQuery dq = new DeleteInventoryQuery("drone_inventory","root","1234");
		
		dq.doDelete(droneID);
		String url = "/inventory";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
