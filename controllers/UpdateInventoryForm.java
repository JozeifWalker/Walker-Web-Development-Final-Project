package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dbHelpers.ReadRecord_Inventory;
import model.Inventory;

/**
 * Servlet implementation class UpdateInventoryForm
 */
@WebServlet(description = "This will get a drone and use the data to fill in a table for updating the record", urlPatterns = { "/update" })
public class UpdateInventoryForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInventoryForm() {
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
		int droneId = Integer.parseInt(request.getParameter("DroneID"));
		
		ReadRecord_Inventory rr = new ReadRecord_Inventory("project","root","1234",droneId);
		
		rr.doRead();
		
		Inventory drone  = rr.getDrone();
		
		request.setAttribute("drone", drone);
		
        String url = "/updateInventory.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
