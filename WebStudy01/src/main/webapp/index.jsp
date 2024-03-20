<%@page import="org.apache.catalina.Role"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.catalina.users.MemoryUser"%>
<%@page import="java.security.Principal"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String message = request.getParameter("message");
	if(StringUtils.isNotBlank(message)){
%>
<script type="text/javascript">
	alert("<%=message%>");
</script>
<%
	}
%>
</head>
<body>
	<h4>웰컴페이지</h4>
	<form name="frm" method="post">
	<%
		MemoryUser principal =  (MemoryUser)request.getUserPrincipal();
// 		String authId = (String)session.getAttribute("authId");
		if(principal!=null){
			StringBuffer roleNames = new StringBuffer();
			Iterator<Role> roles =  principal.getRoles();

			%>
			
			<%=principal.getName()%>님.<%=roleNames %> 
			<a href="<%=request.getContextPath()%>/login/logout.do" onclick="logout()">로그아웃</a>
			<%
		}else{
			%>
			<a href="<%=request.getContextPath() %>/login/loginForm.jsp">로그인</a>
			<%
		}
	%>
	</form>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/app/js/logout.js"></script>
</body>
</html>