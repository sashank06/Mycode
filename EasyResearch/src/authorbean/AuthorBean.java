package authorbean;

import java.util.ArrayList;
import java.util.Date;

public class AuthorBean {
	String username;
	String password;
	String firstname;
	String lastname;
	String email;
	String company;
	String authortype;
	String address;
	String city;
	String phone;
	String state;
	String country;
	String aabstract;
	String apaper;
	String emailsubject;
	String emailmessage;
	String title;
	String keyword;
	String conferencename;
	String conferenceid;
	String paperlocation;
	String papername;
	boolean isInserted;
	boolean isValid;
	int abstractid;
	
	public int getAbstractid() {
		return abstractid;
	}
	public void setAbstractid(int abstractid) {
		this.abstractid = abstractid;
	}
	ArrayList<ArrayList<String>> conferencelist;
	
	public ArrayList<ArrayList<String>> getConferencelist() {
		return conferencelist;
	}
	public void setConferencelist(ArrayList<ArrayList<String>> conferencelist) {
		this.conferencelist = conferencelist;
	}
	public boolean isInserted() {
		return isInserted;
	}
	public void setInserted(boolean isInserted) {
		this.isInserted = isInserted;
	}
	public String getPapername() {
		return papername;
	}
	public void setPapername(String papername) {
		this.papername = papername;
	}
	public String getPaperlocation() {
		return paperlocation;
	}
	public void setPaperlocation(String paperlocation) {
		this.paperlocation = paperlocation;
	}
	public String getConferenceid() {
		return conferenceid;
	}
	public void setConferenceid(String conferenceid) {
		this.conferenceid = conferenceid;
	}
	ArrayList<ArrayList<String>> abstract_status;
	
	public ArrayList<ArrayList<String>> getAbstract_status() {
		return abstract_status;
	}
	public void setAbstract_status(ArrayList<ArrayList<String>> abstract_status) {
		this.abstract_status = abstract_status;
	}
	public String getConferencename() {
		return conferencename;
	}
	public void setConferencename(String conferencename) {
		this.conferencename = conferencename;
	}
	ArrayList<String> conference;
	
	public ArrayList<String> getConference() {
		return conference;
	}
	public void setConference(ArrayList<String> conference) {
		this.conference = conference;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
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
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAuthortype() {
		return authortype;
	}
	public void setAuthortype(String authortype) {
		this.authortype = authortype;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAabstract() {
		return aabstract;
	}
	public void setAabstract(String aabstract) {
		this.aabstract = aabstract;
	}
	public String getApaper() {
		return apaper;
	}
	public void setApaper(String apaper) {
		this.apaper = apaper;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	

}
