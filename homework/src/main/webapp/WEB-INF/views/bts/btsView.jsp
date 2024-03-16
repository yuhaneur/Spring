<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%Map<String,String> btsMap =  (Map)application.getAttribute("btsMap"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/bts" id="bts-form" method="post" name="frm">
        <select name="type" onchange="this.form.requestSubmit()">
		<%for(String key : btsMap.keySet()){
		%>
			<option value="<%=key%>"><%=btsMap.get(key) %></option>
		<%
		}
		%>

        </select>
    </form>
</body>
</html>