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


	<br><br><br>

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
                        <a href="#" class="post-tag">오늘의 추천메뉴</a>
                        <a href="#" class="post-title">아보카도 샌드위치</a>
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
                        <a href="#" class="post-tag">오늘의 추천메뉴</a>
                        <a href="#" class="post-title">소고기 타코</a>
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
                        <a href="#" class="post-tag">오늘의 추천메뉴</a>
                        <a href="#" class="post-title">수제 햄버거</a>
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
                    <a href="#"><img src="/resources/img/bg-img/버섯크림파스타.jpg" alt=""></a>
                </div>

                <!-- Blog Content -->
                <div class="blog-content-bg">
                    <div class="blog-content">
                        <a href="#" class="post-tag">오늘의 추천메뉴</a>
                        <a href="#" class="post-title">버섯 크림 파스타</a>
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
    
    <br><br><br><br><br><br>




<!-- 하단 -->
	<footer>
		<%@ include file="/template/bottom.jsp" %>
	</footer>
	
	
	<script src="/resources/js/jquery/jquery-2.2.4.min.js"></script>
    
    <script src="/resources/js/bootstrap/popper.min.js"></script>
    
    <script src="/resources/js/bootstrap/bootstrap.min.js"></script>
    
    <script src="/resources/js/plugins/plugins.js"></script>
    
    <script src="/resources/js/active.js"></script>
</body>
</html>