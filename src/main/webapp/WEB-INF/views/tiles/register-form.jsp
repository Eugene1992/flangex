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
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <form:form action="/register" method="POST" id="contactForm" modelAttribute="user">
                    <div class="row control-group">
                        <%-- Firstname --%>
                        <div class="form-group col-xs-6 controls">
                            <spring:message code="message.register.form.firstaname" var="firstname"/>
                            <form:input type="text" class="form-control" placeholder="${firstname}" path="firstname" value="Eugene"/>
                            <form:errors cssClass="label label-danger" path="firstname"/>
                        </div>
                        <%-- Last name --%>
                        <div class="form-group col-xs-6 controls">
                            <spring:message code="message.register.form.lastname" var="lastname"/>
                            <form:input type="text" class="form-control" placeholder="${lastname}" path="lastname"/>
                            <form:errors cssClass="label label-danger" path="lastname"/>
                        </div>
                    </div>
                    <div class="row control-group">
                        <%-- Password --%>
                        <div class="form-group col-xs-6 controls">
                            <spring:message code="message.register.form.password" var="password"/>
                            <form:input type="text" class="form-control" placeholder="${password}" path="password" value="26121992z"/>
                            <form:errors cssClass="label label-danger" path="password"/>
                        </div>
                        <%-- Re-Password --%>
                        <div class="form-group col-xs-6 controls">
                            <spring:message code="message.register.form.re-password" var="repassword"/>
                            <form:input type="text" class="form-control" placeholder="${repassword}" path="confirmedPassword" value="26121992z"/>
                            <form:errors cssClass="label label-danger" path="confirmedPassword"/>
                        </div>
                    </div>
                    <div class="row control-group">
                        <%-- Email --%>
                        <div class="form-group col-xs-6 controls">
                            <spring:message code="message.register.form.email" var="email"/>
                            <form:input type="text" class="form-control" placeholder="${email}" path="email" value="deuneko55@gmail.com"/>
                            <form:errors cssClass="label label-danger" path="email"/>
                        </div>
                        <%-- Age --%>
                        <div class="form-group col-xs-3 controls">
                            <spring:message code="message.register.form.age" var="age"/>
                            <form:input type="number" class="form-control" placeholder="${age}" path="age" value="23"/>
                            <form:errors cssClass="label label-danger" path="age"/>
                        </div>
                        <%-- Gender --%>
                        <div class="form-group col-xs-3 floating-label-form-group controls">
                            <spring:message code="message.register.form.gender" var="gender"/>
                            <form:select class="form-control"  path="gender">
                                <form:option selected="true" disable="true" value="${gender}"/>
                                <form:option value="Male" selected="true" />
                                <form:option value="Female"/>
                            </form:select>
                            <form:errors cssClass="label label-danger" path="gender"/>
                        </div>
                    </div>
                    <div class="row control-group">
                        <%-- Country --%>
                        <div class="form-group col-xs-6 floating-label-form-group controls">
                            <spring:message code="message.register.form.country" var="country"/>
                            <form:select class="form-control"  path="country">
                                <%--<form:option value="-" label="Country" selected="true" disabled="true"/>--%>
                                <%--<form:options items="${countryList}"/>--%>
                                <option disabled selected>${country}</option>
                                <option value="Afganistan" selected>Afghanistan</option>
                                <option value="Albania">Albania</option>
                                <option value="Algeria">Algeria</option>
                                <option value="American Samoa">American Samoa</option>
                                <option value="Andorra">Andorra</option>
                                <option value="Angola">Angola</option>
                                <option value="Anguilla">Anguilla</option>
                                <option value="Antigua &amp; Barbuda">Antigua &amp; Barbuda</option>
                                <option value="Argentina">Argentina</option>
                                <option value="Armenia">Armenia</option>
                                <option value="Aruba">Aruba</option>
                                <option value="Australia">Australia</option>
                                <option value="Austria">Austria</option>
                                <option value="Azerbaijan">Azerbaijan</option>
                                <option value="Bahamas">Bahamas</option>
                                <option value="Bahrain">Bahrain</option>
                                <option value="Bangladesh">Bangladesh</option>
                                <option value="Barbados">Barbados</option>
                                <option value="Belarus">Belarus</option>
                                <option value="Belgium">Belgium</option>
                                <option value="Belize">Belize</option>
                                <option value="Benin">Benin</option>
                                <option value="Bermuda">Bermuda</option>
                                <option value="Bhutan">Bhutan</option>
                                <option value="Bolivia">Bolivia</option>
                                <option value="Bonaire">Bonaire</option>
                                <option value="Bosnia &amp; Herzegovina">Bosnia &amp; Herzegovina</option>
                                <option value="Botswana">Botswana</option>
                                <option value="Brazil">Brazil</option>
                                <option value="British Indian Ocean Ter">British Indian Ocean Ter</option>
                                <option value="Brunei">Brunei</option>
                                <option value="Bulgaria">Bulgaria</option>
                                <option value="Burkina Faso">Burkina Faso</option>
                                <option value="Burundi">Burundi</option>
                                <option value="Cambodia">Cambodia</option>
                                <option value="Cameroon">Cameroon</option>
                                <option value="Canada">Canada</option>
                                <option value="Canary Islands">Canary Islands</option>
                                <option value="Cape Verde">Cape Verde</option>
                                <option value="Cayman Islands">Cayman Islands</option>
                                <option value="Central African Republic">Central African Republic</option>
                                <option value="Chad">Chad</option>
                                <option value="Channel Islands">Channel Islands</option>
                                <option value="Chile">Chile</option>
                                <option value="China">China</option>
                                <option value="Christmas Island">Christmas Island</option>
                                <option value="Cocos Island">Cocos Island</option>
                                <option value="Colombia">Colombia</option>
                                <option value="Comoros">Comoros</option>
                                <option value="Congo">Congo</option>
                                <option value="Cook Islands">Cook Islands</option>
                                <option value="Costa Rica">Costa Rica</option>
                                <option value="Cote DIvoire">Cote D'Ivoire</option>
                                <option value="Croatia">Croatia</option>
                                <option value="Cuba">Cuba</option>
                                <option value="Curaco">Curacao</option>
                                <option value="Cyprus">Cyprus</option>
                                <option value="Czech Republic">Czech Republic</option>
                                <option value="Denmark">Denmark</option>
                                <option value="Djibouti">Djibouti</option>
                                <option value="Dominica">Dominica</option>
                                <option value="Dominican Republic">Dominican Republic</option>
                                <option value="East Timor">East Timor</option>
                                <option value="Ecuador">Ecuador</option>
                                <option value="Egypt">Egypt</option>
                                <option value="El Salvador">El Salvador</option>
                                <option value="Equatorial Guinea">Equatorial Guinea</option>
                                <option value="Eritrea">Eritrea</option>
                                <option value="Estonia">Estonia</option>
                                <option value="Ethiopia">Ethiopia</option>
                                <option value="Falkland Islands">Falkland Islands</option>
                                <option value="Faroe Islands">Faroe Islands</option>
                                <option value="Fiji">Fiji</option>
                                <option value="Finland">Finland</option>
                                <option value="France">France</option>
                                <option value="French Guiana">French Guiana</option>
                                <option value="French Polynesia">French Polynesia</option>
                                <option value="French Southern Ter">French Southern Ter</option>
                                <option value="Gabon">Gabon</option>
                                <option value="Gambia">Gambia</option>
                                <option value="Georgia">Georgia</option>
                                <option value="Germany">Germany</option>
                                <option value="Ghana">Ghana</option>
                                <option value="Gibraltar">Gibraltar</option>
                                <option value="Great Britain">Great Britain</option>
                                <option value="Greece">Greece</option>
                                <option value="Greenland">Greenland</option>
                                <option value="Grenada">Grenada</option>
                                <option value="Guadeloupe">Guadeloupe</option>
                                <option value="Guam">Guam</option>
                                <option value="Guatemala">Guatemala</option>
                                <option value="Guinea">Guinea</option>
                                <option value="Guyana">Guyana</option>
                                <option value="Haiti">Haiti</option>
                                <option value="Hawaii">Hawaii</option>
                                <option value="Honduras">Honduras</option>
                                <option value="Hong Kong">Hong Kong</option>
                                <option value="Hungary">Hungary</option>
                                <option value="Iceland">Iceland</option>
                                <option value="India">India</option>
                                <option value="Indonesia">Indonesia</option>
                                <option value="Iran">Iran</option>
                                <option value="Iraq">Iraq</option>
                                <option value="Ireland">Ireland</option>
                                <option value="Isle of Man">Isle of Man</option>
                                <option value="Israel">Israel</option>
                                <option value="Italy">Italy</option>
                                <option value="Jamaica">Jamaica</option>
                                <option value="Japan">Japan</option>
                                <option value="Jordan">Jordan</option>
                                <option value="Kazakhstan">Kazakhstan</option>
                                <option value="Kenya">Kenya</option>
                                <option value="Kiribati">Kiribati</option>
                                <option value="Korea North">Korea North</option>
                                <option value="Korea Sout">Korea South</option>
                                <option value="Kuwait">Kuwait</option>
                                <option value="Kyrgyzstan">Kyrgyzstan</option>
                                <option value="Laos">Laos</option>
                                <option value="Latvia">Latvia</option>
                                <option value="Lebanon">Lebanon</option>
                                <option value="Lesotho">Lesotho</option>
                                <option value="Liberia">Liberia</option>
                                <option value="Libya">Libya</option>
                                <option value="Liechtenstein">Liechtenstein</option>
                                <option value="Lithuania">Lithuania</option>
                                <option value="Luxembourg">Luxembourg</option>
                                <option value="Macau">Macau</option>
                                <option value="Macedonia">Macedonia</option>
                                <option value="Madagascar">Madagascar</option>
                                <option value="Malaysia">Malaysia</option>
                                <option value="Malawi">Malawi</option>
                                <option value="Maldives">Maldives</option>
                                <option value="Mali">Mali</option>
                                <option value="Malta">Malta</option>
                                <option value="Marshall Islands">Marshall Islands</option>
                                <option value="Martinique">Martinique</option>
                                <option value="Mauritania">Mauritania</option>
                                <option value="Mauritius">Mauritius</option>
                                <option value="Mayotte">Mayotte</option>
                                <option value="Mexico">Mexico</option>
                                <option value="Midway Islands">Midway Islands</option>
                                <option value="Moldova">Moldova</option>
                                <option value="Monaco">Monaco</option>
                                <option value="Mongolia">Mongolia</option>
                                <option value="Montserrat">Montserrat</option>
                                <option value="Morocco">Morocco</option>
                                <option value="Mozambique">Mozambique</option>
                                <option value="Myanmar">Myanmar</option>
                                <option value="Nambia">Nambia</option>
                                <option value="Nauru">Nauru</option>
                                <option value="Nepal">Nepal</option>
                                <option value="Netherland Antilles">Netherland Antilles</option>
                                <option value="Netherlands">Netherlands (Holland, Europe)</option>
                                <option value="Nevis">Nevis</option>
                                <option value="New Caledonia">New Caledonia</option>
                                <option value="New Zealand">New Zealand</option>
                                <option value="Nicaragua">Nicaragua</option>
                                <option value="Niger">Niger</option>
                                <option value="Nigeria">Nigeria</option>
                                <option value="Niue">Niue</option>
                                <option value="Norfolk Island">Norfolk Island</option>
                                <option value="Norway">Norway</option>
                                <option value="Oman">Oman</option>
                                <option value="Pakistan">Pakistan</option>
                                <option value="Palau Island">Palau Island</option>
                                <option value="Palestine">Palestine</option>
                                <option value="Panama">Panama</option>
                                <option value="Papua New Guinea">Papua New Guinea</option>
                                <option value="Paraguay">Paraguay</option>
                                <option value="Peru">Peru</option>
                                <option value="Phillipines">Philippines</option>
                                <option value="Pitcairn Island">Pitcairn Island</option>
                                <option value="Poland">Poland</option>
                                <option value="Portugal">Portugal</option>
                                <option value="Puerto Rico">Puerto Rico</option>
                                <option value="Qatar">Qatar</option>
                                <option value="Republic of Montenegro">Republic of Montenegro</option>
                                <option value="Republic of Serbia">Republic of Serbia</option>
                                <option value="Reunion">Reunion</option>
                                <option value="Romania">Romania</option>
                                <option value="Russia">Russia</option>
                                <option value="Rwanda">Rwanda</option>
                                <option value="St Barthelemy">St Barthelemy</option>
                                <option value="St Eustatius">St Eustatius</option>
                                <option value="St Helena">St Helena</option>
                                <option value="St Kitts-Nevis">St Kitts-Nevis</option>
                                <option value="St Lucia">St Lucia</option>
                                <option value="St Maarten">St Maarten</option>
                                <option value="St Pierre &amp; Miquelon">St Pierre &amp; Miquelon</option>
                                <option value="St Vincent &amp; Grenadines">St Vincent &amp; Grenadines</option>
                                <option value="Saipan">Saipan</option>
                                <option value="Samoa">Samoa</option>
                                <option value="Samoa American">Samoa American</option>
                                <option value="San Marino">San Marino</option>
                                <option value="Sao Tome &amp; Principe">Sao Tome &amp; Principe</option>
                                <option value="Saudi Arabia">Saudi Arabia</option>
                                <option value="Senegal">Senegal</option>
                                <option value="Serbia">Serbia</option>
                                <option value="Seychelles">Seychelles</option>
                                <option value="Sierra Leone">Sierra Leone</option>
                                <option value="Singapore">Singapore</option>
                                <option value="Slovakia">Slovakia</option>
                                <option value="Slovenia">Slovenia</option>
                                <option value="Solomon Islands">Solomon Islands</option>
                                <option value="Somalia">Somalia</option>
                                <option value="South Africa">South Africa</option>
                                <option value="Spain">Spain</option>
                                <option value="Sri Lanka">Sri Lanka</option>
                                <option value="Sudan">Sudan</option>
                                <option value="Suriname">Suriname</option>
                                <option value="Swaziland">Swaziland</option>
                                <option value="Sweden">Sweden</option>
                                <option value="Switzerland">Switzerland</option>
                                <option value="Syria">Syria</option>
                                <option value="Tahiti">Tahiti</option>
                                <option value="Taiwan">Taiwan</option>
                                <option value="Tajikistan">Tajikistan</option>
                                <option value="Tanzania">Tanzania</option>
                                <option value="Thailand">Thailand</option>
                                <option value="Togo">Togo</option>
                                <option value="Tokelau">Tokelau</option>
                                <option value="Tonga">Tonga</option>
                                <option value="Trinidad &amp; Tobago">Trinidad &amp; Tobago</option>
                                <option value="Tunisia">Tunisia</option>
                                <option value="Turkey">Turkey</option>
                                <option value="Turkmenistan">Turkmenistan</option>
                                <option value="Turks &amp; Caicos Is">Turks &amp; Caicos Is</option>
                                <option value="Tuvalu">Tuvalu</option>
                                <option value="Uganda">Uganda</option>
                                <option value="Ukraine">Ukraine</option>
                                <option value="United Arab Erimates">United Arab Emirates</option>
                                <option value="United Kingdom">United Kingdom</option>
                                <option value="United States of America">United States of America</option>
                                <option value="Uraguay">Uruguay</option>
                                <option value="Uzbekistan">Uzbekistan</option>
                                <option value="Vanuatu">Vanuatu</option>
                                <option value="Vatican City State">Vatican City State</option>
                                <option value="Venezuela">Venezuela</option>
                                <option value="Vietnam">Vietnam</option>
                                <option value="Virgin Islands (Brit)">Virgin Islands (Brit)</option>
                                <option value="Virgin Islands (USA)">Virgin Islands (USA)</option>
                                <option value="Wake Island">Wake Island</option>
                                <option value="Wallis &amp; Futana Is">Wallis &amp; Futana Is</option>
                                <option value="Yemen">Yemen</option>
                                <option value="Zaire">Zaire</option>
                                <option value="Zambia">Zambia</option>
                                <option value="Zimbabwe">Zimbabwe</option>
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
                    <div class="row control-group">
                        <%-- Native language(s) --%>
                        <div class="form-group col-xs-6 floating-label-form-group controls">
                            <spring:message code="message.register.form.native-langs" var="nativeLangs"/>
                            <form:select class="form-control" size="6" path="nativeLanguages" multiple="true">
                                <option disabled>${nativeLangs}:</option>
                                <option selected>Ukrainian</option>
                                <option>Russian</option>
                                <option>Belarusian</option>
                                <option>English</option>
                            </form:select>
                            <form:errors cssClass="label label-danger" path="nativeLanguages"/>
                        </div>
                        <%-- Practicing language(s) --%>
                        <div class="form-group col-xs-6 floating-label-form-group controls">
                            <spring:message code="message.register.form.practicing-langs" var="practLangs"/>
                            <form:select class="form-control" size="6" path="practicingLanguages" multiple="true">
                                <option disabled>${practLangs}:</option>
                                <option selected>Ukrainian</option>
                                <option>Russian</option>
                                <option>Belarusian</option>
                                <option>English</option>
                            </form:select>
                            <form:errors cssClass="label label-danger" path="practicingLanguages"/>
                        </div>
                    </div>

                    <div class="row control-group">
                        <%-- Description --%>
                        <div class="form-group col-xs-12 controls">
                            <spring:message code="message.register.form.tell-about" var="tellAbout"/>
                            <form:textarea rows="3" class="form-control" placeholder="${tellAbout}" id="message" path="description"/>
                            <p class="help-block text-danger"></p>
                        </div>
                    </div>

                    <div class="row control-group">
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

                    <div class="row control-group">
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

                    <div class="row control-group">
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
                            <button type="submit" class="btn btn-success btn-lg center-block"><spring:message code="message.register.form.btn"/></button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>