<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Comments: This page lets Admin create a conference chair login details -->
<title>Easy Research -Admin- Create Chair</title>
</head>
<body>
			<table style="width: 100%; display: inline-block;">
				<tbody>
					<tr>
						<td>
							<h2>Easy Research - Create Conference Chair</h2>
						</td>
					</tr>
					<tr>
						<td>
							<form name="form1" action="createconferencechair" method="post" onsubmit="return chklogin();">
								<table class="logintable">
									<tbody>
									<tr>
											<td class="textright">Firstname : </td>
											<td class="tableinputtext"><input class="tableinput" type="text" name="fname"/></td>
										</tr>
										<tr>
											<td class="textright">Lastname : </td>
											<td class="tableinputtext"><input class="tableinput" type="text" name="lname"/></td>
										</tr>
										<tr>
											<td class="textright">Email : </td>
											<td class="tableinputtext"><input class="tableinput" type="text" name="email"/></td>
										</tr>
										<tr>
											<td class="textright">Username : </td>
											<td class="tableinputtext"><input class="tableinput" type="text" name="username"/></td>
										</tr>
								 		<tr>
								 			<td class="textright">Password : </td>
								 			<td class="tableinputtext"><input class="tableinput" type="password" name="password"/></td>
								 		</tr>
						 				<tr>
						 					<td colspan="2" style="text-align: center;"><input type="submit" value="Create" name="submit" class="loginbutton"></td>
						 				</tr>
						 					</tbody>
						 		</table>
							</form>
						</td>
						</tr>
						</tbody>
						</table>
						 				

</body>
</html>