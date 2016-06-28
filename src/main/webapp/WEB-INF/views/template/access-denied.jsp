<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>Free Language Exchange</title>
        <!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
        <link rel="stylesheet" href="../../../resources/css/bootstrap.min.css">
        <!-- Custom Fonts -->
        <link href="../../../resources/css/style.css" rel="stylesheet">
        <!-- Custom Fonts -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
        <%-- Glyphicons --%>
        <link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
    </head>
    <body>
    <tiles:insertAttribute name="header" />
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 text-center success-message-div">
                <h3>Access denied! Sorry...!</h3>
                <br>
                <img src="../../../resources/img/access-denied-img.jpg" class="img-responsive img-centered" alt="success-logo.jpg">
                <br>
                <br>
                <p><a href="/" class="btn btn-sm btn-success">Back to main page</a></p>
            </div>
        </div>
    </div>
    <tiles:insertAttribute name="footer" />
    </body>
</html>
