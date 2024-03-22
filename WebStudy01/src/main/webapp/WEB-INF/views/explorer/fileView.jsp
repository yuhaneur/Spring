<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.folder{
		text-decoration: underline;
		color: blue;
	}
</style>
</head>
<body>
<ul>
	<c:forEach items="${fileMap }" var="single">
		<li id="${single.key }" class="${single.value.file? 'file' : 'folder' }">${single.value.name }</li>
	</c:forEach>
</ul>
</body>
<script>
	document.addEventListener("dblclick",function(e){
		let elementId = e.target.id;
		if(e.target.classList.contains("folder")){
			location.href= `?base=\${elementId}`
		}
	})
</script>
</html>