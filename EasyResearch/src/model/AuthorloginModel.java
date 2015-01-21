//This model is by the author to login into his account and his credentials are verified with the values stored in the database.
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import authorbean.AuthorBean;
import conferencechairbean.ConferenceChairBean;
import db.DbConnection;

public class AuthorloginModel {
	
	public void dologincheck(AuthorBean b){
		
		int count;
		try {
			DbConnection d = new DbConnection();
			Statement ps = null;
			ResultSet rs=null;
			ps=d.DbConnection1();
			
			String user_name=b.getUsername();
			String pass_word=b.getPassword();
			
			String sql = "select username,password from login where username = '"+user_name+"'and password = '"+pass_word+"'and type = 'Author'";
			rs=ps.executeQuery(sql);
			
			count = 0;
			while(rs.next()){
				count = count + 1;
			}
			if(count == 1){
		     b.setValid(true);
			}

			getAuthorDetail(b);
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void getAuthorDetail(Object o){
		if(o instanceof ConferenceChairBean){
			ConferenceChairBean a = (ConferenceChairBean)o;
		
			
		try {
			DbConnection d = new DbConnection();
			Statement ps = null;
			ResultSet rs=null;
			ps=d.DbConnection1();
			
			String user_name=a.getAuthorusername();
			
			String sql1="select email from authordetails where username='"+user_name+"'";
			rs=ps.executeQuery(sql1);

			while(rs.next()){
			String email =rs.getString("email");
			a.setAuthoremail(email);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}
		else if(o instanceof AuthorBean){
			AuthorBean a = (AuthorBean)o;
			try {
				DbConnection d = new DbConnection();
				Statement ps = null;
				ResultSet rs=null;
				ps=d.DbConnection1();
				
				String user_name=a.getUsername();
				
				String sql1="select email from authordetails where username='"+user_name+"'";
				rs=ps.executeQuery(sql1);

				while(rs.next()){
				String email =rs.getString("email");
				a.setEmail(email);
				}
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			}
			
		}
	

	public String getAuthorDetail(String s){
		String email="";
		try {
			DbConnection d = new DbConnection();
			Statement ps = null;
			ResultSet rs=null;
			ps=d.DbConnection1();
			
			String sql1="select email from authordetails where username='"+s+"'";
			rs=ps.executeQuery(sql1);

			while(rs.next()){
			email =rs.getString("email");
			
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return email;
		}
}
	
