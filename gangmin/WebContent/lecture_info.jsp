<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />  
<%
	request.setCharacterEncoding("UTF-8");
	String isLogon = null;
	int mkey = 0;
	
	if(session.getAttribute("mkey")!=null){
		mkey = ((Integer)(session.getAttribute("mkey"))).intValue();
	 	String mnickname = (String)session.getAttribute("mnickname");
	 	isLogon = mnickname;
	}
%>
<c:set var="isLogon" value="<%=isLogon %>" />
<c:set var="mkey" value="<%=mkey %>"/>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>강의의 민족 강민</title>
    <link rel="stylesheet" href="${contextPath}/css/lecture_info.css">
    <script type="text/javascript" src="${contextPath}/js/lecture_info2.js"></script>
    
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
    <div class="content_wrap">
        <div>
            <div id="main">
                <img src="${contextPath}/images/${infoLecture.limage}">
                <div id="info">            
                    <h1 style="padding: 0;">${infoLecture.lid}</h1><br>
                    <h2>강사 : ${infoLecture.lname}</h2>
                    <dl>
                        <dd><strong>강좌유형</strong> : ${infoLecture.ltype}</dd>
            			<dd><strong>강좌구성</strong> : ${infoLecture.lconst}</dd>
            			<dd><strong>수강대상</strong> : ${infoLecture.luser}</dd>
           				<dd><strong>제작방식</strong> : ${infoLecture.lcreate}</dd>
            			<dd><strong>학습단계</strong> : ${infoLecture.llevel}</dd>
            			<dd><strong>수강기간</strong> : ${infoLecture.ltime}시간</dd>
            			<dd><strong>학원사</strong> : ${infoLecture.lacademy}</dd>
            			<dd><img src="${contextPath}/images/star.png" style="width:20px; height:20px;"> <fmt:formatNumber value="${lecture.lsumgrade / lecture.lcountgrade}" pattern=".00"/></dd>
                    </dl>
                    <h2>가격 : ${infoLecture.lduration}개월 / ${infoLecture.lprice}만원</h2>
                </div>   
            </div>
            <div class="classinfo">
                <table>
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
        </div>
        <div>
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
                    <input type="range" class="rate_radio" oninput="drawStar(this)" value="1" step="1" min="0" max="10" name="cscore">
                </span>
            </div>
            <div class="review_contents">
                <div class="warning_msg">5자 이상의 리뷰 내용을 작성해 주세요.</div>
                <textarea rows="10" class="review_textarea" name="ccontent"></textarea>
            </div>   
            <div class="cmd">
                <c:choose>
            		<c:when test="${empty isLogon}">
            			<input type="button" name="isnot_Logon" id="isnot_Logon" value="등록">
            			<input type="button" name="save" id="save" value="등록" style="display:none">
            		</c:when>
            		<c:otherwise>
            			<input type="hidden" name="mkey" value="${mkey}" />
            			<input type="hidden" name="lkey" value="${infoLecture.lkey}" />
            			<input type="button" name="isnot_Logon" id="isnot_Logon" value="등록" style="display:none">
                		<input type="button" name="save" id="save" value="등록">
                	</c:otherwise>
                </c:choose>
            </div>
        </form>
    </div>

    <div class="comment">
        <table class="review">
        	<c:choose>
        		<c:when test="${empty commentsList}">
        			<tr>
        				<td>
        					<span>등록된 강의후기가 없습니다.</span>
        				</td>
        			</tr>
        		</c:when>
        		<c:when test="${!empty commentsList}">
        			<c:forEach var="comment" items="${commentsList}" varStatus="commentNum">
        				<tr>
                			<th><h3>${comment.mnickname}</h3></th>
                			<td>
                    			<span>${comment.ccontent}</span>
                			</td>
                			<td>
                	    		<span class="review_rate">
                	        		★★★★★
                	        	<span class="review1" style="width:${comment.cscore * 20}%">★★★★★</span>
                	    		</span>
              	  			</td>
              	  			<td>
            	       			<span>${comment.cdate}</span>
            	    		</td>
            	    		<td>
            	    		<c:choose>
            	    			<c:when test="${comment.mkey eq mkey}">
             	       				<span onclick="revise(${comment.ckey},${infoLecture.lkey})"><a>삭제</a></span>
             	       			</c:when>
             	       			<c:otherwise>
             	       				<span><a>추천</a></span>             	       				            	       		
             	       			</c:otherwise>
            				</c:choose>
            	    		</td>
          	  			</tr>
          	  		</c:forEach>
        		</c:when>
        	</c:choose>
        </table> 
    </div>

    <!--<div class="comment">
        <ul>
            <li>
                <div class="nickname"><h3>섭섭한틀니</h3></div>
                <div class="content">
                    <div class="lec_info">한석원의 4의규칙</div>
                    <div class="commtent">정말 좋은 명강의인거 같아요!</div>
                </div>
                <div class="user_rating">
                    <span class="user_star">
                        <span>★★★★★</span>
                    </span>
                </div>
                <div class="reiview_info">
                    <span class="date">2023.04.10 14:25</span>
                    <span class="revise">수정/삭제</span>
                </div>
            </li>
        </ul>      
    </div>-->

</body>
</html>