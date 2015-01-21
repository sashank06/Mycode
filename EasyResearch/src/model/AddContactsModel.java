//This model is used to add contacts of the chair person into the database.
package model;
import java.sql.SQLException;
import java.sql.Statement;

import conferencechairbean.ConferenceChairBean;
import db.DbConnection;

public class AddContactsModel {
	
	public void doAddContacts(ConferenceChairBean c){
		
		try {
			DbConnection d = new DbConnection();
			Statement ps = null;
			ps=d.DbConnection1();

			String fname= c.getContact_firstname();
			String lname=c.getContact_lastname();
			String email=c.getContact_email();
			
			String sql="insert into chaircontacts values('"+fname+"','"+lname+"','"+email+"')";
			ps.executeUpdate(sql);
			
			c.setValid(true);	
			ps.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
