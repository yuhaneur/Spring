<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body >
<form name="calForm" action="${pageContext.request.contextPath}/mission/case08_9" method="post" enctype="application/x-www-form-urlencoded">
	<input type="number" name="leftOp">
	<select name="operator">
		<option value="PLUS">+</option>
		<option value="MINUS">-</option>
		<option value="MULTIPLY">*</option>
		<option value="DIVIDE">/</option>
	</select>
	<input type="number" name="rightOp">
	<button id="sbmBtn" type="submit">=</button>
</form>
<script type="text/javascript"src="${pageContext.request.contextPath}/resources/js/app/case08_9/calForm.js"></script>
</body>
</html>