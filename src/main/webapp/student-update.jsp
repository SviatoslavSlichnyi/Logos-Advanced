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
            <form action="/students/update" method="POST">
                <input type="hidden" value="${student.id}" class="form-control" id="id" name="id">
                <div class="form-group">
                    <label>Student first name:</label> <input type="text"
                                                              class="form-control" id="first-name" name="firstName"
                                                              value="${student.firstName}">
                </div>
                <div class="form-group">
                    <label>Student last name:</label> <input type="text"
                                                             class="form-control" id="last-name" name="lastName"
                                                             value="${student.lastName}">
                </div>
                <div class="form-group">
                    <label>Student course:</label> <input type="number"
                                                          class="form-control" id="course" name="course"
                                                          value="${student.course}">
                </div>

                <button type="submit" class="btn btn-default">Edit</button>
                <a href="/students" type="submit" class="btn btn-info">Back to students</a>
            </form>
        </div>
    </div>
</div>
