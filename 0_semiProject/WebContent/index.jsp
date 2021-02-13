<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<meta charset="UTF-8">
<title>CookCookRecipe</title>
</head>
<body>
<!--  메인 페이지 -->

<!-- 상단 공동 메뉴 -->
<header id="top_section">
		<%@ include file="/template/top.jsp" %>
</header>

	    
	    
<!-- content 부분-->
    <div class="hero-area">
    
        <!-- Hero Post Slides -->
        <div class="hero-post-slides owl-carousel">
            <!-- Single Slide -->
            <div class="single-slide">
                <!-- Blog Thumbnail -->
                <div class="blog-thumbnail">
                    <a href="#"><img src="/resources/img/bg-img/1.jpg" alt=""></a>
                </div>

                <!-- Blog Content -->
                <div class="blog-content-bg">
                    <div class="blog-content">
                        <a href="#" class="post-tag">Food 1</a>
                        <a href="#" class="post-title">Chicken Salad</a>
                        <div class="post-meta">
                            <a href="#" class="post-date">July 11, 2018</a>
                            <a href="#" class="post-author">By Julia Stiles</a>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Single Slide -->
            <div class="single-slide">
                <!-- Blog Thumbnail -->
                <div class="blog-thumbnail">
                    <a href="#"><img src="/resources/img/bg-img/2.jpg" alt=""></a>
                </div>

                <!-- Blog Content -->
                <div class="blog-content-bg">
                    <div class="blog-content">
                        <a href="#" class="post-tag">Food 2</a>
                        <a href="#" class="post-title">Chicken Salad</a>
                        <div class="post-meta">
                            <a href="#" class="post-date">July 11, 2018</a>
                            <a href="#" class="post-author">By Julia Stiles</a>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Single Slide -->
            <div class="single-slide">
                <!-- Blog Thumbnail -->
                <div class="blog-thumbnail">
                    <a href="#"><img src="/resources/img/bg-img/3.jpg" alt=""></a>
                </div>

                <!-- Blog Content -->
                <div class="blog-content-bg">
                    <div class="blog-content">
                        <a href="#" class="post-tag">Food 3</a>
                        <a href="#" class="post-title">Chicken Salad</a>
                        <div class="post-meta">
                            <a href="#" class="post-date">July 11, 2018</a>
                            <a href="#" class="post-author">By Julia Stiles</a>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Single Slide -->
            <div class="single-slide">
                <!-- Blog Thumbnail -->
                <div class="blog-thumbnail">
                    <a href="#"><img src="/resources/img/bg-img/3.jpg" alt=""></a>
                </div>

                <!-- Blog Content -->
                <div class="blog-content-bg">
                    <div class="blog-content">
                        <a href="#" class="post-tag">Food 4</a>
                        <a href="#" class="post-title">Chicken Salad</a>
                        <div class="post-meta">
                            <a href="#" class="post-date">July 11, 2018</a>
                            <a href="#" class="post-author">By Julia Stiles</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Hero Area End ##### -->

    <!-- ##### Catagory Area Start ##### -->
    <div class="post-catagory section-padding-100-0 mb-70">
        <div class="container">
            <div class="row justify-content-center">
                <!-- Single Post Catagory -->
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="single-post-catagory mb-30">
                        <img src="/resources/img/bg-img/4.jpg" alt="">
                        <!-- Content -->
                        <div class="catagory-content-bg">
                            <div class="catagory-content">
                                <a href="#" class="post-tag">1</a>
                                <a href="#" class="post-title">Healthy Food</a>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Single Post Catagory -->
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="single-post-catagory mb-30">
                        <img src="/resources/img/bg-img/5.jpg" alt="">
                        <!-- Content -->
                        <div class="catagory-content-bg">
                            <div class="catagory-content">
                                <a href="#" class="post-tag">2</a>
                                <a href="#" class="post-title">Organic Cuisine</a>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Single Post Catagory -->
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="single-post-catagory mb-30">
                        <img src="/resources/img/bg-img/6.jpg" alt="">
                        <!-- Content -->
                        <div class="catagory-content-bg">
                            <div class="catagory-content">
                                <a href="#" class="post-tag">3</a>
                                <a href="#" class="post-title">Vegetarian Food</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Catagory Area End ##### -->



<!-- 하단 -->
	<footer>
		<%@ include file="/template/bottom.jsp" %>
	</footer>
</body>
</html>