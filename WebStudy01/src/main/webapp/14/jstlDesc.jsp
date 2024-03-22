<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>14/jstlDesc.jsp</title>
</head>
<body>
<h4>JSTL(Jsp Standard Tag Library)</h4>
<pre>
	: 커스텀 태그 라이브러리
	*** 커스텀 태그 로딩이 필요함.&lt;%@ taglib uri="태그식별"  prefix="namespace"%&gt;
	&lt;namespace:tagname attribute_name="attribute_value"&gt;
	*** Core 태그(c 태그)
	1. (EL 변수)속성 지원 : set, remove
		 <c:set var="dummy" value="TEXT" scope="session"/> var 새로만든 속성이름 / value 값/ scope(생략시 page스코프)
		 ${dummy }
<%-- 		 <c:remove var="dummy" scope="session"/> scope를 설정 안하면 리무브할때 모든 스코프에있는 속성 이름을 다지움 --%>
		 (flash attribute)
		 ${dummy }
		 <c:set var="dummyClone" value="${not empty dummy ? dummy : 'default' }"/>
		 ${dummyClone }
		 
	2. 조건문 : if, choose_when_otherwise (자바의 스위치)
		<c:if test="${not empty dummy}">
			${dummy }
		</c:if>
		<c:if test="${empty dummy}">
			default
		</c:if>
		
		<c:choose>
			<c:when test="${not empty dummy}">
				${dummy }
			</c:when>
			<c:otherwise>
				default
			</c:otherwise>
		</c:choose>
		
	3. 반복문 : foreach , forTokens
		for(선언절;조건절;증감절)  (var="i" begin="1" /int i = 1 )(step="1" = i++)(end="5" = &lt;=5)
		<c:forEach var="i" begin="1" step="2" end="5" varStatus="vs"> (varStatus="vs" 반복문 상태 확인가능) 
			첫번째 반복문 여부 : ${vs.first } 
			마지막 반복문 여부 : ${vs.last }
			몇번째 반복문 : ${vs.count }
			${i }
		</c:forEach>
		토큰?
		intnumber=3; (1개의 토큰)
		int number = 3; (공백을 기준으로 4개의 토큰)
		아버지가 방에 들어가신다
		아버지 가방에 들어가신다
		(delims=" " 구분자)
		<c:forTokens items="아버지 가방에 들어가신다" delims=" " var="token">
			${token }
		</c:forTokens>
		<c:set var="numbers" value="1,2,3,4,5"/>
		<c:forTokens items="${numbers }" delims="," var="num">
			${num * 100 }
		</c:forTokens>
	4. 흐름제어용 : redirect
<%-- 		<c:redirect url="/14/elDesc.jsp"/> --%>
	5. 기타 : url , out, import
		<c:url value="/14/elDesc.jsp" var="elDesc">
			<c:param name="q1" value="v1"></c:param>
			<c:param name="q2" value="v2"></c:param>
		</c:url>
		${elDesc }
		<c:out value="<h4>출력텍스트</h4>" escapeXml="false"/>
		
		<c:set var="htmlSource" value="<h4>출력텍스트</h4>"/>
		<c:out value="${htmlSource }" escapeXml="false"></c:out>
</pre>
<c:import url="https://www.naver.com" var="naver"/>
<c:out value="${naver }" escapeXml="true"></c:out>
</body>
</html>