//Comments - This controller uploads the research paper into the server
package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CheckStatusAuthorModel;
import model.UploadPaperModel;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import authorbean.AuthorBean;

public class UploadPaperCtr extends HttpServlet{
	String name;
	CheckStatusAuthorModel c = new CheckStatusAuthorModel();
	
	private final String UPLOAD_DIRECTORY = "D:/EasyResearchFiles";
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		HttpSession session = request.getSession(false);
		AuthorBean a= (AuthorBean) session.getAttribute("currentUserSession");
		
		
		 if(ServletFileUpload.isMultipartContent(request)){
		try {
	        List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			for(FileItem item : multiparts){
		        if(!item.isFormField()){
	             name = new File(item.getName()).getName();
		         item.write( new File(UPLOAD_DIRECTORY + "/"+ name));
		         
			             }
		        if(item.isFormField() && "uploadPaperAbstractId".equals(item.getFieldName())){
		        	a.setAbstractid(Integer.parseInt(item.getString()));
		        }
		        
		        if(item.isFormField() && "uploadPaperTitleName".equals(item.getFieldName())){
		        	a.setTitle(item.getString());
		        }
			}
			
			a.setPapername(name);
			 a.setPaperlocation(UPLOAD_DIRECTORY + "/" + name);
			
			a.setUsername(a.getUsername());
			//a.setAbstractid((Integer.parseInt(request.getParameter("uploadPaperAbstractId"))));
			a=c.getConferencesAuthor(a);
			UploadPaperModel u = new UploadPaperModel();
			u.doSavePaper(a);
			a.setEmailmessage("Your Paper has been submitted Successfully and the status is under review");
			a.setEmailsubject("Easy Research Paper Confirmation");
			try {		
				AutomaterEmailCtr e1 = new AutomaterEmailCtr();
				e1.sendEmailMessage(a);
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}			
			
			
			
			
			               
//request.setAttribute("message", "File Uploaded Successfully");
			            } catch (Exception ex) {
			               request.setAttribute("message", "File Upload Failed due to " + ex);
			            }         
			          
			        }else{
			            request.setAttribute("message",
			                                 "Sorry this Servlet only handles file upload request");
			        }
			     
			        request.getRequestDispatcher("AuthorLoginSuccess.jsp").forward(request, response);
			      
			    }

}
