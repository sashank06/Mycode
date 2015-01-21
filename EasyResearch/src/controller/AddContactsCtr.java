
//Comments- This controller adds the Conference chair contacts into the address book
package controller;
import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;
import java.util.logging.Logger;

import conferencechairbean.ConferenceChairBean;
import model.*;

public class AddContactsCtr extends HttpServlet{
	
	
	ConferenceChairBean c = new ConferenceChairBean();
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	 		
		String firstname= request.getParameter("AddContactFirstname");
		String lastname=request.getParameter("AddContactLastname");
		String email = request.getParameter("AddContactEmail");
		
		c.setContact_firstname(firstname);
		c.setContact_lastname(lastname);
		c.setContact_email(email);
		
		AddContactsModel a = new AddContactsModel();
		a.doAddContacts(c);
		if(c.isValid()){
			response.sendRedirect("AddContacts.jsp");
		}
	}
}
