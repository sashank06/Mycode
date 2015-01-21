//This model used to obtain user specific details like email from the database
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conferencechairbean.ConferenceChairBean;
import db.DbConnection;

public class UserDetailModel {
	
	public String getUserEmail(Object o){

		String email="";
		
		if(o instanceof ConferenceChairBean){
			ConferenceChairBean a = (ConferenceChairBean)o;
		
			try {
				DbConnection d = new DbConnection();
				Statement ps = null;
				ResultSet rs=null;
				ps=d.DbConnection1();
				
				String user_name=a.getUsername();
				
				String sql1="select email from chairdetails where username='"+user_name+"'";
				rs=ps.executeQuery(sql1);
	
				while(rs.next()){
				 email =rs.getString("email");
				a.setEmail(email);
				}
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return email;
	}
}
