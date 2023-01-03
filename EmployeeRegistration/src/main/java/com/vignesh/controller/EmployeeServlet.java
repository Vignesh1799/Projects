package com.vignesh.controller;

import java.io.IOException;

import com.vignesh.dao.EmployeeDao;
import com.vignesh.model.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
    public EmployeeServlet() {
        super();
    }

    private EmployeeDao d = new EmployeeDao();
    

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		
		
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/Views/EmployeeRegister.jsp");
		dis.forward(request,response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		String location = request.getParameter("location");
		//String id = request.getParameter("id");
		String contact = request.getParameter("contact");
		String salary = request.getParameter("salary");
		
		Employee e = new Employee();
		//e.setId(id);
		e.setFirstname(firstname);
		e.setLastname(lastname);
		e.setUsername(username);
		e.setPassword(password);
		e.setLocation(location);
		e.setContact(contact);
		e.setSalary(salary);
		
		d.registerEmployee(e);
		
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/Views/EmployeeDetails.jsp");
		dis.forward(request,response);
	}

}