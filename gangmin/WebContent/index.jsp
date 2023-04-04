<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    import="java.util.*, member.*" %>
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
    <link rel="stylesheet" href="${contextPath}/css/style2.css">
</head>
<body>
    <div id="wrap">
    <div id="top">
        <div id="top_left">
            <img src="${contextPath}/images/logo.png" style="height:150px;">
        </div>
        <div id="top_middle">
            <div id="search">
                <input type="text" id="search" placeholder="검색어를 입력해주세요.">
            </div>
            <div id="nav">
                <ul>
                    <li><a><b>카테고리 검색</b></a></li>
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
            		<a href="/gangmin/memberdelete.jsp"><input type="button" value="내정보" id="myPage"></a>
            		<a href="/gangmin/member/logout"><input type="button" value="로그아웃" id="logout"></a>
            	</c:otherwise>
            </c:choose>
        </div>
    </div>
    <div id="advertise">
        <p id="adfont">지금 수강인증하면 <b>선착순 1,000명 스터디 플래너</b> 지급!</p>
    </div>
        <div id="content">
            <div id="aside_left">
                <div id="search2">
                    <input type="text" id="txt_search2" placeholder="강의명을 검색하세요.">
                    <input type="submit" id="btn_search2" value="">
                </div>
                <div id="div_checkbox">
                    <div class="category">
                        <p>학원사</p>
                        <div class="checkboxs">
                        
                            <li><input type="checkbox" value="a1">이투스</li>
                            <li><input type="checkbox" value="a2">대성</li>
                            <li><input type="checkbox" value="a3">메가스터디</li>
                            <li><input type="checkbox" value="a4">스카이에듀</li>
                            <li><input type="checkbox" value="a5">오르비</li>
                            <li><input type="checkbox" value="a6">비타에듀</li>
                            <li><input type="checkbox" value="a7">강남구청방송</li>
                            <li><input type="checkbox" value="a8">ebsi</li>
                            <li><input type="checkbox" value="a9">공신닷컴</li>
                            <li><input type="checkbox" value="a10">10러셀블루</li>
                        
                        </div>
                    </div>
                    <div class="category">
                        <p>계열</p>
                        <div class="checkboxs">
                            <li><input type="radio" name="rd_line" id="p1" checked="checked"><label for="p1">인문계열</label></li>
                            <li><input type="radio" name="rd_line" id="p2"><label for="p2">자연계열</label></li>
                        </div>
                    </div>
                    <div class="category">
                        <p>과목</p>
                        <div class="checkboxs" id="line1">
                            <li><input type="radio" name="rd_sub1" id="k1"><label for="k1">국어</label></li>
                            <li><input type="radio" name="rd_sub1" id="k2"><label for="k2">수학</label></li>
                            <li><input type="radio" name="rd_sub1" id="k3"><label for="k3">영어</label></li>
                            <li><input type="radio" name="rd_sub1" id="k4"><label for="k4">생활과 윤리</label></li>
                            <li><input type="radio" name="rd_sub1" id="k5"><label for="k5">윤리와 사상</label></li>
                            <li><input type="radio" name="rd_sub1" id="k6"><label for="k6">한국 지리</label></li>
                            <li><input type="radio" name="rd_sub1" id="k7"><label for="k7">세계 지리</label></li>
                        </div>
                        <div class="checkboxs" id="line2">
                            <li><input type="radio" name="rd_sub2" id="m1"><label for="m1">국어</label></li>
                            <li><input type="radio" name="rd_sub2" id="m2"><label for="m2">수학</label></li>
                            <li><input type="radio" name="rd_sub2" id="m3"><label for="m3">영어</label></li>
                            <li><input type="radio" name="rd_sub2" id="m4"><label for="m4">물리</label></li>
                            <li><input type="radio" name="rd_sub2" id="m5"><label for="m5">화학</label></li>
                            <li><input type="radio" name="rd_sub2" id="m6"><label for="m6">생물</label></li>
                            <li><input type="radio" name="rd_sub2" id="m7"><label for="m7">지구과학</label></li>
                        </div>
                    </div>
                    <div class="category">
                        <p>단원</p>
                        <div class="checkboxs" id="korean">
                            <li><input type="radio" name="radio_final" value="rk1" id="kk1"><label for="kk1">화법과 작문</label></li>
                            <li><input type="radio" name="radio_final" value="rk2" id="kk2"><label for="kk2">문학</label></li>
                            <li><input type="radio" name="radio_final" value="rk3" id="kk3"><label for="kk3">비문학</label></li>
                        </div>
                        <div class="checkboxs" id="math">
                            <li><input type="radio" name="radio_final" value="c1" id="mm1"><label for="mm1">수학I</label></li>
                            <li><input type="radio" name="radio_final" value="c2" id="mm2"><label for="mm2">수학II</label></li>
                            <li><input type="radio" name="radio_final" value="c3" id="mm3"><label for="mm3">미적분</label></li>
                            <li><input type="radio" name="radio_final" value="c4" id="mm4"><label for="mm4">확률과 통계</label></li>
                            <li><input type="radio" name="radio_final" value="c5" id="mm5"><label for="mm5">기하와 벡터</label></li>
                        </div>
                    </div>
                </div>
                <div id="sort">
                    <input type="radio" name="do_sort" id="toggle1" value="r1" checked="checked"/>
                    <label for="toggle1"><li>인기강의순</li></label>
                    <input type="radio" name="do_sort" id="toggle2" value="r2"/>
                    <label for="toggle2"><li>신규강의순</li></label>
                    <input type="radio" name="do_sort" id="toggle3" value="r3"/>
                    <label for="toggle3"><li>낮은가격순</li></label>
                    <input type="radio" name="do_sort" id="toggle4" value="r4"/>
                    <label for="toggle4"><li>높은가격순</li></label>
                    <input type="radio" name="do_sort" id="toggle5" value="r5"/>
                    <label for="toggle5"><li>강의명순</li></label>                                 
                </div>
                <input type="button" value="결과 내 검색" id="search3" onclick="doSearch()">
                <c:choose>
                	<c:when test="${empty lecturesList }">
                		<div class="classes">
                			<h2>등록된 강의가 없습니다.</h2>
                		</div>
                	</c:when>
                	<c:when test="${!empty lecturesList }">
                		<c:forEach var="lecture" items="${lecturesList }" varStatus="lectureNum">
                			<div class="classes">
                				<img class="profile" src="${contextPath}/images/${lecture.limage}">
                				<div class="div1">
                					<h2>${lecture.lid}</h2>
                					<img class="star" src="${contextPath}/images/star.png">
                					<b>${lecture.lsumgrade}</b>(${lecture.lcountgrade})
                				</div>
                				<div class="div2">
                					<h3>${lecture.lduration}개월 / ${lecture.lprice}원</h3>
                					<input type="button" value="후기 보러가기">
                				</div>
                			</div>
                		</c:forEach>
                	</c:when>
                </c:choose>
            </div>
            <div id="aside_right">
                <div id="onoff">
                    <input type="checkbox" name="do_check" id="onoff_toggle" checked="checked"/>
                    <label for="onoff_toggle">
                        <li>온라인 강의</li>
                        <li>오프라인 강의</li>
                    </label>
                </div>
                <div id="second">
                <input type="button" value="찜 목록" id="like">
                <p>로그인하여 저장한 강의들을 확인해보세요.</p>
                </div>
                <div id="exam">
                    <br><br><br>
                    <input type="radio" name="do_exam" id="exam_toggle1" value="e1" checked="checked"/>
                    <label for="exam_toggle1"><p>&nbsp;&nbsp;수능</p></label>
                    <input type="radio" name="do_exam" id="exam_toggle2" value="e2"/>
                    <label for="exam_toggle2"><p>&nbsp;&nbsp;수시</p></label>
                    <input type="radio" name="do_exam" id="exam_toggle3" value="e3"/>
                    <label for="exam_toggle3"><p>&nbsp;&nbsp;공무원</p></label>
                    <input type="radio" name="do_exam" id="exam_toggle4" value="e4"/>
                    <label for="exam_toggle4"><p>&nbsp;&nbsp;자격증</p></label>
                    <input type="radio" name="do_exam" id="exam_toggle5" value="e5"/>
                    <label for="exam_toggle5"><p>&nbsp;&nbsp;편입</p></label>
                    <input type="radio" name="do_exam" id="exam_toggle6" value="e6"/>
                    <label for="exam_toggle6"><p>&nbsp;&nbsp;토익</p></label>
                    <input type="radio" name="do_exam" id="exam_toggle7" value="e7"/>
                    <label for="exam_toggle7"><p>&nbsp;&nbsp;검정고시</p></label>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="js/script.js"></script>
</html>