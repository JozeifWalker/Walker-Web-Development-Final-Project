package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.UpdateSupplierQuery;
import model.Suppliers;

/**
 * Servlet implementation class UpdateSupplierServlet
 */
@WebServlet(description = "Controller which starts the actual drone update to the database", urlPatterns = { "/UpdateSupplierServlet", "/supplierUpdate" })
public class UpdateSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSupplierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String supplierID = request.getParameter("SupplierID");
		int DroneID = Integer.parseInt(request.getParameter("DroneID"));
		String email = request.getParameter("Email");
		String phone = request.getParameter("Phone");
		String vendorFirst = request.getParameter("VendorFirstName");
		String vendorLast = request.getParameter("VendorLastName");
		String serviceNumber =request.getParameter("Service_Number");
		
		Suppliers supplier = new Suppliers();
		supplier.setSupplierID(supplierID);
		supplier.setDroneID(DroneID);
		supplier.setEmail(email);
		supplier.setPhone(phone);
		supplier.setVendorFirstName(vendorFirst);
		supplier.setVendorLastName(vendorLast);
		supplier.setService_Number(serviceNumber);
		UpdateSupplierQuery uq = new UpdateSupplierQuery("drone_inventory","root","1234");
		uq.doUpdate(supplier);
		String url = "/supplier";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	  
	}

}
