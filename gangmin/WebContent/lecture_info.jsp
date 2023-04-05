<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />  
<%
	request.setCharacterEncoding("UTF-8");
	String isLogon = null;
	
	if(session.getAttribute("mkey")!=null){
		int mkey = ((Integer)(session.getAttribute("mkey"))).intValue();
	 	String mnickname = (String)session.getAttribute("mnickname");
	 	isLogon = mnickname;
	}
%>
<c:set var="isLogon" value="<%=isLogon %>" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>강의의 민족 강민</title>
    <link rel="stylesheet" href="${contextPath}/css/productPage2.css">
    <script type="text/javascript" src="${contextPath}/js/lecture_info.js"></script>
</head>    
<body>
    <div id="wrap">
    <div id="top">
        <div id="top_left">
            <a href="${contextPath}/lecture/listLectures.do">
            <img src="${contextPath}/images/logo.png" style="height:150px;">
            </a>
        </div>
        <div id="top_middle">
            <div id="search">
                <input type="text" id="search" placeholder="검색어를 입력해주세요.">
            </div>
            <div id="nav">
                <ul>
                    <li><a>카테고리 검색</a></li>
                    <li><a>추천 강의</a></li>
                    <li><a>커뮤니티</a></li>
                    <li><a>강민 이벤트</a></li>
                </ul>
            </div>
        </div>
        <div id="top_right">
            <c:choose>
        		<c:when test="${empty isLogon }">
            		<a href="/gangmin/login.jsp"><input type="button" value="로그인" id="login"></a>
            		<a href="/gangmin/signin.jsp"><input type="button" value="회원 가입하기" id="new"></a>
            	</c:when>
            	<c:otherwise>
            		<h4><%=isLogon %>님 환영합니다.</h4>
            		<a href="${contextPath}/memberdelete.jsp"><input type="button" value="내정보" id="myPage"></a>
            		<a href="${contextPath}/member/logout"><input type="button" value="로그아웃" id="logout"></a>
            	</c:otherwise>
            </c:choose>
        </div>
    </div>
    <div id="advertise">
        <p id="adfont">지금 수강인증하면 <b>선착순 1,000명 스터디 플래너</b> 지급!</p>
    </div>
    <br>
    <div id="main">
        <img src="${contextPath}/images/${infoLecture.limage}" height="300px;">
        <div id="info">            
            <h1>${infoLecture.lid}</h1><br>
        <h2>강사 : ${infoLecture.lname}</h2>
        <dl>
            <dd><strong>강좌유형</strong> : ${infoLecture.ltype}</dd>
            <dd><strong>강좌구성</strong> : ${infoLecture.lconst}</dd>
            <dd><strong>수강대상</strong> : ${infoLecture.luser}</dd>
            <dd><strong>제작방식</strong> : ${infoLecture.lcreate}</dd>
            <dd><strong>학습단계</strong> : ${infoLecture.llevel}</dd>
            <dd><strong>수강기간</strong> : ${infoLecture.ltime}시간</dd>
        </dl>
        <h2>가격 : ${infoLecture.lduration}개월 / ${infoLecture.lprice}만원</h2>
        </div>   
    </div>
        
        <div>
            <table id="classinfo">
                <caption>
                    <strong>강좌 정보</strong>
                </caption>
                <tr>
                    <th>강좌범위</th>
                    <td>
                        <p>${infoLecture.lunit}</p>
                    </td>
                </tr>
                <tr>
                    <th>강좌특징</th>
                    <td>
                    	<p>${infoLecture.linfo}</p>
                    </td>
                <tr>
                    <th>수강대상</th>
                    <td>
                        <p>${infoLecture.ltarget}</p>
                    </td>
                </tr>
            </table>
        </div>
        <br>
        <div class="textbook">
            <table>
                <style>
                    .textbook table, .textbook td{
                        height: 50px;
                        border: 1px solid black;
                        border-collapse: collapse;
                    }
                </style>
                <caption>
                    <strong>교재 정보</strong>
                </caption>
                <tr>
                    <th rowspan="4"><img src="images/hswbook.png" height="200px"></th>
                    <td><b>교재명</b></td>
                    <td><p>[교재][2024] 4의 규칙 SEASON1 - 수학Ⅰ(no.24454)</p></td>
                </tr>
                <tr>
                    <td><b>판매가</b></td>
                    <td><p style="color: red;">28,000원</p></td>
                </tr>
                <tr>
                    <td><b>교재특징</b></td>
                    <td><p>22,30 번 을 제외한 4점 문항을 정면 돌파하기 위한 N제!</p></td>
                </tr>
                <tr>
                    <td><b>목차</b></td>
                    <td><p>1. 지수함수와 로그함수</p>
                        <p>2. 삼각함수</p>
                        <p>3. 수열</p>
                        <p>정답 및 해설</p></td>
                </tr>

            </table>
        </div>
        <div>
            <style>
                .CC tr{
                    height: 30px;
                }
            </style>
        <table class="CC">
            <caption>
                <strong>커리큘럼</strong>
            </caption>
            <tr>
                <th>차시</th>
                <th>강의명</th>
                <th>강의시간</th>
            </tr>
            <tr>
                <th>1</th>
                <td>지수함수와 로그함수 <1-10번></td>
                <td>42분</td>
            </tr>
            <tr>
                <th>2</th>
                <td>지수함수와 로그함수 <11-20번></td>
                <td>46분</td>
            </tr>
            <tr>
                <th>3</th>
                <td>지수함수와 로그함수 <21-30번></td>
                <td>46분</td>
            </tr>
            <tr>
                <th>4</th>
                <td>지수함수와 로그함수 <31-40번></td>
                <td>51분</td>
            </tr>
            <tr>
                <th>5</th>
                <td>삼각함수 <1-10번></td>
                <td>54분</td>
            </tr>
            <tr>
                <th>6</th>
                <td>삼각함수 <11-18번></td>
                <td>54분</td>
            </tr>
            <tr>
                <th>7</th>
                <td>삼각함수 <19-27번></td>
                <td>42분</td>
            </tr>
            <tr>
                <th>8</th>
                <td>삼각함수 <28-37번></td>
                <td>51분</td>
            </tr>
            <tr>
                <th>9</th>
                <td>수열 <1-11번></td>
                <td>47분</td>
            </tr>
            <tr>
                <th>10</th>
                <td>수열 <12-22번></td>
                <td>74분</td>
            </tr>
            <tr>
                <th>11</th>
                <td>수열 <23-33번></td>
                <td>49분</td>
            </tr>
            <tr>
                <th>12</th>
                <td>수열 <34-45번></td>
                <td>68분</td>
            </tr>
        </table>
    </div>

    <div class="wrap">
        <h1><strong>수강 후기</strong></h1>
        <form name="reviewform" class="reviewform" method="post" action="/save">
            <input type="hidden" name="rate" id="rate" value="0"/>
            <p class="title_star">별점과 수강후기를 남겨주세요.</p>
     
            <div class="review_rating rating_point">
                <div class="warning_msg">별점을 선택해 주세요.</div>
                <span class="rating">
                    ★★★★★
                    <span>★★★★★</span>
                    <input type="range" class="rate_radio" oninput="drawStar(this)" value="1" step="1" min="0" max="10">
                </span>
            </div>
            <div class="review_contents">
                <div class="warning_msg">5자 이상의 리뷰 내용을 작성해 주세요.</div>
                <textarea rows="10" class="review_textarea"></textarea>
            </div>   
            <div class="cmd">
                <input type="button" name="save" id="save" value="등록">
            </div>
        </form>
    </div>
</body>
</html>