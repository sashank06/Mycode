//Comments - This controller validates the reviewer login 
package controller;
import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;

import reviewerbean.ReviewerBean;
import model.*;

public class ReviewerLoginCtr extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		            throws ServletException, IOException {
	}
		
 	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
 		
		processRequest(request, response);
		try {
			ReviewerBean r = new ReviewerBean();
			String user_name=request.getParameter("username");
			String pass_word=request.getParameter("password");
			if("".equals(user_name) || "".equals(pass_word)){
				response.sendRedirect("ReviewerLogin.jsp");
			}
			else{
				r.setUsername(user_name);
				r.setPassword(pass_word);
   
				ReviewerLoginModel l = new ReviewerLoginModel();
				l.dologincheck(r);
				if(r.isValid()){
					HttpSession session = request.getSession(true);
					session.setAttribute("currentReviewerSession",r);
					response.sendRedirect("ReviewerLoginSuccess.jsp");
				}
				else{
					String status = "Invalid Login Credentials";
					request.setAttribute("Invalid Login Credentials", status);
					request.getRequestDispatcher("ReviewerLogin.jsp").forward(request, response);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}


