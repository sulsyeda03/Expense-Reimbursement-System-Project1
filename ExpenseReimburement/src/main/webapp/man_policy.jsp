  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@ page import="com.entities.Employee"%>

<% 
Employee e1 = (Employee)request.getSession().getAttribute("e1");
String fname = e1.getFirst_name();
String lname= e1.getLast_name();
int emp_id = e1.getEmp_id();

%>  

<jsp:include page="PageInfo/topPage.jsp" />
<jsp:include page="PageInfo/manNav.jsp" />

<%=fname + " " + lname%>
<jsp:include page="PageInfo/headerEnd.jsp" />
<jsp:include page="PageInfo/side.jsp" />
<input type="hidden" name="emp_id"  value="<%=emp_id %>"/>

<jsp:include page="PageInfo/policy.jsp" />

<jsp:include page="PageInfo/bottomPage.jsp" />