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
		
		<div class="card-header my-3"><h2>All Products</h2></div>

		<table class = "w3-table-all" id="lists">
			<thead>
				<tr>
				    <th> Image</th>
					<th> Id</th>	
					<th> Name</th>
					<th> Price</th>
					<th> Quantity</th>
					
					<th><c:if test="${pageContext.request.userPrincipal.name!='harshal' }">
					Add to Cart
                 	</c:if>
					
            	<c:if test="${pageContext.request.userPrincipal.name=='harshal' }">
					Edit/Delete
                 	</c:if>
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${lists}" >
					<tr>
						<td style="width: 171px"><img
							src="<c:url value="${product.imageurl}"/>"
							style="width: 200px; height: 200px; " ${product.name}"  /></td> 
						<td>${product.id}</td>
						<td>${product.name}</td>
						<td>${product.price}</td>
						<td>${product.quantity}</td>
						<td ng-controller="myController">

	  <c:if test="${pageContext.request.userPrincipal.name!='harshal'}">
						<authorize
					
						
								 access="hasRole('ROLE_USER')">
								<a href="collectCustomerInfo/${product.id}/${product.price}"
									class="btn btn-primary" style="margin-left: 5px; background-color: green;"> <span
									class=""></span>ADD TO CART</a>
						
							</authorize></c:if> 
							
							 <authorize
								access="hasRole('ROLE_ADMIN')">
						     <c:if test="${pageContext.request.userPrincipal.name=='harshal' }">
								<a href="admin/editProduct/${product.id}"
									class="btn btn-success" style="margin-left: 5px">EDIT </a>
								
								<a href="admin/delete/${product.id}" class="btn btn-danger"
									style="margin-left: 5px"> DELETE</a>
							</authorize></td>
							</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table> 
		
	</div>
</body>
</html>