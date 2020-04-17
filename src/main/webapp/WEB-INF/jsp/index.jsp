<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Cabinet</title>
    <jsp:include page="libs.jsp"/>
</head>
<body>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
        <h5 class="my-0 mr-md-auto font-weight-normal" style="color: #4CAF50">Welcome Page</h5>
        <a id="log-out" class="btn btn-outline-primary" href="login">Log In</a>
    </div>

    <jsp:include page="footer.jsp"/>
</body>
</html>