<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>

<div class="container">
    <div class="row">
        <div class="col-12">
            <a href="/students/create" class="btn btn-primary"><i class="far fa-eye">Add student</i></a>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Course</th>
                    <th scope="col">Student
                        <name></name>
                    </th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${students}" var="student">
                    <tr>
                        <th scope="row">${student.id}</th>
                        <td>${student.course}</td>
                        <td>${student.firstName} ${student.lastName}</td>
                        <td>
                            <div class="btn-group" role="group" aria-label="Basic example">
                                <a href="/students/one?id=${student.id}" type="button"
                                   class="btn btn-primary"><i>edit</i></a>
                                <a href="/students/delete?id=${student.id}" type="button" class="btn btn-danger"><i>delete</i></a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>
