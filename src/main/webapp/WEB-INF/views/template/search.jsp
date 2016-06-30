<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title><tiles:insertAttribute name="title" /></title>
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
                <div class="col-lg-4 search-form" style="<%--background-color: #0f7864;--%>">
                    <form action="/search" method="POST">
                        <div class="form-group col-lg-6 controls">
                            <label for="firstname">First name</label>
                            <input type="text" name="firstname" class="form-control input-sm" id="firstname">
                        </div>
                        <div class="form-group col-lg-6 controls">
                            <label for="lastname">Last name</label>
                            <input type="text" name="lastname" class="form-control input-sm" id="lastname">
                        </div>
                        <div class="form-group col-lg-6 controls">
                            <label for="country">Country</label>
                            <input type="text" name="country" class="form-control input-sm" id="country">
                        </div>
                        <div class="form-group col-lg-6 controls">
                            <label for="city">City</label>
                            <input type="text" name="city" class="form-control input-sm" id="city">
                        </div>
                        <div class="form-group col-lg-6 controls">
                            <label for="age-from">Age</label>
                            <input type="number" name="age-from" placeholder="from" class="form-control input-sm" id="age-from">
                        </div>
                        <div class="form-group col-lg-6 controls">
                            <label for="age-to"><span style="color: #E6E3E3">Age</span></label>
                            <input type="number" name="age-to" placeholder="to" class="form-control input-sm" id="age-to">
                        </div>
                        <div class="form-group col-lg-12 controls">
                            <label for="gender">Gender</label>
                            <select name="gender" class="form-control input-sm" id="gender">
                                <option>Male</option>
                                <option>Female</option>
                                <option>Both</option>
                            </select>
                        </div>
                        <div class="form-group col-lg-6 controls">
                            <label for="native-language">Native language</label>
                            <select name="native-language" class="form-control input-sm" id="native-language">
                                <option>All</option>
                                <option>English</option>
                                <option>Ukrainian</option>
                                <option>Russian</option>
                            </select>
                        </div>
                        <div class="form-group col-lg-6 controls">
                            <label for="practicing-language">Practicing language</label>
                            <select name="practicing-language" class="form-control input-sm" id="practicing-language">
                                <option>All</option>
                                <option>English</option>
                                <option>Ukrainian</option>
                                <option>Russian</option>
                            </select>
                        </div>
                        <div class="form-group col-lg-6 controls social-search">
                            <div class="checkbox">
                                <label class="checkbox-inline">
                                    <input name="facebook-check" type="checkbox" value="true"> Facebook
                                </label>
                            </div>
                        </div>
                        <div class="form-group col-lg-6 controls social-search">
                            <div class="checkbox">
                                <label class="checkbox-inline">
                                    <input name="twitter-check" type="checkbox" value="true"> Twitter
                                </label>
                            </div>
                        </div>
                        <div class="form-group col-lg-6 controls social-search">
                            <div class="checkbox">
                                <label class="checkbox-inline">
                                        <input name="instagram-check" type="checkbox" value="true"> Instagram
                                </label>
                            </div>
                        </div>
                        <div class="form-group col-lg-6 controls social-search">
                            <div class="checkbox">
                                <label class="checkbox-inline">
                                    <input name="linkedin-check" type="checkbox" value="true"> LinkedIn
                                </label>
                            </div>
                        </div>
                        <div class="form-group col-lg-6 controls">
                            <div class="checkbox">
                                <label class="checkbox-inline">
                                    <input name="google-plus-check" type="checkbox" value="true"> Google+
                                </label>
                            </div>
                        </div>
                        <div class="form-group col-lg-6 controls">
                            <div class="checkbox">
                                <label class="checkbox-inline">
                                    <input name="vkontakte-check" type="checkbox" value="true"> VKontakte
                                </label>
                            </div>
                        </div>
                        <button class="btn btn-success center-block" type="submit">Search</button>
                    </form>
                </div>
                <div class="col-lg-8 search-result" style="/*background-color: #1c699d;*/ height: 800px">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Firstname</th>
                                <th>Lastname</th>
                                <th>Age</th>
                                <th>Gender</th>
                                <th>Email</th>
                                <th>Password</th>
                                <th>Role</th>
                                <th>Country</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${usersList}" var="user">
                            <tr>
                                <td>${user.id}</td>
                                <td>${user.firstname}</td>
                                <td>${user.lastname}</td>
                                <td>${user.age}</td>
                                <td>${user.gender}</td>
                                <td>${user.email}</td>
                                <td>${user.password}</td>
                                <td>${user.role}</td>
                                <td>${user.country}</td>
                            </tr>
                        </tbody>
                        </c:forEach>
                    </table>
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
