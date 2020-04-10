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
    } else {
        email.removeClass('invalid');
        $("#email-error").html('');
    }

    return isValid;
}

function isEmailValid(email){
    let re = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    return re.test(String(email).toLowerCase());
}

function validatePassword() {
    let lengthOfPassword = 8;

    let password = $("#pwd");
    let isValid = true;

    if (!password.val()) {
        isValid = false;
        password.addClass('invalid');
        $("#pwd-error").html("Password is required");
    } else if (password.val().length < lengthOfPassword) {
        isValid = false;
        password.addClass('invalid');
        $("#pwd-error").html(`Password should be more than ${lengthOfPassword} symbols`);
    } else {
        password.removeClass('invalid');
        $("#pwd-error").html('');
    }

    return isValid;
}