//Controller - This controller enables the users to get their password if they have forgotten
package controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.ResetPasswordModel;

public class ResetPasswordCtr extends HttpServlet{
	boolean flag;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username= request.getParameter("resetPassUsername");
		String type=request.getParameter("callingUser");
		System.out.println(type);
		
		if("".equals(username)){
			response.sendRedirect("ResetPassword.jsp");
		}
		else
		{
			
			ResetPasswordModel r = new ResetPasswordModel();
			flag=r.checkPassword(username,type);
			if(flag==true){
				response.sendRedirect("/EasyResearch/Home");
			}
			else{
				String status = "Invalid Username";
				request.setAttribute("Invalid Username", status);
				request.getRequestDispatcher("ResetPassword.jsp?user="+type).forward(request, response);
				
			}
		}
	}

}
