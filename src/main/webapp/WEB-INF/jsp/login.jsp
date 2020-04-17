<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<fmt:message key="message.badCredentials" var="badCredentials" />

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
        <form id="login-form" name="login-form" class="form-signin" method="post">

            <c:if test="${param.error != null}">
                <div id="error-bad-cread" class="alert alert-danger" role="alert">
                        ${badCredentials}
                </div>
            </c:if>

            <div class="form-group">
                <label for="email">Email:</label>
                <input id="email"
                       class="form-control"
                       type="text"
                       name="username"
                       onfocusout="validateEmail()">
                <div id="email-error" class="invalid-text"></div>
            </div>

            <div class="form-group">
                <label for="pwd">Password:</label>
                <input id="pwd"
                       class="form-control"
                       type="password"
                       name="password"
                       onfocusout="validatePassword()">
                <div id="pwd-error" class="invalid-text"></div>
            </div>

            <div>
                <input id="login"
                       class="btn btn-success btn-lg btn-block"
                       type="submit"
                       value="login">
            </div>

            <div>
                <p class="message">
                    Not registered?
                    <a id="create-ref" href="${contextPath}/registration">Create an account</a>
                </p>
            </div>
        </form>

    </div>
</div>

<jsp:include page="footer.jsp"/>


</body>

</html>