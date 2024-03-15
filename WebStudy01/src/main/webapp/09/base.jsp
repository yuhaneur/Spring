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
<div class="container">
	<div class="card">
		<jsp:include page="/09/fragment1.jsp"/>
<%-- 		<iframe src="<%=request.getContextPath() %>/09/fragment1.jsp"></iframe> --%>
	</div>
	<div class="card">
		<jsp:include page="/09/fragment2.jsp"/>
	</div>
</div>
<jsp:include page="/WEB-INF/inculdee/postScript.jsp"></jsp:include>
<%-- 	<iframe src="<%=request.getContextPath() %>/WEB-INF/inculdee/postScript.jsp"></iframe> --%>
</body>
</html>