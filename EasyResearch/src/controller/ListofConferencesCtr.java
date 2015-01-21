package controller;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import authorbean.AuthorBean;

import model.EditProfileAuthorModel;
import model.ListofConferencesModel;
public class ListofConferencesCtr extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ListofConferencesModel l = new ListofConferencesModel();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		AuthorBean c = (AuthorBean) session.getAttribute("currentUserSession");
		if(c==null){
			request.getRequestDispatcher("/Home").forward(request, response);
		}
		
		c = l.doListofConferences();
		
		request.setAttribute("conference",c);
		request.getRequestDispatcher("ListofConferences.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		AuthorBean b=(AuthorBean) session.getAttribute("currentUserSession");
		String username=b.getUsername();
		String email = b.getEmail();
		
		String title=request.getParameter("title");
		String conferencename=request.getParameter("nameofconf");
		String keyword= request.getParameter("keywords");
		String abstract_paper=request.getParameter("abstract");
		b.setTitle(title);
		b.setKeyword(keyword);
		b.setConferencename(conferencename);
		b.setAabstract(abstract_paper);
		
		
		b= l.doSaveListofConferences(b);
		b.setEmailmessage("Your abstract has been submitted Successfully and the status is under review");
		b.setEmailsubject("Easy Research Abstract Confirmation");
		
		try {		
			AutomaterEmailCtr e1 = new AutomaterEmailCtr();
			e1.sendEmailMessage(b);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}			
		
		
		response.sendRedirect("AuthorLoginSuccess.jsp");
		
		
		
		
		
				
			}
			
			}


