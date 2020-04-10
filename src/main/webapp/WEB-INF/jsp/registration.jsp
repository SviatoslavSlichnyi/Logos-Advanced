<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Login</title>

    <jsp:include page="libs.jsp"/>

</head>

<body>

<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <h5 class="my-0 mr-md-auto font-weight-normal" style="color: #4CAF50">Magazine</h5>
</div>

    <div class="signup-form">
        <div class="text-center">
            <form:form method="POST" modelAttribute="userForm" class="form-signin">

                <spring:bind path="username">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="username" class="form-control" placeholder="Username"
                                    autofocus="true"/>
                        <form:errors path="username"/>
                        ${usernameError}
                    </div>
                </spring:bind>

                <spring:bind path="password">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="password" path="password" class="form-control" placeholder="Password"/>
                        <form:errors path="password"/>
                    </div>
                </spring:bind>

                <spring:bind path="passwordConfirm">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="password" path="passwordConfirm" class="form-control"
                                    placeholder="Confirm your password"/>
                        <form:errors path="passwordConfirm"/>
                        ${passwordError}
                    </div>
                </spring:bind>

                <input id="login" type="submit" value="Register" class="btn btn-success btn-lg btn-block">

            </form:form>


        </div>
    </div>

    <jsp:include page="footer.jsp"/>

</body>

</html>