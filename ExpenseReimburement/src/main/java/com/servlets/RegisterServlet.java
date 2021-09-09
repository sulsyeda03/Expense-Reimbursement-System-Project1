package com.servlets;

import java.io.IOException;
import java.sql.SQLException;

import com.entities.Employee;
import com.factory.ConnectionFactory;
import com.services.EmployeeService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	ConnectionFactory cf = new ConnectionFactory();
	EmployeeService es1 = new EmployeeService();
	RequestDispatcher rd;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("RegisterServlet is running.....");
		
		// get parameter values from register.html 
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		String first_name = request.getParameter("firstName");
		String last_name = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cnfrmpwd = request.getParameter("cpassword");
		
		// setting the values from register form into object employee
		Employee employee = new Employee();
		employee.setEmp_id(emp_id);
		employee.setFirst_name(first_name);
		employee.setLast_name(last_name);
		employee.setEmail(email);
		employee.setPassword(password);
		
		if(password.equals(cnfrmpwd)) {
			try {
				es1.addUser(employee);
				request.getSession().setAttribute("employee", employee);
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}						
		}else {
			rd = request.getRequestDispatcher("/login_invalid.jsp");
			rd.forward(request, response);
		}
	}
}