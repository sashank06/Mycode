<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="authorbean.AuthorBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- Comments: This page show the abstract and Paper status to author -->
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<script src="functions.js"></script>
		<title>Check Status</title>
	</head>
	
	<body>
		<% AuthorBean b = (AuthorBean)request.getAttribute("conference");%>
		<div id="main-wraper">
			<div id="top-wraper">
				<div id="banner">Easy Research</div>
				<div id="nav">
					<ul>
					  <li><a href="AuthorLoginSuccess.jsp">Home</a></li>
					  <li><a href="/EasyResearch/ListofConferences">List of Conferences</a></li>
				      <li><a href="/EasyResearch/EditProfile">Edit Profile</a></li>
					</ul>
				</div>
				<div class="logout">
					<form name="logout" action="Logout" method="post">
						<input type="submit" value="Logout" align ="right"> 
					</form>
				</div>
				<br/>
			</div>
			<table class = "columncss" id ="authorstatusmaintable" align="center" style="display: inline-block; width :472px; padding-bottom: 10px; border: 1px solid #aaa; border-radius: 3pt;">
				<tbody>
					<tr>
						<td style=" padding-top: 5px; padding-left: 5px;">
							<h2 style="display: inline-block;">Status of Abstracts and Papers</h2>
						</td>
					</tr>
					<c:set var = "listOfAbstractsDecision" value ="<%=b.getAbstract_status()%>"/>
					<c:forEach var = "singleAbstractDecision" items="${listOfAbstractsDecision}">
					<tr>
						<td width="60%" style="padding-left: 10px;">
							<ul style="list-style-type: none;">
								<li style="font-weight: bold;">${singleAbstractDecision[2]}</li>
							</ul>
						</td>
						<td align="center" style="padding-left:50px;">
							<input type="submit" name="Check Status" value ="Status" class = "loginbutton" style="text-align: center; min-width: 90pt;" onclick="displayAbstractStatus('${singleAbstractDecision[0]}','${singleAbstractDecision[2]}','${singleAbstractDecision[5]}','${singleAbstractDecision[6]}','${singleAbstractDecision[7]}');">
						</td>
					</tr>
					</c:forEach>
					<tr>
						<td colspan="2" align="center">
							<form id = "paperUpload" name = "paperUpload" action="UploadPaper" method="post" enctype="multipart/form-data">
								<input type="hidden" id="uploadPaperAbstractId" name="uploadPaperAbstractId"/>
								<input type="hidden" id="uploadPaperTitleName" name="uploadPaperTitleName"/>
								<table align="center" width="509px" id = "AbstractStatusArea" class = "hidden" style="border:1px solid #aaa; text-align: center; margin-left: 41px;">
									<thead>
										<tr style="font-size: 14.5px; border-bottom :1px solid #aaa;">
											<td width="215px" style="text-align: center; border-bottom:1px solid #aaa; border-right:1px solid #aaa;">
												<strong>Conference Name</strong>
											</td>
											<td width="200px" style="text-align: center; border-bottom:1px solid #aaa; border-right:1px solid #aaa;">
												<strong>Abstract/Paper Title</strong>
											</td>
											<td id = "AutPapUpAbstStat"width="165px" style="text-align: center; border-bottom:1px solid #aaa; border-right:1px solid #aaa;">
												<strong>Abstract Status</strong>
											</td>
											<td width="370px" id = "AutPapUp" style="text-align: center; display: none; border-bottom:1px solid #aaa;">
												<strong>Upload Paper</strong>
											</td>
											<td id = "AutPapUpPaperStat"width="150px" style="text-align: center; border-bottom:1px solid #aaa; display:none;">
												<strong>Paper Status</strong>
											</td>
										</tr>
									</thead>
									<tbody>
										<tr style="border-bottom:1px solid #aaa;">
										
											<td id="conferenceNameAuthorCheckStatus" width="215px" style="text-align: center; border-right:1px solid #aaa;"></td>
											<td id="titleAuthorCheckStatus" width="200px" style="text-align: center; border-right:1px solid #aaa;"></td>
											<td id="abstractStatusAuthorCheckStatus" width="165px" style="text-align: center; border-right:1px solid #aaa;"></td>
											<td id="uploadPaperAuthorCheckStatus" width="370px" style="text-align: center; display:none;"><input type="file" name="uploadlink" style="width: 190px; padding-left: 15px;"><input type="submit" class = "loginbutton" name="upload" value="Upload Paper" style = "min-width:80px;" onclick="paperStatusUpload();"/></td>
											<td id="paperStatusAuthorCheckStatus" width="150px" style="text-align: center; display: none;"></td>
										</tr>
									</tbody>
								</table>
							</form>
						</td>
					</tr>
				</tbody>
			</table>
			&nbsp;
			<div class="footer" style="padding-top: 3px;">
				<p id="copyright">Copyright &copy; 2014. Developed by Chandrachudeswaran Sankar, Sashank Santhanam, Rohit Bansod, Samatha Kolagatla</p>
			</div>
		</div>
	</body>
</html>