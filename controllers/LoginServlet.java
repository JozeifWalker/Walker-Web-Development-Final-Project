package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dbHelpers.AdminReaderHelper;
import model.Admins;
/**
 * Servlet implementation class LoginController
 */
@WebServlet(description = "A controller for handling user logins", urlPatterns = { "/Login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session; 
	private String url;
	private int loginAttempts;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession();

		//check to make sure we've clicked link
		if(request.getParameter("logout") !=null){

			//logout and redirect to frontpage
			logout();
			url="login.jsp";
		}
		//forward our request along
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		session = request.getSession();

		//get the number of logins
		if(session.getAttribute("loginAttempts") == null){
			loginAttempts = 0;
		}
		
		//exceeded logins
		if(loginAttempts > 2){
			String errorMessage = "Error: Number of Login Attempts Exceeded";
			request.setAttribute("errorMessage", errorMessage);
			url = "login.jsp";
		}else{	//proceed
			//pull the fields from the form
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			AdminReaderHelper ah ;
			Admins admin = null;
			try {
				ah = new AdminReaderHelper();
				
				admin = ah.authentication(username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//we've found a user that matches the credentials
			if(admin != null) {
				session.invalidate();
				session=request.getSession(true);
				session.setAttribute("admin", admin);
				url="admin_Home.jsp";
				}
			// user doesn't exist, redirect to previous page and show error
						else{
							String errorMessage = "Error: Unrecognized Username or Password<br>Login attempts remaining: "+(3-(loginAttempts));
							request.setAttribute("errorMessage", errorMessage);

							//track login attempts (combats: brute force attacks)
							session.setAttribute("loginAttempts", loginAttempts++);
							url = "login.jsp";
						}
					}
					//forward our request along
					RequestDispatcher dispatcher = request.getRequestDispatcher(url);
					dispatcher.forward(request, response);
				}

				/**
				 * Logs the user out
				 */
				public void logout() {
					session.invalidate();
				}
			

	

	}


