<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!-- 	navigation Bar -->
<%@ include file="navbar.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products </title>

<link rel="stylesheet"
	href="<c:url value="../sources/boots/css/bootstrap.min.css"/>">
<script src="<c:url value="../sources/jsq/jquery.js"/>"></script>
<script src="<c:url value="../sources/boots/jsq/bootstrap.min.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="../sources/css/ProductList.css"/>">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="<c:url value="../sources/jsq/productController.js"/>"></script>
</head>

<body>

		<div class="container">
		
		<div class="card-header my-3"><h2>ORDER DETAILS</h2></div>

		<table class = "w3-table-all" id="lists">
			<thead>
				<tr>
				    <th>Name </th>
					<th> OrderId</th>	
					<th> Address</th>
					<th> City</th>
					
					</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${lists}" >
					<tr>
						
						<td>${product.name}</td>
						<td>${product.id}</td>
						<td>${product.address}</td>
						<td>${product.city}</td>
						
	
					</tr>
				</c:forEach>
			</tbody>
		</table> 
		
	</div>
</body>
</html>