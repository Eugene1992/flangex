<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<header>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <img class="img-responsive" src="${param.contextPath}/resources/img/logo-lg.png" alt="">
                <hr>
                <div class="intro-text">
                    <span class="name">Free Language Exchange</span>
                    <span class="skills"><spring:message code="message.main.slogan"/></span>
                    <hr>
                    <p><a href="/search" class="btn btn-lg btn-primary"><spring:message code="message.find.friends"/></a></p>
                </div>
            </div>
        </div>
    </div>
</header>
