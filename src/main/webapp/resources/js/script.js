$(function () {
    $("#product-form").on('submit', event => onCreateProduct(event));
});

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



function addProduct(id) {
    let product = {
        productId: id
    };

    console.log("product id: " + id);

    $.post("products/add", product, function () {
        alert("The product was successfully added.");
    })
        .fail(function () {
            alert("Error!!!\nThe product was NOT added");
        });
}

function removeProductFromUserList(id) {
    console.log("method: removeProductFromUserList")
    console.log("product id: " + id);

    $.ajax({
        url: 'cabinet/delete/' + id,
        type: 'DELETE',
        success: function () {
            console.log("The product was successfully removed.");
            location.reload();
        },
        error: function () {
            alert("The product was NOT removed");
        }
    });
}


function onCreateProduct(event) {
    event.preventDefault();
    console.log("onCreateProduct method");

    let name = $("#name").val();
    let desc = $("#desc").val();
    let price = $("#price").val();

    let prod = {
        name: name,
        description: desc,
        price: price
    };

    console.log(prod);

    $.post("create-product", prod, function () {
        alert("Successfully added.");
        $("#name").val("");
        $("#desc").val("");
        $("#price").val("");
    })
        .fail(function () {
            alert("Something went wrong");
        })

}

function removeProduct(id) {
    console.log("method: removeProductFromUserList")
    console.log("product id: " + id);

    $.ajax({
        url: 'products/delete/' + id,
        type: 'DELETE',
        success: function () {
            console.log("The product was successfully removed.");
            location.reload();
        },
        statusCode: {
            403: () => {alert("The product is used by someone. ");}
        },
        // error: () => {
        //     alert("!!!Error!!!");
        // }
    });
}