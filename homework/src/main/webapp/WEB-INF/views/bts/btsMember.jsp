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
<jsp:include page="/WEB-INF/views/bts/title.jsp"></jsp:include>
<%
	String path = (String)request.getAttribute("path");
%>
<jsp:include page="<%=path %>"></jsp:include>
</body>
<jsp:include page="/WEB-INF/inculdee/postScript.jsp"></jsp:include>
</html>