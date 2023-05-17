<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<%@ page import="dev.robvega.driverlicense.model.Person" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Create New Licence</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<main class="container mt-5">
    <div class="row justify-content-center">
        <form:form class="mt-5 col-md-5" action="/licenses/new" method="POST" modelAttribute="License">
            <h1 class="mb-3">New Person</h1>
            <div class="mb-3">
                <form:label class="form-label" path="person">Person</form:label>
                <form:select class="form-select" path="person">
                    <form:options items="${personList}" itemLabel="firstName"/>
                </form:select>
                <form:errors class="text-danger" path="person"/>
            </div>
            <div class="mb-3">
                <form:label class="form-label" path="expirationDate">Expiration Date</form:label>
                <form:input class="form-control" path="expirationDate" type="date"/>
                <form:errors class="text-danger" path="expirationDate"/>
            </div>
            <div class="mb-3">
                <form:label class="form-label" path="state">State</form:label>
                <form:input class="form-control" path="state"/>
                <form:errors class="text-danger" path="state"/>
            </div>
            <input class="btn btn-primary float-end" type="submit" value="Submit"/>
        </form:form>
    </div>
</main>
</body>
</html>