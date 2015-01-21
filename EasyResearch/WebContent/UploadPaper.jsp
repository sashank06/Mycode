<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Comments: This page lets author submit his/ her paper once his abstract is accepted -->
		<title>Easy Research- Upload Abstract</title>
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<script src="LoginValidation.js"></script>
		
	</head>
	
	<body>
		
		<div id="main-wraper">
			<div id="top-wraper">
				<div id="banner">Easy Research</div>
				<div id="nav">
					<ul>
					  <li><a href="AuthorLoginSuccess.jsp">Home</a></li>
					  <li><a href="CheckStatusAuthor.jsp">Check Status</a></li>
					  <li><a href="EditProfile.jsp">Edit Profile</a></li>
					</ul>
				</div>
			</div>
			<table style="width: 100%; display: inline-block;">
				<tbody>
					<tr>
						<td>
							<h2>Easy Research - Submit Abstract</h2>
						</td>
					</tr>
					<tr>
						<td>
							
							<h3> Choose File to Upload in Server </h3>
							<form action="UploadPaper" method="post" enctype="multipart/form-data">
								
								<input type="file" name="file" />
									<input type="submit" value="upload" />
	            
							</form>
						</td>
						<td colspan="3" style="width:150px; text-align: center;">
						
						</td>
					
					</tr>
				</tbody>
			</table>
			<div class="footer">
			<p id="copyright">Copyright &copy; 2014. Developed by Chandrachudeswaran Sankar, Sashank Santhanam, Rohit Bansod, Samatha Kolagatla</p>
			</div>
		</div> 
	
	</body>
</html>


