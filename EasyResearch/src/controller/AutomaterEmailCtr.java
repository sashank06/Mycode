//Comments - This class is for sending automated email to all users
package controller;

import java.util.Properties;

import admin.AdminBean;
import authorbean.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import conferencechairbean.*;

import reviewerbean.*;

public class AutomaterEmailCtr {
	Properties emailProperties;
	Session mailSession;
	MimeMessage emailMessage;
	String email;
	String subject;
	String message;
	public void sendEmailMessage(String email,String subject,String message) throws AddressException, MessagingException {

		AutomaterEmailCtr javaEmail = new AutomaterEmailCtr();
		javaEmail.setMailServerProperties();
		javaEmail.createEmailMessage(email,subject,message);
		javaEmail.sendEmail();
	}
	
	public void sendEmailMessage(Object o) throws AddressException, MessagingException {
			AuthorBean a=null;
			ConferenceChairBean c=null;
			ReviewerBean r = null;
			AdminBean ad=null;
			
		AutomaterEmailCtr javaEmail = new AutomaterEmailCtr();
		if(o instanceof AuthorBean){
			 a = (AuthorBean)o;
			 email=a.getEmail();
			subject=a.getEmailsubject();
				message=a.getEmailmessage();
				
		}else if (o instanceof ConferenceChairBean){
			
				c=(ConferenceChairBean)o;
				
				email=c.getEmail();
				subject=c.getEmailsubject();
				message=c.getEmailmessage();
				
		}
		else if(o instanceof ReviewerBean)
		{
			r = (ReviewerBean)o;
			email=r.getEmail();
		subject=r.getEmailsubject();
		message=r.getEmailmessage();
		}
		else{
			ad = (AdminBean)o;
			email=ad.getEmail();
			subject=ad.getEmailsubject();
			message=ad.getEmailmessage();
			}
		javaEmail.setMailServerProperties();
		javaEmail.createEmailMessage(email,subject,message);
		javaEmail.sendEmail();
	}

public void sendEmailMessage(ConferenceChairBean b,String email) throws AddressException,MessagingException{
		
		AutomaterEmailCtr javaEmail = new AutomaterEmailCtr();
		
		String subject="Easy Research Abstract Status Change";
		String message="Congratulations !! your abstract has been selected";
		
		javaEmail.setMailServerProperties();
		javaEmail.createEmailMessage(email,subject,message);
		javaEmail.sendEmail();
	}
	
	public void setMailServerProperties(){
		
		String emailPort = "587";
		emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", emailPort);
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");

	}

	public void createEmailMessage(String a,String b,String c) throws AddressException,MessagingException{
		String[] toEmails = {a};
		String emailSubject = b;
		String emailBody = c;

		mailSession = Session.getDefaultInstance(emailProperties, null);
		emailMessage = new MimeMessage(mailSession);

		for (int i = 0; i < toEmails.length; i++) {
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
		}

		emailMessage.setSubject(emailSubject);
		emailMessage.setContent(emailBody, "text/html");
	}

	public void sendEmail() throws AddressException, MessagingException {

		String emailHost = "smtp.gmail.com";
		String fromUser = "easyresearchcms";
		String fromUserEmailPassword = "cms12345*";

		Transport transport = mailSession.getTransport("smtp");

		transport.connect(emailHost, fromUser, fromUserEmailPassword);
		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();	
	}
}