package com.project.utils;

import java.sql.*;

import com.project.db.DBUtils;
import com.project.beans.Student;

public class StudentUtilsImpl implements StudentUtils {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		boolean isStudentAdded = false;
		conn = DBUtils.connectToDb();
		String query = "insert into student (student_first_name,student_middle_name,student_last_name,student_emailid,student_course) values (?,?,?,?,?);";
		pst = DBUtils.getPreparedStatement(conn, query);
		int rows = 0;
		try {
			pst.setString(1, student.getStudent_first_name().toUpperCase());
			pst.setString(2, student.getStudent_middle_name().toUpperCase());
			pst.setString(3, student.getStudent_last_name().toUpperCase());
			pst.setString(4, student.getStudent_emailid());
			pst.setString(5, student.getStudent_course());

			rows = pst.executeUpdate();
			DBUtils.closeConnections();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rows > 0)
			isStudentAdded = true;

		return isStudentAdded;
	}

	@Override
	public int getStudentsInACourseCount(String course) {
		// TODO Auto-generated method stub
		conn = DBUtils.connectToDb();
		String query = "select count(*) from student where student_course = ?;";
		pst = DBUtils.getPreparedStatement(conn, query);
		int rows = 0;
		try {
			pst.setString(1, course);
			rs = pst.executeQuery();
			if (rs.next())
				rows = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtils.closeConnections();
		return rows;
	}

	@Override
	public Student searchStudent(String email) {
		// TODO Auto-generated method stub
		Student student = null;
		conn = DBUtils.connectToDb();
		String query = "select student_id, student_first_name from student where student_emailid = ?;";
		pst = DBUtils.getPreparedStatement(conn, query);
		try {

			pst.setString(1, email);
			rs = pst.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					student = new Student();
					student.setStudent_id(rs.getInt(1));
					student.setStudent_first_name(rs.getString(2));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtils.closeConnections();
		return student;
	}

	@Override
	public boolean isStudentDuplicate(Student student) {
		// TODO Auto-generated method stub
		boolean isStudentDuplicate = false;
		conn = DBUtils.connectToDb();
		String query = "select * from student where student_emailid=?;";
		pst = DBUtils.getPreparedStatement(conn, query);
		try {
			pst.setString(1, student.getStudent_emailid());
			rs = pst.executeQuery();
			if (rs != null)
				if (rs.next())
					isStudentDuplicate = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isStudentDuplicate;
	}
}
