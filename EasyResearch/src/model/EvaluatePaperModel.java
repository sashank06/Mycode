//This model is used by the reviewers to evaluate the papers which have been accepted by them.
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.DbConnection;
import reviewerbean.ReviewerBean;

public class EvaluatePaperModel {
	
	public ReviewerBean getEvaluatePaper(ReviewerBean r){
		try
		{
			DbConnection d = new DbConnection();
			Statement ps = null;
			ResultSet rs=null;
			ps=d.DbConnection1();
			ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();
			String sql="select p.title,p.paperlocation from paper p ,reviewerjob r where p.id=r.pid and r.reviewname='"+r.getUsername()+"' and not exists(select 1 from reviewercomments rc where rc.paperid = p.id and rc.rusername = r.reviewname)";
			rs=ps.executeQuery(sql);
			while(rs.next()){
				ArrayList<String> single = new ArrayList<String>();
				single.add(rs.getString("title"));
				single.add(rs.getString("paperlocation"));
				a.add(single);
			}
			r.setReviewergetpaper(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	public void doSaveEvaluatePaper(ReviewerBean r){
	
		try {
			int count=0;
			DbConnection d = new DbConnection();
			Statement ps = null;
			ResultSet rs=null;
			ResultSet rs1=null;
			ps=d.DbConnection1();
			int id=0;
			System.out.println("inside evaluate");
			String sql="select count(*) as count1 from reviewercomments";
			rs=ps.executeQuery(sql);
			while(rs.next()){
				count=rs.getInt("count1");
			}
			count++;
			System.out.println("count is "+ count);
			System.out.println(r.getPaperlocation());
			String sql1="select id from paper where paperlocation='"+r.getPaperlocation()+"'";
			rs1=ps.executeQuery(sql1);
		
			while(rs1.next()){
			ps.executeUpdate("insert into reviewercomments values ('"+count+"','"+r.getUsername()+"','"+Integer.parseInt(rs1.getString("id"))+"','"+r.getComments()+"')");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}