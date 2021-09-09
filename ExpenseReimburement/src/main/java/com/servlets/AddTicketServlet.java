package com.servlets;

import java.io.IOException;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.entities.Employee;
import com.entities.Requests;
import com.services.EmployeeService;
import com.services.RequestService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddTicketServlet")
public class AddTicketServlet extends HttpServlet {
RequestService rs1 = new RequestService();
EmployeeService es1 = new EmployeeService();


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	//	System.out.println("AddTicket Servlet- doPost is running.....");
		// parameter list from form : exp_date | category | merchant | amt | memo 
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		String date = request.getParameter("exp_date");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date exp_date = null;
		try {
			exp_date = format.parse(date);
			System.out.println(exp_date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String category = request.getParameter("category");
		String merchant = request.getParameter("merchant");
		double amt = Double.parseDouble(request.getParameter("amt"));
		String memo = request.getParameter("memo");
		
		Employee employee;
		try {
			employee = es1.getEmployee(emp_id);
			Requests req1 = new Requests();
			req1.setEmployee(employee);
			//req1.setEmpId(emp_id);
			req1.setExpenseDate(exp_date);
			req1.setCategory(category);
			req1.setMerchant(merchant);
			req1.setAmount(amt);
			req1.setMemo(memo);
			
			List<Requests> list = new ArrayList<Requests>();
			list.add(req1);
			
			//employee.setRequests(list);
			
				es1.updateEmployee(list,emp_id);
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
			
		
		
			
			
		
		
		
		
			
//		try {
//			rs1.addTicket(req1);
//		} catch (SQLException e) {			
//			e.printStackTrace();
//		}
////		request.getSession().setAttribute("req1", req1);
////		doGet(request,response);
//		Employee employee = new Employee();
//		employee.setEmp_id(emp_id);
		EmployeeDao empDao = new EmployeeDaoImpl();
		Employee e1 = empDao.getEmployeeByEmpId(emp_id);
		String role = e1.getEmp_role();
		
		request.getSession().setAttribute("e1", e1);
		switch(role) {
		
		case "Associate":				
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/RequestConfirm.jsp");
			dispatcher.forward(request, response);	
			break;
		
		case "Manager":
			dispatcher = getServletContext().getRequestDispatcher("/manRequestConfirm.jsp");
            dispatcher.forward(request, response);
			break;			
				
		default:
			dispatcher = getServletContext().getRequestDispatcher("/failLogin.jsp");
			dispatcher.forward(request, response);
	}	
		
		
		
		
		
	}

}
