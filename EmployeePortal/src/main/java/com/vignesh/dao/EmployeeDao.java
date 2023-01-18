package com.vignesh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.Session;
import com.vignesh.model.Employee;

import jakarta.servlet.http.HttpSession;

public class EmployeeDao {

	final String url = "jdbc:mysql://localhost:3306/vignesh";
	final String uName = "root";
	final String pd = "0000";
	Connection con;
	PreparedStatement st;
	ResultSet r;

	public boolean loginDao(Employee e) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, uName, pd);
			String query = "Select employee.Username , employee.Password from Employee where Username = ? and Password = ? ";
			st = con.prepareStatement(query);
			st.setString(1, e.getUserName());
			st.setString(2, e.getPassword());
			
			
			r = st.executeQuery();
			return r.next() ? true : false;

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return false;
	}

	public boolean userNameCheck(Employee e) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, uName, pd);
			String query = "Select employee.Username from Employee where employee.Username = ? ";
			st = con.prepareStatement(query);
			st.setString(1, e.getUserName());

			r = st.executeQuery();
			return r.next() ? true : false;

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return false;
	}

	public boolean registerDao(Employee e) {
		int r = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, uName, pd);
			String query = "Insert into employee (First_Name, Last_Name, Username, Password, Date_of_Birth, Email_ID) values (?,?,?,?,?,?) ";
			st = con.prepareStatement(query);
			st.setString(1, e.getFirstName());
			st.setString(2, e.getLastName());
			st.setString(3, e.getUserName());
			st.setString(4, e.getPassword());
			st.setString(5, e.getDob());
			st.setString(6, e.getEmail());

			r = st.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return (r > 0 ? true : false);
	}
	
	public String firstNameDao(HttpSession s) throws SQLException, ClassNotFoundException
	{
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection(url, uName, pd);
	String query = "Select First_Name from Employee where Username = ?";
	st = con.prepareStatement(query);
	st.setString(1, (String)s.getAttribute("userName"));
	r = st.executeQuery();
	r.next();
	return r.getString(1);	
	}
	

	public String lastNameDao(HttpSession s) throws SQLException, ClassNotFoundException
	{
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection(url, uName, pd);
	String query = "Select Last_Name from Employee where Username = ?";
	st = con.prepareStatement(query);
	st.setString(1, (String)s.getAttribute("userName"));
	r = st.executeQuery();
	r.next();
	return r.getString(1);	
	}
	
	public String DobDao(HttpSession s) throws SQLException, ClassNotFoundException
	{
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection(url, uName, pd);
	String query = "Select Date_of_Birth from Employee where Username = ?";
	st = con.prepareStatement(query);
	st.setString(1, (String)s.getAttribute("userName"));
	r = st.executeQuery();
	r.next();
	return r.getString(1);
	}
	public String emailDao(HttpSession s) throws SQLException, ClassNotFoundException
	{
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection(url, uName, pd);
	String query = "Select Email_ID from Employee where Username = ?";
	st = con.prepareStatement(query);
	st.setString(1, (String)s.getAttribute("userName"));
	r = st.executeQuery();
	r.next();
	return r.getString(1);
	}
	}