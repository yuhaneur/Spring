<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
		int nm = 5;
		String a = request.getParameter("num");
		if(a!=null&& !a.isEmpty()){
			try{
				nm = Integer.parseInt(a);
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
long sigma(int nm){
	if(nm <1 || nm >10)
		throw new IllegalArgumentException("1부터 10 사이의 피연산자만 처리 가능.");
	if(nm==1)return 1;
	else return nm + sigma(nm-1);
// 	sigma(1)= 1;
// 	sigma(2)= 2 + sigma(1);
// 	sigma(3)= 3 + sigma(2);
}
long factorial(int nm){
	if(nm <1 || nm >10)
		throw new IllegalArgumentException("1부터 10 사이의 피연산자만 처리 가능.");
	if(nm==1)return 1;
	else return nm * factorial(nm-1);
// 	sigma(1)= 1;
// 	sigma(2)= 2 + sigma(1);
// 	sigma(3)= 3 + sigma(2);
}


// int sigma(int nm){
// 	int sum = 0;
// 	for(int i =1;i<=nm;i++){
// 		sum+=i;
// 	}
// 	return sum;
// }
// int factorial(int nm){
// 	int mul = 1;
// 	for(int i =1;i<=nm;i++){
// 		mul*=i;
// 	}
// 	return mul;
// }
	%>
<body>

<form action="">
	<input type="number" name="num" min="1" max="10" value="<%=nm %>"/>
	<button type="submit">전송</button>
</form>
<%try{ %>
<h4>누적 합 : <%=sigma(nm) %></h4>
<h4>누적 곱 : <%=factorial(nm) %></h4>
<%}catch(IllegalArgumentException e){
	response.sendError(400, e.getMessage());
}
	%>
</body>
</html>