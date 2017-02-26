<%@page import="com.project.beans.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
</head>
<body bgcolor="silver">
	<font face="calibri">
		<center>
			<input type="button" value="Registration Form" bgcolor="lightblue"
				style="width: 1500px; height: 72px; font-size: 36px; color: WhiteSmoke; font-style: calibri; font-weight: bolder; font-family: Calibri; background-color: Teal"
				disabled="disabled">
			<h2>
				<b></b>
			</h2>
			<br> <br> <br> <font size='3' color='blue'><b>NOTE:
			</b><i><font size='3' color='red'>* marked fields are compulsory fields</font></i></font><br> <br>
			<form name="studentform" action="register" method="post">
				<%
					Student student = (Student) request.getAttribute("studentobj");
					if (student == null) {
				%>
				<table border=2 align="center" style="width: 612px; height: 377px"
					height="360" bgcolor='white'>
					<tr align="center">
						<td style="width: 270px;"><font color="teal"><b>First
									Name</b></font> <font size='3' color='red'>*</font>
						<td><input type="text" name="first_name" size="20"
							style="width: 171px;">
					<tr align="center">
						<td><font color="teal"><b>Middle Name</b></font>
						<td><input type="text" name="middle_name" size="20"
							style="width: 171px;">
					<tr align="center">
						<td><font color="teal"><b>Last Name</b> </font><font size='3'
							color='red'>*</font>
						<td><input type="text" name="last_name" size="20"
							style="width: 171px;">
					<tr align="center">
						<td><font color="teal"><b>Email Id</b> </font><font size='3'
							color='red'>*</font>
						<td><input type="text" name="emailid" size="20"
							style="width: 171px;">
					<tr align="center">
						<td><font color="teal"><b>Course</b></font>
						<td><input type="text" name="course" size="20"
							style="width: 171px;" readonly="readonly"
							value="<%=request.getAttribute("course")%>">
				</table>
				<br> <br>
				<%
					} else {
				%>
				<table border=2 align="center" style="width: 612px; height: 377px"
					height="360" bgcolor='white'>
					<tr align="center">
						<td style="width: 270px;"><font color="teal"><b>First
									Name</b></font> <font size='3' color='red'>*</font>
						<td><input type="text" name="first_name" size="20"
							value="<%=student.getStudent_first_name()%> "
							style="width: 171px;">
					<tr align="center">
						<td><font color="teal"><b>Middle Name</b></font>
						<td><input type="text" name="middle_name" size="20"
							style="width: 171px;"
							value="<%=student.getStudent_middle_name()%>">
					<tr align="center">
						<td><font color="teal"><b>Last Name</b> </font><font size='3'
							color='red'>*</font>
						<td><input type="text" name="last_name" size="20"
							style="width: 171px;" value="<%=student.getStudent_last_name()%>">
					<tr align="center">
						<td><font color="teal"><b>Email Id</b> </font><font size='3'
							color='red'>*</font>
						<td><input type="text" name="emailid" size="20"
							style="width: 171px;" value="<%=student.getStudent_emailid()%>">
					<tr align="center">
						<td><font color="teal"><b>Course</b></font>
						<td><input type="text" name="course" size="20"
							style="width: 171px;" value="<%=request.getAttribute("course")%>"
							readonly="readonly">
				</table>

				<br>
				<%
					}
					Boolean null_flag = false;
					Object obj = request.getAttribute("message");
					if (obj != null)
						null_flag = (Boolean) obj;
					if (null_flag == true) {
				%>
				<font size='3' color='red'>Necessary fields have been left
					empty</font><br> <br>
				<%
					} else {
						Boolean duplicate_flag = false;
						Object flagobj = request.getAttribute("message2");
						if (flagobj != null)
							duplicate_flag = (Boolean) flagobj;
						if (duplicate_flag == true) {
				%>
				<font size='3' color='red'>Student is already registered for
					some course.</font><br>To go back to profile<i> <a href="CounsellorProfile.jsp">Click
					here</a></i><br>
				<%
					} else {
				%>
				<br>
				<%
					}
					}
				%>
				<input type="submit" name="submit" value="SUBMIT"
					style="width: 115px; color: AntiqueWhite; font-weight: bold; height: 32px; font-size: 14px; background-color: Teal">

			</form>
		</center>
	</font>
</body>
</html>