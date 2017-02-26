<%@page import="com.project.utils.CourseUtilsImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.project.utils.StudentUtilsImpl"%>
<%@page import="com.project.beans.Course"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Course</title>
</head>
<body bgcolor='silver'>
<font face = "calibri">
	<center>
		<input type="button" value="Search Course" bgcolor="lightblue" style="width: 1500px; height: 72px; font-size: 36px; color: WhiteSmoke; font-style: calibri; font-weight: bolder; font-family: Calibri; background-color: Teal" disabled="disabled"><h2><b></b></h2>
	<br>
	<br>
		<%!List<String> list = null;%>
		<form name="selectcourse" action="coursedetails" method="post">
			<select name="courses" style="width: 153px; height: 26px; text-align: center">
				<%
					list = new CourseUtilsImpl().getNameOfCourses();
					for (String course : list) {
				%>
				<option value="<%=course%>"><%=course%></option>
				<%
					}
				%>
			</select> <input type="submit" name="search" value="SEARCH" style="width: 115px; color: AntiqueWhite; font-weight: bold; height: 32px; font-size: 14px; background-color: Teal">
		</form>
	</center>
	<br>
	<%
		int capacity = 0;
		String course = "";
		String start_date = "";
		String end_date = "";
		int course_id = 0;
		Course obj = (Course) request.getAttribute("courseobj");
		if (obj != null) {
			course = obj.getCourse_name();
			capacity = obj.getCapacity();
			start_date = obj.getStart_date();
			end_date = obj.getEnd_date();
			course_id = obj.getCourse_id();
	%><br>
	<center>
		<form name="updatecourse" action="updatecourse" method="post">
			<table border=2 align="center" style="width: 638px; height: 235px; background-color: White">
				<tr align="center">
					<td style="width: 298px; "><font color='teal'><b>Course Name</b></font>
					<td style="width: 278px; "><input type="text" name="course" size="20"
						style="width: 153px; text-align: center" value="<%=course%>" readonly="readonly">
				<tr align="center">
					<td ><font color='teal'><b>Course Id</b></font>
					<td><%=course_id%>
				<tr align="center">
					<td ><font color='teal'><b>Start Date</b></font>
					<td><%=start_date%>
				<tr align="center">
					<td><font color='teal'><b>End Date</b></font>
					<td><%=end_date%>
				<tr align="center">
					<td><font color='teal'><b>Capacity</b></font>
					<td><%=capacity%>
			</table>
			<br><br><font size = 4 color='teal'>Enter new capacity<font color = 'silver'>........</font></font> <input type="text" name="new_capacity"
				size="20" style="width: 153px;;"><br><br>
			<%
				Object obj2 = request.getAttribute("message");
					if (obj2!=null) {
						String msg = (String) obj2;
			%>
			<font size='3' color='red'><%=msg%></font><br>
			<%
				} else {
			%>
			<br>
			<%
				}
			%>
			<br/>
			<input type="submit" name="update" value="Update" style="width: 115px; color: AntiqueWhite; font-weight: bold; height: 32px; font-size: 14px; background-color: Teal">
		</form>
	</center>
	<%
		}
	%>
</font>
</body>
</html>