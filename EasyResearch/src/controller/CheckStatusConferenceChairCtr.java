//Comments - This controller is for checking the status of abstract for the conference chair
package controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import authorbean.AuthorBean;



import model.AuthorloginModel;
import model.CheckStatusConferenceChairModel;

import conferencechairbean.ConferenceChairBean;


public class CheckStatusConferenceChairCtr extends HttpServlet{
	CheckStatusConferenceChairModel chk=new CheckStatusConferenceChairModel();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		ConferenceChairBean c = (ConferenceChairBean) session.getAttribute("currentchairSession");
		c = chk.doCheckStatus(c);
		request.setAttribute("conference1",c);
		request.getRequestDispatcher("CheckStatusConferenceChair.jsp").forward(request, response);	
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		ConferenceChairBean b=(ConferenceChairBean) session.getAttribute("currentchairSession");
        
		
		
		String title= request.getParameter("title");
		String conferencename=request.getParameter("nameofconf");
		String keyword= request.getParameter("abstractKeywords");
		String abstract_paper=request.getParameter("abstractsText");
        String status = request.getParameter("decisionType");
        String authorusername=request.getParameter("Username");
        String abstractId = request.getParameter("abstractId");
        
      
        
        b.setTitle(title);
 		b.setKeywords(keyword);
 		b.setConferencename(conferencename);
 		b.setAbstract_paper(abstract_paper);
 		b.setStatus(status);
 		b.setAuthorusername(authorusername);
 		b.setAbstractId(abstractId);
 		
 		b= chk.doSaveStatus(b);
 		String status1="Accept";
 	if(b.getStatus().equals(status1)){
 		
 		
 	 		AuthorloginModel m = new AuthorloginModel();
 		m.getAuthorDetail(b);
 		String authoremail = b.getAuthoremail();
 		AutomaterEmailCtr e = new AutomaterEmailCtr();
 		try {
			e.sendEmailMessage(b, authoremail);
		} catch (AddressException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
 		response.sendRedirect("ConferenceChairLoginSuccess.jsp");
 	}
 	else{
		response.sendRedirect("ConferenceChairLoginSuccess.jsp");
 	}
 	
         

}
}
