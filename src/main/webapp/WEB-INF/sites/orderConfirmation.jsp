<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<jsp:useBean id="now" class="java.util.Date" />

<%@ include file="/WEB-INF/sites/navbar.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm</title>
<link rel="stylesheet"
	href="<c:url value="/sources/boots/css/bootstrap.min.css"/>">
<script src="<c:url value="/sources/jsq/jquery.js"/>"></script>
<script src="<c:url value="/sources/boots/jsq/bootstrap.min.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/sources/css/register.css"/>">
		
	</head>
	<body style="padding: 0px;">
		<div class="container-wrapper">
	<div class="container" style="margin-bottom: 19px">
	 <div class="row" style="margin-top: 20px">
     <form:form class="form-horizontal">
		<div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3" style="width: 100%; margin-left: 0%">
		<div style="text-align: center;"><h1>Receipt</h1></div>
		<div class="row">
			<div class="col-xs-6 col-sm-6 col-md-6">
		 
			      Name:  ${cust.name}<br>
			       Phone No. :${cust.phone}
			   
				<br>
			    	<strong>Shipping Address</strong><br />
				Address : ${cust.address} <br />
				City : ${cust.city},<br>
				
				
			</div>
			</div>
					<div>
					<h4><strong>Grand Total: </strong> <strong class="text-danger">$ ${cust.total}</strong></h4>
					</div>
					
		</div>

				
						 <br /> <br />
					
						
						
						<a href="/OnlineMensFashion/thankCustomer" style="margin-left: 200px"
									class="btn btn-lg btn-info"  style="margin-left: 5px"> <span
									></span>Place Order</a>
						
						</div>
				</form:form>
			</div>
		</div>
	</div>
		
	</body>
</html>


