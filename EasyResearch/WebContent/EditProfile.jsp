<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import= "authorbean.AuthorBean"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<!-- Comments: This page lets Author to update his profile details in the system -->
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<script src="functions.js"></script>
		<title>Edit Profile</title>
	</head>

	<body>
	
	
	<% AuthorBean b = (AuthorBean)request.getAttribute("user"); %>
		<div id="main-wraper">
			<div id="top-wraper">
				<div id="banner">Easy Research</div>
				<div id="nav">
					<ul>
					  <li><a href="AuthorLoginSuccess.jsp">Home</a></li>
					  <li><a href="/EasyResearch/ListofConferences">List of Conferences</a></li>
				  	  <li><a href="/EasyResearch/CheckStatusAuthor">Check Status</a></li>
					</ul>
				</div>
				<div class="logout">
					<form name="logout" action="Logout" method="post">
						<input type="submit" value="Logout" align ="right"> 
					</form>
				</div>
			</div>
			
		
			<form name="form3" action="EditProfile" method="post" >
				<table id="signUpForm" style="width: 100%; border-color: #000000; display: inline-block;">
					<tbody>
						<tr>
				            <td width="75%">
								<h2 style="display: inline-block;">Edit Your Profile</h2>				
							</td>
				        </tr>
				        <tr>
				            <td class="style2">First Name</td>
				            <td><input type="text" class="tableinput" name="fname" value= <%=b.getFirstname()%>></td>
				        </tr>
				        <tr>
				        	<td class="style2">Last Name</td>
				        	<td><input type="text" class="tableinput" name="lname" value =<%=b.getLastname()%>></td>
				        </tr>
				        
				        
				        <tr>
				            <td class="style2">Company/Organization</td>
				            <td><input type="text" class="tableinput" name="company" value=<%=b.getCompany()%>></td>
				        </tr>
				        <tr>
				        	<td class="style2">Author Type</td>
				            <td>
				            	<input type="text" class="tableinput" name="authortype" value=<%=b.getAuthortype() %>>
							</td>
				        </tr>
				        <tr>
				            <td class="style2">Address Line 1</td>
				            <td><input type="text" class="tableinput" name="address" value=<%=b.getAddress() %> ></td>
				        </tr>
				        <tr>
				            <td class="style2">City</td>
				            <td><input type="text" class="tableinput" name="city" value=<%=b.getCity() %>></td>
				        </tr>
				        <tr>
				            <td class="style2">State</td>
				            <td><input type="text" class="tableinput" name="state" value=<%=b.getState() %>></td>
				        </tr>
				        <tr>
				            <td class="style2">Country</td>
				            <td><input type="text" class="tableinput" name="country" value=<%=b.getCountry()%>></td>
				        </tr>
				        <tr>
				            <td class="style2">Phone Number</td>
				            <td><input type="text" class="tableinput" name="phone" value=<%=b.getPhone()%>></td>
				        </tr>
				        <tr>
				            <br/><td class="style1" colspan="2" align="center"><input style="min-width:80pt;" class="loginbutton" type="Submit" name="submit" value="Update"></td>
				        </tr>
			        </tbody>
			    </table>
			</form>
		</div>
	</body>
</html>