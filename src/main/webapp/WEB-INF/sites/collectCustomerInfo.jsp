<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<%@ include file="/WEB-INF/sites/navbar.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Details</title>
<link rel="stylesheet"
	href="<c:url value="/sources/boots/css/bootstrap.min.css"/>">
<script src="<c:url value="/sources/jsq/jquery.js"/>"></script>
<script src="<c:url value="/sources/boots/jsq/bootstrap.min.js"/>"></script>
<link rel="stylesheet" type="text/css"	href="<c:url value="/sources/css/register.css"/>">

</head>
<body style="padding: 0px;">
	
<form:form class="row g-3 fs-5" modelAttribute="order" action="/OnlineMensFashion/collectCustomerInfoProcess" method="post">
					<div class="col-sm-12">
						<!-- <div class="row"> -->
						
							<div class="col-sm-12 form-group">
								<form:label path="name">Name</form:label>
								<form:input type="text" placeholder="Enter First Name.."
									class="form-control" path="name"></form:input>
								<form:errors path="name"></form:errors>
							</div>
						   <div class="col-sm-12 form-group">
								<form:label path="phone">Phone</form:label>
								<form:input type="text" placeholder="Enter First Name.."
									class="form-control" path="phone"></form:input>
								<form:errors path="phone"></form:errors>
							</div>
						<hr>
						<br>
			<h2>Address</h2>
			                  <div class="col-sm-12">
								<div class="row">
							<div class="form-group">
								<form:label path="address">Address</form:label>
								<form:input type="text" placeholder="Enter Your Address..."
									class="form-control" path="address"></form:input>
								<form:errors path="address"></form:errors>
							</div>
								<div class="col-sm-12 form-group">
								<form:label path="city">City</form:label>
								<form:input type="text" placeholder="Enter Your City"
									class="form-control" path="city"></form:input>
								<form:errors path="city"></form:errors>
							</div>
								
						   </div>
						<hr>
						
					
						</div>
						
						<hr>
						<div>

						<div class="form-actions">
							<button type="Submit" class="btn btn-lg btn-info"
								 style="margin-right: 44px; margin-left: 0px">CONTINUE</button>
							
						</div>

					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
