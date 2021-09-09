<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@ page import="com.entities.Employee"%>
<%@ page import="com.entities.Requests"%>
<%@ page import="java.util.List"%>

<% 
Employee e1 = (Employee)request.getSession().getAttribute("e1");
String fname = e1.getFirst_name();
String lname= e1.getLast_name();
int emp_id = e1.getEmp_id();

%>  


<div class="table-assoc">

    <div style="width: 90%; margin: auto; text-align: center;">

<table class="table table-striped table-bordered">
    <thead>
        
            <tr>
                <td>Request ID</td>
                <td>Expense Date</td>
                <td>Request Date</td>
                <td>Category</td>
                <td>Merchant Name</td>
                <td>Amount</td>
                <td>Memo</td>

            </tr>
        
    </thead>
    <tbody>
        
        <% List<Requests> list = (List<Requests>)request.getSession().getAttribute("list");
            for(Requests req:list){
                out.print("<tr>");
                out.print("<td>"+req.getRequestId()+"</td>");
              out.print("<td>"+req.getExpenseDate()+"</td>");
              out.print("<td>"+req.getRequestedDate()+"</td>");
              out.print("<td>"+req.getCategory()+"</td>");
              out.print("<td>"+req.getMerchant()+"</td>");
              out.print("<td>"+req.getAmount()+"</td>");
              out.print("<td>"+req.getMemo()+"</td>");

            }				
              %>     
    </tbody>
</table>
</div>
</div>