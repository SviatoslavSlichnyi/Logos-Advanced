<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
		integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

	<link rel="stylesheet" href="resources/css/style.css">
	<script src="resources/js/script.js"></script>

</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="signup-form">
		<div class="text-center">
			<form id="login-form" name="login-form" class="form-signin">
				<div class="form-group">
					<label for="email">Email:</label>
					<input type="text" class="form-control form-control-sm" id="email" autofocus>
					<div id="email-error" class="invalid-text"></div>
				</div>
				<div class="form-group">
					<label for="pwd">Password:</label>
					<input type="password" class="form-control form-control-sm	" id="pwd">
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
						<input name="firstName" class="form-control form-control-sm">
						<div id="first-name-error" class="invalid-text"></div>
					</div>
					<div class="form-group">
						<label for="lastName">Last Name:</label>
						<input type="text" name="lastName" class="form-control form-control-sm">
						<div id="last-name-error" class="invalid-text"></div>
					</div>
					<div class="form-group">
						<label for="r-email">Email:</label>
						<input type="text" name="email" class="form-control form-control-sm" id="r-email" autofocus>
						<div id="r-email-error" class="invalid-text"></div>
					</div>
					<div class="form-group">
						<label for="r-pwd">Password:</label>
						<input type="password" name="password" class="form-control form-control-sm" id="r-pwd">
						<div id="r-pwd-error" class="invalid-text"></div>
					</div>
					<div>
						<input id="register" type="submit" value="Register now"
							class="btn btn-success btn-lg btn-block">
					</div>
				</form>
			</div>
		</div>
</body>

</html>