<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="<c:url value="/sources/jsq/productController.js"/>"></script>
</head>
<body>
	<%@ include file="navbar.jsp"%>

	<div class="container"
		style="width: 1145px; margin-top: 20px; margin-bottom: 180px;">
		<div ng-app="myapp" ng-controller="myController"
			style="margin-bottom: 30px">
			
				 
					
				</div>
				<table class="table table-hover" id="productList">
				<div>
				<br> List of Products Purchased
				<div>
					<a href="/OnlineMensFashion/cart/removeAllItems"class="btn btn-danger pull-left"
						style="margin-top: 15px; margin-left: 20px">
						 <span
						class="glyphicon glyphicon-remove-sign"> </span>Clear Cart
					</a>
				</div>
				<div>
				<c:forEach var="product" items="${lists}" >
				<a href="/OnlineMensFashion/orderConfirmation/${product.id}" class="btn btn-danger pull-left"
						style="margin-top: 15px; margin-left: 20px"> <span
						class="glyphicon glyphicon-shipping-cart"> </span>Check Out
					</a>
					<thead>
					
						<tr>
						    <th>Product Image</th>
							<th>Product ID</th>
							<th>Name</th>
							<th>Price</th>
							<th>Remove Item</th>
							
						</tr>
					</thead>
					<tbody>
					
						   <td style="width: 171px"><img
							src="<c:url value="${product.imageurl}"/>"
							style="width: 100px; height: 90px;" ${product.name}"  /></td> 
							<td>${product.id}</td>
							<td>${product.name}</td>
							<td>${product.price}</td>
							<td><a href="/OnlineMensFashion/cart/removeCartItems/${product.id}" class="btn btn-danger"
								style="margin-top: 0px;"><span
									class="glyphicon glyphicon-trash"></span>remove</a></td>
				
									</c:forEach>
					<br>
					</tbody>
					<c:if test="${lists!= null }">
					<th>Total Price</th>
					<c:out value="${inCount}"/>
		        	${inCount+=product.price}
			
			          Grand Total Price: ${inCount}
				</table>
				
				
			</div>
			</c:if>
			
			
			<c:url value="/productList" var="url"></c:url>
			<a href="${url}" class="btn btn-default" style="margin-left: 20px">Continue
				Shopping</a>
		</div>
	</div>
	
	
</body>
</html>