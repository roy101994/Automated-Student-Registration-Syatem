package com.project.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.project.beans.Course;
import com.project.utils.CourseUtilsImpl;
import com.project.utils.StudentUtilsImpl;

/**
 * Servlet implementation class UpdateCourseServlet
 */
@WebServlet("/updatecourse")
public class UpdateCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCourseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int new_capacity = 0;
		String message = null;
		String course_name = request.getParameter("course");
		try {
			new_capacity = Integer.parseInt(request
					.getParameter("new_capacity"));
			if (new_capacity < new StudentUtilsImpl()
					.getStudentsInACourseCount(course_name))
				message = "Number of students already registered for the course is larger than capacity. ";
		} catch (NumberFormatException e) {
			message = "Enter positive integral value for capacity";
		}

		if (message != null) {
			Course courseObj = new CourseUtilsImpl().searchCourse(course_name);
			request.setAttribute("message", message);
			request.setAttribute("courseobj", courseObj);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("SearchCourse.jsp");
			dispatcher.forward(request, response);
		} else {
			boolean updated = new CourseUtilsImpl().updateCourse(course_name,
					new_capacity);
			if (updated) {
				Course course = new CourseUtilsImpl().searchCourse(course_name);
				request.setAttribute("courseobj", course);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("UpdateConfirmationMessage.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

}
