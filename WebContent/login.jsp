<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cashier Login</title>
<style>
.myDiv {
  border: 5px black;
  background-color: lightblue;    
  text-align: center;
}
</style>
</head>
<body>
<div class="myDiv">
  <h1>FinancialTrust BANK</h1>
</div>
<h2>EMPLOYEE LOGIN</h2>
		<form method="post" action="LoginSub">
		<p>USERNAME</p>
		<input type="text" name="uname" placeholder="Enter username" required>
		<p>PASSWORD</p>
		<input type="password" name="pass" placeholder="Enter password" required>
		<br>
		<input type="submit" value="Login">
		</form>
</body>
</html>