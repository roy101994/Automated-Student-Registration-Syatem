package com.project.utils;

import com.project.beans.Student;

public interface StudentUtils {

	public boolean addStudent(Student student);

	public int getStudentsInACourseCount(String course);
	
	public Student searchStudent(String email);
	
	public boolean isStudentDuplicate(Student student);
	
}
