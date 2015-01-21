//Comments- This controller is for admin Login validation.
package controller;
import javax.servlet.http.*;
import javax.servlet.*;

import model.AdminModel;

import admin.AdminBean;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminCtr extends HttpServlet {
	Logger logger = Logger.getLogger("loggin");
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		String username=request.getParameter("username");
		String password = request.getParameter("password");
		if("".equals(username) || "".equals(password)){
			response.sendRedirect("Admin.jsp");
		}
		
		AdminBean a = new AdminBean();
		a.setUsername(username);
		a.setPassword(password);
		
		AdminModel b = new AdminModel();
		b.doLogincheck(a);
		if(a.isValid())
		{
			logger.log(Level.INFO,"Admin Loggedin");
			HttpSession session = request.getSession(true);
		
			session.setAttribute("AdminSession",a);
			
			response.sendRedirect("AdminPage.jsp");
		}
		else{
			logger.log(Level.INFO,"Admin Loggedin failed");
			String status = "Invalid Login Credentials";
			request.setAttribute("Invalid Login Credentials", status);
			request.getRequestDispatcher("Admin.jsp").forward(request, response);
		}
		

}
}