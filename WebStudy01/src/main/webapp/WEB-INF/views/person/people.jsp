<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%-- 웹에서 기본 컨텐츠 타입으로 사용되는 HTML 컨텐츠를 생성하기 위한 view layer --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#memDetail{
		width:600px;
		position: absolute;
		left : 700px;
		top: 500px;
	}
	#memDetail table{
		width :500px;
		height: 300px;
	}
	#memDetail table td,#memDetail table th{
		width: 300px;
	}
</style>
</head>
<body>
<c:set value="${pageContext.request.contextPath }" var="cPath" scope="application"/>
<form name="personForm" action="${cPath}/people.do" method="post">
	<input type="text" name="who"/>
</form>
<table>
	<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${people }" var="once">
		<tr>
			<td>${once.id }</td>
			<td><a href="javascript:;" onclick="clickHandler(event)" data-member-id="${once.id }">${once.name }</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<div id="memDetail"></div>
<script>
	 /* function clickHandler(event){
		event.preventDefault();
		let aTag = event.target;
		console.log(aTag.dataset.memberId);
		document.personForm.who.value= aTag.dataset.memberId;
		document.personForm.requestSubmit();
	} */
	
	 function clickHandler(event){
		console.log("Dddd")
		event.preventDefault();
		let aTag = event.target;
		let memberId = aTag.dataset.memberId;
		let url = "${pageContext.request.contextPath }/people.do";
		console.log(url)
		fetch(url,{
			method: 'POST',
			headers :{
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body : 'who='+memberId
		})
		.then(resp =>{
			if(resp.ok){
				return resp.text();
			}else{
				throw new Error("처리실패")
			}
		})
		.then(str=>{
			console.log("str",str)
			memDetail.innerHTML = str
		})
	}
			

	
</script>
</body>
</html>