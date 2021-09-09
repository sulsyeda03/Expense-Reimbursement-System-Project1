<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

    <%@ page import="com.entities.Employee" %>

        <% Employee e1=(Employee)request.getSession().getAttribute("e1"); int emp_id=e1.getEmp_id(); %>


            <div class="row" style="text-align: left;">
                <div class="col">
                </div>
                <div class="col-5">
                </div>
                <div class="col">

                    <div class="nav-item dropdown active">
                        <button class="nav-link dropdown-toggle" href="#" id="navbarDropdown" type="button"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Filter By Status
                        </button>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="ViewManagerServlet?emp_id=<%=emp_id%>">All</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item"
                                href="FilterStatusServlet?status=Pending&&emp_id=<%=emp_id%>">Pending</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item"
                                href="FilterStatusServlet?status=Approved&&emp_id=<%=emp_id%>">Approved</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item"
                                href="FilterStatusServlet?status=Rejected&&emp_id=<%=emp_id%>">Rejected</a>
                        </div>

                    </div>
                    <div>

                    </div>
                </div>
            </div>