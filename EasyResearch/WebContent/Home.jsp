<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="conferencebean.ConferenceBean"%>
<!DOCTYPE>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<title>Easy Research </title>
	<!-- Comments: This is the landing page of EasyResearch -->
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script src="functions.js"></script>
</head>

<body>
	<% ConferenceBean c = (ConferenceBean)request.getAttribute("conferences");%>
	<div id="main-wraper">
		<div id="top-wraper">
			<div id="banner">Easy Research</div>
			<div id="nav">
				<ul>
				  <li><a href="/EasyResearch/Home">Home</a></li>
				  <li><a href="AboutUs.jsp">About us</a></li>
				  <li><a href="ContactUs.jsp">Contact</a></li>
				  <li><a href="Admin.jsp">Admin</a></li>
				</ul>
			</div>
		</div>
		<table style="width: 926px; display: inline-block; float: none;">
			<tbody>
				<tr>
					<td id="left" class = "left" valign="top" >
							<p style="font-size: 16px;"><strong>Login as</strong></p>
							<p><a href="AuthorLogin.jsp">Author</a></p>
							<p><a href="ConferenceChair.jsp">Conference chair</a></p>
						  	<p><a href="ReviewerLogin.jsp">Reviewer</a></p>
					</td>
					<td id="right"  valign="top" class="right" style="display: block; overflow: hidden;">
						<p class="para_title">EasyResearch</p>
						<p style="font-size: 12px; font-style: normal; text-align:justify; width:450px;">
						EasyResearch is a Web application for managing registration, paper submission and paper review. Written in Java, with a MySQL database at the back end, it is a comprehensive and powerful, yet easy to use solution for online conference management.
						<br><br>
						Easy research is a Conference Management System that provides a common platform for the researchers to submit their research papers. It allows the authors to login and submit their research papers. This system also displays various conferences proceedings and the researcher can find his/her area of interest conference and submit their paper. The important dates will not be missed since e-mail reminders are sent to the author.
						<br><br>
						This system is useful for the conference chair and as well as for the reviewers. Conference chair can host the conference and assign the reviewers based on their area of interest. The reviewers can provide feedback and comments to the papers under consideration. The authors can keep track of the paper decision of all the conferences aligned to his/ her interests on his profile.
						<br><br>
						But the most important feature of EasyResearch is it's <strong>free!!!</strong>.   
						</p>
					</td>
					<td id="rightmostConference" valign="top" class="rightmost" style="display: block; overflow-x: scroll; overflow-y: scroll; border: 1px solid #000; height:308px; width:300px; border-radius: 5pt;">
						<h2 style="padding-top: 10px;">Conferences</h2>
						<c:set var = "fullListOfConferencesDetails" value ="<%=c.getConferenceDetailsList()%>"/>
						<c:choose>
							<c:when test="${fullListOfConferencesDetails!= null && fullListOfConferencesDetails !='' && fn:length(fullListOfConferencesDetails) gt 0}">
								<c:forEach var = "singleConferencesDetails" items="${fullListOfConferencesDetails}">		
									<ul>
										<li style="list-style-type: none;">
											<a id="${singleConferencesDetails[0]}" href="javascript:void(0);" onclick="overlay('${singleConferencesDetails[0]}','${singleConferencesDetails[1]}','${singleConferencesDetails[6]}','${singleConferencesDetails[4]}');">${singleConferencesDetails[0]}</a>
										</li>
									</ul>
								</c:forEach>
							</c:when>
							<c:otherwise>
								No conferences Available
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</tbody>
		</table>
		<div id="overlay">
     		<div id="maincontent">
          		<table>
          			<thead>
          				<tr>
          					<td id = "closeButtonModalId"class ="closebuttonModal" colspan="4"></td>
          				</tr>
          				<tr>
          					<td colspan="4" style=" padding-top: 5px; padding-left: 5px;">
								<h2 style="display: inline-block;">Conference Details</h2>
							</td>
          				</tr>
          			</thead>
          			<tbody>
	      				<tr style="font-size: 14.5px;">
							<td width="215px" style="text-align: center; border-left:1px solid #aaa; border-right:1px solid #aaa; border-bottom:1px solid #aaa; border-top: 1px solid #aaa;">
								<strong>Conference Name</strong>
							</td>
							<td width="150px" style="text-align: center; border-left:1px solid #aaa; border-right:1px solid #aaa; border-bottom:1px solid #aaa; border-top: 1px solid #aaa;">
								<strong>Place</strong>
							</td>
							<td width="120px" style="text-align: center; border-left:1px solid #aaa; border-right:1px solid #aaa; border-bottom:1px solid #aaa; border-top: 1px solid #aaa;">
								<strong>To be held on</strong>
							</td>
							<td width="200px" style="text-align: center; border-left:1px solid #aaa; border-right:1px solid #aaa; border-bottom:1px solid #aaa; border-top: 1px solid #aaa;">
								<strong>Abstract Submission by</strong>
							</td>
						</tr>
          				<tr style="font-size: 14.5px;">
							<td id="homeConfNameValue" width="215px" style="text-align: center; border-left:1px solid #aaa; border-right:1px solid #aaa; border-bottom:1px solid #aaa;"></td>
							<td id="homeConfPlaceValue" width="150px" style="text-align: center; border-left:1px solid #aaa; border-right:1px solid #aaa; border-bottom:1px solid #aaa;"></td>
							<td id="homeConfDateValue" width="120px" style="text-align: center; border-left:1px solid #aaa; border-right:1px solid #aaa; border-bottom:1px solid #aaa;"></td>
							<td id="homeAbsSubDateValue" width="200px" style="text-align: center; border-left:1px solid #aaa; border-right:1px solid #aaa; border-bottom:1px solid #aaa;"></td>
						</tr>
          			</tbody>
          		</table>
	     	</div>
		</div>
		<div class="footer">
			<p id="copyright">Copyright &copy; 2014. Developed by Chandrachudeswaran Sankar, Sashank Santhanam, Rohit Bansod, Samatha Kolagatla</p>
		</div>
	</div>
</body>
</html>