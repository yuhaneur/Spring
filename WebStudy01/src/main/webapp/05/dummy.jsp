<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
	int max = 10;
	String maxParam = request.getParameter("max");
	if(maxParam!=null && !maxParam.isEmpty()){
		try{
			max = Integer.parseInt(maxParam);
			if(max<0)max =10;
		}catch(NumberFormatException e){
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.red{
		background-color: red;
	}
	.yellow{
		background-color: yellow;
	}
</style>
</head>
	<%! StringBuffer printNumber(int max){
		String li ="<li class='%s'>%d</li>";
		StringBuffer liTags = new StringBuffer();
		for(int i=1; i<=max;i++){
			boolean odd = i%2 ==1;
			String clzValue = odd ? "red" : "yellow"; 
			liTags.append(String.format(li,clzValue,i));
		}
		return liTags;
	}
		%>
<body>
<a href="?max=5">더미</a>
<img src="">
<form>
	<input name="max" type="number" value="<%=max%>">
	<button type="submit">전송</button>
</form>

	<ul>
	<%=printNumber(max)%>
	</ul>
	<script type="text/javascript">
		function put(){
			value = max.value;
			alert(value)
			max =0;
			if(value<0)max = 10;
			if(value=="")max = 10;
			
		}
	</script>
</body>
</html>