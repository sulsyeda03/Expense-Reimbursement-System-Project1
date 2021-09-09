package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.entities.Employee;
import com.entities.Requests;
import com.factory.ConnectionFactory;
import com.services.EmployeeService;
import com.services.RequestService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewReimbursementServlet")
public class ViewReimbursementServlet extends HttpServlet {
	EmployeeService es1 = new EmployeeService();
	RequestService rs1 = new RequestService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("ViewReimbursementServlet is running.....");
		
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));		
		try {
			List<Requests> list = rs1.getAllTicketsByEmpId(emp_id);
			request.getSession().setAttribute("list", list);	
			Employee e = es1.getEmployee(emp_id);
			request.getSession().setAttribute("e", e);
			if(e.getEmp_role().equals("Associate")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/empView.jsp");
				dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/mngr_viewMyTickets.jsp");
				dispatcher.forward(request, response);
			}
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}

