<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>Free Language Exchange</title>
        <!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
        <link rel="stylesheet" href="../../../resources/css/bootstrap.min.css">
        <!-- Custom Fonts -->
        <link href="${param.contextPath}/resources/css/style.css" rel="stylesheet">
        <!-- Custom Fonts -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
        <%-- Glyphicons --%>
        <link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
    </head>
    <body>
        <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="home_banner" />
        <tiles:insertAttribute name="home_benefits" />
        <tiles:insertAttribute name="home_about" />
        <tiles:insertAttribute name="register-form" />
        <tiles:insertAttribute name="footer" />
        <!-- JQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script>
            var url = window.location.href;
            var isError = url.endsWith("error");
            if(isError){
                $("#login-dropdown-btn").dropdown('toggle');
            }
        </script>
    </body>
</html>
