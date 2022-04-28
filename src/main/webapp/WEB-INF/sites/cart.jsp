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
				<br><h1 align="center">Products</h1>
				<div>
					<a href="/OnlineMensFashion/cart/removeAllCartItems"class="btn btn-info pull-left"
						style="margin-top: 15px; margin-left: 20px">
						 Clear Cart
					</a>
				</div>
				<div>	<thead>
					
						<tr>
						    <th>Product Image</th>
							<th>Product ID</th>
							<th>Name</th>
							<th>Price</th>
							<th>Remove Item</th>
							
						</tr>
					</thead>
					
					<c:forEach var="product" items="${lists}" >
					<tbody>
					<div>
				
				<a href="/OnlineMensFashion/orderConfirmation/${product.id}/${product.name}/${product.price}/${Total}" class="btn btn-danger pull-left"
						style="margin-top: 15px; margin-left: 20px"> <span
						class="glyphicon glyphicon-shipping-cart"> </span>Check Out
					</a>	</div>
						   <td style="width: 171px"><img
							src="<c:url value="${product.imageurl}"/>"
							style="width: 100px; height: 90px;" ${product.name}"  /></td> 
							<td>${product.id}</td>
							<td>${product.name}</td>
							
							<td>${product.price}
							</td>
							<td><a href="/OnlineMensFashion/cart/removeCartItem/${product.id}" class="btn btn-danger"
								style="margin-top: 0px;">remove</a></td>
				
									</c:forEach>
					<br>
					
					
					
					</tbody>
					
				
				
				</table>
				
				<h1>Total Price = ${Total}</h1>
				
				<c:url value="/productList" var="url"></c:url>
			<a href="${url}" class="btn btn-info" style="margin-left: 20px">Continue
				Shopping</a>
					
				
			</div>
				</div>

			

	</div>
	<div></div>
			</div>
			
	
	
	
</body>
</html>