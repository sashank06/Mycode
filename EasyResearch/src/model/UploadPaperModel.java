//This models is used to upload the paper chosen by the author once their abstract has been accepted .
package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DbConnection;
import authorbean.AuthorBean;

public class UploadPaperModel {
	
	public void doSavePaper(AuthorBean a){
		
		long time = System.currentTimeMillis();
		Date date= new Date(time);
		int count=0;
		
		try
		{
			DbConnection d = new DbConnection();
			Statement ps = null;
			ResultSet rs=null;
			ps=d.DbConnection1();
			
			String sql = "select * from paper";
			rs=ps.executeQuery(sql);
			while(rs.next()){
				count++;
			}
			count++;
			
			
			String sql1="insert into paper values('"+count+"','"+a.getConferenceid()+"','"+a.getUsername()+"','"+a.getTitle()+"','"+a.getKeyword()+"','"+a.getPaperlocation()+"','underreview','"+date+"','"+a.getAbstractid()+"')";
			ps.executeUpdate(sql1);

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
