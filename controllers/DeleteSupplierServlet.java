package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.DeleteSupplierQuery;

/**
 * Servlet implementation class DeleteSupplierServlet
 */
@WebServlet(description = "Deletes a record for a particular supplier ID", urlPatterns = { "/deleteSupplier" })
public class DeleteSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSupplierServlet() {
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
	    String SupplierID = request.getParameter("SupplierID");
	    DeleteSupplierQuery del = new DeleteSupplierQuery("drone_inventory","root","1234");
	    
	    del.doDelete(SupplierID);
	    String url = "/supplier";
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	    
	}

}
