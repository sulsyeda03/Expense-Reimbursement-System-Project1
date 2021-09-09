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

<a class="nav-link" href="man_newReq.jsp">New Reimbursement</a>

</li>

<li class="nav-item dropdown active">
    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
      View Tickets
    </a>
    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
      <a class="dropdown-item" href="ViewReimbursementServlet?emp_id=<%=emp_id%>">View My Tickets</a>
      <div class="dropdown-divider"></div>
      <a class="dropdown-item" href="ViewManagerServlet?emp_id=<%=emp_id%>">View Team Tickets</a>
    </div>
  </li>
      
          <jsp:include page="Nav2.jsp" />

          <a class="nav-link" href="man_policy.jsp">View Policy</a>
          
          <jsp:include page="Nav3.jsp" />