$(function () {
    $("#log-out").on('click', (event) => onLogOut(event));
});

onCreateButton = () => {
    console.log("onCreteButton event");

    $.get("admin/create-product", function () {
        console.log("successfully logged in");
        window.location = "admin/create-product.jsp";
    })
        .fail(function(jqXHR, textStatus,){
            if (402 == jqXHR.status) {
                alert("Admin access is needed!!!\n" +
                    "Please, Log in as admin.");
            } else {
                alert("Error status: " + textStatus);
            }
        });
};

onLogOut = () => {
    console.log("Log Out from account");

    $.post("/ishop/logout", function () {
        console.log("Log out successfully");
        window.location = "../login.jsp";
    })
    .fail(function () {
        console.log("Error: logout...");
    })
};
