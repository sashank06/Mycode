<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="reviewerbean.ReviewerBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
	<head>
	<!-- Comments: This page lets Reviewer to download and give comments to the author paper -->
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<script src="functions.js"></script>
		<title>Check Status</title>
	</head>
	
	<body>
		<% ReviewerBean c = (ReviewerBean)request.getAttribute("Reviewer");%>
		<c:set var = "reviewPaperDetailsVar" value="${requestScope.Reviewer.reviewergetpaper}"/>
		<div id="main-wraper">
			<div id="top-wraper">
				<div id="banner">Easy Research</div>
				<div id="nav">
					<ul>
						<li><a href="ReviewerLoginSuccess.jsp">Home</a></li>
				  		<li><a href="/EasyResearch/ReviewerNotification">Notifications</a></li>
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
							<c:when test="${reviewPaperDetailsVar!= null && reviewPaperDetailsVar !='' && fn:length(reviewPaperDetailsVar) gt 0}">
								<td style="padding-left: 10px; width: 40%">
									<table id = "revEvalTable" style="padding-bottom: 10px; border: 1px solid #000000; border-radius: 3pt; vertical-align: top;">
										<tbody>
											<tr>
												<td id="listofPaperTitles">
													<h2>List of Papers</h2>
												</td>
											</tr>
											<tr>
												<td valign="top">
													<dl>
														<c:set var = "listOfReviewingPapersDetails" value ="<%=c.getReviewergetpaper()%>"/>
														<c:forEach var = "singleReviewingPaperDetail" items="${listOfReviewingPapersDetails}">
															<dd><a onclick="displaySingleReviewingPaper('${singleReviewingPaperDetail[0]}','${singleReviewingPaperDetail[1]}')" href="javascript:void(0);">${singleReviewingPaperDetail[0]}</a></dd>
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
							<div id ="ReviewPaperArea" class="hidden">
								<form name="reviewedPaperCommentsform1" action="ReviewerEvaluatePaperComments" method="post">
									<input type="hidden" name="paperLocationSave" id="paperLocationSave"></input>
									<table id = "reviewPaperCheckTable"style="border:1px solid #aaa; vertical-align: top;">
										<tbody>
											<tr>
												<td><h3 id="showPaperReviewTitle" align="left"></h3></td>
											</tr>
											<tr>
												<td class="textright" style="vertical-align: top;">Download Paper: </td>
												<td>
													<a id = "downloadPaper" class="textright" href="javascript:void(0);" name="downloadPaper" style="vertical-align: top; height: 22px; text-decoration: underline" onclick="downloadPaper();"></a>
												</td>
											</tr>
											<tr>
												<td class="textright" style="vertical-align: top;">Comments: </td>
												<td style="text-align: left; padding-right: 20px;">
													<textarea id = "reviewerPaperComments" rows=15 cols=50 name="reviewerPaperComments"></textarea>
												</td>
											</tr>
			        						<tr>
			        							<td class="style1" colspan="2" align="center"><input type="submit" id = "PaperCommentsDecision" name="PaperCommentsDecision" value="Post Comments" class="loginbutton" /></td>
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
			<form name="downloadPaperform1" action="FileDownload" method="post">
				<input type="hidden" name="paperLocationDownload" id="paperLocationDownload"></input>
			</form>										
			<div class="footer" style="padding-top: 3px;">
				<p id="copyright">Copyright &copy; 2014. Developed by Chandrachudeswaran Sankar, Sashank Santhanam, Rohit Bansod, Samatha Kolagatla</p>
			</div>
		</div>
	</body>
</html>