<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1" %>
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
		<form id="login-form" name="login-form" class="form-signin">
			<div class="form-group">
				<label for="email">Email:</label>
				<input id="email" type="text" class="form-control form-control-sm" autofocus>
				<div id="email-error" class="invalid-text"></div>
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label>
				<input id="pwd" type="password" class="form-control form-control-sm	">
				<div id="pwd-error" class="invalid-text"></div>
			</div>
			<div>
				<input id="login" type="submit" value="login" class="btn btn-success btn-lg btn-block">
			</div>
			<div>
				<p class="message"> Not registered? <a id="create-ref" href="#">Create an account</a></p>
			</div>
		</form>
	</div>
	<div class="signup-form">
		<div class="text-center">
			<form id="register-form" class="form-signin">
				<div class="form-group">
					<label for="firstName">First Name :</label>
					<input id="firstName" name="firstName" class="form-control form-control-sm">
					<div id="first-name-error" class="invalid-text"></div>
				</div>
				<div class="form-group">
					<label for="lastName">Last Name:</label>
					<input id="lastName" name="lastName" class="form-control form-control-sm" type="text">
					<div id="last-name-error" class="invalid-text"></div>
				</div>
				<div class="form-group">
					<label for="r-email">Email:</label>
					<input id="r-email" name="email" class="form-control form-control-sm" type="text" autofocus>
					<div id="r-email-error" class="invalid-text"></div>
				</div>
				<div class="form-group">
					<label for="r-pwd">Password:</label>
					<input id="r-pwd" name="password" class="form-control form-control-sm" type="password">
					<div id="r-pwd-error" class="invalid-text"></div>
				</div>
				<div>
					<input id="register" type="submit" value="Register now" class="btn btn-success btn-lg btn-block">
				</div>
			</form>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp"/>

</body>

</html>