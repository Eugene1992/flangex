<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<section id="register">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2><spring:message code="message.register.form.title"/></h2>
                <hr class="star-primary">
            </div>
        </div>
        <div class="row" >
            <div class="col-lg-8 col-lg-offset-2">
                <form:form action="/register" method="POST" id="contactForm" modelAttribute="user">
                    <div class="row control-group reg-form-row">
                        <%-- Firstname --%>
                        <div class="form-group col-xs-6 controls">
                            <spring:message code="message.register.form.firstaname" var="firstname"/>
                            <form:input type="text" class="form-control" placeholder="${firstname}" path="firstname" />
                            <form:errors cssClass="label label-danger" path="firstname"/>
                        </div>
                        <%-- Last name --%>
                        <div class="form-group col-xs-6 controls">
                            <spring:message code="message.register.form.lastname" var="lastname"/>
                            <form:input type="text" class="form-control" placeholder="${lastname}" path="lastname"/>
                            <form:errors cssClass="label label-danger" path="lastname"/>
                        </div>
                    </div>
                    <div class="row control-group reg-form-row">
                        <%-- Password --%>
                        <div class="form-group col-xs-6 controls">
                            <spring:message code="message.register.form.password" var="password"/>
                            <form:input type="text" class="form-control" placeholder="${password}" path="password" />
                            <form:errors cssClass="label label-danger" path="password"/>
                        </div>
                        <%-- Re-Password --%>
                        <div class="form-group col-xs-6 controls">
                            <spring:message code="message.register.form.re-password" var="repassword"/>
                            <form:input type="text" class="form-control" placeholder="${repassword}" path="confirmedPassword" />
                            <form:errors cssClass="label label-danger" path="confirmedPassword"/>
                        </div>
                    </div>
                    <div class="row control-group reg-form-row">
                        <%-- Email --%>
                        <div class="form-group col-xs-6 controls">
                            <spring:message code="message.register.form.email" var="email"/>
                            <form:input type="text" class="form-control" placeholder="${email}" path="email" />
                            <form:errors cssClass="label label-danger" path="email"/>
                        </div>
                        <%-- Age --%>
                        <div class="form-group col-xs-3 controls">
                            <spring:message code="message.register.form.age" var="age"/>
                            <form:input type="number" class="form-control" placeholder="${age}" path="age" />
                            <form:errors cssClass="label label-danger" path="age"/>
                        </div>
                        <%-- Gender --%>
                        <div class="form-group col-xs-3 floating-label-form-group controls">
                            <form:select class="form-control"  path="gender" >
                                <option disabled selected><spring:message code="message.register.form.gender" /></option>
                                <form:option value="Male" />
                                <form:option value="Female" />
                            </form:select>
                            <form:errors cssClass="label label-danger" path="gender"/>
                        </div>
                    </div>
                    <div class="row control-group reg-form-row">
                        <%-- Country --%>
                        <div class="form-group col-xs-6 floating-label-form-group controls">
                            <spring:message code="message.register.form.country" var="country"/>
                            <form:select class="form-control"  path="country">
                                <option disabled selected><spring:message code="message.register.form.country" /></option>
                                <form:options items="${countryList}"/>
                            </form:select>
                            <form:errors cssClass="label label-danger" path="country"/>
                        </div>
                        <%-- City --%>
                        <div class="form-group col-xs-6 controls">
                            <spring:message code="message.register.form.city" var="city"/>
                            <form:input type="text" class="form-control" placeholder="${city}"  path="city"/>
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>
                    <div class="row control-group reg-form-row">
                        <%-- Native language(s) --%>
                        <div class="form-group col-xs-6 floating-label-form-group controls">
                            <spring:message code="message.register.form.native-langs" var="nativeLangs"/>
                            <form:select class="form-control" size="6" path="nativeLanguages" multiple="true">
                                <option class="langs-first-option" disabled>${nativeLangs}:</option>
                                <form:options items="${languageList}"/>
                            </form:select>
                            <form:errors cssClass="label label-danger" path="nativeLanguages"/>
                        </div>
                        <%-- Practicing language(s) --%>
                        <div class="form-group col-xs-6 floating-label-form-group controls">
                            <spring:message code="message.register.form.practicing-langs" var="practLangs"/>
                            <form:select class="form-control" size="6" path="practicingLanguages" multiple="true">
                                <option class="langs-first-option" disabled>${practLangs}:</option>
                                <form:options items="${languageList}"/>
                            </form:select>
                            <form:errors cssClass="label label-danger" path="practicingLanguages"/>
                        </div>
                    </div>

                    <div class="row control-group reg-form-row">
                        <%-- Description --%>
                        <div class="form-group col-xs-12 controls" id="tell-us-area">
                            <spring:message code="message.register.form.tell-about" var="tellAbout"/>
                            <form:textarea rows="3" class="form-control" placeholder="${tellAbout}" id="message" path="description"/>
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>

                    <div class="row control-group reg-form-row">
                        <%-- Facebook Link --%>
                        <div class="input-group col-xs-6 socials controls">
                            <span class="input-group-addon" id="facebook-addon"><i class="fa fa-facebook"></i></span>
                            <spring:message code="message.register.form.facebook-link" var="facebookLink"/>
                            <form:input type="text" id="facebook-input" class="form-control" placeholder="${facebookLink}" path="facebookLink" />
                            <form:errors cssClass="label label-danger" path="facebookLink"/>
                        </div>
                        <%-- LinkedIn Link --%>
                        <div class="input-group col-xs-6 socials controls">
                            <span class="input-group-addon" id="linkedin-addon"><i class="fa fa-linkedin"></i></span>
                            <spring:message code="message.register.form.linkedin-link" var="linkedinLink"/>
                            <form:input type="text" id="linkedin-input" class="form-control" placeholder="${linkedinLink}"  path="linkedInLink" />
                        </div>
                    </div>

                    <div class="row control-group reg-form-row">
                        <%-- Google Plus Link --%>
                        <div class="input-group col-xs-6 socials controls">
                            <span class="input-group-addon" id="google-plus-addon"><i class="fa fa-google-plus"></i></span>
                            <spring:message code="message.register.form.google-plus-link" var="googlePlusLink"/>
                            <form:input type="text" id="google-plus-input" class="form-control" placeholder="${googlePlusLink}"  path="googlePlusLink" />
                        </div>
                        <%-- VKontakte Link --%>
                        <div class="input-group col-xs-6 socials controls">
                            <span class="input-group-addon" id="vk-addon"><i class="fa fa-vk"></i></span>
                            <spring:message code="message.register.form.vk-link" var="vkLink"/>
                            <form:input type="text" id="vk-input" class="form-control" placeholder="${vkLink}"  path="vkontakteLink" />
                        </div>
                    </div>

                    <div class="row control-group reg-form-row">
                        <%-- Twitter Link --%>
                        <div class="input-group col-xs-6 socials controls">
                            <span class="input-group-addon" id="twitter-addon"><i class="fa fa-twitter"></i></span>
                            <spring:message code="message.register.form.twitter-link" var="twitterLink"/>
                            <form:input type="text" id="twitter-input" class="form-control" placeholder="${twitterLink}"  path="twitterLink" />
                        </div>
                        <%-- Instagram Link --%>
                        <div class="input-group col-xs-6 socials controls">
                            <span class="input-group-addon" id="instagram-addon"><i class="fa fa-instagram" aria-hidden="true"></i></span>
                            <spring:message code="message.register.form.instagram-link" var="instagramLink"/>
                            <form:input type="text" id="instagram-input" class="form-control" placeholder="${instagramLink}"  path="instagramLink" />
                        </div>
                    </div>
                    <br>
                    <div id="success"></div>
                    <div class="row">
                        <div class="form-group col-xs-12">
                            <button type="submit" class="btn btn-success btn-lg center-block" id="reg-btn"><spring:message code="message.register.form.btn"/></button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>