<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h4>JSP</h4>
<pre>
	: 자바와 서블릿 스펙을 기반으로 SSR 을 구현하는 템플릿 엔진.
	SSR(Server Side Rendering) : document의 모든 엘리먼트가 서버에서 텍스트 템플릿으로 생성되는 구조.(JSP)
		템플릿 엔진 : 데이터와 템플릿이 분리되어 개발되고, 분리된 두 요소를 결합해 최종 컨텐츠를 생성하는 소프트웨어
			content -> Mime type (maintype/subtype)
			ex) HTML , JSON, Image, XML(application/xml)
	CSR(Client Side Rendering) : 엘리먼트는 클라이언트측 에서 생성되고, 서버에서 데이터만 서비스 받는 구조.(React, VueJs)
	
	jsp 문법 구성요소
	1. 정적 텍스트 : 일반텍스트 , HTML, JS, CSS
	2. 스크립틀릿(scriptlet, 동적 요소를 위한 백그라운드 코드)
		1) scriptlet : &lt;% // java code %&gt;
			<%
				// 블럭 변수 --> 지역 변수 --> 인스턴스 변수 --> 클래스 정적(static)변수
				String data = "데이터";
				LocalDate now = LocalDate.now();
			%>
		2) directive : &lt;%@  %&gt; --> 실행코드와 무관하게 jsp 페이지에 대한 부가적인 환경 설정에 사용.
			- page(required) 
			- taglib(optional) - custom tag 로딩에 사용. 
			- include(optional) - 정적 include 에 사용
			
		3) expresssion : &lt;%= 출력할 값이나 표현식. %&gt;
			<%=data %>, <%=now %>
			<% out.println(now); %>
			
		4) declaration : &lt;%! %&gt; --> 전역 코드 선언에 사용.
			<%!
				static String staticData = "정역 데이터";
				void dummy(){};
			%>
		5) comment : <%-- --%>
			주석의 종류
			- Client side comment : HTML, JS , CSS comment
			- Server side comment : Java , JSP comment
<!-- 			HTML 주석  -->
<!-- 		<style type="text/css"> -->
<!-- /* 			body { */ -->
<!-- /* 				background-color: red; */ -->
<!-- /* 			} */ -->
<!-- 		</style> -->
			<script type="text/javascript">
// 				var dummy = "더미";
			</script>
			<%-- JSP주석 --%>
	3. 기본객체
	4. action tag
	5. 표현언어(EL) ${attributeName }
	6. JSPL 커스텀 태그 라이브러리
</pre>
