<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="conferencechairbean.ConferenceChairBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<!-- Comments: This page provides conference chair a way to invite reviewers -->
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Invite Reviewers</title>
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<script src="functions.js"></script>
	</head>
	<body>
		<% ConferenceChairBean c = (ConferenceChairBean)request.getAttribute("conference"); %>
		<div id="main-wraper">
			<div id="top-wraper">
				<div id="banner">Easy Research</div>
				<div id="nav">
					<ul>
					  <li style="padding-left:0px; padding-right:0px;"><a href="ConferenceChairLoginSuccess.jsp">Home</a></li>
					  <%-- <li style="padding-left:0px; padding-right:0px;"><a href="CreateConference.jsp">Create Conference</a></li> --%>
					  <li style="padding-left:0px; padding-right:0px;"><a href="AddContacts.jsp">Add Contacts</a></li>
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
			<h2 id="InviteReviews" style="display: inline-block;">Invite Reviewers</h2>
			<table>
				<tbody>
					<tr>
						<td>
							<h3 style="display: inline-block;">Add Email(s) to Invite</h3>
							<form name="inviteform1" action="InviteReviewers" method="post">
								<table id = "addContactsTable" style="border:1px solid #000000; width: 400px; border-radius: 8pt; display: inline-block;">
									
									<tbody>
										<tr>
											<td align="right" style="width:10%;">
												<span style="font-size: 14px; font-weight: bold;">Email Id(s) </span>
											</td>
											<td colspan="2" style="width:80%; text-align: left;">
												<input type="text" name="email" style="width:95%" id = "addEmails"></input>
											</td>
										</tr>
										<tr>
											<td colspan="2" align="center" style="text-align: center;">
												<input type="submit" value="Send" name="send" class="loginbutton">
											</td>
										</tr>
									</tbody>
								</table>
							</form>
						</td>
						<td width="30px;">
						</td>
						<td>
							<h3 style="display: inline-block;">Contact List</h3>
							<table style="border:1px solid #000000; width: 350px; border-radius: 8pt; display: inline-block;">
								<tbody>
									<tr>
										<td>
												
											<ul>
												<c:set var = "listOfContacts" value ="<%=c.getContacts()%>"/>
												<c:forEach var = "singleContactDetail" items="${listOfContacts}">
													<li><a onclick="sendEmailToInputBox('${singleContactDetail[2]}')" href="javascript:void(0);">${singleContactDetail[0]} ${singleContactDetail[1]}</a></li>
												</c:forEach>
											</ul>
										</td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
				</tbody>
			</table>
			<br/>
			<div class="footer">
				<p id="copyright">Copyright &copy; 2014. Developed by Chandrachudeswaran Sankar, Sashank Santhanam, Rohit Bansod, Samatha Kolagatla</p>
			</div>
		</div>
	</body>
</html>