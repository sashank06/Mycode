<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!-- Comments: This page is the Admin Home Page after Login -->
	<title>Easy Research- ADMIN PAGE</title>
	<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="main-wraper">
		<div id="top-wraper">
			<div id="banner">Easy Research</div>
			<div id="nav">
				<ul>
				  <li><a href="/EasyResearch/Home">Home</a></li>
				  <li><a href="CreateConferenceChair.jsp">Create Conference Chair</a></li>
				  
				</ul>
			</div>
			<div class="logout">
				<form name="logout" action="Logout" method="post">
					<input type="submit" value="Logout" align ="right" onsubmit="return chklogin();"> 
				</form>
			</div>
		</div>
		<table style="width: 100%; display: inline-block;">
			<tbody>
				<tr>
					<td id="left" rowspan="3" colspan="1">
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