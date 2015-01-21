//Comments - This for the admin to create the conference 
package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import authorbean.AuthorBean;


import model.CreateConferenceModel;

import conferencechairbean.ConferenceChairBean;

public class CreateConferenceCtr extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		ConferenceChairBean c = (ConferenceChairBean) session.getAttribute("currentchairSession");
		
		c.setConference_description(request.getParameter("description"));
		c.setConferencename(request.getParameter("cname"));
		c.setConferenceplace(request.getParameter("place"));
		c.setUsername(c.getUsername());
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date date1=null;
		java.util.Date date2=null;
		java.util.Date date3=null;
		
		try {
			date1 = sdf1.parse(request.getParameter("date1"));
			date2 = sdf1.parse(request.getParameter("date2"));
			date3 = sdf1.parse(request.getParameter("date3"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqlStartDate1 = new java.sql.Date(date1.getTime());
		java.sql.Date sqlStartDate2 = new java.sql.Date(date2.getTime());
		java.sql.Date sqlStartDate3 = new java.sql.Date(date3.getTime());
		
		c.setAbstract_date(sqlStartDate1);
		c.setPaper_date(sqlStartDate2);
		c.setConference_date(sqlStartDate3);
		
		CreateConferenceModel m = new CreateConferenceModel();
		m.doCreateConference(c);
		response.sendRedirect("ConferenceChairLoginSuccess.jsp");
		
	}

}
