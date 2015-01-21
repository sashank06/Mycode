<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="conferencechairbean.ConferenceChairBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- Comments: This page give confernce chair the power to accept or reject the assigned papers-->
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<script src="functions.js"></script>
		<title>Check Status</title>
	</head>
	
	<body>
		<% ConferenceChairBean c = (ConferenceChairBean)request.getAttribute("conference1");%>
		<c:set var = "abstractDetailsVar" value="${requestScope.conference1.abstract_details}"/>
		<div id="main-wraper">
			<div id="top-wraper">
				<div id="banner">Easy Research</div>
				<div id="nav">
					<ul>
						<li style="padding-left:0px; padding-right:0px;"><a href="ConferenceChairLoginSuccess.jsp">Home</a></li>
					  	<%-- <li style="padding-left:0px; padding-right:0px;"><a href="CreateConference.jsp">Create Conference</a></li> --%>
					    <li style="padding-left:0px; padding-right:0px;"><a href="AddContacts.jsp">Add Contacts</a></li>
					    <li style="padding-left:0px; padding-right:0px;"><a href="/EasyResearch/InviteReviewers">Invite Reviewers</a></li>  
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
				<br/>
			</div>
			<table style="display: inline-block;">
				<tbody>
					<tr>
						<c:choose>
							<c:when test="${abstractDetailsVar!= null && abstractDetailsVar !='' && fn:length(abstractDetailsVar) gt 0}">
								<td style="padding-left: 10px; width: 40%">
									<table id = "abstractTable" style="padding-bottom: 10px; border: 1px solid #000000; border-radius: 3pt; vertical-align: top;">
										<tbody>
											<tr>
												<td>
													<h2>Check Abstracts</h2>
												</td>
											</tr>
											<tr>
												<td>
													<dl>
														<c:set var = "listOfAbstractsDetails" value ="<%=c.getAbstract_details()%>"/>
														<c:forEach var = "singleAbstractDetail" items="${listOfAbstractsDetails}">
															<dd><a onclick="displaySingleAbstract('${singleAbstractDetail[0]}','${singleAbstractDetail[1]}','${singleAbstractDetail[2]}','${singleAbstractDetail[3]}','${singleAbstractDetail[4]}','${singleAbstractDetail[5]}')" href="javascript:void(0);">${singleAbstractDetail[2]}</a></dd>
														</c:forEach>
													</dl>
												</td>
												<td>
											</tr>
										</tbody>
									</table>
								</td>
							</c:when>
							<c:otherwise>
								<td style="text-align: left; display: inline-block; padding-left:25px; font-weight: bold; width: 200%">
									<p style="padding-left:25px;">No abstracts to check currently</p><br/>
								</td>
							</c:otherwise>
						</c:choose>
						<td style="width:50%; padding-left:20px;">
							<div id ="CheckAbstractArea" class="hidden">
								<form name="absChkform1" action="CheckStatusConferenceChair" method="post" >
									<input type="hidden" name="Username" style="width:95%" id="UserKey"></input>
									<input type="hidden" name="nameofconf" style="width:95%" id="nameofconf"></input>
									<input type="hidden" name="abstractId" style="width:95%" id="abstractId"></input>
									<input type="hidden" name="title" style="width:95%" id="title"></input>
									<input type="hidden" name="abstractKeywords" id="abstractKeywords"></input>
									<input type="hidden" name="abstractsText" id="abstractsText"></input>
									<table id = "checkAbstractTable"style="border:1px solid #aaa; vertical-align: top;">
										<tbody>
											<tr>
												<td><h3 id="showConfAbsTitle" align="left"></h3></td>
											</tr>
											<tr>
												<td class="textright" style="width:10px; vertical-align: top;">Keywords : </td>
												<td class="tableinputtext"><input style="width:95%" class="tableinput" type="text" id = "checkAbstractKeywords" name="checkAbstractKeywords" disabled="disabled"></input></td>
											</tr>
											<tr>
												<td class="textright" style="vertical-align: top;">Abstract: </td>
												<td style="text-align: left; padding-right: 20px;">
													<textarea disabled="disabled" id = "abstract" rows=15 cols=50 name="abstract"></textarea>
												</td>
											</tr>
											<tr>
			        							<td class="textright" style="vertical-align: top;">Decision: </td>
			            						<td>
				            						<select id = "decisionValue" name="decisionType" class="table_selectinput">
														<option value="Decision" selected="selected"> Decision </option>
														<option value="Accept"> Accept </option>
														<option value="Reject"> Reject </option>
													</select>
												</td>
			        						</tr>
			        						<tr>
			        							<td class="style1" colspan="3" align="center"><button type="button" id = "makeDecision" name="makeDecision" value="Make Decision" class="loginbutton" onclick="checkValueOfDecision();">Make Decision</button></td>
			        						</tr>
										</tbody>
									</table>
								</form>
							</div>
							<br/>			
						</td>
					</tr>
				</tbody>
			</table>
			&nbsp;
			&nbsp;
			<div class="footer" style="padding-top: 3px;">
				<p id="copyright">Copyright &copy; 2014. Developed by Chandrachudeswaran Sankar, Sashank Santhanam, Rohit Bansod, Samatha Kolagatla</p>
			</div>
		</div>
	</body>
</html>