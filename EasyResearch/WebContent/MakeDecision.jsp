<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="conferencechairbean.ConferenceChairBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
	<head>
		<!-- Commments: This page lets the Conference chair make Final decision on the paper on which reviewers have given comments -->
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<script src="functions.js"></script>
		<title>Easy Research - Final Decision on Papers</title>
	</head>
	
	<body>
		<% ConferenceChairBean c = (ConferenceChairBean)request.getAttribute("finalcomments");%>
		<c:set var = "reviewedToDecidePaperDetailsVar" value="${requestScope.finalcomments.finalcomments}"/>
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
						<li style="padding-left:0px; padding-right:0px;"><a href="/EasyResearch/ConferenceChairNotification">Notifications</a></li>
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
							<c:when test="${reviewedToDecidePaperDetailsVar!= null && reviewedToDecidePaperDetailsVar !='' && fn:length(reviewedToDecidePaperDetailsVar) gt 0}">
								<td style="padding-left: 10px; width: 40%">
									<table id = "confMakeDecTable" style="padding-bottom: 10px; border: 1px solid #000000; border-radius: 3pt; vertical-align: top;">
										<tbody>
											<tr>
												<td id="listofPaperDecisionTitles">
													<h2>List of Papers</h2>
												</td>
											</tr>
											<tr>
												<td valign="top">
													<dl>
														<c:set var = "listOfReviewedToDecidePapersDetails" value ="<%=c.getFinalcomments()%>"/>
														<c:forEach var = "singleReviewedToDecidePaperDetail" items="${listOfReviewedToDecidePapersDetails}">
															<dd><a onclick="displaySinglePaperFinalDecision('${singleReviewedToDecidePaperDetail[0]}','${singleReviewedToDecidePaperDetail[1]}','${singleReviewedToDecidePaperDetail[2]}','${singleReviewedToDecidePaperDetail[3]}','${singleReviewedToDecidePaperDetail[4]}','${singleReviewedToDecidePaperDetail[5]}','${singleReviewedToDecidePaperDetail[6]}')" href="javascript:void(0);">${singleReviewedToDecidePaperDetail[2]}</a></dd>
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
								<td style="text-align: left; display: inline-block; padding-left:25px; font-weight: bold; ">
									<p style="padding-left:25px;">Currently there are no Papers to review</p><br/>
								</td>
							</c:otherwise>
						</c:choose>
						<td style="width:50%; padding-left:20px;">
							<div id ="MakeDecArea" class="hidden">
								<form name="makeDecisionOnCommentsform1" action="MakeDecision" method="post">
									<input type="hidden" name="paperDecisionId" id="paperDecisionId"></input>
									<table id = "makeDecisionOnCommentsTable"style="border: 1px solid #000000;vertical-align: top;width: 565px;min-height: 297px;border-radius: 5px;">
										<tbody>
											<tr>
												<td><h3 id="showPaperMakeDecisionTitle" align="left"></h3></td>
											</tr>
											<tr>
												<td class="textright" style="vertical-align: top;">Download Paper: </td>
												<td style="vertical-align:  top;">
													<a id = "downloadPaperforDecision" class="textright" href="javascript:void(0);" name="downloadPaperforDecision" style="vertical-align: top; height: 22px; text-decoration: underline" onclick="downloadPaperForDecision();"></a>
												</td>
											</tr>
											<tr>
												<td class="textright" style="vertical-align: top;">Comments: </td>
												<td id = "reviewerPaperDecisionComments" valign ="top" name="reviewerPaperDecisionComments" style="text-align: left; padding-right: 80px; vertical-align:top height: 11px; width: 300px;"></td>
												<td></td>
											</tr>
											<tr>
			        							<td class="textright" style="vertical-align: top;">Decision: </td>
			            						<td>
				            						<select id = "finalPaperDecisionValue" name="finalPaperDecisionValue" class="table_selectinput">
														<option value="Decision" selected="selected"> Decision </option>
														<option value="Accept"> Accept </option>
														<option value="Reject"> Reject </option>
													</select>
												</td>
			        						</tr>
			        						<tr>
			        							<td class="style1" colspan="2" align="center"><button type="button" id = "FinalPaperDecisions" name="FinalPaperDecision" value="Final Paper Decision" onclick="checkValueOfFinalPaperDecision();" class="loginbutton" >Final Paper Decision</button></td>
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
			<form name="downloadPaperDecisionform1" action="FileDownload" method="post">
				<input type="hidden" name="paperDecisionLocationDownload" id="paperDecisionLocationDownload"></input>
			</form>										
			<div class="footer" style="padding-top: 3px;">
				<p id="copyright">Copyright &copy; 2014. Developed by Chandrachudeswaran Sankar, Sashank Santhanam, Rohit Bansod, Samatha Kolagatla</p>
			</div>
		</div>
	</body>
</html>