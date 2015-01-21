<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="conferencechairbean.ConferenceChairBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- Comments: This page has all papers populated for the conference chair to assign them to reviewers -->
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<script src="functions.js"></script>
		<title>Check Status</title>
	</head>
	
	<body>
		<% ConferenceChairBean c = (ConferenceChairBean)request.getAttribute("conference1");%>
		<c:set var = "paperDetailsList" value="${requestScope.conference1.papers_details}"/>
		<c:set var = "reviewersList" value="${requestScope.conference1.reviewers}"/>
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
			<form name="formpapRev" action="AssignReviewerPaper" method="post">
			<table style="display: inline-block; border: 1px solid #000000; width: 896px; border-radius: 5pt;">
				<tbody>
					
					<c:choose>
						<c:when test="${paperDetailsList!= null && paperDetailsList !='' && fn:length(paperDetailsList) gt 0 && reviewersList!= null && reviewersList !='' && fn:length(reviewersList) gt 0}">
							<tr>
								<c:choose>
									<c:when test="${paperDetailsList!= null && paperDetailsList !='' && fn:length(paperDetailsList) gt 0}">
										<td style="padding-left: 10px;">
											<table id = "paperTable" style="width: 422px; padding-bottom: 35px; height: 212px; vertical-align: top;">
												<tbody>
													<tr>
														<td style="padding-left: 10px;">
															<h2 style="display: inline-block;">Assign Papers</h2>
														</td>
													</tr>
													<c:set var = "listOfPaperDetails" value ="<%=c.getPapers_details()%>"/>
													<c:forEach var = "singlePaperDetail" items="${listOfPaperDetails}">
														<tr>
															<td>
																<input type="hidden" name="paperId" id="paperId"></input>
																<input type="hidden" name="paperName" id="paperName"></input>
																<dl>
																	<dd><input type="radio" <%-- onselect="displaySinglePaper('${singlePaperDetail[0]}','${singlePaperDetail[1]}')" --%> name="paperSelected" value="${singlePaperDetail[0]}_:_${singlePaperDetail[1]}"></input>${singlePaperDetail[1]}</dd>
																</dl>
															</td>
															<td>
																<input type="hidden" name="paperAssigned" id="paperAssigned"></input>
																<c:choose>
																	<c:when test="${singlePaperDetail[2] !=null && singlePaperDetail[2]!='' && singlePaperDetail[2] eq 'true'}">
																		Assigned
																	</c:when>
																	<c:otherwise>
																		Pending
																	</c:otherwise>
																</c:choose>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</td>
									</c:when>
									<c:otherwise>
										<td style="text-align: left; display: inline-block; padding-left:25px; font-weight: bold; ">
											<p style="padding-left:25px;">Currently  there are no Papers to be assign</p><br/>
										</td>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${paperDetailsList!= null && paperDetailsList !='' && fn:length(paperDetailsList) gt 0 && reviewersList!= null && reviewersList !='' && fn:length(reviewersList) gt 0}">
										<input type="hidden" id = "reviewersDetailsInputList" name="reviewersDetailsInputList[]"></input>
										<td style="padding-left: 10px;">
											<table id = "reviewerTable" style="width: 422px; overflow-y: scroll; padding-bottom: 10px; height: 212px; vertical-align: top;">
												<tbody>
													<tr>
														<td style="padding-left: 10px; padding-top:7px;">
															<h2 style="display: inline-block;">Reviewers</h2>
														</td>
													</tr>
													<tr>
														<td>
															<dl>
																<c:set var = "listOfReviewersDetails" value ="<%=c.getReviewers()%>"/>
																<c:forEach var = "singleReviewerDetail" items="${listOfReviewersDetails}">
																	<dd><input type="checkbox" name="reviewerList" onselect="selectReviewers('${singleReviewerDetail[0]}','${singleReviewerDetail[1]}','${singleReviewerDetail[2]}')" value="${singleReviewerDetail[2]}"></input>${singleReviewerDetail[0]} ${singleReviewerDetail[1]} (${singleReviewerDetail[3]})</dd>
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
											<p style="padding-left:25px;">Currently  there are no Reviewers to allocated</p><br/>
										</td>
									</c:otherwise>
								</c:choose>
							</tr>
							<tr>
								<td colspan="2" align="center" style="text-align: center;">
									<button type="button" value="Assign" name="assign" class="loginbutton" onclick="fetchPaperAndReviewerDetails();">Assign</button>
								</td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<td style="text-align: left; display: inline-block; padding-left:25px; font-weight: bold; ">
									<p style="padding-left:25px;">No Papers or Reviewers to be shown currently</p><br/>
								</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			</form>
			&nbsp;
			&nbsp;
			<div class="footer" style="padding-top: 3px;">
				<p id="copyright">Copyright &copy; 2014. Developed by Chandrachudeswaran Sankar, Sashank Santhanam, Rohit Bansod, Samatha Kolagatla</p>
			</div>
		</div>
	</body>
</html>