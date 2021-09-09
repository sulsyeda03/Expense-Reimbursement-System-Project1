  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@ page import="com.entities.Employee"%>
<%@ page import="com.entities.Requests"%>

<% 
Employee e1 = (Employee)request.getSession().getAttribute("e1");
String fname = e1.getFirst_name();
String lname= e1.getLast_name();
int emp_id = e1.getEmp_id();

%>  


<jsp:include page="PageInfo/manNav.jsp" />
<%=fname + " " + lname%>
<jsp:include page="PageInfo/headerEnd.jsp" />
<jsp:include page="PageInfo/side.jsp" />
<input type="hidden" name="emp_id"  value="<%=emp_id %>"/>

<% Requests req = (Requests)request.getSession().getAttribute("req");%>
				
		<div style="width: 65%; margin: auto;">
		  <form method="post" action="UpdateTicketServlet">
		    <table style="border-spacing: 10px; border-collapse: separate; background-color: transparent; width: 90%;">
		    	<tr>
		        <td style="text-align: right;">
		          <label for="requst_id">Request Id </label>
		        </td>
		        <td>
		          <input type="text" class="form-control" style="width: 100%;" id="requst_id" name="request_id" value="<%=req.getRequestId() %>" readonly>
		        </td>
		      </tr>
		      <tr>
		        <td style="text-align: right;">
		          <label for="emp_id">Employee Id </label>
		        </td>
		        <td>
		          <input type="text" class="form-control" style="width: 100%;" id="emp_id" name="emp_id" value="<%=emp_id %>" readonly>
		        </td>
		      </tr>
		      <tr>
		        <td style="text-align: right;">
		          <label for="exp_date">Date Expense Occured </label>
		        </td>
		        <td>
		          <input type="date" class="form-control" style="width: 100%;" id="exp_date" name="exp_date" value="<%=req.getExpenseDate() %>" readonly>
		        </td>
                <tr>
                    <td style="text-align: right;">
                      <label for="req_date">Date Ticket Submitted </label>
                    </td>
                    <td>
                      <input type="date" class="form-control" style="width: 100%;" id="req_date" name="req_date" value="<%=req.getRequestedDate() %>" readonly>
                    </td>
		      </tr>
		      <tr>
		        <td style="text-align: right;">
		          <label for="category">Expense Category </label>
		        </td>
		        <td>
		          <select class="form-control" id="category" name="category" style="width: 100%; height:34px;" readonly>
                    <!-- have to use if else for all 4 options -->
                    <%if(req.getCategory().equals("Lodging")){
                    	out.println("<option value='Lodging'selected >Lodging</option>");
                    	out.println("<option value='Travel'>Travel</option>");
                    	out.println("<option value='Food'>Food</option>");
                    	out.println("<option value='Other'>Other</option>");
                    }else if (req.getCategory().equals("Travel")){
                    	out.println("<option value='Lodging' >Lodging</option>");
                    	out.println("<option value='Travel' selected>Travel</option>");
                    	out.println("<option value='Food'>Food</option>");
                    	out.println("<option value='Other'>Other</option>");
                    }else if (req.getCategory().equals("Food")){
                    	out.println("<option value='Lodging' >Lodging</option>");
                    	out.println("<option value='Travel'>Travel</option>");
                    	out.println("<option value='Food' selected>Food</option>");
                    	out.println("<option value='Other'>Other</option>");
                    }else if (req.getCategory().equals("Other")){
                    	out.println("<option value='Lodging' >Lodging</option>");
                    	out.println("<option value='Travel' selected>Travel</option>");
                    	out.println("<option value='Food'>Food</option>");
                    	out.println("<option value='Other'selected>Other</option>");
                    }               	
    		         %>
		          </select>
		        </td>
		      </tr>
		      <tr>
		        <td style="text-align: right;">
		          <label for="merchant">Merchant Name </label>
		        </td>
		        <td>
		          <input type="text" class="form-control" style="width: 100%;" id="merchant" name="merchant" value="<%=req.getMerchant() %>" readonly>
		        </td>
		      </tr>
		      <tr>
		        <td style="text-align: right;">
		          <label for="amt">Reimbursement Amount </label>
		        </td>
		        <td>
		        	<div class="currency-wrap">
		        	<span class="currency-code">$</span>
		        	<input class="text-currency form-control" type="number" id="amt" name="amt" style=" height: 34px; width: 100%;" value="<%=req.getAmount() %>" readonly></div>
		        </td>
		      </tr>
		      <tr>
		        <td style="text-align: right;">
		          <label for="memo">Reimbursement Notes </label>
		        </td>
		        <td>
		        <textarea class="form-control" style="width: 100%; height: 125px;" id="memo" name="memo" readonly><%=req.getMemo() %></textarea>
		        </td>
		      </tr>
		      <tr>
		        <td style="text-align: right;">
		          <label for="status">Ticket Status </label>
		        </td>
		        <td>
		          
		          <%
		          if(req.getStatus().equals("Pending")){
		        	  out.println("<select id='status' name='status' style='width: 100%; height:34px;' required='required'>");
		        	  out.println("<option value='Pending' disabled>Pending</option>");
		        	  out.println("<option value='Approved'>Approved</option>");
		        	  out.println("<option value='Rejected'>Rejected</option>");
		        	  out.println("</select></td></tr><tr>");
		        	  out.println("<td style='text-align: right;''>");
		        	  out.println("<label for='comments'>Comments </label>");
		        	  out.println("</td><td>");
		        	  out.println("<textarea class='form-control' style='width: 100%; height: 125px;' id='comments' name='comments' required='required' ></textarea>");
		        	  out.println("</td></tr><tr><td></td><td>");
	                  out.println("<button type='submit' class='btn btn-info' style='width: 100%;'>Update Ticket</button></td>");	
		          }else {
		        	  if(req.getStatus().equals("Approved")){
			        	  out.println("<select disabled id='status' name='status' style='width: 100%; height:34px;' required='required'>");
			        	  out.println("<option value='Pending' >Pending</option>");
			        	  out.println("<option value='Approved' selected>Approved</option>");
			        	  out.println("<option value='Rejected'>Rejected</option>"); 
			          }else{
			        	  out.println("<select disabled id='status' name='status' style='width: 100%; height:34px;' required='required'>");
			        	  out.println("<option value='Pending' >Pending</option>");
			        	  out.println("<option value='Approved'>Approved</option>");
			        	  out.println("<option value='Rejected' selected>Rejected</option>");
			          }	
		        	  out.println("</select></td></tr><tr>");
		        	  out.println("<td style='text-align: right;''>");
		        	  out.println("<label for='comments'>Comments </label>");
		        	  out.println("</td><td>");
		        	  out.println("<textarea class='form-control' style='width: 100%; height: 125px;' id='comments' name='comments' readonly >"+req.getComment()+"</textarea>");
		        	  out.println("</td></tr><tr><td></td><td>");
	                  out.println("<button disabled type='submit' class='btn btn-info' style='width: 100%;'>Update Ticket</button></td>");		        
		          }
		        	    
		          %>		            
		          
		        </td>
		      </tr>
		    </table>
		  </form>
		</div>
		
		</div>