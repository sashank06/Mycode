//This model is used to update the author profile after the values have been populated from the database
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import authorbean.AuthorBean;
import db.DbConnection;
public class EditProfileAuthorModel {
	String firstname=null;
	String email=null;
	String lastname=null;
	String company=null;
	String authortype=null;
	String address=null;
	String city=null;
	String state=null;
	String country=null;
	String phone=null;
	String username1=null;
	
	public void doShowProfile(AuthorBean a){
		try 
		{
			DbConnection d = new DbConnection();
			Statement ps = null;
			ResultSet rs=null;
			ps=d.DbConnection1();
			
			String username=a.getUsername();
			
			String sql = "select * from authordetails where username='"+username+"';";
			rs=ps.executeQuery(sql);
			
			while(rs.next()){
				firstname= rs.getString("firstname");
				email = rs.getString("email");
				lastname=rs.getString("lastname");
				company=rs.getString("company");
				authortype=rs.getString("authortype");
				address=rs.getString("address");
				city=rs.getString("city");
				state=rs.getString("state");
				country=rs.getString("country");
				phone=rs.getString("phonenumber");
				username1=rs.getString("username");
			}

			a.setEmail(email);
			a.setFirstname(firstname);
			a.setCity(city);
			a.setCompany(company);
			a.setCountry(country);
			a.setLastname(lastname);
			a.setAuthortype(authortype);
			a.setAddress(address);
			a.setState(state);
			a.setPhone(phone);
			a.setUsername(username1);
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doEditProfile(AuthorBean b){
		try 
		{		
			DbConnection d = new DbConnection();
			Statement ps = null;
			ps=d.DbConnection1();
			
			String firstname=b.getFirstname();
			String lastname= b.getLastname();
			String authortype=b.getAuthortype();
			String address=b.getAddress();
			String city=b.getCity();
			String state=b.getState();
			String country=b.getCountry();
			String phone=b.getPhone();
			String company=b.getCompany();

			String sql= "update authordetails set firstname='"+firstname+"',lastname='"+lastname+"',authortype='"+authortype+"',address='"+address+"',city='"+city+"',state='"+state+"',country='"+country+"',phonenumber='"+phone+"',company='"+company+"' where email='"+email+"'";	
			ps.executeUpdate(sql);
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
