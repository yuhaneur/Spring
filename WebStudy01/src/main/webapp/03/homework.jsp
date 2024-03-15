<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String[] fileName = (String[])request.getAttribute("fileName"); 
if (fileName!=null){
%>

		<form action="<%=request.getContextPath() %>/imageForm.do" method="get">
            <select name="image">
	            <%for(String file : fileName){
	            %>
	            <option><%=file %></option>
	            <% 
	            }
	            %>
            </select>
            <button type="submit">이미지 랜더링</button>
        </form>
<%
}else{
%>
<form action="<%=request.getContextPath() %>/imageForm.do" method="get">
            <select name="image">
	            <option></option>
            </select>
            <button type="submit">이미지 랜더링</button>
        </form>
<%
}
%>
        <script type="text/javascript">
        	
        </script>
</body>
</html>