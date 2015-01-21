//Comments - This controller loads the home page and displays all the conference available dynamically
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conferencebean.ConferenceBean;



import model.ListofConferencesModel;

public class HomeCtr extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger("myLogger");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.log(Level.INFO, "Getting List of Conferences");
		ConferenceBean a = new ConferenceBean();
		ListofConferencesModel l = new ListofConferencesModel();
		a=l.getListofConferencesonHome();
		request.setAttribute("conferences",a);
		logger.log(Level.INFO, "Redirecting to Home Page");
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.log(Level.INFO, "Getting List of Conferences");
		ConferenceBean a = new ConferenceBean();
		ListofConferencesModel l = new ListofConferencesModel();
		a=l.getListofConferencesonHome();
		request.setAttribute("conferences",a);
		logger.log(Level.INFO, "Redirecting to Home Page");
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}
}