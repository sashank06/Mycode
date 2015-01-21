//This model is used by the conference chair to make a decision on the paper which have been evaluated by the reviewers.
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conferencechairbean.ConferenceChairBean;
import db.DbConnection;

public class MakeDecisionModel {
	
	public ConferenceChairBean makeDecisiononPaper(ConferenceChairBean c){
		
		
		try 
		{
			DbConnection d = new DbConnection();
			Statement ps = null;
			Statement ps1 = null;
			ResultSet rs=null;
			ResultSet rs1=null;
			ps=d.DbConnection1();
			ps1=d.DbConnection1();
			Statement ps2=null;
			ps2=d.DbConnection1();
			ResultSet rs2=null;
			
			ArrayList<Object> a = new ArrayList<Object>();

						
			String sql="select * from (select count(*) as commentcount,paperid from reviewercomments rc group by rc.paperid) as temp where temp.commentcount =3 ";
			rs=ps.executeQuery(sql);
			while(rs.next()){
					
				int paperId=0;
				paperId=Integer.parseInt(rs.getString("paperid"));
				ArrayList<Object> singlePaper= new ArrayList<Object>();
				
				String sql1="select title,conferenceid,conferencename,paper.id,paperlocation from paper, listofconferences where paper.conferenceid = listofconferences.id and paper.id='"+paperId+"'";
				rs1=ps1.executeQuery(sql1);
					
				while(rs1.next()){		
					singlePaper.add(rs1.getString("paper.id"));
					singlePaper.add(rs1.getString("conferencename"));
					singlePaper.add(rs1.getString("title"));
					singlePaper.add(rs1.getString("paperlocation"));
				}
				
				String sql2="select firstname,lastname,comments from reviewercomments, reviewerdetails where username = rusername and paperid='"+paperId+"'";
				rs2=ps2.executeQuery(sql2);
				
				while(rs2.next()){
					ArrayList<String> singlePaperReviewerComment= new ArrayList<String>();
					
					singlePaperReviewerComment.add(rs2.getString("firstname"));
					singlePaperReviewerComment.add(rs2.getString("lastname"));
					singlePaperReviewerComment.add(rs2.getString("comments"));
					
					singlePaper.add(singlePaperReviewerComment);
				}
				a.add(singlePaper);	
			}
			c.setFinalcomments(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public String saveFinalDecision(ConferenceChairBean c){
		String email="";
		try
		{
			DbConnection d = new DbConnection();
			Statement ps = null;
			Statement ps1 = null;
			ResultSet rs=null;
			ResultSet rs1=null;
			ps=d.DbConnection1();
			ps1=d.DbConnection1();
		
			int paperid=Integer.parseInt(c.getPaperId());
			ps.executeUpdate("update paper set status='"+c.getFinaldecision()+"' where id='"+paperid+"'");
		     
			rs=ps.executeQuery("select authorusername from paper where id='"+paperid+"'");
		
			while(rs.next()){
				rs1=ps1.executeQuery("select email from authordetails where username='"+rs.getString("authorusername")+"'");
				while(rs1.next()){
					email=rs1.getString("email");
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return email;
	}
}
