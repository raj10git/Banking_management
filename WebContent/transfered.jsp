<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer success</title>
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
<h1>SOURCE AND TARGET ACCOUNT DETAILS AFTER TRANSFER</h1>
<p>CUSTOMER ID :- ${CUSTOMER_ID}</p>
<p>ACCOUNT ID :- ${SACCOUNT_ID}</p>
<p>ACCOUNT TYPE :- ${SACCOUNT_TYPE}</p>
<p>SOURCE ACCOUNT BALANCE BEFORE TRANSFER :- ${with}</p>
<p>SOURCE ACCOUNT LATEST BALANCE :- ${SACCOUNT_BALANCE}</p>
<p>ACCOUNT ID :- ${RACCOUNT_ID}</p>
<p>ACCOUNT TYPE :- ${RACCOUNT_TYPE}</p>
<p>TARGET ACOOUNT BALANCE BEFORE TRANSFER :- ${dep}</p>
<p>TARGET ACCOUNT LATEST BALANCE :- ${RACCOUNT_BALANCE}</p>
<a href="member.jsp">BACK TO GET DETAILS PAGE</a>
</body>
</html>