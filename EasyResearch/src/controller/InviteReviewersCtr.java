// Comments - This Controller is invite the reviewers based on the address book
package controller;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.net.*;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import model.InviteReviewersModel;

import conferencechairbean.ConferenceChairBean;

import authorbean.AuthorBean;

import reviewerbean.ReviewerBean;


public class InviteReviewersCtr extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	InviteReviewersModel ir=new InviteReviewersModel();
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	
		HttpSession session = request.getSession(false);
		ConferenceChairBean c = (ConferenceChairBean) session.getAttribute("currentchairSession");
		c = ir.doInviteReviewers();
		request.setAttribute("conference",c);
		request.getRequestDispatcher("InviteReviewers.jsp").forward(request, response);
	}
	
		
	


	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{

		try {
			HttpSession session = request.getSession(false);
			ConferenceChairBean c = (ConferenceChairBean) session.getAttribute("currentchairSession");
			
			String email = request.getParameter("email");
			ReviewerBean r = new ReviewerBean();
			r.setEmail(email);
			InetAddress inetAddr = InetAddress.getLocalHost();
			
			String subject = "Easy Research Invitation";
			String message="You are invited for the Conference.Please Click on the below link to signup and view/rate Papers http://"+inetAddr.getHostAddress()+":8090/EasyResearch/SignupReviewer.jsp?_cid="+c.getUsername()+"";
			//String message="You are invited for the Conference.Please Click on the below link to signup and view/rate Papers http://"+inetAddr.getHostAddress()+":9002/EasyResearch/SignupReviewer.jsp?_cid="+c.getUsername()+"";
			r.setEmailmessage(message);
			r.setEmailsubject(subject);
			AutomaterEmailCtr a = new AutomaterEmailCtr();
			a.sendEmailMessage(r);
			response.sendRedirect("ConferenceChairLoginSuccess.jsp");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		catch(UnknownHostException e){
			e.printStackTrace();
		}
		
}
}
