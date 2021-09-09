# Expense Reimbursement System**

**Actors involved in system:**  

- User 
- Associate
- Manager 



`  `**As an user :** 

- A user can register on Expense Reimbursement System Application
- A registered user can log in to system



`   `**As an Associate:** 

- Login
- An Associate can create a new ticket
- View all past tickets 
- View policy 
- Logout



`   `**As a Manager:** 

- Manager will have all functionalities of Associate actor i.e.
- As an Manager: 
  - Can login
  - Can create a new ticket
  - View all past tickets 
  - View policy
  - Logout
- Additionally, Manager can:
  - View tickets of all associates 
  - Use below functionalities on Associate's tickets: 
    - Update status from "Pending" to "Approved"
    - Update status from "Pending" to "Rejected"
    - add comments to already submitted "Associate" tickets
    - Filter tickets based on status : "Pending", "Approved", "Rejected" 



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



Project Link:  

Contributors: "@sulsyeda03" , @CCatlin28 









