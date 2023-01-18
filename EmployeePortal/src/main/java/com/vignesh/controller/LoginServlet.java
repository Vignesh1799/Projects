package com.vignesh.controller;

import com.vignesh.dao.EmployeeDao;
import com.vignesh.model.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		Employee e = new Employee();
		EmployeeDao d = new EmployeeDao();
		e.setUserName(req.getParameter("username"));
		e.setPassword(req.getParameter("password"));
		

		try {
			if (d.loginDao(e)) {
				HttpSession s = req.getSession();
				s.setAttribute("userName", e.getUserName());
				s.setAttribute("FirstName", d.firstNameDao(s));
				s.setAttribute("LastName", d.lastNameDao(s));
				s.setAttribute("DOB", d.DobDao(s));
				s.setAttribute("Email", d.emailDao(s));
				
				RequestDispatcher rd = req.getRequestDispatcher("EmployeeLoginHomePage.jsp");
				rd.forward(req, res);
			} else
				res.sendRedirect("LoginError.jsp");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}