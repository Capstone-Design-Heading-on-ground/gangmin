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
    <link rel="stylesheet" href="${contextPath}/css/style3.css">
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
        	<form name = "frmsearch">
            <div id="search">
                <input type="text" id="searchlecture" onkeypress="findlecture(event)" placeholder="검색어를 입력해주세요." name="findl">
            </div>
            </form>
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
                	<form method="get" action="/" name="categorySearch">
                    <div class="category">
                        <p>학원사</p>
                        <div class="checkboxs1">
                            <li>
                                <input type="checkbox" id="category_toggle1" value="이투스" name="checkList">
                                <label for="category_toggle1"><p>이투스</p></label>
                            </li>
                            <li>
                                <input type="checkbox" id="category_toggle2" value="대성마이맥" name="checkList">
                                <label for="category_toggle2"><p>대성마이맥</p></label>
                            </li>
                            <li>
                                <input type="checkbox" id="category_toggle3" value="메가스터디" name="checkList">
                                <label for="category_toggle3"><p>메가스터디</p></label>
                            </li>
                            <li>
                                <input type="checkbox" id="category_toggle4" value="스카이에듀" name="checkList">
                                <label for="category_toggle4"><p>스카이에듀</p></label>
                            </li>
                            <li>
                                <input type="checkbox" id="category_toggle5" value="오르비" name="checkList">
                                <label for="category_toggle5"><p>오르비</p></label>
                            </li>
                            <li>
                                <input type="checkbox" id="category_toggle6" value="ebsi" name="checkList">
                                <label for="category_toggle6"><p>ebsi</p></label>
                            </li>
                        </div>
                    </div>
                    <div class="category">
                        <p>계열</p>
                        <div class="checkboxs1">
                            <li>
                                <input type="radio" name="rd_line" id="p1" value="인문계열" checked="checked">
                                <label for="p1"><p>인문계열</p></label>
                            </li>
                            <li>
                                <input type="radio" name="rd_line" id="p2" value="자연계열">
                                <label for="p2"><p>자연계열</p></label>
                            </li>
                        </div>
                    </div>
                    <div class="category">
                        <p>과목</p>
                        <div class="checkboxs2" id="line1">
                            <li>
                                <input type="radio" name="rd_sub1" id="k1" value="국어">
                                <label for="k1"><p>국어</p></label>
                            </li>
                            <li>
                                <input type="radio" name="rd_sub1" id="k2" value="수학">
                                <label for="k2"><p>수학</p></label>
                            </li>
                            <li>
                                <input type="radio" name="rd_sub1" id="k3" value="영어">
                                <label for="k3"><p>영어</p></label>
                            </li>
                            <li>
                                <input type="radio" name="rd_sub1" id="k4" value="생활과 윤리">
                                <label for="k4"><p>생활과 윤리</p></label>
                            </li>
                            <li>
                                <input type="radio" name="rd_sub1" id="k5" value="윤리와 사상">
                                <label for="k5"><p>윤리와 사상</p></label>
                            </li>
                            <li>
                                <input type="radio" name="rd_sub1" id="k6" value="한국 지리">
                                <label for="k6"><p>한국 지리</p></label>
                            </li>
                            <li>
                                <input type="radio" name="rd_sub1" id="k7" value="세계 지리">
                                <label for="k7"><p>세계 지리</p></label>
                            </li>
                        </div>
                        <div class="checkboxs2" id="line2">
                            <li><input type="radio" name="rd_sub2" id="m1" value="국어"><label for="m1"><p>국어</p></label></li>
                            <li><input type="radio" name="rd_sub2" id="m2" value="수학"><label for="m2"><p>수학</p></label></li>
                            <li><input type="radio" name="rd_sub2" id="m3" value="영어"><label for="m3"><p>영어</p></label></li>
                            <li><input type="radio" name="rd_sub2" id="m4" value="물리"><label for="m4"><p>물리</p></label></li>
                            <li><input type="radio" name="rd_sub2" id="m5" value="화학"><label for="m5"><p>화학</p></label></li>
                            <li><input type="radio" name="rd_sub2" id="m6" value="생물"><label for="m6"><p>생물</p></label></li>
                            <li><input type="radio" name="rd_sub2" id="m7" value="지구과학"><label for="m7"><p>지구과학</p></label></li>
                        </div>
                    </div>
                    <div class="category">
                        <p>단원</p>
                        <div class="checkboxs2" id="korean">
                            <li><input type="radio" name="radio_final" value="화법과 작문" id="kk1"><label for="kk1"><p>화법과 작문</p></label></li>
                            <li><input type="radio" name="radio_final" value="문학" id="kk2"><label for="kk2"><p>문학</p></label></li>
                            <li><input type="radio" name="radio_final" value="비문학" id="kk3"><label for="kk3"><p>비문학</p></label></li>
                        </div>
                        <div class="checkboxs2" id="math">
                            <li><input type="radio" name="radio_final" value="수학I" id="mm1"><label for="mm1"><p>수학I</p></label></li>
                            <li><input type="radio" name="radio_final" value="수학II" id="mm2"><label for="mm2"><p>수학II</p></label></li>
                            <li><input type="radio" name="radio_final" value="미적분" id="mm3"><label for="mm3"><p>미적분</p></label></li>
                            <li><input type="radio" name="radio_final" value="확률과 통계" id="mm4"><label for="mm4"><p>확률과 통계</p></label></li>
                            <li><input type="radio" name="radio_final" value="기하와 벡터" id="mm5"><label for="mm5"><p>기하와 벡터</p></label></li>
                        </div>
                    </div>
                    </form>
                </div>
                <form name = "frmcate">
                <div id="sort" name = "sort">
                    <input type="radio" name="do_sort" id="toggle1" value="sort_pop" checked="checked" onclick="togglecon1(event)"/>
                    <label for="toggle1"><li>인기강의순</li></label>
                    
                    <input type="radio" name="do_sort" id="toggle2" value="sort_new" onclick="togglecon1(event)"/>
                    <label for="toggle2"><li>신규강의순</li></label>
                    
                    <input type="radio" name="do_sort" id="toggle3" value="sort_low" onclick="togglecon1(event)"/>
                    <label for="toggle3"><li>낮은가격순</li></label>
                    
                    <input type="radio" name="do_sort" id="toggle4" value="sort_high" onclick="togglecon1(event)"/>
                    <label for="toggle4"><li>높은가격순</li></label>
                    
                    <input type="radio" name="do_sort" id="toggle5" value="sort_name" onclick="togglecon1(event)"/>
                    <label for="toggle5"><li>강의명순</li></label>                                 
                </div>
                </form>
                <input type="button" value="결과 내 검색" id="search3" onclick="doSearch2()" name="btn_search2"/>
                <c:choose>
                	<c:when test="${empty lecturesList }">
                		<div class="classes">
                			<h2>등록된 강의가 없습니다.</h2>
                		</div>
                	</c:when>
                	<c:when test="${!empty lecturesList }">
                		<c:forEach var="lecture" items="${lecturesList }" varStatus="lectureNum">
                			<div class="classes">
                				<img class="profile" src="${contextPath}/images/${lecture.limage}" style="width:100px;hight:100px">
                				<div class="div1">
                					<a href="${contextPath}/lecture/connectLecture?lkey=${lecture.lkey}">
                					<h2 style="width:300px;font-size:18px;">${lecture.lid}</h2>
                					</a>
                					<img class="star" src="${contextPath}/images/star.png">
                					<b><fmt:formatNumber value="${lecture.lsumgrade / lecture.lcountgrade}" pattern=".00"/></b>(${lecture.lcountgrade})
                				</div>
                				<div class="div2">
                					<h3>${lecture.lduration}개월 / ${lecture.lprice}원</h3>
                					<input type="button" onclick="location.href='${contextPath}/lecture/connectLecture?lkey=${lecture.lkey}'" value="후기 보러가기">
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
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="${contextPath}/js/event2.js"></script>
<script src="${contextPath}/js/search.js"></script>
<script src="${contextPath}/js/script.js"></script>
</html>