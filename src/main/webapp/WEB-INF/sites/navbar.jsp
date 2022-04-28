<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="<c:url value="/sources/boots/css/bootstrap.min.css"/>">
<script src="<c:url value="/sources/jsq/jquery.js"/>"></script>

<style>
.navbar-custom
{

background-color: #4d004d;
}
</style>


</head>
<body>

	<nav class="navbar navbar-inverse navbar-custom">
	<div class="container-fluid">

		

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value="/index1" />">Assignment-1</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href=" <c:url value="/index1" />">Home</a></li>
				<li><a href=" <c:url value="/productList" />">Items</a></li>
				<li><a href=" <c:url value="/aboutus" />">About Us</a></li>
				
				
			
            	<c:if test="${pageContext.request.userPrincipal.name=='harshal' }">
            	 
                 <li><a href=" <c:url value="/admin/addProduct" />">AddProduct</a></li>
                     <li><a href=" <c:url value="/admin/orderdisplay" />">OrderDetailst</a></li>
                 
                 	</c:if>
			</ul>

			<ul class="nav navbar-nav navbar-right">

				<c:if test="${!empty pageContext.request.userPrincipal.name}">
					 
					 <button type="button" class="btn btn-lg " style="background-color:yellow;"  >
					 <a href="<c:url value="/index1" />">
					WELCOME : ${pageContext.request.userPrincipal.name}</a>   </button>


				<c:if test="${pageContext.request.userPrincipal.name!='harshal' }">
					<security:authorize access="hasRole('ROLE_USER')">
					<button type="button" class="btn btn-lg " style="background-color:silver;" >
						 <a href="<c:url value="cart/getCart" />"> Cart</a> 
						  </button>  
					</security:authorize>
					</c:if>
					
					
					 <button type="button" class="btn btn-lg" style="background-color:skyblue;" >
					 <a href="<c:url value="/logout" />"> Logout</a> 
					 </button>
				</c:if>
			</ul>


			<ul class="nav navbar-nav navbar-right">

				<c:if test="${pageContext.request.userPrincipal.name==null}">
				
					<li><a href="<c:url value="/login" />">My Cart</a></li>
					
					<li><a href="<c:url value="/login" />"> Login</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	</nav>



</body>
</html>