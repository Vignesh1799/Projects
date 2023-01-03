package com.vignesh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.vignesh.model.Employee;

public class EmployeeDao {
	
	String url = "jdbc:mysql://localhost : 3306/vignesh";
	String uname = "root";
	String pd = "0000";
	
	public int registerEmployee(Employee e)
	{
		int result = 0;
		try{String query = "Insert into employee (first_Name,Last_Name,username,password,location,contact,salary)values (?,?,?,?,?,?,?)";
	
		Connection con = DriverManager.getConnection(url,uname,pd);
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, e.getFirstname());
		st.setString(2, e.getLastname());
		st.setString(3, e.getUsername());
		st.setString(4, e.getPassword());
		st.setString(5, e.getLocation());
		st.setString(6, e.getContact());
		st.setString(7, e.getSalary());
		result = st.executeUpdate();
		con.close();
		st.close();
		}
		catch(Exception ex) {System.out.println(ex);}
	return result;
	}

}