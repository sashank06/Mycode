//Comments - this controller is for admin creating the conference chair
package controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conferencechairbean.ConferenceChairBean;

import model.CreateConferenceChairModel;

public class CreateConferenceChairCtr extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ConferenceChairBean b = new ConferenceChairBean();
		String firstname= request.getParameter("fname");
		String email= request.getParameter("email");
		String user_name=request.getParameter("username");
		String pass_word=request.getParameter("password");
		String lastname=request.getParameter("lname");
		if("".equals(user_name) || "".equals(pass_word)){
			response.sendRedirect("CreateConferenceChair.jsp");
		}
		else{
			b.setUsername(user_name);
			b.setPassword(pass_word);
			b.setFirstname(firstname);
			b.setEmail(email);
			b.setLastname(lastname);

			CreateConferenceChairModel a = new CreateConferenceChairModel();
			a.doCreateChair(b);
			try {
				AutomaterEmailCtr e1 = new AutomaterEmailCtr();
				e1.sendEmailMessage(b);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				response.sendRedirect("AdminPage.jsp");
			
		}
	}

}
