package com.services;

import java.sql.SQLException;
import java.util.List;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.entities.Employee;
import com.entities.Requests;

public class EmployeeService {

private static EmployeeDao empDao = new EmployeeDaoImpl();
	
	public EmployeeService() { } 
	
	// aunthenticate user 
	public Employee login(int emp_id, String password) {
		System.out.println("Inside EmployeeService - login method..");
		System.out.println("emp_id "+emp_id);
		try {
			Employee e1 = empDao.getEmployeeByEmpId(emp_id);
			if(e1 != null ) {
				System.out.println("checking password...");
				if(e1.getPassword().equals(password)) {
					return e1;
				}else {
					return null;
				}
			}
		}catch (NullPointerException e) {
			System.out.println("Invalid Username");
			e.printStackTrace();				
		}return null;
	}
	
	public void addUser(Employee e) throws SQLException{
		System.out.println("Inside EmployeeService - login method..");
		System.out.println("emp :"+e);
		try {
				empDao.addEmployee(e);
				System.out.println("Employee added successfully");
			
		}catch (NullPointerException ex) {
			System.out.println("Empty fields in register form");
			ex.printStackTrace();				
		}
	}
	
	public void updateEmployee(List<Requests> requests , int emp_id) throws SQLException {
		System.out.println("Inside EmployeeService - updateEmployee method..");
		System.out.println("emp :"+emp_id);
		try {
				empDao.updateEmployee(requests, emp_id);
				System.out.println("Employee updated successfully");
			
		}catch (NullPointerException ex) {
			System.out.println("Error");
			ex.printStackTrace();				
		}
	}
	
	
	
	
	
	
	
	
	public Employee getEmployee(int emp_id) throws SQLException{
		Employee e1 = empDao.getEmployeeByEmpId(emp_id);
		if(e1 != null ) {
		return e1;
		}else return null;
	}
}
