//Comments  - This controller is for evaluating the paper by the reviewers
package controller;

import java.io.IOException;
import model.EvaluatePaperModel;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import reviewerbean.ReviewerBean;

public class EvaluatePaperCtr extends HttpServlet{
	EvaluatePaperModel e = new EvaluatePaperModel();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		ReviewerBean r= (ReviewerBean) session.getAttribute("currentReviewerSession");
		r=e.getEvaluatePaper(r);
		request.setAttribute("Reviewer", r);
		request.getRequestDispatcher("ReviewerEvaluatePaper.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		ReviewerBean r= (ReviewerBean) session.getAttribute("currentReviewerSession");
		String comments=request.getParameter("reviewerPaperComments");
		r.setComments(comments);
		String paperlocation=request.getParameter("paperLocationSave");
		System.out.println(paperlocation);
		r.setPaperlocation(paperlocation);
		e.doSaveEvaluatePaper(r);
		response.sendRedirect("ReviewerLoginSuccess.jsp");
		
	}
}