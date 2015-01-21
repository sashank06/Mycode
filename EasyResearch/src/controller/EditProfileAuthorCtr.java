//Comments - This controller is for updating the profile of the author
package controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EditProfileAuthorModel;

import authorbean.AuthorBean;

public class EditProfileAuthorCtr extends HttpServlet{
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
}
	EditProfileAuthorModel b = new EditProfileAuthorModel();
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
processRequest(request, response);

HttpSession session = request.getSession(true);
AuthorBean c= (AuthorBean) session.getAttribute("currentUserSession");

b.doShowProfile(c);
request.setAttribute("user",c);

request.getRequestDispatcher("EditProfile.jsp").forward(request, response);
}

protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	AuthorBean a = new AuthorBean();
	a.setFirstname(request.getParameter("fname"));
	a.setLastname(request.getParameter("lname"));
	a.setCompany(request.getParameter("company"));
	a.setAuthortype(request.getParameter("authortype"));
	a.setAddress(request.getParameter("address"));
	a.setCity(request.getParameter("city"));
	a.setState(request.getParameter("state"));
	a.setCountry(request.getParameter("country"));
	a.setPhone(request.getParameter("phone"));
	b.doEditProfile(a);
	request.getRequestDispatcher("AuthorLoginSuccess.jsp").forward(request, response);
	
}
}

