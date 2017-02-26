<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
</head>
<body bgcolor='silver'>
	<center>
		<b><font face="calibri" color = 'teal'> <input type="button"
				value="Change Password" bgcolor="lightblue"
				style="width: 1500px; height: 72px; font-size: 36px; color: WhiteSmoke; font-style: calibri; font-weight: bolder; font-family: Calibri; background-color: Teal"
				disabled="disabled">
				<h2>
					<b> </b>
				</h2> <br> <br> <br>
				<form name="changepasswordform" action="changepassword"
					method="post">
					<table border=2 align="center" style="width: 638px; height: 235px"
						bgcolor='white'>
						<tr align="center">
							<td><b><font color='teal'><big>Email Id</big></font></b>
							<td><big><input type="text" name="email" size="20"
									style="width: 153px; font-weight: normal;"></big>
						<tr align="center">
							<td><font color='teal'><big><b>Password</font> </big>
							<td><big><input type="password" name="pswd" size="20"
									style="width: 153px; font-weight: normal;"></big><big>
							</big>
						<tr align="center">
							<td><font color='teal'><big><b>New Password</font>
								</big>
							<td><big><input type="password" name="nwpswd"
									size="20" style="width: 153px; font-weight: normal;"
									placeholder="6-10 characters"></big><big> </big>
						<tr align="center">
							<td><font color='teal'><big><b>Confirm
											Password</b></font> </big>
							<td><big><input type="password" name="cnfrmnwpswd"
									size="20" style="width: 153px; font-weight: normal;"
									placeholder="6-10 characters"></big><big> </big>
					</table>
					<big> </big>
					<%
						String message = (String) request.getAttribute("message");
						if (message != null) {
					%>
					<!-- <font size='7' color='red'>!</font> -->
					<font size='3' color='red'><%=message%></font>
					<%
						} else
					%>
					<br> <br> <input type="submit" name="submit"
						value="Submit"
						style="width: 121px; color: AntiqueWhite; font-weight: bold; height: 44px; font-size: 14px; background-color: Teal">
				</form>

		</font> </b>
	</center>
</body>
</html>