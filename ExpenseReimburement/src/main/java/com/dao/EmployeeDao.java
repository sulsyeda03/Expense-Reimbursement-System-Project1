package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.entities.Employee;
import com.entities.Requests;

public interface EmployeeDao {
	
    // all the methods are implemented in EmployeeDaoImpl

	public void addEmployee(Employee emp) throws SQLException;
	public void updateEmployee(List<Requests> requests, int emp_id) throws SQLException;
	//public void deleteEmployee(Employee emp);
	// public List<Employee> getEmployeesByRole(String role);
	public Employee getEmployeeByEmpId(int emp_id);
	
	
	
}
