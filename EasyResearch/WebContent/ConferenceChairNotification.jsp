<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="conferencechairbean.ConferenceChairBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- Comments: This page provides notifications to the Conference Chair-->
		<title>Easy Research- Conference Chair Notification</title>
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<script src="functions.js"></script>
	</head>
	<body>
	<% ConferenceChairBean c = (ConferenceChairBean)request.getAttribute("conference1");%>
	<c:set var = "chairNotificationDetailsList" value="${requestScope.conference1.chairnotify}"/>
		<div id="main-wraper">
			<div id="top-wraper">
				<div id="banner">Easy Research</div>
				<div id="nav">
					<ul>
					  <li style="padding-left:0px; padding-right:0px;"><a href="ConferenceChairLoginSuccess.jsp">Home</a></li>
					  <%-- <li style="padding-left:0px; padding-right:0px;"><a href="CreateConference.jsp">Create Conference</a></li> --%>
					  <li style="padding-left:0px; padding-right:0px;"><a href="AddContacts.jsp">Add Contacts</a></li>
					  <li style="padding-left:0px; padding-right:0px;"><a href="/EasyResearch/InviteReviewers">Invite Reviewers</a></li>  
					  <li style="padding-left:0px; padding-right:0px;"><a href="/EasyResearch/CheckStatusConferenceChair">Check Abstract</a></li>
					  <li style="padding-left:0px; padding-right:0px;"><a href="/EasyResearch/AssignReviewerPaper">Assign Papers</a></li>
					  <li style="padding-left:0px; padding-right:0px;"><a href="/EasyResearch/MakeDecision">Make Paper Decision</a></li>
					</ul>
				</div>
				<div class="logout">
					<form name="logout" action="Logout" method="post">
						<input type="submit" value="Logout" align ="right"> 
					</form>
				</div>
			</div>
			<br/>
			&nbsp;
			<table class = "conferenceChairNotificationDetailsTable" style="width: 522px; display: inline-block; border: 1px solid #aaa; border-radius: 5px; border-collapse: collapse;">
				<thead>
					<tr bgcolor="#ffffff">
						<td style="padding-left: 10px;" width ="522px" bgcolor="#ffffff" colspan="3">
							<h2 style="display: inline-block;" id="conferenceNameNotifications"><%=c.getConferencename()%></h2>
						</td>
					</tr>
					<tr>
						<td style="text-align:center;" width ="34%">
							Paper Title
						</td>
						<td style="text-align:center;" width ="40%">
							Reviewer Name 
						</td>
						<td style="text-align:center;" width ="26%">
							Status
						</td>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${chairNotificationDetailsList!=null && chairNotificationDetailsList!='' && fn:length(chairNotificationDetailsList) gt 0}">
							<c:forEach var = "singleChairNotificationDetail" items="${chairNotificationDetailsList}">
							<tr>
								<td style="text-align:center; padding-left: 5px;" width ="34%">
									<c:out value="${singleChairNotificationDetail[2]}"/>
								</td>
								<td style="text-align:center; padding-left: 5px;" width ="40%">
									<c:out value="${singleChairNotificationDetail[3]} ${singleChairNotificationDetail[4]}"/> 
								</td>
								<td style="text-align:center; padding-left: 5px;" width ="26%">
									<c:out value="${singleChairNotificationDetail[6]}"/><br/>
								</td>
							</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td style="padding-left: 10px;" width ="100%">
									Currently, there are no notifications to be shown<br/> 	
								</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			<br/>
			&nbsp;
			&nbsp;
			<div class="footer">
				<p id="copyright">Copyright &copy; 2014. Developed by Chandrachudeswaran Sankar, Sashank Santhanam, Rohit Bansod, Samatha Kolagatla</p>
			</div>
		</div>
	</body>
</html>