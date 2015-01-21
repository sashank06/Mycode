//This controller is for validating the conference chair login
package controller;
import javax.servlet.http.*;
import javax.servlet.*;


import java.io.*;

import conferencechairbean.ConferenceChairBean;

import model.*;
public class ConferenceChairLoginCtr extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		processRequest(request, response);
		try {
			ConferenceChairBean c = new ConferenceChairBean();
			String username = request.getParameter("username");
			String password=request.getParameter("password");
			if("".equals(username) || "".equals(password)){
				   response.sendRedirect("ConferenceChair.jsp");
			}
			else{
				c.setUsername(username);
				c.setPassword(password);
				
				ConferenceChairloginModel cm = new ConferenceChairloginModel();
				cm.dologinCheck(c);
				if(c.isValid()){
					HttpSession session = request.getSession(true);
					   session.setAttribute("currentchairSession",c);
					   response.sendRedirect("ConferenceChairLoginSuccess.jsp");
				}
				else{
					String status = "Invalid Login Credentials";
					request.setAttribute("Invalid Login Credentials", status);
					request.getRequestDispatcher("ConferenceChair.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}