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
        <tiles:insertAttribute name="register_form" />
        <tiles:insertAttribute name="footer" />
        <script type="text/javascript" src="${param.contextPath}/resources/js/jquery.min.js"></script>
        <script type="text/javascript" src="${param.contextPath}/resources/js/bootstrap.min.js"></script>
    </body>
</html>
