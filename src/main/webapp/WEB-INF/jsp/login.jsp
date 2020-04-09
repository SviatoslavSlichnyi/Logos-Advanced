<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>

    <jsp:include page="libs.jsp"/>

</head>

<body>

<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <h5 class="my-0 mr-md-auto font-weight-normal" style="color: #4CAF50">Magazine</h5>
</div>

<div class="signup-form">
    <div class="text-center">
        <form id="login-form" name="login-form" class="form-signin ${error != null ? 'has-error' : ''}" method="post">
            <div class="form-group">
                <span>${message}</span>
                <label for="email">Email:</label>

                <input id="email" name="username" type="text" class="form-control form-control-sm" autofocus="true">

                <div id="email-error" class="invalid-text"></div>
            </div>
            <div class="form-group">
                <label for="pwd">Password:</label>
                <input id="pwd" name="password" type="password" class="form-control form-control-sm	">
                <div id="pwd-error" class="invalid-text"></div>
            </div>
            <div>
                <span>${error}</span>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input id="login" type="submit" value="login" class="btn btn-success btn-lg btn-block">
            </div>
        </form>
    </div>
</div>

<jsp:include page="footer.jsp"/>

</body>

</html>