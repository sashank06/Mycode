//This model is used to register the author into the system and values are stored in the database
package model;

import java.sql.SQLException;
import java.sql.Statement;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import authorbean.AuthorBean;
import controller.AutomaterEmailCtr;
import db.DbConnection;

public class SignupAuthorModel 
{
	public void doSignupAuthor(AuthorBean b) 
	{
		try 
		{
			
			DbConnection d = new DbConnection();
			Statement ps = null;
			ps=d.DbConnection1();
			
			String firstname=b.getFirstname();
			String lastname= b.getLastname();
			String user_name=b.getUsername();
			String pass_word=b.getPassword();
			String email=b.getEmail();
			String authortype=b.getAuthortype();
			String address=b.getAddress();
			String city=b.getCity();
			String state=b.getState();
			String country=b.getPhone();
			String phone=b.getPhone();
			String company=b.getCompany();
			
			String sql1 = "insert into er.login VALUES('"+user_name+"','"+pass_word+"','Author')";
			ps.executeUpdate(sql1);
	
			String sql = "insert into er.authordetails VALUES('"+firstname+"','"+lastname+"','"+email+"','"+company+"','"+authortype+"','"+address+"','"+city+"','"+state+"','"+country+"','"+phone+"','"+user_name+"')";
    		ps.executeUpdate(sql);
			
    		b.setInserted(true);
			b.setEmailmessage("Your Easy Research account is created successfully");
			b.setEmailsubject("Easy Research Account Created");
			
			ps.close();
			try 
			{	
				if(b.isInserted()){
					AutomaterEmailCtr e1 = new AutomaterEmailCtr();
					e1.sendEmailMessage(b);
				}
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