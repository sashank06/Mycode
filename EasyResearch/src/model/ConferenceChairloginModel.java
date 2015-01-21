//This model is used by the conference chair to login into account and his credentials are validated with the database.
package model;
import java.sql.*;

import conferencechairbean.ConferenceChairBean;
import db.DbConnection;

public class ConferenceChairloginModel {
	
	public void dologinCheck(ConferenceChairBean c){
		try {
			int count;
			
			DbConnection d = new DbConnection();
			Statement ps = null;
			ResultSet rs=null;
			ps=d.DbConnection1();

			String user_name=c.getUsername();
			String pass_word=c.getPassword();

			String sql = "select username,password from login where Username = '"+user_name+"'and Password = '"+pass_word+"'and type='Chair'";
			rs=ps.executeQuery(sql);

			count = 0;
			while(rs.next())
			{
				count = count + 1;
			}
			if(count == 1)
			{
				c.setValid(true);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
