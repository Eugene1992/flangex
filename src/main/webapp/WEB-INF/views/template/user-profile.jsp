<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 col-xs-offset-0 col-sm-offset-0 col-md-offset-2 col-lg-offset-2 toppad" >
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h3 class="panel-title">${user.firstname} ${user.lastname}</h3>
                                </div>
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-md-3 col-lg-3 " align="center">
                                            <img alt="User Pic" src="${param.contextPath}/resources/img/user-${user.gender}.png" class="img-rounded img-responsive">
                                            <br>
                                            <%--<a href="#" class="btn btn-success btn-sm">Add friend</a>--%>
                                        </div>
                                        <div class=" col-md-9 col-lg-9 ">
                                            <table class="table table-user-information ">
                                                <tbody>
                                                    <tr>
                                                        <td><b>Name:</b></td>
                                                        <td>${user.firstname} ${user.lastname}</td>
                                                    </tr>
                                                    <tr>
                                                        <td><b>Age:</b></td>
                                                        <td>${user.age}</td>
                                                    </tr>
                                                    <tr>
                                                        <td><b>Gender:</b></td>
                                                        <td>${user.gender}</td>
                                                    </tr>

                                                    <tr>
                                                    <tr>
                                                        <td><b>Email:</b></td>
                                                        <td>${user.email}</td>
                                                    </tr>
                                                    <tr>
                                                        <td><b>Location:</b></td>
                                                        <td>${user.country}</td>
                                                    </tr>
                                                    <tr>
                                                        <td><b>About me:</b></td>
                                                        <td>${user.description}</td>
                                                    </tr>
                                                    <tr>
                                                        <td><b>Native lang's:</b></td>
                                                        <td>
                                                            <c:forEach items="${user.nativeLanguages}" var="lang" varStatus="status">
                                                                <c:out value="${lang}"/><c:if test="${!status.last}">,</c:if>
                                                            </c:forEach>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><b>Practicing lang's:</b></td>
                                                        <td>
                                                            <c:forEach items="${user.practicingLanguages}" var="lang" varStatus="status">
                                                                <c:out value="${lang}"/><c:if test="${!status.last}">,</c:if>
                                                            </c:forEach>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><b>Socials:</b></td>
                                                        <td>
                                                            <div class="social">
                                                                <c:if test="${not empty user.facebookLink}">
                                                                    <a href="${user.facebookLink}"><i class="fa fa-lg fa-facebook"></i></a>
                                                                </c:if>
                                                                <c:if test="${not empty user.googlePlusLink}">
                                                                    <a href="${user.googlePlusLink}"><i class="fa fa-lg fa-google-plus"></i></a>
                                                                </c:if>
                                                                <c:if test="${not empty user.vkontakteLink}">
                                                                    <a href="${user.vkontakteLink}"><i class="fa fa-lg fa-lg fa-vk"></i></a>
                                                                </c:if>
                                                                <c:if test="${not empty user.twitterLink}">
                                                                    <a href="${user.twitterLink}"><i class="fa fa-lg fa-twitter"></i></a>
                                                                </c:if>
                                                                <c:if test="${not empty user.instagramLink}">
                                                                    <a href="${user.instagramLink}"><i class="fa fa-lg fa-instagram"></i></a>
                                                                </c:if>
                                                                <c:if test="${not empty user.linkedInLink}">
                                                                    <a href="${user.linkedInLink}"><i class="fa fa-lg fa-linkedin"></i></a>
                                                                </c:if>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <tiles:insertAttribute name="footer" />

        <script type="text/javascript" src="${param.contextPath}/resources/js/jquery.min.js"></script>
        <script type="text/javascript" src="${param.contextPath}/resources/js/bootstrap.min.js"></script>
    </body>
</html>
