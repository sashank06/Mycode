<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<!--  Comments: This page gives conference chair to add contacts into the system  which he can use later on while doing paper review -->
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Easy Research - Add Contacts</title>
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<script src="LoginValidation.js"></script>
	</head>

	<body>
		<div id="main-wraper">
			<div id="top-wraper">
				<div id="banner">Easy Research</div>
				<div id="nav">
					<ul>
					  <li style="padding-left:0px; padding-right:0px;"><a href="ConferenceChairLoginSuccess.jsp">Home</a></li>
					  <%-- <li style="padding-left:0px; padding-right:0px;"><a href="CreateConference.jsp">Create Conference</a></li> --%>
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
			<div>
				<table style="width: 100%; display: inline;">
					<tbody>
						<tr>
							<td>
								<h2>Easy Research - Add Contacts</h2>
							</td>
						</tr>
					</tbody>
				</table>
				<div id = "addContactDiv" style="text-align: center;">
					<form name="addcontactform" action="AddContacts" method="post" onsubmit="return chkContactParam();">
						<input type="hidden" name="callingUser" value="<%= request.getParameter("user") %>"/>
						<table class="logintable" style="text-align: center" align="center">
							<tbody>
								<tr>
									<td class="textright" style="padding-left:10px;">First name : </td>
									<td class="tableinputtext"><input class="tableinput" type="text" name="AddContactFirstname" id="AddContactFirstname"/></td>
									<td class="textright" style="padding-left:10px;">Last name : </td>
									<td class="tableinputtext"><input class="tableinput" type="text" name="AddContactLastname" id="AddContactLastname"/></td>
				 					<td class="textright" style="padding-left:10px;">Email Id : </td>
									<td class="tableinputtext"><input class="tableinput" type="text" name="AddContactEmail" id="AddContactEmail"/></td>
				 				</tr>
				 				<tr>
				 					<td colspan="6" style="text-align: center;"><input type="submit" value="Add Contact" class="loginbutton"></td>
				 				</tr>
				 			</tbody>
		 				</table>
					</form>
				</div>	
			</div>
			<div class="footer">
				<p id="copyright">Copyright &copy; 2014. Developed by Chandrachudeswaran Sankar, Sashank Santhanam, Rohit Bansod, Samatha Kolagatla</p>
				<p><small>Template designed by htmltemplates.net website templates</small></p>
			</div>
		</div>
	</body>
</html>