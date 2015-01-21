//this model is used by the conference chair to invite the reviewers for the conference from the contactbook
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conferencechairbean.ConferenceChairBean;
import db.DbConnection;

public class InviteReviewersModel {
	
	ConferenceChairBean c = new ConferenceChairBean();
	public ConferenceChairBean doInviteReviewers(){
		
		ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();
		try
		{
			DbConnection d = new DbConnection();
			Statement ps = null;
			ResultSet rs=null;
			ps=d.DbConnection1();
			
			String sql = "select * from chaircontacts";
			rs=ps.executeQuery(sql);
			
			while(rs.next())
			{
				ArrayList<String> singleRecordArray = new ArrayList<String>();
				singleRecordArray.add(rs.getString("firstname"));
				singleRecordArray.add(rs.getString("lastname"));
				singleRecordArray.add(rs.getString("email"));
				a.add(singleRecordArray);	
			}
			
			c.setContacts(a);
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
}
