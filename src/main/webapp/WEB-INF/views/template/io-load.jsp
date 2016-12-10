<%--
  Created by IntelliJ IDEA.
  User: Evgeniy
  Date: 10.12.2016
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" href="${param.contextPath}/resources/css/bootstrap.min.css">
        <style>
            #links {
                width: 500px;
                margin: 0 auto;
            }
        </style>
    </head>
    <body>
        <div id="links">
            <h3>For successful completion of the job<br>save the pictures on the links below</h3>
            <a href="${param.contextPath}/resources/img/io/load/img-01.png" class="btn btn-sm btn-info" role="button">Picture #1</a>
            <a href="${param.contextPath}/resources/img/io/load/img-02.png" class="btn btn-sm btn-info" role="button">Picture #2</a>
            <a href="${param.contextPath}/resources/img/io/load/img-03.png" class="btn btn-sm btn-info" role="button">Picture #3</a>
            <a href="${param.contextPath}/resources/img/io/load/img-04.png" class="btn btn-sm btn-info" role="button">Picture #4</a>
            <a href="${param.contextPath}/resources/img/io/load/img-05.png" class="btn btn-sm btn-info" role="button">Picture #5</a>
        </div>
    </body>
</html>
