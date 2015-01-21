//This model is used by the conference chair to populate the list of reviewers to whom the papers have been submitted and current status of decision.
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conferencechairbean.ConferenceChairBean;
import db.DbConnection;

public class ConferenceChairNotificationModel
{
	public ConferenceChairBean checknotifyStatus(ConferenceChairBean c)
	{
	
		ArrayList<ArrayList<String>> notify = new ArrayList<ArrayList<String>>();
		String chairConference = new String();
		try{
			DbConnection d = new DbConnection();
			Statement ps = null;
			ResultSet rs=null;
			ps=d.DbConnection1();
			
			String sql = "select t.*, l.conferencename, p.title, rd.firstname,rd.lastname from tempreviewersassign as t, reviewerdetails as rd, paper as p,listofconferences as l where rd.username = t.ruser1 and t.paperid=p.id and p.conferenceid=l.id and l.chairusername='"+c.getUsername()+"'";
			rs=ps.executeQuery(sql);
			while(rs.next()){
				ArrayList<String> chairnotify = new ArrayList<String>();
				chairnotify.add(rs.getString("tid"));
				chairnotify.add(rs.getString("paperid"));
				chairnotify.add(rs.getString("title"));
				chairnotify.add(rs.getString("firstname"));
				chairnotify.add(rs.getString("lastname"));
				chairnotify.add(rs.getString("ruser1"));
				chairnotify.add(rs.getString("statusofreviewers"));	
				chairConference = rs.getString("conferencename");
				notify.add(chairnotify);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		c.setChairnotify(notify);
		c.setConferencename(chairConference);
		return c;
	}
}