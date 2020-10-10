<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deposit success</title>
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
<p>Transaction success!!</p>
<h1>ACCOUNT DETAILS AFTER DEPOSIT</h1>
<p>CUSTOMER ID :- ${CUSTOMER_ID}</p>
<p>ACCOUNT ID :- ${ACCOUNT_ID}</p>
<p>ACCOUNT TYPE :- ${ACCOUNT_TYPE}</p>
<p>BALANCE BEFORE DEPOSIT :- ${dep}</p>
<p>LATEST BALANCE :- ${ACCOUNT_BALANCE}</p>
<a href="member.jsp">BACK TO GET DETAILS PAGE</a>
</body>
</html>