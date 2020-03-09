<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
	<jsp:include page="remote-libs.jsp"/>
	<jsp:include page="res.jsp"/>
</head>
<body>
	<jsp:include page="navbar.jsp"/>

        <table class="table table-dark">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Description</th>
					<th scope="col">price</th>
					<th style="width: 5vw"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="product">
				<tr>
					<td scope="row">${product.id}</td>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.price}</td>
					<td><button id="add-product"
								type="button"
								class="btn btn-outline-success"
								onclick="addProduct(${product.id})">ADD</button></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>

	<jsp:include page="footer.jsp"/>
</body>
</html>