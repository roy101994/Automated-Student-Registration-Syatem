<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation Page</title>
</head>
<body bgcolor = 'silver'>
	<center>
	<img src ="confirmationFace.jpg"><br>
		<h2><font size = 5 color = 'teal'>Registration Successful!!</font></h2>
		<br>
		<br><b><%=request.getAttribute("name")%></b> has been
		successfully registered.<br> Id No.: <b><%=request.getAttribute("id")%></b>.
		<%
			String profile = (String)request.getAttribute("profile");
			if(profile==null)
			{
		%>
		<br><font color = 'teal'>To get back to profile</font> <a href="CounsellorProfile.jsp"><i>Click
				here</i></a>
		<%
			}
			else
			{
		%>
		<br><font color = 'teal'>To get back to profile</font> <a href="<%=profile %>"><i>Click
				here</i></a>
		<%
			}
		%>
	</center>
</body>
</html>