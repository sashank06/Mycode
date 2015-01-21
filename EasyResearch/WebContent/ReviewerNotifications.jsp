<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="reviewerbean.ReviewerBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- Comments: This page shows notifications to reviewers -->
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<script src="functions.js"></script>
		<title>Check Status</title>
	</head>
	
	<body>
		<% ReviewerBean c = (ReviewerBean)request.getAttribute("Reviewer");%>
		<c:set var = "notificationDetailsVar" value="${requestScope.Reviewer.reviewernotification}"/>
		<div id="main-wraper">
			<div id="top-wraper">
				<div id="banner">Easy Research</div>
				<div id="nav">
					<ul>
						<li><a href="ReviewerLoginSuccess.jsp">Home</a></li>
				  		<li><a href="/EasyResearch/ReviewerEvaluatePaperComments">Evaluate Papers</a></li>
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
							<c:when test="${notificationDetailsVar!= null && notificationDetailsVar !='' && fn:length(notificationDetailsVar) gt 0}">
								<td style="padding-left: 10px; width: 40%">
									<table id = "notifcationsTable" style="padding-bottom: 10px; border: 1px solid #000000; border-radius: 3pt; vertical-align: top;">
										<tbody>
											<tr>
												<td>
													<h2>Paper Notifications</h2>
												</td>
											</tr>
											<tr>
												<td>
													<dl>
														<c:set var = "listOfPaperNotificationDetails" value ="<%=c.getReviewernotification()%>"/>
														<c:forEach var = "singlePaperNotificationDetail" items="${listOfPaperNotificationDetails}">
															<dd><a onclick="displaySinglePaperNotification('${singlePaperNotificationDetail[0]}','${singlePaperNotificationDetail[1]}','${singlePaperNotificationDetail[2]}')" href="javascript:void(0);">${singlePaperNotificationDetail[0]}</a></dd>
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
									<p style="padding-left:25px;">No paper to review currently</p><br/>
								</td>
							</c:otherwise>
						</c:choose>
						<td style="width:50%; padding-left:20px;">
							<div id ="PaperNotificationArea" class="hidden">
								<form name="revPaperform1" action="ReviewerNotification" method="post" >
									<input type="hidden" name="nameofconfPaper" id="nameofconfPaper"></input>
									<input type="hidden" name="paperTitle" id="paperTitle"></input>
									<input type="hidden" name="paperAbstractsText" id="paperAbstractsText"></input>
									<table id = "reviewPaperTable"style="border:1px solid #aaa; vertical-align: top;">
										<tbody>
											<tr>
												<td><h3 id="showConfReviewPaperTitle" align="left" style="display: inline-block; width: 284px; padding-left:"><span id="showConfReviewPaperTitleSpan"></span></h3></td>
											</tr>
											<tr>
												<td class="textright" style="vertical-align: top;">Abstract: </td>
												<td style="text-align: left; padding-right: 20px;">
													<textarea disabled="disabled" id = "abstractPaper" rows=15 cols=50 name="abstractPaper"></textarea>
												</td>
											</tr>
											<tr>
			        							<td class="textright" style="vertical-align: top;">Decision: </td>
			            						<td>
				            						<select id = "paperDecisionValue" name="paperDecisionValue" class="table_selectinput">
														<option value="Decision" selected="selected"> Decision </option>
														<option value="Accept"> Accept </option>
														<option value="Reject"> Deny </option>
													</select>
												</td>
			        						</tr>
			        						<tr>
			        							<td class="style1" colspan="3" align="center"><button type="button" id = "makeReviewPaperDecision" name="makeReviewPaperDecision" class="loginbutton" onclick="checkValueOfPaperReviewDecision();">Submit</button></td>
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