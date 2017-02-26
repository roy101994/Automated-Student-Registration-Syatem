package com.project.utils;

import java.util.List;

import com.project.beans.Course;

public interface CourseUtils {

	public boolean addCourse(Course course);

	public Course searchCourse(String course_name);

	public boolean updateCourse(String course_name,int new_capacity);
	
	public List<String> getNameOfCourses();
	
	public List<Course> getAllCourses();
	
	public boolean checkDuplicate(String course_name);

}
