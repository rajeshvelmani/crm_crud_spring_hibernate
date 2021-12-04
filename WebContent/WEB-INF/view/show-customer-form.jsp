<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href="${pageContext.request.contextPath}/resources/style/style.css" rel="stylesheet"/>
    <!--  bootstrap css-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
        crossorigin="anonymous">
</head>
<body class="container">
	<nav class="navbar navbar-light bg-light">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">CRM</a>
	  </div>
	</nav>
	
	<form:form action="saveCustomer" modelAttribute="customer" method="POST" class="m-3">
	  <form:hidden path="id"/>
	  <div class="col-md-6">
	    <label for="inputAddress" class="form-label">First Name</label>
	    <form:input path="firstName" type="text" class="form-control" placeholder="John"/>
	  </div>
	  <div class="col-md-6">
	    <label for="inputAddress2" class="form-label">Last Name</label>
	    <form:input path="lastName" type="text" class="form-control" placeholder="William"/>
	  </div>
	  <div class="col-md-6">
	    <label for="inputEmail4" class="form-label">Email</label>
	    <form:input path="email" type="email" class="form-control" placeholder="William@john.com"/>
	  </div>
	  <div class="col-12 mt-3">
	    <button type="submit" class="btn btn-primary">Save Customer</button>
	  </div>
	</form:form>
</body>
</html>