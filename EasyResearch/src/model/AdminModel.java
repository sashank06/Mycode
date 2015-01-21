//this model is used by the administrator to login and create conference and values are stored in database
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import admin.AdminBean;
import db.DbConnection;

public class AdminModel {
	
	
	public void doLogincheck(AdminBean a){
		
		try {
			DbConnection d = new DbConnection();
			Statement ps = null;
			ResultSet rs=null;
			ps=d.DbConnection1();

			int count = 0;

			String username = a.getUsername();
			String password= a.getPassword();
			
			String sql = "select username,password from login where username = '"+username+"'and password = '"+password+"'and type='Admin'";
			rs=ps.executeQuery(sql);
			
			while(rs.next()){
				count = count + 1;
			}			
			if(count==1){
				a.setValid(true);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
