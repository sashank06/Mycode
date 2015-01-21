<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="authorbean.AuthorBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<!-- Comments: This page give the list of conference to author -->
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<script src="functions.js"></script>
		<script src="chkabstract.js"></script>
		
		<title>Author List of Conferences</title>
	</head>
	
	<body>
	<% AuthorBean b = (AuthorBean)request.getAttribute("conference"); %>
		<div id="main-wraper">
			<div id="top-wraper">
				<div id="banner">Easy Research</div>
				<div id="nav">
					<ul>
					  <li><a href="AuthorLoginSuccess.jsp">Home</a></li>
					  <li><a href="/EasyResearch/EditProfile">Edit Profile</a></li>
					  <li><a href="/EasyResearch/CheckStatusAuthor">Check Status</a></li>
					</ul>
				</div>
				<div class="logout">
					<form name="logout" action="Logout" method="post">
						<input type="submit" value="Logout" align ="right"> 
					</form>
				</div>
			</div>
			<table style="width: 100%; display: inline-block; padding-bottom: 10px;">
				<tbody>
					<tr>
						<td>
							<h2 style="display: inline-block;">List of Conferences</h2>
						</td>
					</tr>
					<tr>
						<td>	
							<ul>
								<c:set var = "listOfConf" value ="<%=b.getConferencelist()%>"/>
								<c:forEach var = "singleConference" items="${listOfConf}">
									<li><a onclick="displaySingleConference('${singleConference[0]}','${singleConference[1]}','${singleConference[3]}')" href="javascript:void(0);">${singleConference[0]}</a></li>
								</c:forEach>
							</ul>
						</td>
					</tr>
					<tr>
						<td>
							<div id = "ConferenceArea" class="hidden">
								<form name="formabs" action="ListofConferences" method="post" onsubmit="return chkabstract();">
									<input type="hidden" name="nameofconf" style="width:90%" id="TitleValue"></input>
									<table style="border:1px solid #aaa; border-radius: 8pt; margin-left: 40px; width:840px">
										<tbody>
											<tr>
												<td colspan="2">
													<h2 id="conferenceName" style="text-align: left; display: inline-block;">ConferenceName</h2><br>
												</td>
											</tr>
											<tr>
												<td align="right" valign="top" style="width: 25%">
													<span style="font-size: 14px; font-weight: bold; vertical-align: top;">Conference Description: </span>
												</td>
												<td colspan="2" style="text-align: left;">
													<textarea rows=auto cols=80 name="description" style="width:90%;" id="ConfDescription" disabled="disabled"></textarea>
												</td>
											</tr>
											<tr>
												<td align="right" valign="top" style="width: 25%">
													<span style="font-size: 14px; font-weight: bold;">Title: </span>
												</td>
												<td colspan="2" style="text-align: left;">
													<input type="text" name="title" style="width:90%" value=""></input>
												</td>
											</tr>
											<tr>
												<td align="right" valign="top" style="width: 25%">
													<span style="font-size: 14px; font-weight: bold;">Keywords: </span>
												</td>
												<td colspan="2" style="text-align: left;">
													<input type="text" name="keywords" style="width:90%"></input>
												</td>
											</tr>
											<tr>
												<td align="right" valign="top" style="width: 25%">
													<span style="font-size: 14px; font-weight: bold;">Enter Abstract: </span>
												</td>
												<td colspan="2" style="text-align: left;">
													<textarea rows=17 cols=80 style="width:90%;" name="abstract"></textarea>
												</td>
											</tr>
											<tr>
												<td colspan="2" align="center" style="text-align: center;">
													<input type="submit" value="Register" name="submit" class="loginbutton">
												</td>
											</tr>
										</tbody>
									</table>
								</form>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="footer">
				<p id="copyright">Copyright &copy; 2014. Developed by Chandrachudeswaran Sankar, Sashank Santhanam, Rohit Bansod, Samatha Kolagatla</p>
			</div>
		</div>
	</body>
</html>