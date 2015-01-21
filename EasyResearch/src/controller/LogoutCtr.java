//Comments - This controller logouts all the users from the system except author
package controller;
import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.*;

public class LogoutCtr extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
			
			HttpSession session = request.getSession(false);
		
				session.removeAttribute("currentUserSession");
				session.invalidate();
				
			
			request.getRequestDispatcher("/Home").forward(request,response);
}
}