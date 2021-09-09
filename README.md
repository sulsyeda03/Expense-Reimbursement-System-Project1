# Expense Reimbursement System

Project is entirely deployed on EC2 Instance: [Click here](http://3.143.82.88:8080/ExpenseReimburement/home.html)

[Project Link](https://github.com/sulsyeda03/Expense-Reimbursement-System-Project1)

Contributors: [sulsyeda03](https://github.com/sulsyeda03) , [CCatlin28](https://github.com/CCatlin28)

IDE used: Eclipse 

![Project Stucture](https://user-images.githubusercontent.com/85700911/132738776-0bd2190d-5e88-4353-9d99-e1b064203681.png)


**Actors involved in system:**  

- User 
- Associate
- Manager 



`  `**As an user :** 

- A user can register on Expense Reimbursement System Application
- A registered user can log in to system



`   `**As an Associate, I can perform below functionalities:** 

- Login
- Create a new ticket
- View all past tickets 
- View policy 
- Logout



`   `**As a Manager, I can perform below functionalities:** 

- Manager will have all functionalities of Associate actor i.e.
- A Manager can: 
  - Login
  - Create a new ticket
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

_____________________________________________________________________________________________


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













