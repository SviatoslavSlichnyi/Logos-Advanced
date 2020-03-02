$(function () {
    console.log("page is ready");

    $("#product-form").on('submit', event => onCreateProduct(event));
});

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
    // debugger;
    $.post("create-product", prod, function () {
        alert("Successfully added.");
    })
    .fail(function () {
        alert("Something went wrong");
    })

};

function objectifyForm(formArray) {//serialize data function
    let result = {};
    for (var i = 0; i < formArray.length; i++) {
        result[formArray[i]['name']] = formArray[i]['value'];
    }
    return result;
}