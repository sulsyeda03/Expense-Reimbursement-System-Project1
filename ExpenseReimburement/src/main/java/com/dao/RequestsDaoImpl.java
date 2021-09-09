package com.dao;


import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entities.Employee;
import com.entities.Requests;
import com.factory.ConnectionFactory;

public class RequestsDaoImpl implements RequestsDao{
	public static ConnectionFactory cf = new ConnectionFactory();
	public static SessionFactory factory = null;
	
	@SuppressWarnings("static-access")
	public RequestsDaoImpl() {
		super();
		try {
			this.factory = cf.getSessionFactory();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void addTicket(Requests request) throws SQLException {
		Session session = cf.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(request);
		transaction.commit();
		cf.close();		
	}
	
	public void updateTicket(Requests request) throws SQLException{
		Session session = cf.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(request);
		System.out.println("After update, commit "+request);
		transaction.commit();
		cf.close();
	}

	@Override
	public List<Requests> getAllTicketsByEmpId(int emp_id) throws SQLException {
		System.out.println("Inside getTicketsByEmpId() - Requests");
		Session session = cf.getSession();
		// HQl 
		String hql = "from Requests req where emp_id= :n";
		Query query = session.createQuery(hql);
		query.setParameter("n", emp_id);
		List<Requests> result = query.getResultList();
		System.out.println("printing list result " +result);
		cf.close();
		return result;
	}

	@Override
	public Requests getTicketsByRequestId(int requestId) throws SQLException {
		System.out.println("Inside getAllTicketsByRequestId() - Requests "+requestId);
		Session session = cf.getSession();
		Requests result = session.get(Requests.class,requestId);
		System.out.println("printing list result "+result);
		cf.close();		
		return result;
	}
	
	@SuppressWarnings("static-access")
	@Override
	public List<Requests> getAllTicketsExceptEmpId(int emp_id) throws SQLException{
		System.out.println("Inside getAllTickets()- Requests "+emp_id);
		Session session = cf.getSession();
		// HQl query , retrieving all tickets except for emp_id
		String hql = "from Requests req where emp_id <> :e";
		Query query = session.createQuery(hql);
		query.setParameter("e", emp_id);
		List<Requests> result = query.getResultList();		
		System.out.println("printing list result "+result);
		cf.close();		
		return result;
	}
	
	public List<Requests> getAllTicketsByStatus(String status,int emp_id) throws SQLException {
		System.out.println("Inside getAllTicketsByStatus()- Requests "+status+"|"+emp_id);
		Session session = cf.getSession();
		// HQl query , retrieving all tickets by status except for emp_id
		String hql = "from Requests req where status =: s and emp_id <> :e";
		Query query = session.createQuery(hql);
		query.setParameter("s", status);
		query.setParameter("e", emp_id);
		List<Requests> result = query.getResultList();		
		System.out.println("printing list result "+result);
		cf.close();		
		return result;
	}

	
	}
		
			
			

