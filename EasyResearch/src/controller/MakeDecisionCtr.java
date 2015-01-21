//Comments - This controller makes the conference chair to make a final decision on the paper
package controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conferencechairbean.ConferenceChairBean;

import model.MakeDecisionModel;

public class MakeDecisionCtr extends HttpServlet{
	MakeDecisionModel m = new MakeDecisionModel();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		ConferenceChairBean c = (ConferenceChairBean) session.getAttribute("currentchairSession");
		c=m.makeDecisiononPaper(c);
		request.setAttribute("finalcomments",c);
		request.getRequestDispatcher("MakeDecision.jsp").forward(request, response);
		
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			HttpSession session = request.getSession(false);
			ConferenceChairBean c = (ConferenceChairBean) session.getAttribute("currentchairSession");
			String decision=request.getParameter("finalPaperDecisionValue");
			String paper=request.getParameter("paperDecisionId");
			String message="";
			
			c.setPaperId(paper);
			
			c.setFinaldecision(decision);
			m.saveFinalDecision(c);
			String email=m.saveFinalDecision(c);
			String subject="EasyResearch Paper submission status Change";
			if(decision.equals("Accept")){
				 message="Congrats your paper has been Accepted.";
				
			}
			else{
				 message="We are sorry your paper has not been accepted.All the best for future";
			}
			AutomaterEmailCtr e = new AutomaterEmailCtr();
			e.sendEmailMessage(email, subject, message);
		} catch (AddressException e) {
			
			e.printStackTrace();
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		response.sendRedirect("ConferenceChairLoginSuccess.jsp");
}
}