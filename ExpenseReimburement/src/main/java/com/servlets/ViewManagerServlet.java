package com.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.entities.Requests;
import com.services.RequestService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewManagerServlet")
public class ViewManagerServlet extends HttpServlet {
	RequestService rs1 = new RequestService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("ViewManagerServlet is running.....");
		
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));		
		try {
			List<Requests> list = rs1.getAllTicketsExceptEmpId(emp_id);
			System.out.println("view all tickets except emp_id "+list);
			request.getSession().setAttribute("list", list);			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/mngr_teamTickets.jsp");
			dispatcher.forward(request, response);
			}catch (SQLException e) {
			e.printStackTrace();
			}
	}
	
}
		
