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
    <title>Create New License</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<main class="container mt-5">
    <div class="row justify-content-center">
        <h1>Licenses app</h1>
        <div>
            <a href="persons/new">Create New Person</a>
            <a class="ms-4" href="licenses/new">Create New License</a>
        </div>
        <table class="table table-striped mt-5">
            <thead>
                <tr>
                    <th>Full Name</th>
                    <th>State</th>
                    <th>License Expiration Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${personList}" var="person">
                <tr>
                    <td><a href="persons/${person.id}">${person.firstName} ${person.lastName}</a></td>
                    <td>${person.license.state}</td>
                    <td>${person.license.expirationDate}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</main>
</body>
</html>