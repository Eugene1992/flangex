<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
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
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h3 class="panel-title">${user.firstname} ${user.lastname}</h3>
                                </div>
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-md-3 col-lg-3 " align="center">
                                            <img alt="User Pic" src="https://pp.vk.me/c622031/v622031947/547e7/KTtaUImch4E.jpg" class="img-rounded img-responsive">
                                            <br>
                                            <a href="#" class="btn btn-success btn-sm">Add friend</a>
                                        </div>
                                        <div class=" col-md-9 col-lg-9 ">
                                            <table class="table table-user-information ">
                                                <tbody>
                                                    <tr>
                                                        <td>Name:</td>
                                                        <td>${user.firstname} ${user.lastname}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Age</td>
                                                        <td>${user.age}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Gender</td>
                                                        <td>${user.gender}</td>
                                                    </tr>

                                                    <tr>
                                                    <tr>
                                                        <td>Email</td>
                                                        <td>${user.email}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Location</td>
                                                        <td>${user.country}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>About me</td>
                                                        <td>${user.description}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Socials</td>
                                                        <td>
                                                                <a href="#" class="btn btn-primary btn-xs"><i class="fa fa-google-plus"></i></a>
                                                                <a href="#" class="btn btn-primary btn-xs"><i class="fa fa-vk"></i></a>
                                                                <a href="#" class="btn btn-primary btn-xs"><i class="fa fa-twitter"></i></a>
                                                                <a href="#" class="btn btn-primary btn-xs"><i class="fa fa-facebook"></i></a>
                                                                <a href="#" class="btn btn-primary btn-xs"><i class="fa fa-instagram"></i></a>
                                                                <a href="#" class="btn btn-primary btn-xs"><i class="fa fa-linkedin"></i></a>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <%--<a href="#" class="btn btn-primary">My Sales Performance</a>--%>
                                            <%--<a href="#" class="btn btn-primary">Team Sales Performance</a>--%>

                                            <%--<div class="social">
                                                                    <ul>
                                                                        <li><a href="#"><i class="fa fa-lg fa-facebook"></i></a></li>
                                                                        <li><a href="#"><i class="fa fa-lg fa-twitter"></i></a></li>
                                                                        <li><a href="#"><i class="fa fa-lg fa-google-plus"></i></a></li>
                                                                        <li><a href="#"><i class="fa fa-lg fa-github"></i></a></li>
                                                                        <li><a href="#"><i class="fa fa-lg fa-pinterest"></i></a></li>
                                                                        <li><a href="#"><i class="fa fa-lg fa-linkedin"></i></a></li>
                                                                        <li><a href="#"><i class="fa fa-lg fa-flickr"></i></a></li>
                                                                        <li><a href="#"><i class="fa fa-lg fa-instagram"></i></a></li>
                                                                        <li><a href="#"><i class="fa fa-lg fa-vimeo-square"></i></a></li>
                                                                        <li><a href="#"><i class="fa fa-lg fa-stack-overflow"></i></a></li>
                                                                        <li><a href="#"><i class="fa fa-lg fa-dropbox"></i></a></li>
                                                                        <li><a href="#"><i class="fa fa-lg fa-tumblr"></i></a></li>
                                                                        <li><a href="#"><i class="fa fa-lg fa-dribbble"></i></a></li>
                                                                        <li><a href="#"><i class="fa fa-lg fa-skype"></i></a></li>
                                                                        <li><a href="#"><i class="fa fa-lg fa-stack-exchange"></i></a></li>
                                                                        <li><a href="#"><i class="fa fa-lg fa-youtube"></i></a></li>
                                                                        <li><a href="#"><i class="fa fa-lg fa-xing"></i></a></li>
                                                                        <li><a href="#"><i class="fa fa-lg fa-rss"></i></a></li>
                                                                        <li><a href="#"><i class="fa fa-lg fa-foursquare"></i></a></li>
                                                                        <li><a href="#"><i class="fa fa-lg fa-youtube-play"></i></a></li>
                                                                    </ul>
                                                                </div>--%>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-footer">
                                    <a href="/profile" type="button" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-list"></i></a>
                                    <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                                        <span class="pull-right">
                                            <a href="" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
                                            <a href="/remove/${user.id}" data-original-title="Remove this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
                                        </span>
                                    </sec:authorize>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <tiles:insertAttribute name="footer" />
        <!-- JQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </body>
</html>
