  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@ page import="com.entities.Employee"%>

<% 
Employee e1 = (Employee)request.getSession().getAttribute("e1");
String fname = e1.getFirst_name();
String lname= e1.getLast_name();
int emp_id = e1.getEmp_id();

%>

<jsp:include page="topPage.jsp" />
<jsp:include page="Nav1.jsp" />

        <a class="nav-link" href="assoc_newReq.jsp">New Reimbursement</a>

        <jsp:include page="Nav2.jsp" />

        <a class="nav-link" href="ViewReimbursementServlet?emp_id=<%=emp_id%>">View Reimbursement</a>
        <input type="hidden" name="emp_id" id="emp_id" value="<%=emp_id %>"/>
       
    
        <jsp:include page="Nav2.jsp" />

        <a class="nav-link" href="assoc_policy.jsp">View Policy</a>
    
        <jsp:include page="Nav3.jsp" />