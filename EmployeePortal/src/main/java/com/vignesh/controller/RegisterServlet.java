package com.vignesh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.vignesh.dao.EmployeeDao;
import com.vignesh.model.Employee;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Employee e = new Employee();
		e.setUserName(req.getParameter("username"));

		EmployeeDao d = new EmployeeDao();
		System.out.println(req.getParameter("password"));
		System.out.println(req.getParameter("password1"));
		
		String p1 = req.getParameter("password");
		String p2 = req.getParameter("password1");
		if (!d.userNameCheck(e)) {
			if (p1.equals(p2)) {
				System.out.println("entered");
				e.setFirstName(req.getParameter("firstname"));
				e.setLastName(req.getParameter("lastname"));
				e.setEmail(req.getParameter("email"));
				e.setPassword(req.getParameter("password1"));
				e.setDob(req.getParameter("dob"));
				System.out.println(e.getDob());
				if (d.registerDao(e))
					res.sendRedirect("SuccessRegister.jsp");
			} else {
				PrintWriter out = res.getWriter();
				out.write("\n");
				out.write("\n");
				out.write("\n");
				out.write(" <h1> <center> Password doesn't Match... <h1> </center> ");
				out.write("\n");
				out.write("\n");
				out.write("\n");
				out.write("<form action = \"login.jsp\" method = \"post\">\r\n"
						+ "<center><p> <b> Try to login by entering same password : </b> </p><input type=\"submit\" Value=\"Sign Up\" />\r\n"
						+ "		</center>");
			}
		} else {
			PrintWriter out = res.getWriter();

			out.write("\n");
			out.write("\n");
			out.write("\n");
			out.write(" <h1> <center> UserName Already Exists... <h1> </center> ");
			out.write("\n");
			out.write("\n");
			out.write("\n");
			out.write("<form action = \"login.jsp\" method = \"post\">\r\n"
					+ "<center><p> <b> Try to login with different Username : </b> </p><input type=\"submit\" value=\"Sign Up\" />\r\n"
					+ "		</center>");

		}
	}
}
