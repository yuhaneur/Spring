<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String res = (String)request.getAttribute("res");
String leftOp = (String)request.getAttribute("leftOp");
String rightOp = (String)request.getAttribute("rightOp");
String sachick = (String)request.getAttribute("sachick");
System.out.println("sachick"+sachick);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%=leftOp %>   <%=sachick %>   <%=rightOp %>  = <%= res%></h1>
</body>
</html>