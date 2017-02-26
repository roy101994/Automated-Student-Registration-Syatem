package com.project.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.beans.Student;
import com.project.utils.StudentUtilsImpl;

/**
 * Servlet implementation class StudentRegistrationServlet
 */
@WebServlet("/register")
public class StudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("emailid");
		String first_name = request.getParameter("first_name");
		String middle_name =request.getParameter("middle_name");
		String last_name = request.getParameter("last_name");
		Student student = new Student();
		student.setStudent_first_name(first_name);
		student.setStudent_middle_name(middle_name);
		student.setStudent_last_name(last_name);
		student.setStudent_emailid(email);
		
		if(email.equals("")||first_name.equals("")||last_name.equals(""))
		{
			String course = (String)request.getParameter("course");
			request.setAttribute("course", course);
			request.setAttribute("message", true);
			request.setAttribute("studentobj", student);
			RequestDispatcher dispatcher = request.getRequestDispatcher("StudentRegistrationForm.jsp");
			dispatcher.forward(request, response);
		}
		else if(new StudentUtilsImpl().isStudentDuplicate(student)){
			String course = (String)request.getParameter("course");
			request.setAttribute("course", course);
			request.setAttribute("message2", true);
			request.setAttribute("studentobj", student);
			RequestDispatcher dispatcher = request.getRequestDispatcher("StudentRegistrationForm.jsp");
			dispatcher.forward(request, response);
		}
		else{
			student.setStudent_course(request.getParameter("course"));
			boolean added = new StudentUtilsImpl().addStudent(student);
			if(added)
			{
				Student student2 = new StudentUtilsImpl().searchStudent(email);
				request.setAttribute("name", "Student "+student2.getStudent_first_name());
				request.setAttribute("id",student2.getStudent_id());
				RequestDispatcher dispatcher = request.getRequestDispatcher("ConfirmationMessage.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
