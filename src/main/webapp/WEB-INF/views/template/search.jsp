<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Free Language Exchange</title>
        <link rel="stylesheet" href="${param.contextPath}/resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="${param.contextPath}/resources/css/style.css">
        <link rel="stylesheet" href="${param.contextPath}/resources/css/font-awesome.min.css">
        <link rel="stylesheet" href="${param.contextPath}/resources/css/bootstrap-glyphicons.css">
        <link rel="stylesheet" href="${param.contextPath}/resources/css/dataTables.bootstrap.min.css">
    </head>
    <body>
        <tiles:insertAttribute name="header" />
        <div class="container">
            <div class="row">
                <div class="col-lg-4 search-form" style="<%--background-color: #0f7864;--%>">
                    <form action="/searching" method="GET">
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
                            <input type="number" min="0" name="age-from" placeholder="from" class="form-control input-sm" id="age-from">
                        </div>
                        <div class="form-group col-lg-6 controls">
                            <label for="age-to"><span style="color: #E6E3E3">Age</span></label>
                            <input type="number" min="0" name="age-to" placeholder="to" class="form-control input-sm" id="age-to">
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
                                <c:forEach items="${languageList}" var="lang">
                                    <option value="${lang}">${lang}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-lg-6 controls">
                            <label for="practicing-language">Practicing language</label>
                            <select name="practicing-language" class="form-control input-sm" id="practicing-language">
                                <c:forEach items="${languageList}" var="lang">
                                    <option value="${lang}">${lang}</option>
                                </c:forEach>
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
                    <table class="table table-striped" id="users-table">
                        <thead>
                            <tr>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${usersList}" var="userData">
                            <c:forEach items="${userData}" var="user" varStatus="nested">
                                <c:if test="${nested.index == 0}">
                                <tr>
                                    <td width="120px" class="text-center">
                                        <img height="150px" style="float: left; margin: 0 0 0 5px;" alt="User Pic" src="${param.contextPath}/resources/img/user-${user.gender}.png" class="img-rounded img-responsive">
                                        <%--<a href="#" class="btn btn-success btn-sm" style="text-align: center">Add friend</a>--%>
                                    </td>
                                    <td>
                                        <div>
                                            <table class="table table-striped table-bordered">
                                                <tbody>
                                                    <tr>
                                                        <td width="190px">Name:</td>
                                                        <td>${user.firstname} ${user.lastname}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Age:</td>
                                                        <td>${user.age}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Gender:</td>
                                                        <td>${user.gender}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Email:</td>
                                                        <td>${user.email}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Location:</td>
                                                        <td>${user.country}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>About me:</td>
                                                        <td>${user.description}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Native lang's:</td>
                                                        <td>
                                                            <c:forEach items="${user.nativeLanguages}" var="lang" varStatus="status">
                                                                <c:out value="${lang}"/><c:if test="${!status.last}">,</c:if>
                                                            </c:forEach>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Practicing lang's:</td>
                                                        <td>
                                                            <c:forEach items="${user.practicingLanguages}" var="lang" varStatus="status">
                                                                <c:out value="${lang}"/><c:if test="${!status.last}">,</c:if>
                                                            </c:forEach>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Socials:</td>
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
                                    </td>
                                </tr>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <tiles:insertAttribute name="footer" />

        <script type="text/javascript" src="${param.contextPath}/resources/js/jquery.min.js"></script>
        <script type="text/javascript" src="${param.contextPath}/resources/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="${param.contextPath}/resources/js/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript" src="${param.contextPath}/resources/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
        <script>
            $(document).ready(function() {
                $('#users-table').DataTable( {
                    "pagingType": "full_numbers",
                    "paging":   true,
                    "ordering": false
                } );
            } );

            $(document).ready(function() {
                var lang = window.location.href.split('?lang=')[1];
                if (lang === undefined && $.cookie('lang') === null){
                    $.cookie("lang", "ENG");
                } else {
                    if (lang === 'ru') {
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
