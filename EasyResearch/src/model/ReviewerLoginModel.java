//This model is used by the reviewer to login into his account and the credentials are evaluated with the database.
package model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import reviewerbean.ReviewerBean;
import db.DbConnection;


public class ReviewerLoginModel {
	
public void dologincheck(ReviewerBean b){
		
		try 
		{
			DbConnection d = new DbConnection();
			Statement ps = null;
			ResultSet rs=null;
			ps=d.DbConnection1();
			
			String user_name=b.getUsername();
			String pass_word=b.getPassword();
			
			String sql = "select username,password from er.login where username = '"+user_name+"'and password = '"+pass_word+"'and type='Reviewer'";
			rs=ps.executeQuery(sql);
			
			int count = 0;
			while(rs.next()){
				count = count + 1;
			}
			
			if(count == 1){
		     b.setValid(true);
			}
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}