package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.UpdatePurchaseQuery;
import model.Purchases;

/**
 * Servlet implementation class UpdatePurchaseServlet
 */
@WebServlet("/UpdatePurchaseServlet")
public class UpdatePurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePurchaseServlet() {
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
		
		String orderid =request.getParameter("OrderID");
		int employeeid = Integer.parseInt(request.getParameter("EmployeeID"));
		double msrp = Double.parseDouble(request.getParameter("MSRP"));
		double tax = Double.parseDouble(request.getParameter("Tax"));
		String ship = request.getParameter("Ship_Date");
		String receive = request.getParameter("Received_Date");
		String invoice = request.getParameter("InvoiceID");
		String drone = request.getParameter("DroneID");
		String supplier = request.getParameter("SupplierID");
		
		Purchases prc = new Purchases();
		
		prc.setOrderID(orderid);
		prc.setEmployeeID(employeeid);
		prc.setMSRP(msrp);
		prc.setTax(tax);
		prc.setShip_Date(ship);
		prc.setReceived_Date(receive);
		prc.setInvoiceID(invoice);
		prc.setDroneID(drone);
		prc.setSupplierID(supplier);
		
		UpdatePurchaseQuery update = new UpdatePurchaseQuery("drone_inventory","root","1234");
		update.doUpdate(prc);
		
		String url = "/purchases";
	     
	     RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
	}

}

		

