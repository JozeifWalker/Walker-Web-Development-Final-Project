package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.AddSupplier;
import model.Suppliers;

/**
 * Servlet implementation class AddSupplierServlet
 */
@WebServlet({ "/AddSupplierServlet", "/addVendor" })
public class AddSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSupplierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String supplierID = request.getParameter("SupplierID");
		int droneID = Integer.parseInt(request.getParameter("DroneID"));
		String email = request.getParameter("Email");
		String Phone = request.getParameter("Phone");
		String vendorFirst = request.getParameter("VendorFirstName");
		String vendorLast = request.getParameter("VendorLastName");
		String serviceNumber =request.getParameter("Service_Number");
		
		Suppliers supplier = new Suppliers();
		supplier.setSupplierID(supplierID);
		supplier.setDroneID(droneID);
		supplier.setEmail(email);
		supplier.setPhone(Phone);
		supplier.setVendorFirstName(vendorFirst);
		supplier.setVendorLastName(vendorLast);
		supplier.setService_Number(serviceNumber);
		
		AddSupplier add = new AddSupplier("drone_inventory","root","1234");
		
		add.addSupplier(supplier);
		String url = "/supplier";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
		
	}

}
