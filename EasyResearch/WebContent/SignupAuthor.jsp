<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Easy Research - Create an Account</title>
		<!-- Comments: This page lets Author to sign up into the system by providing his/ her details -->
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<script src="AuthorSignup.js"></script>
	</head>
	
	<body>
		<div id="main-wraper">
			<div id="top-wraper">
				<div id="banner">Easy Research</div>
				<div id="nav">
					<ul>
					  <li><a href="/EasyResearch/Home">Home</a></li>
					  <li><a href="AboutUs.jsp">About us</a></li>
					  <li><a href="ContactUs.jsp">Contact</a></li>
					</ul>
				</div>
			</div>
			<h2>Create an Easy Research Account</h2>
		
			<form name="form2" action="SignupAuthor" method="post" onsubmit="return signupcheck();">
				<table id="signUpForm" style="width: 100%; border-color: #000000;">
			        <tr>
			            <td class="style2">First Name</td>
			            <td><input type="text" class="tableinput" name="fname"></td>
			        </tr>
			        <tr>
			        	<td class="style2">Last Name</td>
			        	<td><input type="text" class="tableinput" name="lname"></td>
			        </tr>
			        <tr>
			            <td class="style2">User Name</td>
			            <td><input type="text" class="tableinput" name="username"></td>
			        </tr>
			        <tr>
			            <td class="style2">Password</td>
			            <td><input type="password" class="tableinput" name="password"></td>
			        </tr>
			        <tr>
			            <td class="style2">Re-Type Password</td>
			            <td><input type="password" class="tableinput" name="retypepassword"></td>
			        </tr>
			        <tr>
			            <td class="style2">Email</td>
			            <td><input type="text" class="tableinput" name="Email"></td>
			        </tr>
			        <tr>
			            <td class="style2">Re-Email</td>
			            <td><input type="text" class="tableinput" name="ReEmail"></td>
			        </tr>
			        <tr>
			            <td class="style2">Company/Organization</td>
			            <td><input type="text" class="tableinput" name="company"></td>
			        </tr>
			        <tr>
			        	<td class="style2">Author Type</td>
			            <td style="padding-left: 4px;">
			            	<select name="authortype" class="table_selectinput">
								<option value="Authortype"> Author Type </option>
								<option value="Student"> Student </option>
								<option value="Professor"> Professor </option>
								<option value="Working Professional">Working Professional </option>
							</select>
						</td>
			        </tr>
			        <tr>
			            <td class="style2">Address Line 1</td>
			            <td><input type="text" class="tableinput" name="address"></td>
			        </tr>
			        <tr>
			            <td class="style2">City</td>
			            <td><input type="text" class="tableinput" name="city"></td>
			        </tr>
			        <tr>
			            <td class="style2">State</td>
			            <td><input type="text" class="tableinput" name="state"></td>
			        </tr>
			        <tr>
			            <td class="style2">Country</td>
			            <td><input type="text" class="tableinput" name="country"></td>
			        </tr>
			        <tr>
			            <td class="style2">Phone Number</td>
			            <td><input type="text" class="tableinput" name="phone"></td>
			        </tr>
			        <tr>
			            <td class="style1" colspan="2"><input type="Submit" name="submit" value="Create Account"></td>
			        </tr>
			    </table>
			</form>
		</div>
	</body>
</html>
    