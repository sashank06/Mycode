//Comments - This controller creates the reviewer account into the system
package controller;
import java.awt.HeadlessException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.SignupReviewerModel;
import reviewerbean.ReviewerBean;


public class SignupReviewerCtr extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
		processRequest(request, response);
		try{
			
			ReviewerBean b = new ReviewerBean();
			String cid=request.getParameter("chairUser");
			String firstname=request.getParameter("fname");
			String lastname=request.getParameter("lname");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String repassword=request.getParameter("retypepassword");
			String email=request.getParameter("Email");
			//String reemail=request.getParameter("ReEmail");
			String paoi=request.getParameter("primaryaoi");
			String saoi=request.getParameter("secondaryaoi");
			if(("".equalsIgnoreCase(firstname.trim()))|| ("".equalsIgnoreCase(lastname.trim())) || ("".equalsIgnoreCase(username.trim())) || ("".equalsIgnoreCase(password.trim())) || ("".equalsIgnoreCase(repassword.trim())) || ("".equalsIgnoreCase(email.trim())) || ("".equalsIgnoreCase(paoi.trim())) || ("".equalsIgnoreCase(saoi.trim())))
			{
				response.sendRedirect("SignupReviewer.jsp");
			}
			else if((password!=null && !password.trim().equals(repassword.trim())))
					{
				response.sendRedirect("SignupReviewer.jsp");
			}
			else
			{
			
			b.setFirstname(firstname);
			b.setLastname(lastname);
			b.setUsername(username);
			b.setEmail(email);
			b.setPassword(password);
			b.setPareaofinterest(paoi);
			b.setSareaofinterest(saoi);
			b.setChairusername(cid);
		
			
			SignupReviewerModel s = new SignupReviewerModel();
			try {
				s.doSignupReviewer(b);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			if(b.isValid()){
				//HttpSession session = request.getSession(true);
				// session.setAttribute("currentUserSession",b);
				response.sendRedirect("ReviewerLoginSuccess.jsp");
			}					   
		}
		} catch (HeadlessException e) {
			e.printStackTrace();
		}
	}

}
