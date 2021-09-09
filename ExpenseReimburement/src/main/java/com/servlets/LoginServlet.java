package com.servlets;

import java.io.IOException;

import com.entities.Employee;
import com.factory.ConnectionFactory;
import com.services.EmployeeService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	ConnectionFactory cf = new ConnectionFactory();
	EmployeeService es1 = new EmployeeService();
	RequestDispatcher rd;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		String password = request.getParameter("password");	
		
		Employee employee = new Employee();
		employee.setEmp_id(emp_id);
		employee.setPassword(password);	
		
		Employee e1 = es1.login(emp_id, password);		
		if( e1!= null ) {
			String role = e1.getEmp_role();
			
			request.getSession().setAttribute("e1", e1);
			switch(role) {
			
			case "Associate":				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/assoc_dashboard.jsp");
				dispatcher.forward(request, response);					
				break;
			
			case "Manager":
				dispatcher = getServletContext().getRequestDispatcher("/man_dashboard.jsp");
                dispatcher.forward(request, response);
				break;			
			}		
		}else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/failLogin.jsp");
            dispatcher.forward(request, response);
		}	
		
		
	}


}
