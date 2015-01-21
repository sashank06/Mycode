//This model is used by the reviewer to login into his account and get the list of papers which have been assigned to him and he can make a decision of accept and reject.
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import reviewerbean.ReviewerBean;
import db.DbConnection;

public class ReviewerNotificationsModel{
	
	public ReviewerBean getAbstractDetails(ReviewerBean r){
		
		String ruser=null;
		String paperid=null;
		String abstracttext=null;
		String title=null;
		String conferencename=null;
		ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();		
		int id=0;
		
		try 
		{
			DbConnection d = new DbConnection();
			Statement ps = null;
			Statement ps1 = null;
			Statement ps2 = null;
			ResultSet rs=null;
			ResultSet rs1=null;
			ResultSet rs2=null;
			ps=d.DbConnection1();
			ps1=d.DbConnection1();
			ps2=d.DbConnection1();
			
			String sql="select ruser1,paperid from tempreviewersassign where ruser1='"+r.getUsername()+"' and statusofreviewers='pending'";
            rs=ps.executeQuery(sql);
            while(rs.next()) {
            	 ruser=rs.getString("ruser1");
            	 paperid=rs.getString("paperid");
            	 id=Integer.parseInt(paperid);
             
            	
            	 String sql1="select title,abstract from abstract where id=(select abstractid from paper where id='"+id+"')";           	
            	 rs1=ps1.executeQuery(sql1);
            	 while(rs1.next())
            	 {
	             	ArrayList<String> reviewernotification = new ArrayList<String>();
	              	reviewernotification.add(rs1.getString("title"));
	            	reviewernotification.add(rs1.getString("Abstract"));
	            	String sql2="select conferencename from listofconferences where id=(select conferenceid from abstract where title='"+rs1.getString("title")+"')";
	            	rs2=ps2.executeQuery(sql2);
	            	
	            	while(rs2.next()){
	            		reviewernotification.add(rs2.getString("conferencename"));
	            	}
	            	a.add(reviewernotification);
            	 }
             }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		r.setReviewernotification(a);
		return r;
	}
	
	public void saveDecision(ReviewerBean r){
		
		try
		{
			DbConnection d = new DbConnection();
			Statement ps = null;
			Statement ps1 = null;
			ResultSet rs=null;
			ResultSet rs1=null;
			ps=d.DbConnection1();
			ps1=d.DbConnection1();
			
			String cname=null;
			String rname=null;
			int count=0;
			int pid,cid;
			
			String sql="update tempreviewersassign set statusofreviewers='"+r.getDecision()+"' where ruser1='"+r.getUsername()+"'";
			ps.executeUpdate(sql);
			
			if(r.getDecision().equals("Accept")) {
				String sql1="select l.id,l.chairusername,t.ruser1,t.paperid from listofconferences l,tempreviewersassign t,paper p where t.paperid=p.id and p.conferenceid=l.id and t.ruser1='"+r.getUsername()+"'";
				rs=ps.executeQuery(sql1);
				
				while(rs.next()) {
					cname=rs.getString("l.chairusername");
					rname=rs.getString("t.ruser1");
					cid=Integer.parseInt(rs.getString("l.id"));
					pid=Integer.parseInt(rs.getString("t.paperid"));
					rs1=ps1.executeQuery("select count(*) as count from reviewerjob");
				    while(rs1.next()){
				    	count=rs1.getInt(1);
				    }
				    count++;
				    ps.executeUpdate("insert into reviewerjob values('"+count+"','"+cid+"','"+cname+"','"+rname+"','"+pid+"')");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
