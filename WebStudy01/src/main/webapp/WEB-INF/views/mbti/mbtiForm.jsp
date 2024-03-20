<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Map.Entry"%>
<%@ page contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MBTI</title>
</head>
<%
String result = (String)request.getAttribute("result"); 
if(StringUtils.isNotBlank(result)){
%>
<script type="text/javascript">
	document.addEventListener("DOMContentLoaded",()=>{
		window['mbti-form'].type.value="<%=result%>";
		document.forms[0].requestSubmit();
	});
</script>
<%
}
%>

<body>
    <form id="mbti-form" method="post" name="frm">
        <select name="type" onchange="this.form.requestSubmit()">
        	<%
        		Map<String,String> mbtiMap = (Map)application.getAttribute("mbtiMap");
        		for(Entry<String,String> entry : mbtiMap.entrySet()){
        			%>
		            <option value="<%=entry.getKey()%>"><%=entry.getValue() %></option>
        			<%
        		}
        	%>

        </select>
    </form>
    <div id="mbti-area">
    
    </div>
<script src="<%=request.getContextPath() %>/resources/js/app/js/mbtiForm.js"></script>
</body>
</html>