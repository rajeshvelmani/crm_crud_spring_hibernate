<%@page import="com.crm.utils.SortUtils" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>List Customer</title>

    <link href="${pageContext.request.contextPath}/resources/style/style.css" rel="stylesheet" />
    <!--  bootstrap css-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
        crossorigin="anonymous">
    <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">


</head>

<body class="container">
    <nav class="navbar navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">CRM</a>
            <div class="d-flex">
                <form:form action="search" method="GET" class="d-flex">
                    <input class="form-control me-2" type="search" name="searchvalue"
                        placeholder="Search customer">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form:form>
            </div>
        </div>
    </nav>

	<div class="d-flex flex-row-reverse mt-5">
	    <a href="showCustomerForm" class="btn btn-primary me-2">Add Customer</a>
	</div>

    <!-- construct a sort link for first name -->
    <c:url var="sortLinkFirstName" value="/customer/list">
        <c:param name="sort" value="<%= Integer.toString(SortUtils.FIRST_NAME) %>" />
    </c:url>

    <!-- construct a sort link for last name -->
    <c:url var="sortLinkLastName" value="/customer/list">
        <c:param name="sort" value="<%= Integer.toString(SortUtils.LAST_NAME) %>" />
    </c:url>

    <!-- construct a sort link for email -->
    <c:url var="sortLinkEmail" value="/customer/list">
        <c:param name="sort" value="<%= Integer.toString(SortUtils.EMAIL) %>" />
    </c:url>

    <table class="table">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">
                    First Name
                    <a href="${sortLinkFirstName}">
                        <i class="bi bi-sort-alpha-down"></i>
                    </a>
                </th>
                <th scope="col">
                    Last Name
                    <a href="${sortLinkLastName}">
                        <i class="bi bi-sort-alpha-down"></i>
                    </a>
                </th>
                <th scope="col">
                	Email Address
                	<a href="${sortLinkEmail}">
                		<i class="bi bi-sort-alpha-down"></i>
                	</a>
                </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="customer" items="${customers}">

                <c:url var="updateLink" value="/customer/update">
                    <c:param name="id" value="${customer.id}"></c:param>
                </c:url>
                <c:url var="deleteLink" value="/customer/delete">
                    <c:param name="id" value="${customer.id}"></c:param>
                </c:url>
                <tr>
                    <th scope="row"> ${customer.id}</th>
                    <td>${ customer.firstName }</td>
                    <td>${ customer.lastName }</td>
                    <td>${ customer.email }</td>
                    <td>
                        <a href="${updateLink}">
                            <i class="bi bi-pencil-square text-warning"></i>
                        </a>
                    </td>
                    <td>
                        <a href="${deleteLink}"
                            onClick="if(!(confirm('are you want to delete ?')))return false">
                            <i class="bi bi-trash-fill text-danger"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!--  bootstrap script-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>

</html>