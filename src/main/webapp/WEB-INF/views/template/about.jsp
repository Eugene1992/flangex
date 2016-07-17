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
        <div class="row admin-content">
            <div class="col-lg-3 col-md-3 col-sm-4 text-center">
                <img src="${param.contextPath}/resources/img/ava-white.png" id="author-img" class="img-responsive img-centered img-thumbnail" alt="success-logo.jpg">
                <div class="alert alert-success" id="cv-download" role="alert">
                    <p style="font-size: 16px">Find me in socials <br>or download my CV</p>
                    <hr>
                    <img src="${param.contextPath}/resources/img/vk-logo.png" alt="">
                    <img src="${param.contextPath}/resources/img/facebook-logo.png" alt="">
                    <a href="${param.contextPath}/resources/files/cv.pdf"><img src="${param.contextPath}/resources/img/pdf-48.png" alt="df"></a>
                    <a href="${param.contextPath}/resources/files/cv.docx"><img src="${param.contextPath}/resources/img/doc-48.png" alt="df"></a>
                </div>
            </div>
            <div class="col-lg-8 col-lg-offset-1 col-md-8 col-md-offset-1 col-sm-8 about-descr">
                <h3 class="text-center">Hello, visitor!</h3>
                <br>
                <p>My name is Evgeniy, i'm beginner java developer and this is my pet project!</p>
                <p style="text-align: justify">A few months ago I decided to improve my english level and find a pen pal. To my surprise it was not so easy as I expected. Most services were paid, inconvenient in use, or have a small online. This gave me an idea to create my own language service. I took the example of <a href="https://www.mylanguageexchange.com/">this</a>, set tasks and began to work...</p>
                <p>And as you can see I got it! I called it flangex, as an abbreviation of Free Language Exchange.</p>
                <p><span class="theme-green"><b>Flangex</b></span> - Java Enterprise project with a registration / authorization and role-based interface (USER, ADMIN).
                <p>The main objective of the project to give the visitor a free and easy way to find a pen pal. All that he needs is to enter search criteria and select the speaker. Service only provide the contact details - user decide where he prefer to communicate with his partner. In our case its email and 6 most popular socials.</p>
                <p>The administrator can create / edit / delete users and filter them by contact details using admin panel.</p>
                <p>The user can manage your profile and data(entered contact details during registration).</p>
                <p><i>All interface covered by JUnit tests using Spring MVC Test and Spring Security Test.</i></p>
                <p>Stack of technologies used in the project: Spring, Spring Security, Spring MVC, Hibernate, Java 8, HTML, CSS, JS, JQuery, Datatables, Bootstrap, Log4j, JUnit, Spring Tests, Hibernate Validation, JSP, JSTL, TomCat, MySQL, Postgres, HSQL, Maven, Git.</p>
                <p>Project sources you can find here: <a href="https://github.com/Eugene1992/flangex"><i class="fa fa-lg fa-github" id="git-repo-logo"></i></a></p>
            </div>
        </div>
        <div class="row tech-stack-img-row">
            <div class="col-lg-2 col-md-3 col-sm-4 col-xs-6">
                <img class="tech-stack-img center-block" src="${param.contextPath}/resources/img/about/spring-logo.png" alt="spring-logo">
            </div>
            <div class="col-lg-2 col-md-3 col-sm-4 col-xs-6">
                <img class="tech-stack-img center-block" src="${param.contextPath}/resources/img/about/spring-security-logo.png" alt="spring-security-logo">
            </div>
            <div class="col-lg-2 col-md-3 col-sm-4 col-xs-6">
                <img class="tech-stack-img center-block" src="${param.contextPath}/resources/img/about/spring-mvc-logo.png" alt="spring-mvc-logo">
            </div>
            <div class="col-lg-2 col-md-3 col-sm-4 col-xs-6">
                <img class="tech-stack-img center-block" src="${param.contextPath}/resources/img/about/html-css-js-logo.png" alt="html-css-js-logo">
            </div>
            <div class="col-lg-2 col-md-3 col-sm-4 col-xs-6">
                <img class="tech-stack-img center-block" src="${param.contextPath}/resources/img/about/bootstrap-logo.png" alt="bootstrap-logo">
            </div>
            <div class="col-lg-2 col-md-3 col-sm-4 col-xs-6">
                <img class="tech-stack-img center-block" src="${param.contextPath}/resources/img/about/git-github-logo.jpg" alt="git-github-logo">
            </div>
            <div class="col-lg-2 col-md-3 col-sm-4 col-xs-6">
                <img class="tech-stack-img center-block" src="${param.contextPath}/resources/img/about/hibernate-logo.png" alt="hibernate-logo">
            </div>
            <div class="col-lg-2 col-md-3 col-sm-4 col-xs-6">
                <img class="tech-stack-img center-block" src="${param.contextPath}/resources/img/about/mysql-logo.png" alt="my-sql-logo">
            </div>
            <div class="col-lg-2 col-md-3 col-sm-4 col-xs-6">
                <img class="tech-stack-img center-block" src="${param.contextPath}/resources/img/about/postgres-logo.png" alt="postgres-logo">
            </div>
            <div class="col-lg-2 col-md-3 col-sm-4 col-xs-6">
                <img class="tech-stack-img center-block" src="${param.contextPath}/resources/img/about/hsql-logo.jpg" alt="hsql-logo">
            </div>
            <div class="col-lg-2 col-md-3 col-sm-4 col-xs-6">
                <img class="tech-stack-img center-block" src="${param.contextPath}/resources/img/about/maven-logo.png" alt="maven-logo">
            </div>
            <div class="col-lg-2 col-md-3 col-sm-4 col-xs-6">
                <img class="tech-stack-img center-block" src="${param.contextPath}/resources/img/about/jsp-logo.png" alt="jsp-logo">
            </div>
            <div class="col-lg-2 col-md-3 col-sm-4 col-xs-6">
                <img class="tech-stack-img center-block" src="${param.contextPath}/resources/img/about/java8-logo.png" alt="java8-logo">
            </div>
            <div class="col-lg-2 col-md-3 col-sm-4 col-xs-6">
                <img class="tech-stack-img center-block" src="${param.contextPath}/resources/img/about/log4j-logo.jpg" alt="log4j-logo">
            </div>
            <div class="col-lg-2 col-md-3 col-sm-4 col-xs-6">
                <img class="tech-stack-img center-block" src="${param.contextPath}/resources/img/about/Junit-logo.png" alt="Junit-logo">
            </div>
            <div class="col-lg-2 col-md-3 col-sm-4 col-xs-6">
                <img class="tech-stack-img center-block" src="${param.contextPath}/resources/img/about/tomcat-logo.png" alt="tomcat-logo">
            </div>
            <div class="col-lg-2 col-md-3 col-sm-4 col-xs-6">
                <img class="tech-stack-img center-block" src="${param.contextPath}/resources/img/about/intelij-logo.png" alt="intelij-logo">
            </div>
            <div class="col-lg-2 col-md-3 col-sm-4 col-xs-6">
                <img class="tech-stack-img center-block" src="${param.contextPath}/resources/img/about/mockito-logo.jpg" alt="mockito-logo">
            </div>
        </div>
    </div>
    <tiles:insertAttribute name="footer" />
    <script type="text/javascript" src="${param.contextPath}/resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="${param.contextPath}/resources/js/bootstrap.min.js"></script>
    </body>
</html>
