// Comments - this controller populates all the notifications like the reviewers accepted list

package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ConferenceChairNotificationModel;
import conferencechairbean.ConferenceChairBean;

public class ConferenceChairNotificationCtr extends HttpServlet{
	ConferenceChairNotificationModel chk=new ConferenceChairNotificationModel();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		ConferenceChairBean c = (ConferenceChairBean) session.getAttribute("currentchairSession");
		c = chk.checknotifyStatus(c);
		request.setAttribute("conference1",c);
		request.getRequestDispatcher("ConferenceChairNotification.jsp").forward(request, response);	
		
	}
}


