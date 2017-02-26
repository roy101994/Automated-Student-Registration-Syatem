package com.project.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.project.db.DBUtils;
import com.project.beans.Course;

public class CourseUtilsImpl implements CourseUtils {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	Statement st = null;

	@Override
	public boolean addCourse(Course course) {
		// TODO Auto-generated method stub
		boolean isCourseAdded = false;
		conn = DBUtils.connectToDb();
		String query = "insert into course (course_name,start_date,end_date,capacity) values (?,?,?,?);";
		pst = DBUtils.getPreparedStatement(conn, query);
		int rows = 0;
		try {
			pst.setString(1, course.getCourse_name());
			pst.setString(2, course.getStart_date());
			pst.setString(3, course.getEnd_date());
			pst.setInt(4, course.getCapacity());

			rows = pst.executeUpdate();
			DBUtils.closeConnections();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rows > 0)
			isCourseAdded = true;

		return isCourseAdded;
	}

	@Override
	public Course searchCourse(String course_name) {
		// TODO Auto-generated method stub
		conn = DBUtils.connectToDb();
		String query = "select * from course where course_name = ?;";
		pst = DBUtils.getPreparedStatement(conn, query);
		Course course = null;
		try {
			pst.setString(1, course_name);
			rs = pst.executeQuery();
			if (rs != null)
				if (rs.next()) {
					course = new Course();
					course.setCourse_id(rs.getInt(1));
					course.setCourse_name(rs.getString(2));
					course.setStart_date(rs.getString(3));
					course.setEnd_date(rs.getString(4));
					course.setCapacity(rs.getInt(5));
				}
			DBUtils.closeConnections();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return course;
	}

	@Override
	public boolean updateCourse(String course_name, int new_capacity) {
		// TODO Auto-generated method stub
		boolean isCourseUpdated = false;

		conn = DBUtils.connectToDb();
		String query = "update course set capacity = ? where course_name = ?";
		pst = DBUtils.getPreparedStatement(conn, query);
		int rows = 0;
		try {
			pst.setInt(1, new_capacity);
			pst.setString(2, course_name);
			rows = pst.executeUpdate();
			DBUtils.closeConnections();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rows > 0)
			isCourseUpdated = true;

		return isCourseUpdated;

	}

	@Override
	public List<String> getNameOfCourses() {
		// TODO Auto-generated method stub
		conn = DBUtils.connectToDb();
		String query = "select course_name from course;";
		st = DBUtils.getStatement(conn);
		List<String> list = null;
		try {

			rs = st.executeQuery(query);
			if (rs != null) {
				list = new ArrayList<String>();
				while (rs.next())
					list.add(rs.getString(1));
			}
			DBUtils.closeConnections();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean checkDuplicate(String course_name) {
		// TODO Auto-generated method stub
		boolean isDuplicate = false;
		conn = DBUtils.connectToDb();
		String query = "select course_name from course where course_name= ?;";
		pst = DBUtils.getPreparedStatement(conn, query);
		try {
			pst.setString(1, course_name);
			rs = pst.executeQuery();
			if (rs.next())
				isDuplicate = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtils.closeConnections();
		return isDuplicate;
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		List<Course> list = null;
		conn = DBUtils.connectToDb();
		Course course = null;
		String query = "select * from course;";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			if(rs!=null)
			{
				list = new ArrayList<Course>();
				while(rs.next())
				{
					course = new Course();
					course.setCourse_id(Integer.parseInt(rs.getString(1)));
					course.setCourse_name(rs.getString(2));
					course.setStart_date(rs.getString(3));
					course.setEnd_date(rs.getString(4));
					course.setCapacity(Integer.parseInt(rs.getString(5)));
					list.add(course);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
