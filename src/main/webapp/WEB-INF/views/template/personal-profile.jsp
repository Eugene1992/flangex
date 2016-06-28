<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>Free Language Exchange</title>
        <!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
        <link rel="stylesheet" href="../../../resources/css/bootstrap.min.css">
        <!-- Custom Fonts -->
        <link href="../../../resources/css/style.css" rel="stylesheet">
        <!-- Custom Fonts -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
        <%-- Glyphicons --%>
        <link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">

        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css">
        <script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
        <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
    <tiles:insertAttribute name="header" />
        <div class="container">
            <div class="row">
                <div class="admin-content table-responsive">
                    <div class="alert alert-success" id="personal-cab-panel">
                        <ul class="nav nav-pills">
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <li class="active"><a data-toggle="tab" href="#home"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span> Admin panel</a></li>
                            </sec:authorize>
                            <li><a data-toggle="tab" href="#menu1"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> Personal data</a></li>
                            <li><a data-toggle="tab" href="#menu2"><span class="glyphicon glyphicon-heart" aria-hidden="true"></span> Friends</a></li>
                            <li><a data-toggle="tab" href="#menu3"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Settings</a></li>
                            <li class="pull-right"><a href="j_spring_security_logout"><span class="glyphicon glyphicon-share" aria-hidden="true"></span> Logout</a></li>
                        </ul>
                    </div>
                    <div class="tab-content">
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <div id="home" class="tab-pane fade in active">
                            <table id="users-table" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                <thead>
                                <tr class="info">
                                    <th>Id</th>
                                    <th>Firstname</th>
                                    <%--<th>Lastname</th>--%>
                                    <th>Age</th>
                                    <th>Gender</th>
                                    <th>Email</th>
                                    <th>Password</th>
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
                                            <%--<td>${user.lastname}</td>--%>
                                        <td>${user.age}</td>
                                        <td>${user.gender}</td>
                                        <td>${user.email}</td>
                                        <td>${user.password}</td>
                                        <td>${user.role}</td>
                                        <td>${user.country}</td>
                                        <td><button type="button" style="width: 100%" class="btn btn-info btn-xs" data-toggle="modal" data-target="#userModal${user.id}">Update</button></td>
                                        <td><a href="/remove/${user.id}" style="width: 100%" class="btn btn-danger btn-xs" role="button">Delete</a></td>
                                        <td><a href="/user/${user.id}" style="width: 100%" class="btn btn-success btn-xs" role="button">View</a></td>
                                    </tr>
                                    <!-- Modal -->
                                    <div class="modal fade" id="userModal${user.id}" role="dialog">
                                        <div class="modal-dialog">
                                            <!-- Modal content-->
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">${user.firstname} ${user.lastname}</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="row">
                                                        <%--<div class="col-md-3 col-lg-3 " align="center">--%>
                                                            <%--<img alt="User Pic" src="https://pp.vk.me/c622031/v622031947/1ce05/87amyV4ec2k.jpg" class="img-thumbnail img-responsive">--%>
                                                        <%--</div>--%>
                                                        <%--<div class=" col-md-9 col-lg-9 ">--%>
                                                            <%--<p>Name - ${user.firstname}</p>                                                        <p>Lastname - ${user.lastname}</p>--%>
                                                            <%--<p>Age - ${user.age}</p>--%>
                                                            <%--<p>Gender - ${user.gender}</p>--%>
                                                            <%--<p>Country - ${user.country}</p>--%>
                                                        <%--</div>--%>
                                                            <form class="form-horizontal" action="" method="post">

                                                                    <!-- Name input-->
                                                                    <div class="form-group form-group-sm">
                                                                        <label class="col-md-2 control-label" for="name">Name</label>
                                                                        <div class="col-md-4">
                                                                            <input id="name" name="name" type="text" value="${user.firstname}" class="form-control">
                                                                        </div>
                                                                    </div>

                                                                    <!-- Email input-->
                                                                    <div class="form-group form-group-sm">
                                                                        <label class="col-md-2 control-label" for="email">Email</label>
                                                                        <div class="col-md-4">
                                                                            <input id="email" name="email" type="text" value="${user.email}" placeholder="Your email" class="form-control">
                                                                        </div>
                                                                    </div>

                                                                <hr>

                                                                    <!-- Message body -->
                                                                    <div class="form-group">
                                                                        <label class="col-md-3 control-label" for="message">Your message</label>
                                                                        <div class="col-md-9">
                                                                            <textarea class="form-control" id="message" name="message" placeholder="Please enter your message here..." rows="5"></textarea>
                                                                        </div>
                                                                    </div>

                                                                    <!-- Form actions -->
                                                                    <div class="form-group">
                                                                        <div class="col-md-12 text-right">
                                                                            <button type="submit" class="btn btn-info btn-sm center-block">Update</button>
                                                                        </div>
                                                                    </div>

                                                            </form>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-sm btn-primary" data-dismiss="modal">Close</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        </sec:authorize>
                        <div id="menu1" class="tab-pane fade">
                            <h3>Personal data</h3>
                            <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
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
