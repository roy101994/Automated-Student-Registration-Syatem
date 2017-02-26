<%@page import="com.project.beans.Course"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Course Form</title>
</head>
<body bgcolor="silver">
	<font face="calibri">
		<center>
			<input type="button" value="New Course Details" bgcolor="lightblue"
				style="width: 1500px; height: 72px; font-size: 36px; color: WhiteSmoke; font-style: calibri; font-weight: bolder; font-family: Calibri; background-color: Teal"
				disabled="disabled">
			<h2>
				<b></b>
			</h2>
			<br> <br> <br> <font size='3' color='blue'>NOTE: </font><font size='3' color='red'>*
				marked fields are compulsory fields. <br><font size='3' color='blue'>Date format:</font> YYYY-MM-DD<br>

			</font><br> 
			<form name="courseform" action="newcourse" method="post">
				<%
					Course course = (Course) request.getAttribute("courseobj");
					if (course == null) {
				%>
				<table border=2 align="center" style="width: 602px; height: 260px; background-color: White">
					<tr align="center">
						<td style="width: 298px; "><font color = "teal"><b>Course Name</b></font><font size='3' color='red'>*</font>
						<td style="width: 244px; "><input type="text" name="course_name" size="20"
							style="width: 171px;">
					<tr align="center">
						<td><font color = "teal"><b>Start Date</b></font><font size='3' color='red'>*</font>
						<td><input type="text" name="start_date" size="20"
							style="width: 171px;" placeholder = "YYYY-MM-DD">
					<tr align="center">
						<td><font color = "teal"><b>End Date</b></font><font size='3' color='red'>*</font>
						<td><input type="text" name="end_date" size="20"
							style="width: 171px;" placeholder = "YYYY-MM-DD">
					<tr align="center">
						<td><font color = "teal"><b>Capacity</b></font><font size='3' color='red'>*</font>
						<td><input type="text" name="capacity" size="20"
							style="width: 171px;" placeholder = "0">
				</table>
				<%
					} else {
				%>
				<table border=2 align="center" style="width: 602px; height: 260px; background-color: White">
					<tr align="center">
						<td style="width: 298px; "><font color = "teal"><b>Course Name</b></font><font size='3' color='red'>*</font>
						<td style="width: 244px; "><input type="text" name="course_name" size="20"
							style="width: 171px;" value="<%=course.getCourse_name()%>">
					<tr align="center">
						<td><font color = "teal"><b>Start Date</b></font><font size='3' color='red'>*</font>
						<td><input type="text" name="start_date" size="20"
							style="width: 171px;" value="<%=course.getStart_date()%>">
					<tr align="center">
						<td><font color = "teal"><b>End Date</b></font><font size='3' color='red'>*</font>
						<td><input type="text" name="end_date" size="20"
							style="width: 171px;" value="<%=course.getEnd_date()%>">
					<tr align="center">
						<td><font color = "teal"><b>Capacity</b></font><font size='3' color='red'>*</font>
						<td><input type="text" name="capacity" size="20"
							style="width: 171px;" value="<%=course.getCapacity()%>">
				</table>

				<br><%
					}
					String msg = "";
					Object obj = request.getAttribute("message");
					if (obj != null)
						msg = (String) obj;
					if (!msg.equals("")) {
				%>
				<font size='3' color='red'><%=msg%></font><br>
				<%
					} else {
				%>
				<br><br>
				<%
					}
				%>
				<input type="submit" name="submit" value="SUBMIT"
					style="width: 115px; color: AntiqueWhite; font-weight: bold; height: 32px; font-size: 14px; background-color: Teal">
			</form>
		</center>
	</font>
</body>
</html>