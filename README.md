# Expense Reimbursement System**

**Actors involved in system:**  

- User 
- Associate
- Manager 



`  `**As an user :** 

- A user can register on Expense Reimbursement System Application
- A registered user can log in to system



`   `**As an Associate:** 

- an Associate can create a new ticket
- View all past tickets 
- View policy 



`   `**As a Manager:** 

- Manager will have all functionalities of Associate actor i.e.
- As an Manager: 
  - An Associate can create a new ticket
  - View all past tickets 
  - View policy
- Additionally, Manager can:
- Manager can view tickets of all associates 
- Manager can Update status from "Pending" to "Approved"
- Manager can Update status from "Pending" to "Rejected"
- Manager can add comments to already submitted "Associate" tickets





`  `**By default,** 

- All the tickets created are: 
- In status - "Pending"
- It records automatically , when the ticket was created
- It records automatically , when the ticket was "Approved" or "Rejected" by Manager 
- No action can be taken on already "Approved" or "Rejected" tickets

__Techstack for Expense Reimbursement System(Project 1):__ 

  Techstack  | Technologies/Tools Used
------------ | -------------
Project Design | DAO Design Pattern 
Backend | JAVA, JavaScript 
Middle tier | Servlets
Back-End connected to Database using | Hibernate
Web-Container | Deployed onto Tomcat10 Server
Database | MYSQL hosted on AWS RDS
Frontend | HTML, CSS, Bootstrap 
Testing | JUnit
Logging framework | Log4J 










