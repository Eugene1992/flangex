<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<section id="portfolio">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2><spring:message code="message.main.benefits.title"/></h2>
                <hr class="star-primary">
            </div>
        </div>
        <div class="row">
            <div class="col-sm-4 portfolio-item">
                <a href="#portfolioModal1" class="portfolio-link" data-toggle="modal">
                    <div class="caption">
                        <div class="caption-content">
                            <i class="fa fa-search-plus fa-3x"></i>
                        </div>
                    </div>
                    <img src="../../../resources/img/free.png" class="img-responsive center-block" alt="">
                </a>
                <br>
                <p class="text-center"><spring:message code="message.main.benefits.free"/></p>
            </div>
            <div class="col-sm-4 portfolio-item">
                <a href="#portfolioModal2" class="portfolio-link" data-toggle="modal">
                    <div class="caption">
                        <div class="caption-content">
                            <i class="fa fa-search-plus fa-3x"></i>
                        </div>
                    </div>
                    <img src="../../../resources/img/easy.png" class="img-responsive center-block" alt="">
                </a>
                <br>
                <p class="text-center"><spring:message code="message.main.benefits.easy"/></p>
            </div>
            <div class="col-sm-4 portfolio-item">
                <a href="#portfolioModal3" class="portfolio-link" data-toggle="modal">
                    <div class="caption">
                        <div class="caption-content">
                            <i class="fa fa-search-plus fa-3x"></i>
                        </div>
                    </div>
                    <img src="../../../resources/img/socials.png" class="img-responsive center-block" alt="">
                </a>
                <br>
                <p class="text-center"><spring:message code="message.main.benefits.talk"/></p>
            </div>
        </div>
    </div>
</section>