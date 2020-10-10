<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer money</title>
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
<h2>ENTER THE CUSTOMER ID, ACCOUNT TYPE AND AMOUNT TO WITHDRAW MONEY.</h2>
		<form method="post" action="TransferMoney">
		<p>CUSTOMER ID</p>
		<input type="text" name="custid" placeholder="Enter CUSTOMER ID" required>
		<p>SOURCE ACCOUNT TYPE</p>
		<input type="text" name="sacctype" placeholder="Enter ACCOUNT TYPE" required>
		<p>TARGET ACCOUNT TYPE</p>
		<input type="text" name="racctype" placeholder="Enter ACCOUNT TYPE" required>
		<p>AMOUNT TO TRANSFER</p>
		<input type="text" name="amt" placeholder="ENTER AMOUNT" required>
		<p><input type="submit" value="TRANSFER MONEY"></p>
		</form>
</body>
</html>