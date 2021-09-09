package com.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.entities.Employee;
import com.entities.Requests;
import com.services.EmployeeService;
import com.services.RequestService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FilterStatusServlet")
public class FilterStatusServlet extends HttpServlet {
	EmployeeService es1 = new EmployeeService();
	RequestService rs1 = new RequestService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("FilterStatusServlet  - doGet is running.....");		
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		String status = request.getParameter("status");
		System.out.println(status);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/new_reimbursement.jsp");
//		dispatcher.forward(request, response);
		
		
		
			List<Requests> list;
			try {
				list = rs1.getAllTicketsByStatus(status,emp_id);
				request.getSession().setAttribute("list", list);	
				Employee e = es1.getEmployee(emp_id);
				request.getSession().setAttribute("e", e);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/mngr_teamTickets.jsp");
				dispatcher.forward(request, response);	
			} catch (SQLException e1) {				
				e1.printStackTrace();
			}
			
	}
}