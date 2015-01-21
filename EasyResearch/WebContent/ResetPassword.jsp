<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<!-- This page lets user to reset his or her password. -->
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Reset Password</title>
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<script src="Reset.js"></script>
	</head>

	<body>
		<%String invalid = (String)request.getAttribute("Invalid Username"); %>
		<c:set var = "invalid" value ="<%=invalid%>"/>
		<div id="main-wraper">
			<div id="top-wraper">
				<div id="banner">Easy Research</div>
				<div id="nav">
					<ul>
					  <li><a href="/EasyResearch/Home">Home</a></li>
					  <li><a href="AboutUs.jsp">About us</a></li>
					  <li><a href="ContactUs.jsp">Contact</a></li>
					</ul>
				</div>
			</div>
			<div>
				<table style="width: 100%; display: inline-block;">
					<tbody>
						<tr>
							<td>
								<h2>Easy Research - Reset Password</h2>
							</td>
						</tr>
						<tr>
							<td>
								<c:if test="${invalid!=null && invalid!=''}">
									<span class = "invalidText" style ="color: red;">${invalid}</span>
									<c:set var = "invalid" value =""/>
								</c:if>
								<form name="resetpassform" action="ResetPassword" method="post" onsubmit= "return chkreset();">
									<input type="hidden" name="callingUser" value="<%= request.getParameter("user") %>"/>
									<table class="logintable">
										<tbody>
											<tr>
												<td class="textright">Username : </td>
												<td class="tableinputtext"><input class="tableinput" type="text" name="resetPassUsername"/></td>
											</tr>
									 	
							 				<tr>
							 					<td colspan="2" style="text-align: center;"><input type="submit" value="Send Password" class="loginbutton"></td>
							 				</tr>
							 			</tbody>
					 				</table>
								</form>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="footer">
				<p id="copyright">Copyright &copy; 2014. Developed by Chandrachudeswaran Sankar, Sashank Santhanam, Rohit Bansod, Samatha Kolagatla</p>
				
			</div>
		</div>
	</body>
</html>