<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Cabinet</title>
	<jsp:include page="libs.jsp"/>
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
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${products}" var="product">
		<tr>
			<td scope="row">${product.id}</td>
			<td>${product.name}</td>
			<td>${product.description}</td>
			<td>${product.price}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<jsp:include page="footer.jsp"/>
</body>
</html>