$(function () {
    $("#log-out").on('click', (event) => onLogOut(event));
    $("#create-pd").on('click', (event) => onCreateButton(event))
});

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
