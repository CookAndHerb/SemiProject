<%@page import="com.recipe.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.write{
	margin-right : 36px;
	
	}
	
	#wrtbtn{
	background : #b0c364;
	
	}
	
	#search{
	clear:both;
	
	}
</style>
</head>
<body>

<!-- 상단 공동 메뉴 -->
<header id="top_section">
		<%@ include file="/template/top.jsp" %>
</header>
	<br>
	<!-- 글쓰기 버튼 -->
	<% MemberVO mvo = (MemberVO)session.getAttribute("member"); // 로그인 돼있는 경우만 글쓰기 버튼 보이도록
	
	if(mvo != null){
	%>
	<div class="float-right col-2 write">
  <a type="button " class="btn text-white bold " id="wrtbtn" href="/rBoard/RboardInsertPage.jsp"><b>글쓰기</b></a>
  </div>
  <%} %>
    <!-- ##### Catagory Area Start ##### -->
    <div class="post-catagory section-padding-100">
        <div class="container">
            <div class="row">
                <!-- Single Post Catagory -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-post-catagory mb-30">
                        <img src="/resources/img/bg-img/반찬.jpg" alt="">
                        <!-- Content -->
                        <div class="catagory-content-bg">
                            <div class="catagory-content">
                                <a href="/RboardAllList.do?category=1" class="post-tag">The Best</a>
                                <a href="/RboardAllList.do?category=1" class="post-title">반찬</a>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Single Post Catagory -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-post-catagory mb-30">
                        <img src="/resources/img/bg-img/탕.jpg" alt="">
                        <!-- Content -->
                        <div class="catagory-content-bg">
                            <div class="catagory-content">
                                <a href="/RboardAllList.do?category=2" class="post-tag">The Best</a>
                                <a href="/RboardAllList.do?category=2" class="post-title">국 & 탕</a>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Single Post Catagory -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-post-catagory mb-30">
                        <img src="/resources/img/bg-img/찌개.jpg" alt="">
                        <!-- Content -->
                        <div class="catagory-content-bg">
                            <div class="catagory-content">
                                <a href="/RboardAllList.do?category=3" class="post-tag">The Best</a>
                                <a href="/RboardAllList.do?category=3" class="post-title">찌개</a>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Single Post Catagory -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-post-catagory mb-30">
                        <img src="/resources/img/bg-img/22.jpg" alt="">
                        <!-- Content -->
                        <div class="catagory-content-bg">
                            <div class="catagory-content">
                                <a href="/RboardAllList.do?category=4" class="post-tag">The Best</a>
                                <a href="/RboardAllList.do?category=4" class="post-title">밥 & 죽</a>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Single Post Catagory -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-post-catagory mb-30">
                        <img src="/resources/img/bg-img/면.jpg" alt="">
                        <!-- Content -->
                        <div class="catagory-content-bg">
                            <div class="catagory-content">
                                <a href="/RboardAllList.do?category=5" class="post-tag">The Best</a>
                                <a href="/RboardAllList.do?category=5" class="post-title">면</a>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Single Post Catagory -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-post-catagory mb-30">
                        <img src="/resources/img/bg-img/21.jpg" alt="">
                        <!-- Content -->
                        <div class="catagory-content-bg">
                            <div class="catagory-content">
                                <a href="/RboardAllList.do?category=6" class="post-tag">The Best</a>
                                <a href="/RboardAllList.do?category=6" class="post-title">디저트</a>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Single Post Catagory -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-post-catagory mb-30">
                        <img src="/resources/img/bg-img/6.jpg" alt="">
                        <!-- Content -->
                        <div class="catagory-content-bg">
                            <div class="catagory-content">
                                <a href="/RboardAllList.do?category=7" class="post-tag">The Best</a>
                                <a href="/RboardAllList.do?category=7" class="post-title">비건</a>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Single Post Catagory -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-post-catagory mb-30">
                        <img src="/resources/img/bg-img/음료.jpg" alt="">
                        <!-- Content -->
                        <div class="catagory-content-bg">
                            <div class="catagory-content">
                                <a href="/RboardAllList.do?category=8" class="post-tag">The Best</a>
                                <a href="/RboardAllList.do?category=8" class="post-title">음료</a>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Single Post Catagory -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-post-catagory mb-30">
                        <img src="/resources/img/bg-img/20.jpg" alt="">
                        <!-- Content -->
                        <div class="catagory-content-bg">
                            <div class="catagory-content">
                                <a href="/RboardAllList.do?category=9" class="post-tag">The Best</a>
                                <a href="/RboardAllList.do?category=9" class="post-title">기타</a>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>

            
        </div>
        <br>
        
         <!-- 검색부분 -->
        <div id="search" align="center" >
                  <form action="/RboardSearch.do" method="post">
                         <select name="searchCategory">
               				 <option value="boardTitle">제목</option>
               				 <option value="boardWriter">작성자</option>
						</select>
                          <input type="search" name="keyword"  placeholder="Search">
                          <button type="submit" class="btn"><i class="fa fa-search"></i></button>
                   </form>
              </div>
    </div>
    <!-- ##### Catagory Area End ##### -->
    
   
			
 				
<!-- 하단 -->
	<footer>
		<%@ include file="/template/bottom.jsp" %>
	</footer>
</body>
</html>