<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>New Person</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <main class="container mt-5">
	   	<div class="row justify-content-center">
	   	    <div class="mt-5 col-md-8">
	   	        <h1>${person.firstName} ${person.lastName}</h1>
	   	        <div class="row mt-4">
	   	            <p class="col-6">License Number:</p>
	   	            <p class="col-6">${person.license.number}</p>
	   	        </div>
	   	        <div class="row">
                    <p class="col-6">State:</p>
                    <p class="col-6">${person.license.state}</p>
                </div>
                <div class="row">
                    <p class="col-6">Expiration Date:</p>
                    <p class="col-6">${person.license.expirationDate}</p>
                </div>
	   	    </div>
	   	</div>
   </main>
</body>
</html>