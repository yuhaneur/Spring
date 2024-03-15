<%@page import="java.util.Arrays"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" 
    pageEncoding="UTF-8"%>
<%
	String accept = request.getHeader("accept");
	if(accept.contains("json")){
		response.setContentType("application/json;charset=UTF-8");
		%>
		{
			"result" : "정상 서비스 완료"
		}
		<%
	}else{
		response.setContentType("text/html;charset=UTF-8");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06.useRequest.jsp</title>
</head>
<body>
<h4>request 기본객체 활용</h4>
<pre>
	1. Line
		<%= request.getRequestURI() %>,<%=request.getMethod() %>
	2. Header
		request.getHeader(name),getHeaderNames(),getData[Int]Header(name)
	3. Body	
		1) parameter : String getParameter(name), String[] getParameterValues(name)
					getParameterNames(), getParameterMap()					
		2) multipart
		3) payload
</pre>
<table>
	<thead>
		<tr>
			<th>파라미터명</th>
			<th>파라미터값</th>
		</tr>	
	</thead>
	<tbody>
	<%
		request.setCharacterEncoding("utf-8");
		StringBuffer trTags = new StringBuffer();
		String ptrn = "<tr><td>%s</td><td>%s</td><tr>\n";
		Map<String,String[]> parameterMap =	request.getParameterMap();
		for(Entry<String,String[]> entry : parameterMap.entrySet()){
			String paramName = entry.getKey();
			String[] paramValues = entry.getValue();
			trTags.append(String.format(ptrn,paramName,Arrays.toString(paramValues)));
		}
	%>
	<%=trTags %>
	</tbody>
	
</table>



<h4>요청 헤더</h4>
<table>
	<thead>
	
		<tr>
			<td></td>
			<td></td>
		</tr>
	
	</thead>
	<tbody>
<%
	trTags.delete(0, trTags.length());
	Enumeration<String> names  = request.getHeaderNames(); 
	while (names.hasMoreElements()) {
		String name= (String) names.nextElement();
		String value = request.getHeader(name);
		trTags.append(String.format(ptrn,name,value));
	}
	%>
	<%=trTags %>
	</tbody>
</table>
</body>
</html>

<%
	}
%>