$(function () {
    console.log("ready");
    $("#create-ref").on('click', (event) => onRegisterRef(event));
    $("#register-form").on('submit', (event) => onRegistraion(event));
    $("#login-form").on('submit', (event) => onLogin(event));
})


function onLogin(event) {
    event.preventDefault();
    console.log("login form: ");
    let email = $("#email").val();
    let password = $("#pwd").val();
    let loginUser = {
        email: email,
        password: password
    };
    console.log(loginUser);

    let isAdmin = email === "admin" && password === "admin";

    if (isAdmin || dataIsValid()) {
        // debugger;
        $.post("login", loginUser, function () {
            console.log("successfully logged in");
            window.location = "cabinet.jsp"
        })
        .fail(function(){
            alert("error log in");
        });
    }
}

function onRegisterRef(event) {
    event.preventDefault();
    console.log("ref to register");
    $("#register-form").show();
    $("#login-form").hide();
}

function onRegistration(event) {
    event.preventDefault();
    console.log("click registration form");

    let registerUser = objectifyForm($("#register-form").serializeArray());
    if(registrationDataIsValid(registerUser)){
        console.log("successfully validated");
        $.post("registration", registerUser, function(){
            alert("Succesfully register user " + registerUser.email);
            $("#register-form").hide();
            $("#login-form").show();
        })
            .fail(function() {
                alert("Something whent whrong. Please try again ");
            });
    }
    console.log(registerUser);

}


function dataIsValid() {
    console.log("dataIsValid")
    return validateEmail() && validatePassword();
}

function validateEmail() {
    let email = $("#email");
    let isValid = true;
    if (!email.val()) {
        isValid = false;
        email.addClass('invalid');
        $("#email-error").html("Email is required")
    } else if (!isEmailValid(email.val())) {
        isValid = false;
        email.addClass('invalid');
        $("#email-error").html("Invalid email")
    }
    return isValid
}

function validatePassword() {
    console.log("validate password")
    let password = $("#pwd");
    let isValid = true;
    if (!password.val()) {
        isValid = false;
        password.addClass('invalid');
        $("#pwd-error").html("Password is required");
    } else if (password.val().length < 8) {
        isValid = false;
        password.addClass('invalid');
        $("#pwd-error").html("Password should be more than 8 symbols");
    }
    return isValid;
}

function onRegisterRef(event) {
    event.preventDefault();
    console.log("ref to register");
    $("#register-form").show();
    $("#login-form").hide();
}

function onRegistraion(event) {
    event.preventDefault();
    console.log("click registration form");

    let registerUser = objectifyForm($("#register-form").serializeArray());
    if(registrationDataIsValid(registerUser)){
        $.post("registration", registerUser, function(){
            alert("Succesfully register user " + registerUser.email);
            $("#register-form").hide();
            $("#login-form").show();
        })
        .fail(function() {
            alert("Something whent whrong. Please try again ");
        });
    }
    console.log(registerUser);
  
}
function registrationDataIsValid(user){
    console.log("validation registration");
    let isValid = true;
    if(!user.firstName){
        isValid = false;
        $("#first-name-error").html("First name is required");
        $("#register-form input[name='firstName']").addClass('invalid');
    }
    if(!user.lastName){
        isValid = false;
        $("#last-name-error").html("Last name is required");
        $("#register-form input[name='lastName']").addClass('invalid');
    }
    if(!user.email){
        isValid = false;
        $("#r-email-error").html("email is required");
        $("#register-form input[name='email']").addClass('invalid');
    }else if (!isEmailValid(user.email)){
        isValid = false;
        $("#r-email-error").html("Invalid email format");
        $("#register-form input[name='email']").addClass('invalid');
    }
    if (!user.password){
        isValid = false;
        $("#r-pwd-error").html("Password is required");
        $("#register-form input[name='password']").addClass('invalid');
    } else if (user.password.length < 8){
        isValid = false;
        $("#r-pwd-error").html("Password lenght should be at least 8 symbols");
        $("#register-form input[name='password']").addClass('invalid');
    }
    return isValid;
}

function isEmailValid(email){
    let re = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    return re.test(String(email).toLowerCase());
}

function objectifyForm(formArray) {//serialize data function
    let result = {};
    for (var i = 0; i < formArray.length; i++) {
        result[formArray[i]['name']] = formArray[i]['value'];
    }
    return result;
}

function addProduct(id) {
    let product = {
        productId: id
    };

    console.log("product id: " + id);

    $.post("products", product, function () {
        alert("The product was successfully added.");
    })
    .fail(function () {
        alert("Error!!!\nThe product was NOT added");
    })
}