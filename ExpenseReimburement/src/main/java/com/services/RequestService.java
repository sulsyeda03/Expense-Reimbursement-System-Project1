package com.services;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.dao.RequestsDao;
import com.dao.RequestsDaoImpl;
import com.entities.Employee;
import com.entities.Requests;

public class RequestService {
	private static RequestsDao reqDao = new RequestsDaoImpl();
	
	public RequestService() { } 

	public void addTicket(Requests request) throws SQLException {
		try {
			reqDao.addTicket(request);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void updateTicket(Requests request) throws SQLException {
		try {
			reqDao.updateTicket(request);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public List<Requests> getAllTicketsByEmpId(int emp_id) throws SQLException {
		System.out.println("RequestService - viewRequests() is running.....");
		List<Requests> list = reqDao.getAllTicketsByEmpId(emp_id);	
		System.out.println("viewTicketsByEmpId-RequestService"+list);
		return list;
	}
	
	public List<Requests> getAllTicketsExceptEmpId(int emp_id) throws SQLException {
		System.out.println("RequestService - getAllTicketsExceptEmpId is running.....");
		List<Requests> list = reqDao.getAllTicketsExceptEmpId(emp_id);	
		System.out.println("getAllTicketsExceptEmpId-RequestService"+list);
		return list;
	}
	
	public Requests getTicketsByRequestId(int requestId) throws SQLException {
		System.out.println("RequestService - getAllTicketsByRequestId is running.....");
		Requests list = reqDao.getTicketsByRequestId(requestId);	
		System.out.println("getAllTicketsByRequestId-RequestService"+list);
		return list;
	}
	
	public List<Requests> getAllTicketsByStatus(String status,int emp_id) throws SQLException {
		System.out.println("RequestService - getAllTicketsByStatus is running.....");
		List<Requests> list = reqDao.getAllTicketsByStatus(status, emp_id);	
		System.out.println("getAllTicketsByStatus-RequestService"+list);
		return list;
	}
	
	
}