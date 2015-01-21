package reviewerbean;

import java.util.ArrayList;

public class ReviewerBean {
		String username;
		String password;
		String firstname;
		String lastname;
		String email;
		String pareaofinterest;
		String sareaofinterest;
		boolean isValid;
		String emailsubject;
		String emailmessage;
		String chairusername;
		String decision;
		String paperlocation;
		String comments;

		public String getComments() {
			return comments;
		}
		public void setComments(String comments) {
			this.comments = comments;
		}
		public String getPaperlocation() {
			return paperlocation;
		}
		public void setPaperlocation(String paperlocation) {
			this.paperlocation = paperlocation;
		}
		ArrayList<ArrayList<String>> reviewernotification;
		ArrayList<ArrayList<String>> reviewergetpaper;
		
		
		public ArrayList<ArrayList<String>> getReviewergetpaper() {
			return reviewergetpaper;
		}
		public void setReviewergetpaper(ArrayList<ArrayList<String>> reviewergetpaper) {
			this.reviewergetpaper = reviewergetpaper;
		}
		public ArrayList<ArrayList<String>> getReviewernotification() {
			return reviewernotification;
		}
		public void setReviewernotification(
				ArrayList<ArrayList<String>> reviewernotification) {
			this.reviewernotification = reviewernotification;
		}
		public String getDecision() {
			return decision;
		}
		public void setDecision(String decision) {
			this.decision = decision;
		}
		
		public String getChairusername() {
			return chairusername;
		}
		public void setChairusername(String chairusername) {
			this.chairusername = chairusername;
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
		public String getPareaofinterest() {
			return pareaofinterest;
		}
		public void setPareaofinterest(String pareaofinterest) {
			this.pareaofinterest = pareaofinterest;
		}
		public String getSareaofinterest() {
			return sareaofinterest;
		}
		public void setSareaofinterest(String sareaofinterest) {
			this.sareaofinterest = sareaofinterest;
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
		//String company;
		//String authortype;
		//String address;
		//String city;
		//String phone;
		//String state;
		//String country;
		
		
}
	