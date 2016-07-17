<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
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
        <tiles:insertAttribute name="home_banner" />
        <tiles:insertAttribute name="home_benefits" />
        <tiles:insertAttribute name="home_about" />
        <tiles:insertAttribute name="register-form" />
        <tiles:insertAttribute name="footer" />

        <script type="text/javascript" src="${param.contextPath}/resources/js/jquery.min.js"></script>
        <script type="text/javascript" src="${param.contextPath}/resources/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
        <script>
            $(document).ready(function() {
                var url = window.location.href;
                var isError = url.endsWith("error");
                if(isError){
                    $("#login-dropdown-btn").dropdown('toggle');
                }
            });

            $(document).ready(function() {
                var lang = window.location.href.split('?lang=')[1];
                if ($.cookie('lang') === null){
                    $.cookie("lang", "ENG");
                } else {
                    if (lang === 'ru' || $.cookie('lang') === 'ru') {
                        $.cookie("lang", "RUS");
                        $("#lang").text(lang = $.cookie("lang"));
                    } else {
                        $.cookie("lang", "ENG");
                        $("#lang").text(lang = $.cookie("lang"));
                    }
                }
                /*$("#lang").text(lang === 'ru' ? "RUS" : "ENG");*/
            });
        </script>
    </body>
</html>
