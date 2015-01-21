//Comments- This controller is for checking the status of abstract and paper for the author
package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CheckStatusAuthorModel;

import authorbean.AuthorBean;
public class CheckStatusAuthorCtr extends HttpServlet{
	CheckStatusAuthorModel chk = new CheckStatusAuthorModel();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		AuthorBean c = (AuthorBean) session.getAttribute("currentUserSession");
		c = chk.doLogincheck(c);
		request.setAttribute("conference",c);
		request.getRequestDispatcher("CheckStatusAuthor.jsp").forward(request, response);
	}
}