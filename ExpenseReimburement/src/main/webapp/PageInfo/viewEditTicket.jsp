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
                <td>Approved Date</td>
                <td>Status</td>
                <td>Comment</td>
                <th>EDIT </th>
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
              out.print("<td>"+req.getApprovedDate()+"</td>");
              out.print("<td>"+req.getStatus()+"</td>");
              out.print("<td>"+req.getComment()+"</td>");
              out.print("<td>"+"<a method='get' href='UpdateTicketServlet?requestId="+req.getRequestId()+"'> EDIT </a>"+"</td>");	
              out.print("</tr>");
            }				
              %>     
    </tbody>
</table>
</div>
</div>