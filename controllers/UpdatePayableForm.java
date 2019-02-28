package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.ReadRecord_Payables;
import model.Payables;

/**
 * Servlet implementation class UpdatePayableForm
 */
@WebServlet({ "/UpdatePayableForm", "/updateAccounts" })
public class UpdatePayableForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePayableForm() {
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
	      String InvoiceID = request.getParameter("InvoiceID");
	      
	      ReadRecord_Payables rr  = new ReadRecord_Payables("project","root","1234",InvoiceID);
	      
	      rr.doRead();
	      
	      Payables pay = rr.getPay();
	      
	      request.setAttribute("pay", pay);
	      String url = "/updatePayables.jsp";
	      
	      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
	}

}
