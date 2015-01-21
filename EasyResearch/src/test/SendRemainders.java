//Comments - this class sends automatic mail remainders to author and reviewers
package test;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.Date;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import controller.AutomaterEmailCtr;
import db.DbConnection;

import model.ListofConferencesModel;

public class SendRemainders {
	
	Logger logger = Logger.getLogger("myLogger");
	ListofConferencesModel l = new ListofConferencesModel();
	ArrayList<ArrayList<String>> emails= new ArrayList<ArrayList<String>>();
	
	public void sendEmailAuthor(){
		ArrayList<Integer> cid = new ArrayList<Integer>();
		long time=System.currentTimeMillis();
		Date date= new Date(time);
		Date paper_date;
		int id;
		long days;
		
		try {
			DbConnection d = new DbConnection();
			Statement ps = null;
			ResultSet rs = null;
			ps=d.DbConnection1();
			rs=ps.executeQuery("select id,paper_date from listofconferences");
			while(rs.next()){
				id=Integer.parseInt(rs.getString("id"));
				 paper_date=rs.getDate("paper_date");
				long diff=paper_date.getTime()- date.getTime();			
				days= diff/(24*60*60*1000);
				
				if(days>=2 && days<=3){
					cid.add(id);
				}
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}

		emails=l.sendRemaindersAuthor(cid);
		String message="Please submit your paper -Remainder";
		String subject="Easy Research- Paper Submission Pending";
		AutomaterEmailCtr e = new AutomaterEmailCtr();
		for(int i=0;i< emails.size();i++){
			ArrayList<String> a = emails.get(i);
			for(int j=0;j<a.size();j++){
				try {
					e.sendEmailMessage(a.get(j), subject, message);
				} catch (AddressException e1) {
					e1.printStackTrace();
				} catch (MessagingException e1) {
					e1.printStackTrace();
				}
				
			}
			
		}
		
	}
	
	public void sendEmailReviewer(){
		ArrayList<Integer> cid = new ArrayList<Integer>();
		long time=System.currentTimeMillis();
		Date date= new Date(time);
		Date conference_date;
		int id;
		long days;
		try {
			
			DbConnection d = new DbConnection();
			Statement ps = null;
			ResultSet rs = null;
			ps=d.DbConnection1();
			rs=ps.executeQuery("select id,conference_date from listofconferences");
			while(rs.next()){	
			id=Integer.parseInt(rs.getString("id"));
			 conference_date=rs.getDate("conference_date");
			 long diff=conference_date.getTime()- date.getTime();			
				days= diff/(24*60*60*1000);
				
				if(days>=2 && days<=3){
					cid.add(id);
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		emails=l.sendRemaindersReviewer(cid);
		String message="Please Evaluate the Paper -Remainder";
		String subject="Easy Research- Paper Evaluation Pending";
		AutomaterEmailCtr e = new AutomaterEmailCtr();
		for(int i=0;i< emails.size();i++){
			ArrayList<String> a = emails.get(i);
			for(int j=0;j<a.size();j++){
				try {
					e.sendEmailMessage(a.get(j), subject, message);
				} catch (AddressException e1) {
					e1.printStackTrace();
				} catch (MessagingException e1) {
					e1.printStackTrace();
				}
				
			}
			
		}
		
		
	}
	
}
