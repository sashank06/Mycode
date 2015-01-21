//Comments- This controller is for Author Logout 
package controller;
import java.io.IOException;

import authorbean.*;

import javax.servlet.http.*;
import javax.servlet.*;

public class AuthorLogoutCtr extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		AuthorBean b = (AuthorBean) session.getAttribute("currentUserSession");
		if(b==null)
			response.sendRedirect("AuthorLogin.jsp");
		else{
			session.removeAttribute("currentUserSession");
			session.invalidate();
			b=null;
			response.sendRedirect("AuthorLogin.jsp");
		}
	}
}
