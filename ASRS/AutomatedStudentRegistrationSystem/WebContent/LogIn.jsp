<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body bgcolor='silver'>
	<b><font face="calibri">
			<center>
				<input type="button" value="Login Page" bgcolor="lightblue"
					style="width: 1500px; height: 72px; font-size: 36px; color: WhiteSmoke; font-style: calibri; font-weight: bolder; font-family: Calibri; background-color: Teal"
					disabled="disabled">
				<h2>
					<b> </b>
				</h2>
			</center> <br> <br> <br> <%
 	Boolean loginStatus = true;
 	Object status = request.getAttribute("loginStatus");
 	if (status != null)
 		loginStatus = (Boolean) status;
 %>
			<center>
				<form name="loginform" action="login" method="post">
					<table border=2 align="center" style="width: 638px; height: 235px"
						bgcolor='white'>
						<tr align="center">
							<td><b><font color='white'>...</font><font color='teal'><big>Email
											Id</big></font><font color='white'>...</font></b>
							<td><big><input type="text" name="email" size="20"
									style="width: 153px; font-weight: normal;"></big>
						<tr align="center">
							<td><font color='teal'><big><b>Password</font> </big>
							<td><big><input type="password" name="pswd" size="20"
									style="width: 153px; font-weight: normal;"></big><big>
							</big>
						<tr align="center">
							<big> </big>
							<td style="width: 295px;"><font color='teal'><big><b>LogIn
											As</b> </big></font>
							<td><select name="designation"
								style="width: 153px; height: 26px; font-weight: normal;"><big>
								</big>
								<option value="Counsellor">
										<big>Counsellor</big>
									</option>
									<big> </big>
								<option value="Registrar">
										<big>Registrar</big>
									</option>
									<big> </big></select><big> </big>
					</table>
					<big> </big>
					<%
						String msg = "";
						if (!loginStatus)
							msg = "Invalid username, password or designation";
					%>

					<font size='4' color='red'><%=msg%></font> <br>
					<br> <input type="submit" name="submit" value="Login"
						style="width: 121px; color: AntiqueWhite; font-weight: bold; height: 44px; font-size: 14px; background-color: Teal">
				</form>
			</center>
	</font> </b>
</body>
</html>