package com.ex.general.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.employee.domain.Employee;
import com.ex.employee.service.EmployeeService;
 
@WebServlet(name = "GeneralServlet", urlPatterns = "/")

public class LoginServlet  extends HttpServlet{
	
	private static final EmployeeService empServ = new EmployeeService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String option = req.getParameter("logout");

		if (option != null) {
			req.getSession().invalidate();
			req.setAttribute("message", "Logged out");
			req.getRequestDispatcher("user.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String option = req.getParameter("option");

		RequestDispatcher rd = null;
  
		if (option.equalsIgnoreCase("register")) {
			Employee emp = new Employee();
			emp.setUsername(username);
			emp.setPassword(password);
			if (empServ.registerUser(emp)) {
				req.setAttribute("message", "Success!");
			} else {
				req.setAttribute("message", "Failure! Username might be taken.");
			}
			rd = req.getRequestDispatcher("calc.jsp");

		} else if (option.equalsIgnoreCase("login")) {
			Employee emp = new Employee();
			emp.setUsername(username);
			emp.setPassword(password);
			emp.setAuthenticated(false);
			emp = empServ.authenticateUser(emp);

//			if (emp.getAuthenticated()) {
				rd = req.getRequestDispatcher("calc.jsp");
//				// Create HttpSession object here and add user to it
//				req.getSession().setAttribute("user", user);
//			} else {
//				rd = req.getRequestDispatcher("user.jsp");
//				req.setAttribute("message", "Invalid credentials!");
//			}

		} else {
			rd = req.getRequestDispatcher("user.jsp");
			req.setAttribute("message", "Please select a valid option.");
		}

		rd.forward(req, resp);
	}
	

}
