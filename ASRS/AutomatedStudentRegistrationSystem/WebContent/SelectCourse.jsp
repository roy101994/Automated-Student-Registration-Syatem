<%@page import="com.project.utils.CourseUtilsImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.project.utils.StudentUtilsImpl"%>
<%@page import="com.project.utils.StudentUtils"%>
<%@page import="com.project.beans.Course"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor='silver'>

<font face = "calibri">
	<center>
		<input type="button" value="Select a Course" bgcolor="lightblue" style="width: 1500px; height: 72px; font-size: 36px; color: WhiteSmoke; font-style: calibri; font-weight: bolder; font-family: Calibri; background-color: Teal" disabled="disabled"><h2><b></b></h2>
	<br>
	<br>
	
		<%!List<String> list = null;%>
		<form name="selectcourse" action="selectcourse" method="post">
			<select name="courses" style="width: 153px; height: 26px">
				<%
					list = new CourseUtilsImpl().getNameOfCourses();
					for (String course : list) {
				%>
				<option value="<%=course%>"><%=course%></option>
				<%
					}
				%>
			</select>  
			
					 <font color = 'silver'>..........</font> <input type="submit" name="submit" value="SUBMIT" style="width: 115px; color: AntiqueWhite; font-weight: bold; height: 32px; font-size: 14px; background-color: Teal">
		</form>
	</center>
	<br>
	<br>
	<center>
	<%
		int capacity = 0;
		String course = "";
		int studentCount = 0;
		Course obj = (Course) request.getAttribute("courseobj");
		if (obj != null) {
			course = obj.getCourse_name();
			capacity = obj.getCapacity();
			studentCount = new StudentUtilsImpl()
					.getStudentsInACourseCount(course);
			Boolean isApplicable = false;
			if (studentCount < capacity)
				isApplicable = true;
	%>
		<form name="coursedetails" action="registrationpage" method="post">
			<table border=2 align="center" style="width: 638px; height: 235px; background-color: White">
				<tr align="center">
					<td style="width: 289px; "><font color = "teal"><b>Selected Course</b></font>
					<td style="width: 284px; "><input type="text" name="course" size="20"
						style="width: 183px; color: Black; text-align: center" readonly="readonly" value="<%=course%>">
				<tr align="center">
					<td ><font color = "teal"><b>Maximum Capacity</b></font>
					<td><%=capacity%>
				<tr align="center">
					<td ><font color = "teal"><b>Registered Student</b></font>
					<td><%=studentCount%>
			</table><br>
			<%
				if (isApplicable == false) {
			%>
			<font size="3" color="red">Seats full</font><br><br> 
										<input type="submit" name="continue" value="Continue" style="width: 115px; color: AntiqueWhite; font-weight: bold; height: 32px; font-size: 14px; background-color: Teal" disabled="disabled">
			 <br /><font color = "red"> Select other course to check
			availability of seats</font><br><br /> <a href="CounsellorProfile.jsp"><i>Go
					To Previous Page</i></a>
			<%
				} else {
			%>
			<input type="submit" name="continue" value="Continue" style="width: 115px; color: AntiqueWhite; font-weight: bold; height: 32px; font-size: 14px; background-color: Teal">

			<%
				}
			%>
		</form>
	<%
		}
	%>
	</center>
	
	</font>
</body>
</html>