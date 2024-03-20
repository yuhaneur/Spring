<%@page import="kr.or.ddit.vo.BtsVO"%>
<%@page import="java.util.List"%>
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
	List<BtsVO> btsList = (List<BtsVO>) request.getAttribute("BtsList"); 
%>
<form method="post" name="btsForm" enctype="application/x-www-form-urlencoded">
	<select name = "member" onchange="this.form.requestSubmit();" required>
		<option value>선택</option>
		<%
			for(BtsVO vo  : btsList){
				
				%>
					<option value="<%=vo.getCode() %>" label="<%=vo.getName() %>,<%=vo.getCount() %>" />
				
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