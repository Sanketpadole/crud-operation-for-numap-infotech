<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>

</head>
<body >

	<%@ include file="navbar.jsp"%>
	
	
		<h1 >add products</h1>
		

				
	     <form:form   modelAttribute="product" action="addProductProcess" method="post">
	      
					
						<div class="row">
							<table>
							<td>
							
							
							<tr><div class="col-sm-12 form-group">
								<form:label path="name">Product Name</form:label>
								 <form:input type="text"
									placeholder="Enter Product Name.." class="form-control"
									path="name"></form:input>
								 <form:errors path="name"></form:errors>
							
							</div>
							</tr>
							</td>
							
						<td>
						<tr>
							<div class="col-sm-12 form-group">
								<form:label path="price">Product Price</form:label>
								 <form:input type="text"
									placeholder="Enter Product Price.." class="form-control"
									path="price"></form:input>
								 <form:errors path="price"></form:errors>
							</div>
							</tr>
							
							<tr>	<div class="col-sm-12 form-group">
								<form:label path="quantity">Quantity</form:label>
								 <form:input type="text"
									placeholder="quantity.." class="form-control"
									path="quantity"></form:input>
								</div>
							</tr>
						</td>
						
						
					 	<div class="form-group">
						<form:label path="imageurl">Product Image</form:label>
							<form:input type="text" path="imageurl"/>
						</div> 
						
						
							</table>
						
						
						 
						<div class="form-actions">
							<button type="submit" class="btn btn-lg btn-warning">Add Product</button>
						</div>
					</div>
			 </form:form>
			</div>
		</div>
	
</body>
</html>