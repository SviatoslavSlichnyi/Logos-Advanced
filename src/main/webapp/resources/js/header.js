$(function(){
    console.log("header");
    $("#logout").on('click', function (){
        $.post("logout", function(){
            alert("Successfully logged out");
            window.location = "login.jsp";
        }).
        fail(function(){
            console.log("error when logout");
        })
    });

    $("#home").on('click', function(){
        console.log("home");
        window.location = "http://localhost:8080/ishop/products";
    });

})