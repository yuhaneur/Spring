<%@page import="kr.or.ddit.vo.BtsVO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>14/elDesc.jsp</title>
</head>
<body>
<h4>EL(Expression Language, 표현 언어)</h4>
<pre>
	값을 출력하기 위한 목적으로 사용되는 스크립트 언어
	표현식을 대체하는 용도로 사용됨.
	<%=23 %>, ${23 }
	<%
		String text = "TEXT";
		session.setAttribute("textAttr", text);
	%>
	<%=text %> , ${textAttr }, <%=session.getAttribute("textAttr") %>
	request : ${request }, ${pageContext.request } ,${pageContext }
	session : ${session }, ${pageContext.session }
	<%
		pageContext.setAttribute("attr", "23");
	%>
	산술연산자 : ${23+12 } ,${attr+12 }, ${attr*12 }, ${attr/12 }, \${attr++ }
		=, ++, concat은 지원하지 않음.
	논리연산자 : &&(and), ||(or) , !(not) 
			${true and true } , ${dummy and true } ,${not true } , ${not dummy }
	비교연산자 : >(gt) , <(lt) , ==(eq), >=(ge) , <=(le) , !=(ne)
			${23 ne 35 }	,${23 lt 35 }, ${23 ge 35 }
	삼항연산자 : 논리값?  참:거짓
			${23 lt 35 ? "작다" : "크거나같다" }
	<%
		pageContext.setAttribute("dummy", "  ");
		List sample = new ArrayList();
		sample.add("element1");
		pageContext.setAttribute("sample", sample);
		Map map = new HashMap();
		map.put("key1", "value1");
		map.put("key-2", "value2");
		pageContext.setAttribute("dummyMap", map);
		BtsVO bts = new BtsVO("B001","뷔","path");
		pageContext.setAttribute("bts", bts);
	%>
	단항연산자 : empty(비어있다)
			${empty dummy } ,${not empty dummy }
			sample의 존재여부 : ${empty sample ? "비어있음" : "비어있지않음" }
			${sample.get(0) } , ${sample[0] }
			${dummyMap.get("key1") } ,${dummyMap.key1 }, ${dummyMap['key1'] }
			${dummyMap.get("key-2") } ,${dummyMap.key-2 }, ${dummyMap['key-2'] }
			${bts.getName() } , ${bts.name }, ${bts['name'] }
</pre>
<script>
	let attr = 35;
	console.log(`\${attr}`)
</script>
</body>
</html>