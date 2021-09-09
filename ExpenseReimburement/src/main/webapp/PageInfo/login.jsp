<br>
  <div>
    <div style="width: 30%; float: left;">
      <img style="width: 100%;" src="bootstrap/img/logob.png" alt="">
    </div>
    <Section style="width: 70%; margin: auto; text-align: center; float: left;">
      <h1>Welcome to the Mirabilis Expense Reimbursment Portal</h1>
      <h3>Login to access Expense Portal</h3>
      <br>
      <form method="post" action="LoginServlet" style="width: 45%; margin: auto">
        <div class="form-group">
          <label for="emp_id">Employee ID</label>
          <input type="text" class="form-control" id="emp_id" name="emp_id" placeholder="Enter Employee ID">
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" class="form-control" id="password" name="password" style="width: 100%;"
            placeholder="Enter Password">
        </div>
        <button type="submit" class="btn btn-info" style="width: 100%;">Login</button>
      </form>
  </div>