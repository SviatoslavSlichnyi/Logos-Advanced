<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Upload</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
</head>
<body>
<div class="container">
    <div class="col-md-8 col-md-offset-2">
        <h3>Upload File</h3>
        <form:form method="POST" action="/data/file" enctype="multipart/form-data">
            <div class="form-group">
                <input type="file" name="multipartFile" placeholder='Choose a file...' />
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-primary pull-right" value="Submit"/>
                <button type="reset" class="btn btn-danger">Reset</button>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
