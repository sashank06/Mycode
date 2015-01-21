package conferencechairbean;

import java.sql.Date;
import java.util.ArrayList;
public class ConferenceChairBean {
	String firstname;
	String lastname;
	String username;
	String password;
	String name;
	String email;
	boolean isValid;
	String emailsubject;
	String emailmessage;
	String contact_firstname;
	String contact_lastname;
	String contact_email;
	String abstractId;
	String title;
	String conferencename;
	String abstract_paper;
	String keywords;
	String status;
	String authorusername;
	String authoremail;
	String conferenceplace;
	boolean isAssigned;
	ArrayList<Object> finalcomments;
	String finaldecision;
	ArrayList<ArrayList<String>> reviewers;
	ArrayList<ArrayList<String>> papers_details;
	ArrayList<ArrayList<String>> contacts;
	ArrayList<ArrayList<String>> abstract_details;
	ArrayList<ArrayList<String>> chairnotify;

	String conference_description;
	Date abstract_date;
	Date paper_date;
	Date conference_date;
	String[] email_reviewers;
	String paperId;

	public String getFinaldecision() {
		return finaldecision;
	}
	public void setFinaldecision(String finaldecision) {
		this.finaldecision = finaldecision;
	}
	public ArrayList<Object> getFinalcomments() {
		return finalcomments;
	}
	public void setFinalcomments(ArrayList<Object> finalcomments) {
		this.finalcomments = finalcomments;
	}
	public boolean isAssigned() {
	return isAssigned;
}
public void setAssigned(boolean isAssigned) {
	this.isAssigned = isAssigned;
}


public ArrayList<ArrayList<String>> getChairnotify() {
	return chairnotify;
}
public void setChairnotify(ArrayList<ArrayList<String>> chairnotify) {
	this.chairnotify = chairnotify;
}



public String[] getEmail_reviewers() {
	return email_reviewers;
}
public void setEmail_reviewers(String[] email_reviewers) {
	this.email_reviewers = email_reviewers;
}
public String getPaperId() {
	return paperId;
}
public void setPaperId(String paperId) {
	this.paperId = paperId;
}
public ArrayList<ArrayList<String>> getReviewers() {
	return reviewers;
}
public void setReviewers(ArrayList<ArrayList<String>> reviewers) {
	this.reviewers = reviewers;
}
public ArrayList<ArrayList<String>> getPapers_details() {
	return papers_details;
}
public void setPapers_details(ArrayList<ArrayList<String>> papers_details) {
	this.papers_details = papers_details;
}



public String getConference_description() {
	return conference_description;
}
public void setConference_description(String conference_description) {
	this.conference_description = conference_description;
}
public Date getAbstract_date() {
	return abstract_date;
}
public void setAbstract_date(Date abstract_date) {
	this.abstract_date = abstract_date;
}
public Date getPaper_date() {
	return paper_date;
}
public void setPaper_date(Date paper_date) {
	this.paper_date = paper_date;
}
public Date getConference_date() {
	return conference_date;
}
public void setConference_date(Date conference_date) {
	this.conference_date = conference_date;
}
public ArrayList<ArrayList<String>> getContacts() {
	return contacts;
}
public void setContacts(ArrayList<ArrayList<String>> contacts) {
	this.contacts = contacts;
}
public ArrayList<ArrayList<String>> getAbstract_details() {
	return abstract_details;
}
public void setAbstract_details(ArrayList<ArrayList<String>> abstract_details) {
	this.abstract_details = abstract_details;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public boolean isValid() {
	return isValid;
}
public void setValid(boolean isValid) {
	this.isValid = isValid;
}
public String getEmailsubject() {
	return emailsubject;
}
public void setEmailsubject(String emailsubject) {
	this.emailsubject = emailsubject;
}
public String getEmailmessage() {
	return emailmessage;
}
public void setEmailmessage(String emailmessage) {
	this.emailmessage = emailmessage;
}
public String getContact_firstname() {
	return contact_firstname;
}
public void setContact_firstname(String contact_firstname) {
	this.contact_firstname = contact_firstname;
}
public String getContact_lastname() {
	return contact_lastname;
}
public void setContact_lastname(String contact_lastname) {
	this.contact_lastname = contact_lastname;
}
public String getContact_email() {
	return contact_email;
}
public void setContact_email(String contact_email) {
	this.contact_email = contact_email;
}
public String getAbstractId() {
	return abstractId;
}
public void setAbstractId(String abstractId) {
	this.abstractId = abstractId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getConferencename() {
	return conferencename;
}
public void setConferencename(String conferencename) {
	this.conferencename = conferencename;
}
public String getAbstract_paper() {
	return abstract_paper;
}
public void setAbstract_paper(String abstract_paper) {
	this.abstract_paper = abstract_paper;
}
public String getKeywords() {
	return keywords;
}
public void setKeywords(String keywords) {
	this.keywords = keywords;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getAuthorusername() {
	return authorusername;
}
public void setAuthorusername(String authorusername) {
	this.authorusername = authorusername;
}
public String getAuthoremail() {
	return authoremail;
}
public void setAuthoremail(String authoremail) {
	this.authoremail = authoremail;
}
public String getConferenceplace() {
	return conferenceplace;
}
public void setConferenceplace(String conferenceplace) {
	this.conferenceplace = conferenceplace;
}

}
