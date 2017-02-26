package com.project.servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.project.beans.Course;
import com.project.utils.CourseUtilsImpl;
import com.project.utils.DateUtils;

/**
 * Servlet implementation class CreateNewCourseServlet
 */
@WebServlet("/newcourse")
public class NewCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewCourseServlet() {
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
		String course_name = request.getParameter("course_name").toUpperCase();
		String start_date = request.getParameter("start_date");
		String end_date = request.getParameter("end_date");
		int capacity = 0;
		String msg = "";
		Course course = new Course();
		course.setCapacity(capacity);
		course.setCourse_name(course_name);
		course.setStart_date(start_date);
		course.setEnd_date(end_date);
		try {
			capacity = Integer.parseInt(request.getParameter("capacity"));
		} catch (NumberFormatException e) {
			msg = msg + "Enter integral value for capacity. ";
		}
		boolean isDuplicate = new CourseUtilsImpl().checkDuplicate(course_name);
		if (isDuplicate) {
			request.setAttribute("message", "The course is already registered");
			request.setAttribute("courseobj", course);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("NewCourseForm.jsp");
			dispatcher.forward(request, response);

		} else {
			if (msg.equals(""))
				if (capacity <= 0)
					msg = msg + "Capacity should be positive. ";
			if (course_name.equals(""))
				msg = msg + "Necessary fields have been left empty. ";
			String message = new DateUtils().checkDates(start_date, end_date);
			if (message != null) {
				msg = msg + message;
			}
			if (!msg.equals("")) {
				request.setAttribute("courseobj", course);
				request.setAttribute("message", msg);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("NewCourseForm.jsp");
				dispatcher.forward(request, response);
			} else {
				course.setCapacity(capacity);
				boolean added = new CourseUtilsImpl().addCourse(course);
				if (added) {
					Course course2 = new CourseUtilsImpl()
							.searchCourse(course_name);
					request.setAttribute("name",
							"Course " + course2.getCourse_name());
					request.setAttribute("id", course2.getCourse_id());
					request.setAttribute("profile", "RegistrarProfile.jsp");
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("ConfirmationMessage.jsp");
					dispatcher.forward(request, response);
				}
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
