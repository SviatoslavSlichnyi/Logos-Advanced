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
    $.post("create-product", prod, function () {
        alert("Successfully added.");
        $("#name").val("");
        $("#desc").val("");
        $("#price").val("");
    })
    .fail(function () {
        alert("Something went wrong");
    })

};

function removeProduct(id) {
    console.log("method: removeProduct")
    console.log("product id: " + id);

    $.ajax({
        url: 'products/' + id,
        type: 'DELETE',
        success: function () {
            console.log("The product was successfully removed.");
            location.reload();
        },
        error: function () {
            alert("The product is used by someone.");
        }
    });
}