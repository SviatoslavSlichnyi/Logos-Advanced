<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
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

<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Username</th>
        <th scope="col">Password</th>
        <th scope="col">Roles</th>
        <th style="width: 5vw"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allUsers}" var="user">
        <tr>
            <td scope="row">${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>
                <c:forEach items="${user.roles}" var="role">
                    ${role.name};
                </c:forEach>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/admin" method="post">
                    <input type="hidden" name="userId" value="${user.id}"/>
                    <input type="hidden" name="action" value="delete"/>
                    <button type="submit" class="btn btn-outline-danger">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="footer.jsp"/>
</body>

</html>