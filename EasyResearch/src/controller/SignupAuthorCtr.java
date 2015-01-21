//Comments - This controller allows the author to create an account into the system
package controller;

import java.awt.HeadlessException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SignupAuthorModel;
import authorbean.AuthorBean;

public class SignupAuthorCtr extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
		processRequest(request, response);
		try{
			
			AuthorBean b = new AuthorBean();
			String firstname=request.getParameter("fname");
			String lastname=request.getParameter("lname");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String repassword=request.getParameter("retypepassword");
			String email=request.getParameter("Email");
			String reemail=request.getParameter("ReEmail");
			String company=request.getParameter("company");
			String authortype=request.getParameter("authortype");
			String address=request.getParameter("address");
			String city=request.getParameter("city");
			String state=request.getParameter("state");
			String country=request.getParameter("country");
			String phone=request.getParameter("phone");
			if(("".equalsIgnoreCase(firstname.trim()))|| ("".equalsIgnoreCase(lastname.trim())) || ("".equalsIgnoreCase(username.trim())) || ("".equalsIgnoreCase(password.trim())) || ("".equalsIgnoreCase(repassword.trim())) || ("".equalsIgnoreCase(email.trim())) || ("".equalsIgnoreCase(reemail.trim()))|| ("".equalsIgnoreCase(company.trim())) || ("".equalsIgnoreCase(address.trim())) || ("".equalsIgnoreCase(city.trim())) || ("".equalsIgnoreCase(state.trim())) || ("".equalsIgnoreCase(country.trim()))|| ("".equalsIgnoreCase(phone.trim()))||("".equalsIgnoreCase(authortype.trim())))
			{
				response.sendRedirect("SignupAuthor.jsp");
			}
			else if((password!=null && !password.trim().equals(repassword.trim()))
					|| (email!=null && !email.trim().equals(reemail.trim()))){
				response.sendRedirect("SignupAuthor.jsp");
			}
			else
			{
			b.setFirstname(firstname);
			b.setLastname(lastname);
			b.setUsername(username);
			b.setEmail(email);
			b.setPassword(password);
			b.setCompany(company);
			b.setAuthortype(authortype);
			b.setAddress(address);
			b.setCity(city);
			b.setState(state);
			b.setCountry(country);
			b.setPhone(phone);
			
			SignupAuthorModel s = new SignupAuthorModel();
			try {
				s.doSignupAuthor(b);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			if(b.isValid()){
				HttpSession session = request.getSession(true);
				session.setAttribute("currentUserSession",b);
				response.sendRedirect("AuthorLoginSuccess.jsp");
			}					   
		}
		} catch (HeadlessException e) {
			e.printStackTrace();
		}
	}
}