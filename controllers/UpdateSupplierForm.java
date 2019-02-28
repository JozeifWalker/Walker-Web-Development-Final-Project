package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.ReadRecord_Supplier;
import model.Suppliers;

/**
 * Servlet implementation class UpdateSupplierForm
 */
@WebServlet(description = "This will get a drone and use the data to fill in a table for updating the record", urlPatterns = { "/updateSupplier" })
public class UpdateSupplierForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSupplierForm() {
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
		
		ReadRecord_Supplier rr = new ReadRecord_Supplier("project","root","1234",supplierID);
		
		rr.doRead();
		
		Suppliers supplier = rr.getSupplier();
		
		request.setAttribute("supplier", supplier);
		String url = "/updateSupplier.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
