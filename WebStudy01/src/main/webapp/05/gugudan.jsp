<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String minDan = request.getParameter("minDan");
String maxDan = request.getParameter("maxDan");
int nDan=0;
int mDan=0;
if((minDan!=null && !minDan.isEmpty())||(maxDan!=null && !maxDan.isEmpty())){
	try{
		nDan =Integer.parseInt(minDan);
		mDan = Integer.parseInt(maxDan);
		
	}catch(NumberFormatException e){
		response.sendError(400,e.getMessage());
		return;
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%! 
	StringBuffer firstDan(int nDan, int mDan){
		if(nDan>mDan)throw new IllegalArgumentException("최소단수가 최대단수보다 큽니다.");
		if(nDan<1)throw new IllegalArgumentException("최소단수는 1부터 시작할 수 있습니다.");
		StringBuffer sb = new StringBuffer();
		String str1 = "<tr><th>%d단</th>";
		String str2 = "<td>%d*%d=%d</td>";
		for(int i=nDan; i<=mDan;i++){
			sb.append(String.format(str1, i));
			for(int j=1;j<=9;j++){
				sb.append(String.format(str2, i,j,i*j));
			}
			sb.append("</tr>");
		}
		return sb;
	}

%>
<body>
<form action="">
	<input type="number" name="minDan" >
	<input type="number" name="maxDan" >
	<button type="submit">전송</button>
</form>
 <%try{
%>
 <table>
        <%=firstDan(nDan,mDan) %>
    </table>
<%
}catch(IllegalArgumentException e){
	response.sendError(400,e.getMessage());
}
%>
</body>
</html>