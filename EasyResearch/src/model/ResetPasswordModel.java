//This model is used by the author,conference chair and reviewer to reset the password which is fetched from the database.
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;




import controller.AutomaterEmailCtr;
import db.DbConnection;

public class ResetPasswordModel {
	
	
	public boolean checkPassword(String user_name,String type1){
		
		String password=null;
		String type=null;
		String email=null;
		
		try 
		{
			DbConnection d = new DbConnection();
			Statement ps = null;
			ResultSet rs=null;
			ps=d.DbConnection1();
			
			String sql = "select password,type from login where username='"+user_name+"'"; 
			rs=ps.executeQuery(sql);
			
			while(rs.next()){
				password = rs.getString("password");
				System.out.println(password);
				type=rs.getString("type");
				System.out.println(type);
			}
			
			if(type.equalsIgnoreCase(type1)){
				type=type.toLowerCase();
				
				String sql1="select email from "+type+"details where username='"+user_name+"'";
				rs=ps.executeQuery(sql1);
				
				while(rs.next()){
					email= rs.getString("email");
				}

				ps.close();
				
				String subject="EasyResearch Password";
				String message="Your password is " + password;
				
				AutomaterEmailCtr a = new AutomaterEmailCtr();
				a.sendEmailMessage(email,subject,message);
				
				return true;
			}
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}		
		return false;
	}
}
