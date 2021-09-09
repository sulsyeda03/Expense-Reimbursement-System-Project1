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


public class EmployeeDaoImpl implements EmployeeDao {
	public static ConnectionFactory cf = new ConnectionFactory();
	public static SessionFactory factory = null;
	
	// default constructor
	public EmployeeDaoImpl() {
		super();
		try {
			this.factory = cf.getSessionFactory();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// add employee to employee table 
	@SuppressWarnings("static-access")
	@Override
	public void addEmployee(Employee employee) throws SQLException{
		Session session = cf.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(employee);
		transaction.commit();
		cf.close();	
	}

	// update employee in employee table 
	@Override
	public void updateEmployee(List<Requests> requests , int emp_id) throws SQLException {
		Session session = cf.getSession();
		Transaction transaction = session.beginTransaction();
		String hql = "UPDATE Employee e set requests = :list " + "WHERE e.emp_id = :n";
		Query query = session.createQuery(hql);
		query.setParameter("list", requests);
		query.setParameter("n", emp_id);
		int result = query.executeUpdate();
		List<Requests> list = query.getResultList();		
		System.out.println("Rows affected: " + list);
		
		transaction.commit();
		cf.close();
	}

	// delete employee in employee table 
//	@Override
//	public void deleteEmployee(Employee employee) {
//		Session session = cf.getSession();
//		Transaction transaction = session.beginTransaction();
//		session.delete(employee);
//		transaction.commit();
//		cf.close();
//		
//	}

	// get all employees by role 
//	@Override
//	public List<Employee> getEmployeesByRole(String role) {
//		
//		return null;
//	}

	// get employee details with emp_id
	@Override
	public Employee getEmployeeByEmpId(int emp_id) {
		System.out.println("Inside getEmployeeByEmpId() : "+emp_id);
		//System.out.println("Factory :"+factory);
		Session session = cf.getSession();
		Employee employee = session.get(Employee.class,emp_id);
		System.out.println("getEmployeeByEmpId() : "+employee.toString());
		cf.close();
		return employee;
	}
	
	

}
