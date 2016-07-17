<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="locale" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/"><img src="${param.contextPath}/resources/img/logo-sm.png" alt="Flagex-logo"></a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="page-scroll">
                    <a href="/search"><spring:message code="message.search"/></a>
                </li>
                <li class="page-scroll">
                    <a href="/register"><spring:message code="message.registration"/></a>
                </li>
                <sec:authorize access="isAnonymous()">
                <li class="dropdown page-scroll">
                    <a href="#" class="dropdown-toggle" id="login-dropdown-btn" data-toggle="dropdown" role="button" aria-expanded="false"><spring:message code="message.login"/></a>
                    <div class="dropdown-menu form-login stop-propagation" role="menu">
                        <form action="j_spring_security_check" method="POST" id="login-form">
                            <div class="form-group form-group-sm">
                                <input type="email" name="user_name" class="form-control" placeholder="Enter email" />
                            </div>
                            <div class="form-group form-group-sm">
                                <input type="password" name="user_password" class="form-control" placeholder="Enter password" />
                            </div>
                                <c:if test="${not empty error}">
                                        <div class="login-err-msg">${error}</div>
                                </c:if>
                            <div class="checkbox login-remember-me">
                                <label><input type="checkbox" name="_spring_security_remember_me" >Remember me</label>
                            </div>
                            <button type="submit" class="btn btn-success btn-block btn-sm"><spring:message code="message.login"/></button>
                        </form>
                    </div>
                </li>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <li class="dropdown page-scroll">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Welcome, <span class="loged-username-greeting"><security:authentication property="principal.username" /><span class="caret"></span></span></a>
                        <ul class="dropdown-menu" id="dropdown-loged-user-menu">
                            <li><a href="/profile">Cabinet<span class="glyphicon glyphicon-user pull-right"></span></a></li>
                            <li><a href="">Settings<span class="glyphicon glyphicon-cog pull-right"></span></a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="j_spring_security_logout">Logout<span class="glyphicon glyphicon-share pull-right"></span></a></li>
                        </ul>
                    </li>
                </sec:authorize>

                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" id="lang-switch"><span id="lang">ENG</span> <span class="caret"></span></a>
                    <ul class="dropdown-menu lang-change" id="dropdown-lang-switch" >
                        <li><a href="?lang=ru">RUS</a></li>
                        <li><a href="?lang=en">ENG</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>