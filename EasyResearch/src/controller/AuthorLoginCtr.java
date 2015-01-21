//Comments - This controller is for Author Login validation
package controller;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import authorbean.AuthorBean;
import model.*;

public class AuthorLoginCtr extends HttpServlet{
	Logger logger = Logger.getLogger("myLogger");
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		            throws ServletException, IOException {
	}
		
 	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
 		
		processRequest(request, response);
		try {
			AuthorBean b = new AuthorBean();
			String user_name=request.getParameter("username");
			String pass_word=request.getParameter("password");
			if("".equals(user_name) || "".equals(pass_word)){
				response.sendRedirect("AuthorLogin.jsp");
			}
			
			else{
				b.setUsername(user_name);
				b.setPassword(pass_word);
   
				AuthorloginModel a = new AuthorloginModel();
				a.dologincheck(b);
				if(b.isValid()){
					HttpSession session = request.getSession(true);
					session.setAttribute("currentUserSession",b);
					
					
					response.sendRedirect("AuthorLoginSuccess.jsp");
					
					logger.log(Level.INFO, "Author Loggedin");
				}
				else{
					logger.log(Level.INFO, "Author Loggedin Failed");
					String status = "Invalid Login Credentials";
					request.setAttribute("Invalid Login Credentials", status);
					request.getRequestDispatcher("AuthorLogin.jsp").forward(request, response);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}