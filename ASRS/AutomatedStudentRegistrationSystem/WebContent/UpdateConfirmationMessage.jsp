<%@page import="com.project.beans.Course"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor ='silver'>
<font color ='teal'>

	<center>
	<img src ="confirmationFace.jpg"><br>
		<h2>Successfully Updated!!</h2>
		<br>
		<br>
		<%
			Course course = (Course) request.getAttribute("courseobj");
		%>
		Course <b><%=course.getCourse_name()%></b> has been successfully
		updated.<br>
		<table>
			<tr>
				<td>Id No.:
				<td><b><%=course.getCourse_id()%></b>
			<tr>
				<td>Updated Capacity :
				<td><b><%=course.getCapacity()%></b>
		</table>
		<br>To get back to profile 
		<a href = "RegistrarProfile.jsp"><i>Click here</i></a>
	</center>
	</font>
</body>
</html>