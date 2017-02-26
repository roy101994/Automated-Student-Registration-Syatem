package com.project.servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.project.utils.*;

@WebServlet("/changepassword")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePasswordServlet() {
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

		String emailId = request.getParameter("email");
		String password = request.getParameter("pswd");
		String newPassword = request.getParameter("nwpswd");
		String confirmPassword = request.getParameter("cnfrmnwpswd");

		MemberUtils member_util = new MemberUtilsImpl();

		if (newPassword.length() > 5 && newPassword.length() < 11) {
			if (newPassword.equals(confirmPassword)) {
				if (member_util.changePassword(emailId, password, newPassword)) {
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("PasswordChangeConfirmation.jsp");
					dispatcher.forward(request, response);
				} else {
					request.setAttribute("message",
							"Invalid emailId or password.");
					request.setAttribute("Status", false);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("ChangePassword.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				request.setAttribute("message",
						"Confirmation password does not match new password.");
				request.setAttribute("Status", false);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("ChangePassword.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			request.setAttribute("message",
					"Password length should be 6 to 10 character long.");
			request.setAttribute("Status", false);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("ChangePassword.jsp");
			dispatcher.forward(request, response);
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