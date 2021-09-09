package com.dao;


import java.sql.SQLException;
import java.util.List;

import com.entities.Employee;
import com.entities.Requests;

public interface RequestsDao {
	
	// all the methods are implemented in REquestsDaoImpl
	public void addTicket(Requests request) throws SQLException;
	public void updateTicket(Requests request) throws SQLException;
	public List<Requests> getAllTicketsByEmpId(int emp_id) throws SQLException;
	public List<Requests> getAllTicketsExceptEmpId(int emp_id) throws SQLException;
	public List<Requests> getAllTicketsByStatus(String status,int emp_id) throws SQLException;
	public Requests getTicketsByRequestId(int requestId) throws SQLException;
	
}