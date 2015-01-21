<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!-- Comments: This is the Home page for COnference Chair. This has link to make decision on papers, check abstract, notifications etc. -->
	<title>Easy Research- Conference Chair Home</title>
	<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="main-wraper">
		<div id="top-wraper">
			<div id="banner">Easy Research</div>
			<div id="nav">
				<ul>
				  <%-- <li style="padding-left:0px; padding-right:0px;"><a href="CreateConference.jsp">Create Conference</a></li> --%>
				  <li style="padding-left:0px; padding-right:0px;"><a href="AddContacts.jsp">Add Contacts</a></li>
				  <li style="padding-left:0px; padding-right:0px;"><a href="/EasyResearch/InviteReviewers">Invite Reviewers</a></li>  
				  <li style="padding-left:0px; padding-right:0px;"><a href="/EasyResearch/CheckStatusConferenceChair">Check Abstract</a></li>
				  <li style="padding-left:0px; padding-right:0px;"><a href="/EasyResearch/AssignReviewerPaper">Assign Papers</a></li>
				  <li style="padding-left:0px; padding-right:0px;"><a href="/EasyResearch/ConferenceChairNotification">Notifications</a></li>
				  <li style="padding-left:0px; padding-right:0px;"><a href="/EasyResearch/MakeDecision">Make Paper Decision</a></li>
				</ul>
			</div>
			<div class="logout">
				<form name="logout" action="Logout" method="post">
					<input type="submit" value="Logout" align ="right"> 
				</form>
			</div>
		</div>
		<table style="width: 100%; display: inline-block;">
			<tbody>
				<tr>
					<td id="left" rowspan="3" colspan="1"></td>
				</tr>
			</tbody>
		</table>
			<div class="footer">
				<p id="copyright">Copyright &copy; 2014. Developed by Chandrachudeswaran Sankar, Sashank Santhanam, Rohit Bansod, Samatha Kolagatla</p>
			</div>
		</div>
</body>
</html>