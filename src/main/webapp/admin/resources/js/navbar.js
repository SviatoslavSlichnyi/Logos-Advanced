$(function () {
    $("#log-out").on('click', (event) => onLogOut(event));
});

onLogOut = () => {
    console.log("Log Out from account");

    $.post("/java-advanced/logout", function () {
        console.log("Log out successfully");
        window.location = "../login.jsp";
    })
    .fail(function () {
        console.log("Error: logout...");
    })
};
