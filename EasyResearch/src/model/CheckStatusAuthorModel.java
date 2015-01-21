//This model is used by the author to check the status of the abstract or the paper which has been submitted
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import authorbean.AuthorBean;
import db.DbConnection;

public class CheckStatusAuthorModel {
	
	public AuthorBean doLogincheck(AuthorBean b){
		ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();
		try {
			DbConnection d = new DbConnection();
			Statement ps = null;
			Statement ps1 = null;
			ResultSet rs=null;
			ps=d.DbConnection1();
			ResultSet rs1=null;
			ps1=d.DbConnection1();
			
			String username=b.getUsername();
			
			
			String sql = "select * from abstract inner join listofconferences on abstract.conferenceid = listofconferences.id where authorusername='"+username+"'";
			rs=ps.executeQuery(sql);
			
			while(rs.next())
			{
				ArrayList<String> singleRecordArray = new ArrayList<String>();
				singleRecordArray.add(rs.getString("conferencename"));
				singleRecordArray.add(rs.getString("authorusername"));
				singleRecordArray.add(rs.getString("title"));
				singleRecordArray.add(rs.getString("keywords"));
				singleRecordArray.add(rs.getString("abstract"));
				singleRecordArray.add(rs.getString("status"));
				singleRecordArray.add(rs.getString("abstract.id"));
				
				String sql1="select status from paper where abstractid='"+rs.getString("abstract.id")+"'";
				rs1=ps1.executeQuery(sql1);
				if(!rs1.isBeforeFirst()){
					singleRecordArray.add(" ");//paper status
				}
				else{
					while(rs1.next())
					{
						singleRecordArray.add(rs1.getString("status"));//paper status
					}
				}
				if(singleRecordArray!=null && singleRecordArray.size()>0)
					a.add(singleRecordArray);
				
			}
			
			b.setAbstract_status(a);
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;		
	}

	public AuthorBean getConferencesAuthor(AuthorBean a) {
		
		try {
			DbConnection d = new DbConnection();
			Statement ps = null;
			ResultSet rs=null;
			ps=d.DbConnection1();
			
			String sql1="select * from abstract where authorusername='"+a.getUsername()+"' and id='"+a.getAbstractid()+"'";
			rs=ps.executeQuery(sql1);
			while(rs.next()){
				a.setConferenceid(rs.getString("conferenceid"));
				a.setTitle(rs.getString("title"));
				a.setKeyword(rs.getString("keywords"));
				
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}
}
