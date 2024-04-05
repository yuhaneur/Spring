<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<tiles:insertAttribute name="preScript"/>
	<c:if test="${not empty message }">
	<script>
		alert("${message}");
	</script>
	<c:remove var="message" scope="session" />
</c:if>
</head>
<body data-context-path="${pageContext.request.contextPath }" data-new-mem-id=${request.memId }>
	<div class="container">
		<main>
			<tiles:insertAttribute name="content"/>
		</main>
	</div>
	<tiles:insertAttribute name="postScript"/>
</body>
</html>