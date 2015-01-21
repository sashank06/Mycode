//Comments - This controller uploads the paper that the author submits.

package controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.io.output.*;


public class FileUploadCtr extends HttpServlet{
	private final String UPLOAD_DIRECTORY = "D:/EasyResearchFiles";
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		 
		
		 if(ServletFileUpload.isMultipartContent(request)){
		try {
	List<FileItem> multiparts = new ServletFileUpload(
			                   new DiskFileItemFactory()).parseRequest(request);
			               
		for(FileItem item : multiparts){
		 if(!item.isFormField()){
	String name = new File(item.getName()).getName();
		 item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
			                    }
			                }
			            
			               //File uploaded successfully
request.setAttribute("message", "File Uploaded Successfully");
			            } catch (Exception ex) {
			               request.setAttribute("message", "File Upload Failed due to " + ex);
			            }         
			          
			        }else{
			            request.setAttribute("message",
			                                 "Sorry this Servlet only handles file upload request");
			        }
			     
			        request.getRequestDispatcher("/result.jsp").forward(request, response);
			      
			    }
		
		
	}	
	


