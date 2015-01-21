//This model is used to add conference by the admin.
package model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conferencechairbean.ConferenceChairBean;
import db.DbConnection;

public class CreateConferenceModel {

	public void doCreateConference(ConferenceChairBean c){
		
		try 
		{
			DbConnection d = new DbConnection();
			Statement ps = null;
			ResultSet rs=null;
			ps=d.DbConnection1();
			
			rs=getCountofConferences();
			
			int count=0;
			while(rs.next()){
				count++;
			}
			count++;
			
			String sql1="insert into listofconferences values('"+count+"','"+c.getConferencename()+"','"+c.getConferenceplace()+"','"+c.getUsername()+"','"+c.getConference_description()+"','"+c.getAbstract_date()+"','"+c.getPaper_date()+"','"+c.getConference_date()+"')";
			ps.executeUpdate(sql1);
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet getCountofConferences(){
		
		DbConnection d = new DbConnection();
		Statement ps = null;
		ResultSet rs=null;
		ps=d.DbConnection1();
		try 
		{
			String sql="select * from er.listofconferences";
			rs=ps.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
