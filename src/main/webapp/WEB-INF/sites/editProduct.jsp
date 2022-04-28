<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Product</title>
<link rel="stylesheet"
	href="<c:url value="/sources/boots/css/bootstrap.min.css"/>">
<script src="<c:url value="/sources/jsq/jquery.js"/>"></script>
<script src="<c:url value="/sources/boots/jsq/bootstrap.min.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/sources/css/register.css"/>">

</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container" style="margin-bottom: 19px">
		<h1 class="well">Update Product !</h1>
		<div class="col-lg-12 well">
			<div class="row">

				<!--  RegisterServlet  form -->
				<c:url value="/admin/editProduct" var="url"></c:url>
				<form:form method="post" action="${url}" modelAttribute="editProductObj">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<form:label path="id">Product Id</form:label>
								<form:input type="text" placeholder="Enter ProductId.."
									class="form-control" path="id"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<form:label path="name">Product Name</form:label>
								<form:input type="text" placeholder="Enter Product Name.."
									class="form-control" path="name"></form:input>
							</div>
						</div>
						
					
							<div class="col-sm-4 form-group">
								<form:label path="price">Product Price</form:label>
								<form:input type="text" placeholder="Enter Product Price.."
									class="form-control" path="price"></form:input>
							</div>
							<div class="col-sm-4 form-group">
								<form:label path="quantity">Quantity</form:label>
								<form:input type="text" placeholder="Number of Products.."
									class="form-control" path="quantity"></form:input>
							</div>
							
							<div class="col-sm-4 form-group">
								<form:label path="imageurl">ImageUrl</form:label>
								<form:input type="text" placeholder="set ImageUrl"
									class="form-control" path="imageurl"></form:input>
							</div>
						</div>
						<div class="form-actions">
							<button type="submit" class="btn btn-lg btn-info">Update</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	
</body>
</html>