//This model is by the chair person to assign paper to the reviewers chosen and the details are stored in a table in the database.
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import conferencechairbean.ConferenceChairBean;
import db.DbConnection;
public class ChairAssignPaperModel {
	Logger logger = Logger.getLogger("loggin");
	public ConferenceChairBean getList(ConferenceChairBean c){
		ArrayList<ArrayList<String>> paper = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> reviewer = new ArrayList<ArrayList<String>>();
		try {
			
			DbConnection d = new DbConnection();
			Statement ps = null;
			Statement ps1 = null;
			ResultSet rs=null;
			ResultSet rs1=null;
			ResultSet rs2=null;
			ps=d.DbConnection1();
			ps1=d.DbConnection1();
			
			String sql = "select id,title from paper where conferenceid=(select id from listofconferences where chairusername='"+c.getUsername()+"')";
			rs=ps.executeQuery(sql);
			while(rs.next())
			{
				ArrayList<String> p = new ArrayList<String>();
				if((rs.getString("id")!=null && !"".equals(rs.getString("id").trim())) && (rs.getString("title")!=null && !"".equals(rs.getString("title").trim()))){
					String paperId = rs.getString("id");
					p.add(rs.getString("id"));
					p.add(rs.getString("title"));
					
					String sql2 = "select jobid from reviewerjob where pid = '"+paperId+"'";
					rs2=ps1.executeQuery(sql2);

					int count = 0;
					while (rs2.next()){
						count++;
					}
			
					String assigned = "false";
					if(count<3){
						assigned="false";
					}
					else{
						assigned="true";
					}
					p.add(assigned);
				}
				paper.add(p);
			}
		
			
			//String sql1="select firstname,lastname,email from reviewerdetails where chairname='"+c.getUsername()+"'";
			//rs1=ps.executeQuery(sql1);
			String sql1="select * from (select r.firstname,r.lastname,r.email,count(*) as count,r.chairname as chair from reviewerdetails r left outer join tempreviewersassign t on r.username = t.ruser1 where t.statusofreviewers != 'Reject' and not exists (select * from reviewercomments rc where rc.rusername = t.ruser1 and rc.paperid = t.paperid) group by t.ruser1 union select r.firstname,r.lastname,r.email,0 as count, r.chairname as chair from reviewerdetails r left outer join tempreviewersassign t on r.username = t.ruser1 where t.statusofreviewers is NULL ) as temp where chair = '"+c.getUsername()+"' order by count asc";
			rs1=ps.executeQuery(sql1);
			while(rs1.next()){
				ArrayList<String> r = new ArrayList<String>();
				r.add(rs1.getString("firstname"));
				r.add(rs1.getString("lastname"));
				r.add(rs1.getString("email"));
				r.add(rs1.getString("count"));
				reviewer.add(r);
			}
			
			c.setPapers_details(paper);
			c.setReviewers(reviewer);
			
			ps.close();
			
			
		}catch (SQLException e) {
			logger.log(Level.INFO, "SQL Exception thrown in getting the list of reviewers or paper details to be displayed in Assign Papers Page");
			e.printStackTrace();
		}
		return c;
	}
	
	public ConferenceChairBean saveTempReviewers(ConferenceChairBean c){
		String[] email=c.getEmail_reviewers();
		String paperid=c.getPaperId();
		int pid=Integer.parseInt(paperid);
		int count=0;
		try {
			DbConnection d = new DbConnection();
			Statement ps = null;
			ResultSet rs=null;
			ResultSet rs1=null;
			ps=d.DbConnection1();
			
			String[] rusername;
			rusername= new String[email.length];
			
			for(int i=0;i<email.length;i++){
				String sql="select username from reviewerdetails where email='"+email[i]+"'";
				rs=ps.executeQuery(sql);
				while(rs.next()){
					rusername[i]=rs.getString("username");
				}
			}
		
			String sql1= " select * from tempreviewersassign";
			rs1=ps.executeQuery(sql1);
			while(rs1.next()){
				count++;
				
			}
			count++;
			
			for(int j=0;j<rusername.length;j++){
				String sql2="insert into tempreviewersassign values('"+count+"','"+pid+"','"+rusername[j]+"','pending')";
				ps.executeUpdate(sql2);
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
}