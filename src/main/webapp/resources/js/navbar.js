$(function () {
    $("#log-out").on('click', (event) => onLogOut(event));
    $("#create-pd").on('click', (event) => onCreateButton(event))
});

onCreateButton = (event) => {
    console.log("onCreteButton event");

    $.get("admin/create-product", function () {
        console.log("successfully logged in");
        window.location = "admin/create-product.jsp";
    })
    .fail(function(){
        alert("Admin access is needed!!!\n" +
            "Please, Log in as admin.");
    });
};

onLogOut = () => {
    console.log("Log Out from account");

    $.post("logout", function () {
        console.log("Log out successfully");
        window.location = "login.jsp";
    })
    .fail(function () {
        console.log("Error: logout...");
    })
};
