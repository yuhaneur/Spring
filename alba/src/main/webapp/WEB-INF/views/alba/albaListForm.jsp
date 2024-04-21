<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/includee/preScript.jsp"/>
</head>
<body data-cpath="${pageContext.request.contextPath }">

	<button id="insertBtn" type="button">알바생 등록하기</button>
	<br><br>
	<table border="1px">
		<tr>
			<th>이름</th>
			<th>성별</th>
			<th>지역</th>
			<th>학력</th>
			<th>자격증</th>
			<th>경력사항</th>
		</tr>
		<c:forEach items="${albaList }" var="alba">
		<tr>
			<td><a href="<c:url value='/alba/${alba.alId }'/>">${alba.alName }</a></td>
			<td>
				<c:choose>
			        <c:when test="${alba.alGen eq 'M'}">
			            남자
			        </c:when>
			        <c:otherwise>
			            여자
			        </c:otherwise>
    			</c:choose>
			</td>
			<td>${alba.alAddr1 }</td>
			<td>${alba.grade.grName }</td>
			<td>
				<c:forEach items="${alba.mylicList}" var="mylic">
	                ${mylic.licence.licName}
	                <br>
	            </c:forEach>
			</td>
			<td>${alba.alCareer }</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="6">
			${pagingHTML }
<!-- 				이름, 지역, 전체 , 세가지 검색 조건으로 검색 및 페이징 처리. -->
<!-- 				recordCount = 3, pageSize =2 -->
				<div id="searchUI">
					<form:select path="paging.simpleCondition.searchType">
						<form:option value="" label="전체"/>
						<form:option value="name" label="이름"/>
						<form:option value="address" label="지역"/>
					</form:select>
					<form:input  path="paging.simpleCondition.searchWord"/>
					<button id="searchBtn">검색</button>
				</div>
			</td>
		</tr>
	</table>
	<form:form modelAttribute="paging" method="get" action="${pageContext.request.contextPath }/alba"  id="searchForm">
		<form:input path="simpleCondition.searchType"/>
		<form:input path="simpleCondition.searchWord"/>
		<input type="text" name="currentPage" value="1">
	</form:form>
	<script type="text/javascript">
		const cpath = document.body.dataset.cpath;
		const $searchForm = $("#searchForm");
		console.log("cpath",cpath);
		console.log("searchForm",searchForm);
			insertBtn.addEventListener('click',function(){
				location.href=`\${cpath}/alba/insert`
			})
			
		function ${pagingFunction}(page){
			console.log("page",page)
			searchForm.currentPage.value=page;
			$searchForm.submit();
		}
	
		$("#searchBtn").on("click", function(event){
			let $searchUI = $(this).parents("#searchUI");
			$searchUI.find(":input[name]").each(function(idx,ipt){
				let name = this.name;
				let value = $(this).val();
				searchForm.searchType =value;
				searchForm[name].value = value;
			});
			$searchForm.submit();
		});
	</script>
<jsp:include page="/WEB-INF/includee/postScript.jsp"/>
</body>
</html>