<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
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
                <div class="admin-content table-responsive">
                    <div class="alert alert-success" id="personal-cab-panel">
                        <ul class="nav nav-pills">
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <li><a data-toggle="tab" href="#home"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span> Admin panel</a></li>
                            </sec:authorize>
                            <li class="active"><a data-toggle="tab" href="#menu1"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> Personal data</a></li>
                            <li><a data-toggle="tab" href="#menu2"><span class="glyphicon glyphicon-heart" aria-hidden="true"></span> Friends</a></li>
                            <li><a data-toggle="tab" href="#menu3"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Settings</a></li>
                            <li class="pull-right"><a href="j_spring_security_logout"><span class="glyphicon glyphicon-share" aria-hidden="true"></span> Logout</a></li>
                        </ul>
                    </div>
                    <div class="tab-content">
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <div id="home" class="tab-pane fade">
                            <table id="users-table" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                <thead>
                                <tr class="info">
                                    <th>Id</th>
                                    <th>Firstname</th>
                                    <th>Age</th>
                                    <th>Gender</th>
                                    <th>Email</th>
                                    <th>Role</th>
                                    <th>Country</th>
                                    <th>Update</th>
                                    <th>Delete</th>
                                    <th>Profile</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${usersList}" var="user">
                                    <jsp:useBean id="user" scope="page" type="ua.com.flangex.model.User"/>
                                    <tr>
                                        <td>${user.id}</td>
                                        <td>${user.firstname}</td>
                                        <td>${user.age}</td>
                                        <td>${user.gender}</td>
                                        <td>${user.email}</td>
                                        <td>${user.role}</td>
                                        <td>${user.country}</td>
                                        <td><button type="button" style="width: 100%" class="btn btn-info btn-xs" data-toggle="modal" data-target="#userModal${user.id}">Update</button></td>
                                        <td><button type="button" style="width: 100%" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#confirm-delete-user${user.id}">Delete</button></td>
                                        <td><a href="/user/${user.id}" style="width: 100%" class="btn btn-success btn-xs" role="button">View</a></td>
                                    </tr>
                                    <div id="confirm-delete-user${user.id}" class="modal fade confirm-delete" role="dialog">
                                        <div class="modal-dialog">
                                            <div class="modal-content modal-sm">
                                                <div class="modal-body">
                                                    <p>Do you really want to delete user ${user.firstname}?</p>
                                                </div>
                                                <div class="modal-footer">
                                                    <a href="/remove/${user.id}">
                                                        <button style="width: 49%;" type="button" class="btn btn-sm btn-danger"><i class="fa fa-check" aria-hidden="true"></i> Yes</button>
                                                    </a>
                                                    <button style="width: 49%;" type="button" data-dismiss="modal" class="btn btn-sm btn-info"><i class="fa fa-times" aria-hidden="true"></i> No</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Modal -->
                                    <div class="modal fade" id="userModal${user.id}" role="dialog">
                                        <div class="modal-dialog modal-lg">
                                            <form:form cssClass="form-horizontal" method="post" action="/update/${user.id}" modelAttribute="user" role="form">
                                            <!-- Modal content-->
                                            <div class="modal-content">
                                                <div class="modal-header" style="background-color: #18BC9C">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">${user.firstname} ${user.lastname}</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="form-group form-group-sm col-md-6">
                                                        <form:label path="firstname">First Name:</form:label>
                                                        <form:input path="firstname" class="form-control" value="${user.firstname}"/>
                                                    </div>
                                                    <div class="form-group form-group-sm col-md-6">
                                                        <form:label path="lastname">Last Name:</form:label>
                                                        <form:input path="lastname" class="form-control" value="${user.lastname}"/>
                                                    </div>
                                                    <div class="form-group form-group-sm col-md-6">
                                                        <form:label path="password">Password:</form:label>
                                                        <form:input path="password" class="form-control" value="${user.password}"/>
                                                    </div>
                                                    <div class="form-group form-group-sm col-md-6">
                                                        <form:label path="password">Confirm password:</form:label>
                                                        <form:input path="confirmedPassword" class="form-control" value="${user.confirmedPassword}"/>
                                                    </div>
                                                    <div class="form-group form-group-sm col-md-6">
                                                        <form:label path="email">Email:</form:label>
                                                        <form:input path="email" class="form-control" value="${user.email}"/>
                                                    </div>
                                                    <div class="form-group form-group-sm col-md-3">
                                                        <form:label path="age">Age:</form:label>
                                                        <form:input type="number" min="0" max="120" path="age" class="form-control" value="${user.age}"/>
                                                    </div>
                                                    <div class="form-group form-group-sm col-md-3">
                                                        <form:label path="gender">Gender:</form:label>
                                                        <form:select path="gender" class="form-control" >
                                                            <c:choose>
                                                                <c:when test="${user.gender=='Male'}">
                                                                    <option selected>Male</option>
                                                                    <option >Female</option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option selected>Female</option>
                                                                    <option>Male</option>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </form:select>
                                                    </div>
                                                    <form:hidden path="nativeLanguages" value="${user.nativeLanguages}"/>
                                                    <form:hidden path="practicingLanguages" value="${user.practicingLanguages}"/>
                                                    <div class="form-group form-group-sm col-md-4">
                                                        <form:label path="country">Country:</form:label>
                                                        <form:input path="country" class="form-control" value="${user.country}"/>
                                                    </div>
                                                    <div class="form-group form-group-sm col-md-4">
                                                        <form:label path="city">City:</form:label>
                                                        <form:input path="city" class="form-control" value="${user.city}"/>
                                                    </div>
                                                    <div class="form-group form-group-sm col-md-4">
                                                        <form:label path="role">Role:</form:label>
                                                        <form:select path="role" class="form-control" >
                                                            <c:choose>
                                                                <c:when test="${user.role=='ROLE_USER'}">
                                                                    <option selected>ROLE_USER</option>
                                                                    <option >ROLE_ADMIN</option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option selected>ROLE_ADMIN</option>
                                                                    <option>ROLE_USER</option>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </form:select>
                                                    </div>
                                                    <div class="form-group form-group-sm col-md-12">
                                                        <form:label path="city">Description:</form:label>
                                                        <form:textarea path="description" rows="3" class="form-control" type="text"/>
                                                    </div>
                                                    <div class="form-group form-group-sm col-md-4">
                                                        <form:label path="facebookLink">Facebook:</form:label>
                                                        <form:input path="facebookLink" class="form-control" value="${user.facebookLink}"/>
                                                    </div>
                                                    <div class="form-group form-group-sm col-md-4">
                                                        <form:label path="twitterLink">Twitter:</form:label>
                                                        <form:input path="twitterLink" class="form-control" value="${user.twitterLink}"/>
                                                    </div>
                                                    <div class="form-group form-group-sm col-md-4">
                                                        <form:label path="googlePlusLink">Google plus:</form:label>
                                                        <form:input path="googlePlusLink" class="form-control" value="${user.googlePlusLink}"/>
                                                    </div>
                                                    <div class="form-group form-group-sm col-md-4">
                                                        <form:label path="instagramLink">Instagram:</form:label>
                                                        <form:input path="instagramLink" class="form-control" value="${user.instagramLink}"/>
                                                    </div>
                                                    <div class="form-group form-group-sm col-md-4">
                                                        <form:label path="vkontakteLink">VKontakte:</form:label>
                                                        <form:input path="vkontakteLink" class="form-control" value="${user.vkontakteLink}"/>
                                                    </div>
                                                    <div class="form-group form-group-sm col-md-4">
                                                        <form:label path="linkedInLink">LinkedIn:</form:label>
                                                        <form:input path="linkedInLink" class="form-control" value="${user.linkedInLink}"/>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="submit" class="btn btn-sm btn-success center-block"> Update </button>
                                                </div>
                                            </div>
                                            </form:form>
                                        </div>
                                    </div>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        </sec:authorize>
                        <div id="menu1" class="tab-pane fade in active">
                            <div class="row">
                                <div class="col-md-3 col-md-offset-1">
                                    <img src="${param.contextPath}/resources/img/user-Male.png" alt="user-picture" class="img-responsive img-rounded user-logo-img">
                                    <br>
                                    <div class="text-center">
                                        <button style="width: 49%;" class="btn btn-sm btn-success " data-toggle="modal" data-target="#authUserModal">Edit profile</button>
                                        <button style="width: 49%;" class="btn btn-sm btn-danger" data-toggle="modal" data-target="#confirm-delete-user">Delete profile</button>
                                    </div>
                                </div>
                                <div class="col-md-6 col-md-offset-1">
                                    <table class="table table-bordered">
                                        <tbody>
                                            <tr>
                                                <td><b>Name:</b></td>
                                                <td>${authUser.firstname} ${authUser.lastname}</td>
                                            </tr>
                                            <tr>
                                                <td><b>Age:</b></td>
                                                <td>${authUser.age}</td>
                                            </tr>
                                            <tr>
                                                <td><b>Gender:</b></td>
                                                <td>${authUser.gender}</td>
                                            </tr>
                                            <tr>
                                            <tr>
                                                <td><b>Email:</b></td>
                                                <td>${authUser.email}</td>
                                            </tr>
                                            <tr>
                                                <td><b>Password:</b></td>
                                                <td>${authUser.password}</td>
                                            </tr>
                                            <tr>
                                                <td><b>Country:</b></td>
                                                <td>${authUser.country}</td>
                                            </tr>
                                            <tr>
                                                <td><b>City:</b></td>
                                                <td>${authUser.city}</td>
                                            </tr>
                                            <tr>
                                                <td><b>About me:</b></td>
                                                <td>${authUser.description}</td>
                                            </tr>
                                            <tr>
                                                <td><b>Native lang's:</b></td>
                                                <td>
                                                    <c:forEach items="${authUser.nativeLanguages}" var="lang" varStatus="status">
                                                        <c:out value="${lang}"/><c:if test="${!status.last}">,</c:if>
                                                    </c:forEach>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td><b>Practicing lang's:</b></td>
                                                <td>
                                                    <c:forEach items="${authUser.practicingLanguages}" var="lang" varStatus="status">
                                                        <c:out value="${lang}"/><c:if test="${!status.last}">,</c:if>
                                                    </c:forEach>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td><b>Socials:</b></td>
                                                <td>
                                                    <div class="social">
                                                        <c:if test="${not empty authUser.facebookLink}">
                                                            <a href="${authUser.facebookLink}"><i class="fa fa-lg fa-facebook"></i></a>
                                                        </c:if>
                                                        <c:if test="${not empty authUser.googlePlusLink}">
                                                            <a href="${authUser.googlePlusLink}"><i class="fa fa-lg fa-google-plus"></i></a>
                                                        </c:if>
                                                        <c:if test="${not empty authUser.vkontakteLink}">
                                                            <a href="${authUser.vkontakteLink}"><i class="fa fa-lg fa-lg fa-vk"></i></a>
                                                        </c:if>
                                                        <c:if test="${not empty authUser.twitterLink}">
                                                            <a href="${authUser.twitterLink}"><i class="fa fa-lg fa-twitter"></i></a>
                                                        </c:if>
                                                        <c:if test="${not empty authUser.instagramLink}">
                                                            <a href="${authUser.instagramLink}"><i class="fa fa-lg fa-instagram"></i></a>
                                                        </c:if>
                                                        <c:if test="${not empty authUser.linkedInLink}">
                                                            <a href="${authUser.linkedInLink}"><i class="fa fa-lg fa-linkedin"></i></a>
                                                        </c:if>
                                                    </div>
                                                </td>
                                            </tr>
                                            <div id="confirm-delete-user" class="modal fade confirm-delete" role="dialog">
                                                <div class="modal-dialog">
                                                    <div class="modal-content modal-sm">
                                                        <div class="modal-body">
                                                            <p>Are you sure?</p>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <a href="/profile-delete/${authUser.id}">
                                                                <button style="width: 49%;" type="button" class="btn btn-sm btn-danger"><i class="fa fa-check" aria-hidden="true"></i> Yes</button>
                                                            </a>
                                                            <button style="width: 49%;" type="button" data-dismiss="modal" class="btn btn-sm btn-info"><i class="fa fa-times" aria-hidden="true"></i> No</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="modal fade" id="authUserModal" role="dialog">
                                                <div class="modal-dialog modal-lg">
                                                    <form:form cssClass="form-horizontal" method="post" action="/update/${authUser.id}" modelAttribute="user" role="form">
                                                        <!-- Modal content-->
                                                        <div class="modal-content">
                                                            <div class="modal-header" style="background-color: #18BC9C">
                                                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                                <h4 class="modal-title">${authUser.firstname} ${authUser.lastname}</h4>
                                                            </div>
                                                            <div class="modal-body">
                                                                <div class="form-group form-group-sm col-md-6">
                                                                    <form:label path="firstname">First Name:</form:label>
                                                                    <form:input path="firstname" class="form-control" value="${authUser.firstname}" required="true"/>
                                                                </div>
                                                                <div class="form-group form-group-sm col-md-6">
                                                                    <form:label path="lastname">Last Name:</form:label>
                                                                    <form:input path="lastname" class="form-control" value="${authUser.lastname}"/>
                                                                </div>
                                                                <div class="form-group form-group-sm col-md-6">
                                                                    <form:label path="password">Password:</form:label>
                                                                    <form:input path="password" class="form-control" value="${authUser.password}" required="true"/>
                                                                </div>
                                                                <form:hidden path="role" class="form-control" value="${authUser.role}"/>
                                                                <div class="form-group form-group-sm col-md-6">
                                                                    <form:label path="password">Confirm password:</form:label>
                                                                    <form:input path="confirmedPassword" class="form-control" value="${authUser.confirmedPassword}" required="true"/>
                                                                </div>
                                                                <div class="form-group form-group-sm col-md-6">
                                                                    <form:label path="email">Email:</form:label>
                                                                    <form:input path="email" class="form-control" value="${authUser.email}"/>
                                                                </div>
                                                                <div class="form-group form-group-sm col-md-3">
                                                                    <form:label path="age">Age:</form:label>
                                                                    <form:input type="number" min="0" max="120" path="age" class="form-control" value="${authUser.age}" required="true"/>
                                                                </div>
                                                                <div class="form-group form-group-sm col-md-3">
                                                                    <form:label path="gender">Gender:</form:label>
                                                                    <form:select path="gender" class="form-control" required="true">
                                                                        <c:choose>
                                                                            <c:when test="${authUser.gender=='Male'}">
                                                                                <option selected>Male</option>
                                                                                <option >Female</option>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <option selected>Female</option>
                                                                                <option>Male</option>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </form:select>
                                                                </div>
                                                                <form:hidden path="nativeLanguages" value="${authUser.nativeLanguages}"/>
                                                                <form:hidden path="practicingLanguages" value="${authUser.practicingLanguages}"/>
                                                                <div class="form-group form-group-sm col-md-6">
                                                                    <form:label path="country">Country:</form:label>
                                                                    <form:select path="country" class="form-control" required="true">
                                                                        <c:forEach items="${countryList}" var="country">
                                                                            <c:choose>
                                                                            <c:when test="${authUser.country eq country}">
                                                                                <option selected>${country}</option>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <option>${country}</option>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                        </c:forEach>
                                                                    </form:select>
                                                                </div>
                                                                <div class="form-group form-group-sm col-md-6">
                                                                    <form:label path="city">City:</form:label>
                                                                    <form:input path="city" class="form-control" value="${authUser.city}"/>
                                                                </div>
                                                                <div class="form-group form-group-sm col-md-12">
                                                                    <form:label path="description">Description:</form:label>
                                                                    <form:textarea path="description" rows="3" class="form-control" type="text"/>
                                                                </div>
                                                                <div class="form-group form-group-sm col-md-6">
                                                                    <form:label path="nativeLanguages">Native language(s):</form:label>
                                                                    <form:select path="nativeLanguages" class="form-control" size="6" required="true">
                                                                        <c:forEach items="${languageList}" var="lang">
                                                                            <c:set var="contains" value="false" />
                                                                            <c:forEach items="${authUser.nativeLanguages}" var="natLang">
                                                                                <c:if test="${lang eq natLang}">
                                                                                    <c:set var="contains" value="true" />
                                                                                </c:if>
                                                                            </c:forEach>
                                                                            <c:choose>
                                                                                <c:when test="${contains}">
                                                                                    <option selected>${lang}</option>
                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    <option>${lang}</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </c:forEach>
                                                                    </form:select>
                                                                </div>
                                                                <div class="form-group form-group-sm col-md-6">
                                                                    <form:label path="practicingLanguages">Practicing language(s):</form:label>
                                                                    <form:select path="practicingLanguages" class="form-control" size="6" required="true">
                                                                        <c:forEach items="${languageList}" var="lang">
                                                                            <c:set var="contains" value="false" />
                                                                            <c:forEach items="${authUser.practicingLanguages}" var="practLang">
                                                                                <c:if test="${lang eq practLang}">
                                                                                    <c:set var="contains" value="true" />
                                                                                </c:if>
                                                                            </c:forEach>
                                                                            <c:choose>
                                                                                <c:when test="${contains}">
                                                                                    <option selected>${lang}</option>
                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    <option>${lang}</option>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </c:forEach>
                                                                    </form:select>
                                                                </div>
                                                                <div class="form-group form-group-sm col-md-4">
                                                                    <form:label path="facebookLink">Facebook:</form:label>
                                                                    <form:input path="facebookLink" class="form-control" value="${authUser.facebookLink}"/>
                                                                </div>
                                                                <div class="form-group form-group-sm col-md-4">
                                                                    <form:label path="twitterLink">Twitter:</form:label>
                                                                    <form:input path="twitterLink" class="form-control" value="${authUser.twitterLink}"/>
                                                                </div>
                                                                <div class="form-group form-group-sm col-md-4">
                                                                    <form:label path="googlePlusLink">Google plus:</form:label>
                                                                    <form:input path="googlePlusLink" class="form-control" value="${authUser.googlePlusLink}"/>
                                                                </div>
                                                                <div class="form-group form-group-sm col-md-4">
                                                                    <form:label path="instagramLink">Instagram:</form:label>
                                                                    <form:input path="instagramLink" class="form-control" value="${authUser.instagramLink}"/>
                                                                </div>
                                                                <div class="form-group form-group-sm col-md-4">
                                                                    <form:label path="vkontakteLink">VKontakte:</form:label>
                                                                    <form:input path="vkontakteLink" class="form-control" value="${authUser.vkontakteLink}"/>
                                                                </div>
                                                                <div class="form-group form-group-sm col-md-4">
                                                                    <form:label path="linkedInLink">LinkedIn:</form:label>
                                                                    <form:input path="linkedInLink" class="form-control" value="${authUser.linkedInLink}"/>
                                                                </div>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button type="submit" class="btn btn-sm btn-success center-block"> Update </button>
                                                            </div>
                                                        </div>
                                                    </form:form>
                                                </div>
                                            </div>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div id="menu2" class="tab-pane fade">
                            <h3>Friends</h3>
                            <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
                        </div>
                        <div id="menu3" class="tab-pane fade">
                            <h3>Settings</h3>
                            <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
                        </div>
                    </div>

                    <script type="text/javascript" src="${param.contextPath}/resources/js/jquery.min.js"></script>
                    <script type="text/javascript" src="${param.contextPath}/resources/js/jquery.dataTables.min.js"></script>
                    <script type="text/javascript" src="${param.contextPath}/resources/js/dataTables.bootstrap.min.js"></script>
                    <script type="text/javascript" src="${param.contextPath}/resources/js/bootstrap.min.js"></script>
                    <script>
                        $(document).ready(function() {
                            $('#users-table').DataTable( {
                                "pagingType": "full_numbers"
                            } );
                        } );
                    </script>
                </div>
            </div>
        </div>
    <tiles:insertAttribute name="footer" />
    </body>
</html>
