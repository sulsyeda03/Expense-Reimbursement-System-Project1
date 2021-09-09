package com.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import com.entities.Requests;
import com.services.RequestService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateTicketServlet")
public class UpdateTicketServlet extends HttpServlet {
RequestService rs1 = new RequestService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("UpdateTicketStatus-doGet method is running.....");
		int requestId = Integer.parseInt(request.getParameter("requestId"));
		
		try {
			Requests req = rs1.getTicketsByRequestId(requestId);
			request.getSession().setAttribute("req", req);
			System.out.println("do-Post before update "+req);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update_ticket.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("UpdateTicketStatus-doPost method is running.....");
		System.out.println(request.getParameter("request_id"));			
		int requestId = Integer.parseInt(request.getParameter("request_id"));	
		String status = request.getParameter("status");
		String comment = request.getParameter("comments");
		
		try {
			Requests req1 = rs1.getTicketsByRequestId(requestId);
			req1.setStatus(status);
			req1.setComment(comment);
			req1.setApprovedDate(new Date());
			rs1.updateTicket(req1);
			System.out.println("do-Post Updated "+req1);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/mngr_teamTickets.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e1) {			
			e1.printStackTrace();
		}

		
		
		
	}
}
