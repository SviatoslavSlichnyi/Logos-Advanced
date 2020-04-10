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
    <h5 class="my-0 mr-md-auto font-weight-normal" style="color: #4CAF50">Personal Cabinet</h5>
    <h5 class="my-0 mr-md-auto font-weight-normal" style="color: #007bff">${userEmail}</h5>
    <nav class="my-2 my-md-0 mr-md-3">
        <c:if test="${userEmail == 'admin@mail.com'}">
            <a class="p-2 text-dark" href="admin">Admin</a>
            <a class="p-2 text-dark" href="cabinet">Cabinet</a>
        </c:if>
    </nav>
    <a id="log-out" class="btn btn-outline-primary" href="logout">Log out</a>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>