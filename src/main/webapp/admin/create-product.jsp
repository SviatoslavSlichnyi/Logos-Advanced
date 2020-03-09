<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
    <jsp:include page="../remote-libs.jsp"/>
    <link rel="stylesheet" href="../resources/css/style.css">
    <script src="resources/js/navbar.js"></script>
    <script src="resources/js/script.js"></script>
</head>
<body>

    <jsp:include page="navbar.jsp"/>

	 <form id="product-form" class="signup-form" <%--method="post" action="create-product"--%>>
        <div class="form-group">
            <!-- Default input -->
            <label id="nameLable" name="name" for="name" class="disabled">Name</label>
            <input type="text" id="name" class="form-control" value="">
<%--          <div id="product-error" class="invalid-text"></div>--%>

        </div>
        <div class="form-group">
            <label id="descLable" name="description" for="desc" class="disabled">Description</label>
            <input type="text" id="desc" class="form-control" value="">
<%--          <div id="descr-error" class="invalid-text"></div>--%>
        </div>
        <div class="form-group">
            <label id="priceLable" name="price" for="price" class="disabled">Price</label>
            <input type="text" id="price" class="form-control" value="">
<%--          <div id="price-error" class="invalid-text"></div>--%>
        </div>
        <div>
          <input id="add-product" type="submit"class="btn btn-success btn-lg btn-block">
        </div>
    </form>

	<jsp:include page="../footer.jsp"/>

</body>
</html>