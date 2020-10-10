<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.format{
	text-decoration:none;
	padding:10px;
	border:2px black solid;
	background:bisque;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Details</title>
</head>
<body>
<h1>ACCOUNT DETAILS</h1>
<p>CUSTOMER ID :- ${CUSTOMER_ID}</p>
<p>ACCOUNT ID :- ${ACCOUNT_ID}</p>
<p>ACCOUNT TYPE :- ${ACCOUNT_TYPE}</p>
<p>ACCOUNT BALANCE :- ${ACCOUNT_BALANCE}</p><br>
<span><a class="format" href="deposit.jsp">DEPOSIT MONEY</a> &nbsp; <a class="format" href="withdraw.jsp">WITHDRAW MONEY</a>
		 &nbsp; <a class="format" href="transfer.jsp">TRANSFER MONEY</a></span>
</body>
</html>