$(function () {
    $("#login-form").on('submit', (event) => onLogin(event));
});


function onLogin(event) {
    event.preventDefault();
    console.log("login form: ");

    let email = $("#email").val();
    let password = $("#pwd").val();

    let loginUser = {
        username: email,
        password: password
    };
    console.log(loginUser);

    if (dataIsValid()) {
        // debugger;
        $.post("login", loginUser, function () {
            console.log("successfully logged in");
            window.location = "cabinet";
        })
        .fail(function(){
            alert("error log in");
        });
    }
}

function dataIsValid() {
    console.log("dataIsValid");
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
    return isValid;
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

function isEmailValid(email){
    let re = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    return re.test(String(email).toLowerCase());
}
