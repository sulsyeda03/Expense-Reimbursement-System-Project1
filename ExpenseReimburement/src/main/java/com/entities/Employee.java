package com.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

//creating table for reistering employee on expense 
//reimbursement application 
@Entity
@Table(name="employee")
public class Employee {

	@Id 
	@Column (length=6)
	private int emp_id;
	
	@Column 
	private String emp_role;
	
	@Column(name="firstName", length=50)
	private String first_name;
	
	@Column(name="lastName", length=50)
	private String last_name;
	
	@Column(length=20)
	private String password;
	
	@Column(length=100, unique=true)
	private String email;
	
	@OneToMany
	private List<Requests> requests;
	
	// default constructor
	public Employee() {
		super();
	}

	public Employee(int emp_id, String emp_role, String first_name, String last_name, String password, String email,
			List<Requests> requests) {
		super();
		this.emp_id = emp_id;
		this.emp_role = emp_role;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.email = email;
		this.requests = requests;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_role() {
		return emp_role;
	}

	public void setEmp_role(String emp_role) {
		this.emp_role = emp_role;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Requests> getRequests() {
		return requests;
	}

	public void setRequests(List<Requests> requests) {
		this.requests = requests;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_role=" + emp_role + ", first_name=" + first_name + ", last_name="
				+ last_name + ", password=" + password + ", email=" + email + ", requests=" + requests + "]";
	}

	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	