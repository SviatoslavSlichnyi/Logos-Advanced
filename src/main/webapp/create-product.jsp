<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Products</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form id="product-form" name="products" action="products" method="POST">
    <div class="form-group">
        <label for="product">Name:</label>
        <input name="name" type="text" class="form-control form-control-sm" id="product" autofocus value="IPHONE 7">
        <div id="pr-error" class="invalid-text"></div>
    </div>
    <div class="form-group">
        <label for="descr"> Description:</label>
        <input name="description" type="text" class="form-control form-control-sm" id="descr" value="The best choise">
        <div id="descr-error" class="invalid-text"></div>
    </div>
    <div class="form-group">
        <label for="price">Price:</label>
        <input name="price" type="text" class="form-control form-control-sm" id="price" value="280">
        <div id="price-error" class="invalid-text"></div>
    </div>
    <div>
        <input id="add-product" type="submit" value="Add product" class="btn btn-success btn-lg btn-block">
    </div>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>