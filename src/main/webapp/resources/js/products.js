$(function(){
    $.get("products", function(){
        console.log("products");
    })
})


function buyPhone(id){

    console.log(id);

    $.post("buy", {'id': id}, function(){
        alert("Congratulation you by you phone");
    });
}