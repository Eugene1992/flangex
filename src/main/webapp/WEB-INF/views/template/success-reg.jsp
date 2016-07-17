<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>Free Language Exchange</title>
        <link rel="stylesheet" href="${param.contextPath}/resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="${param.contextPath}/resources/css/style.css">
        <link rel="stylesheet" href="${param.contextPath}/resources/css/font-awesome.min.css">
        <link rel="stylesheet" href="${param.contextPath}/resources/css/bootstrap-glyphicons.css">
    </head>
    <body>
        <tiles:insertAttribute name="header" />
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center success-message-div">
                    <img src="${param.contextPath}/resources/img/successful-registration.jpg" class="img-responsive img-centered" alt="success-logo.jpg">
                    <h3>Thank you for registering, ${username}!</h3>
                    <p>Your registering email is: <span>${email}</span></p>
                    <p>Now you can try to log into your personal cabinet.</p><br>
                    <p><a href="/" class="btn btn-sm btn-success">Back to main page</a></p>
                </div>
            </div>
        </div>
        <tiles:insertAttribute name="footer" />

        <script type="text/javascript" src="${param.contextPath}/resources/js/jquery.min.js"></script>
        <script type="text/javascript" src="${param.contextPath}/resources/js/bootstrap.min.js"></script>
    </body>
</html>
