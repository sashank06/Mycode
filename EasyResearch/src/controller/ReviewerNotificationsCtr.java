// Comments - This controller enables the reviewer to see all the notifications in his dashboard like papers allocated to him/her
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ReviewerNotificationsModel;

import reviewerbean.ReviewerBean;

public class ReviewerNotificationsCtr extends HttpServlet{
	ReviewerNotificationsModel r = new ReviewerNotificationsModel();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		ReviewerBean c = (ReviewerBean) session.getAttribute("currentReviewerSession");
		
		c=r.getAbstractDetails(c);
		request.setAttribute("Reviewer", c);
		request.getRequestDispatcher("ReviewerNotifications.jsp").forward(request, response);
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		ReviewerBean c = (ReviewerBean) session.getAttribute("currentReviewerSession");
		String decision=request.getParameter("paperDecisionValue");
		c.setDecision(decision);
		r.saveDecision(c);
		response.sendRedirect("ReviewerLoginSuccess.jsp");
		
		
		
}
}