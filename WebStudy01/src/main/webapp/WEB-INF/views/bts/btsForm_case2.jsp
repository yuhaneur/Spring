<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/inculdee/preScript.jsp"></jsp:include>
</head>
<body>

<form method="post" name="btsForm" enctype="application/x-www-form-urlencoded">
	<select name = "member" onchange="this.form.requestSubmit();" required>
		<option value>선택</option>
		<c:forEach items="${BtsList }" var="vo">
			<option value="${vo.code }" label="${vo.name },${vo.count}" />
		</c:forEach>
	</select>
</form>
<div id='result-area'>
	
</div>
<script src="<%=request.getContextPath() %>/resources/js/app/js/bts.js"></script>
<jsp:include page="/WEB-INF/inculdee/postScript.jsp"></jsp:include>
</body>
</html>