<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/inculdee/preScript.jsp"></jsp:include>
</head>
<body>
<%
	Map<String,String[]> btsMap = (Map) application.getAttribute("btsMap"); 
%>
<form  method="post" name="btsForm" enctype="application/x-www-form-urlencoded">
	<select name = "member" onchange="this.form.requestSubmit();" required>
		<option value>선택</option>
		<%
			for(Entry<String,String[]> entry : btsMap.entrySet()){
				%>
				<option value="<%=entry.getKey() %>" label="<%=entry.getValue()[0] %>" />
				<%
			}
		%>
	</select>
</form>
<div id='result-area'>
	
</div>
<script src="<%=request.getContextPath() %>/resources/js/app/js/bts.js"></script>
<jsp:include page="/WEB-INF/inculdee/postScript.jsp"></jsp:include>
</body>
</html>