//This model is used to add conference by the admin.
package model;

import java.sql.SQLException;
import java.sql.Statement;

import conferencechairbean.ConferenceChairBean;

import db.DbConnection;

public class CreateConferenceChairModel {
	
	public void doCreateChair(ConferenceChairBean b){
		
		try 
		{
			DbConnection d = new DbConnection();
			Statement ps = null;
			ps=d.DbConnection1();
			
			String firstname=b.getFirstname();
			String email = b.getEmail();
			String username=b.getUsername();
			String password=b.getPassword();
			String lastname=b.getLastname();
					
			String newLine = System.getProperty("line.separator");
			
			String sql = "insert into er.login VALUES('"+username+"','"+password+"','Chair')";
			ps.executeUpdate(sql);
			String sql1="insert into er.chairdetails VALUES('"+firstname+"','"+lastname+"','"+email+"','"+username+"')";
			ps.executeUpdate(sql1);
			
			b.setEmailsubject("Easy Research Conference Chair Created");
			b.setEmailmessage("Hello Conference Chair . Welcome to Easy Chair. Please find your Login details" + newLine+ "Username: "+ b.getUsername() +newLine+ "Password : " +b.getPassword());
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
