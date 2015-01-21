//This model is used to submit the reviewer details and store his details into the database
package model;

import java.sql.SQLException;
import java.sql.Statement;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import reviewerbean.ReviewerBean;
import controller.AutomaterEmailCtr;
import db.DbConnection;

public class SignupReviewerModel {

	public void doSignupReviewer(ReviewerBean b) 
	{
		try 
		{				
			DbConnection d = new DbConnection();
			Statement ps = null;
			ps=d.DbConnection1();
			String cid=b.getChairusername();
			
			String firstname=b.getFirstname();
			String lastname= b.getLastname();
			String user_name=b.getUsername();
			String pass_word=b.getPassword();
			String email=b.getEmail();
			String paoi=b.getPareaofinterest();
			String saoi=b.getSareaofinterest();
			
    		String sql1 = "insert into er.login VALUES('"+user_name+"','"+pass_word+"','Reviewer')";
    		ps.executeUpdate(sql1);  
    		
    		String sql = "insert into er.reviewerdetails VALUES('"+firstname+"','"+lastname+"','"+user_name+"','"+email+"','"+paoi+"','"+saoi+"','"+cid+"')";
			ps.executeUpdate(sql);
			
			b.setEmailmessage("Your Easy Research account is created successfully");
			b.setEmailsubject("Easy Research Account Created");
			
			ps.close();
			try
			{		
				AutomaterEmailCtr e1 = new AutomaterEmailCtr();
				e1.sendEmailMessage(b);
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}			
			
			b.setValid(true);
		} catch (SQLException e) {
 			e.printStackTrace();
 		}
	}
}