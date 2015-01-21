//Comments- This controller is for assigning the paper to the conference chair
package controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import model.ChairAssignPaperModel;


import conferencechairbean.ConferenceChairBean;


public class ChairAssignPaperCtr extends HttpServlet{
	Logger logger = Logger.getLogger("logging");
	ChairAssignPaperModel m = new ChairAssignPaperModel();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		ConferenceChairBean c = (ConferenceChairBean) session.getAttribute("currentchairSession");
		
		
		c=m.getList(c);
		request.setAttribute("conference1",c);
		request.getRequestDispatcher("AssignReviewerPaper.jsp").forward(request, response);	
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		ConferenceChairBean c = (ConferenceChairBean) session.getAttribute("currentchairSession");
		
		String [] email=request.getParameterValues("reviewerList");
		String paperId= request.getParameter("paperId");
		c.setEmail_reviewers(email);
		c.setPaperId(paperId);
		c=m.saveTempReviewers(c);
		
		
		String message="You are assigned a paper in EasyResearch CMT.Please login to Accept or Reject  the review of Paper";
		String subject="Easy Research - Assigned Paper";
		
		for(int i=0;i<email.length;i++){
			String email_send=email[i];
		AutomaterEmailCtr a = new AutomaterEmailCtr();
		try {
			a.sendEmailMessage(email_send, subject, message);
		} catch (AddressException e) {
			logger.log(Level.INFO, "Sending Email to Reviewers failed for assigning the paper- Probably due to wrong email address");
			e.printStackTrace();
		} catch (MessagingException e) {
			logger.log(Level.INFO, "Sending Email to Reviewers failed for assigning the paper- Probably due to Server problem");
			e.printStackTrace();
		}
		}
		request.setAttribute("conference1",c);
		request.getRequestDispatcher("ConferenceChairLoginSuccess.jsp").forward(request, response);	
		}
	}


