<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>


<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <h5 class="my-0 mr-md-auto font-weight-normal" style="color: #4CAF50">Magazine</h5>
    <h5 class="my-0 mr-md-auto font-weight-normal" style="color: #007bff">${userEmail}</h5>
    <nav class="my-2 my-md-0 mr-md-3">
        <a id="create-pd" class="p-2 text-dark" href="#">Create</a>
        <a class="p-2 text-dark" href="http://localhost:8080/ishop/products">Products</a>
        <a class="p-2 text-dark" href="http://localhost:8080/ishop/cabinet">Cabinet</a>
    </nav>
    <a id="log-out" class="btn btn-outline-primary" href="#">Log out</a>
</div>
