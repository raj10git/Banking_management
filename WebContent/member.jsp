<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get account details</title>
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
<h2>WELCOME</h2>
<h3>Enter Customer ID AND Account ID to get Account details</h3>
		<form method="post" action="AccountDetails">
		<p>CUSTOMER ID</p>
		<input type="text" name="custid" placeholder="Enter CUSTOMER ID" required>
		<p>ACCOUNT ID</p>
		<input type="text" name="accid" placeholder="Enter ACCOUNT ID" required>
		<p><input type="submit" value="GET DETAILS"></p>
		</form>
</body>
</html>