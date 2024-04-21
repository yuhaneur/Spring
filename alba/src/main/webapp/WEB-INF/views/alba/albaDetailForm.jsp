<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	<input type="hidden" value="${alba.alId }">
		<tr>
			<th>이름</th>
			<td>${alba.alName }</td>
		</tr>
		<tr>
			<th>성별</th>
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
		</tr>
		<tr>
			<th>지역</th>
			<td>${alba.alAddr1 }</td>
		</tr>
		<tr>
			<th>학력</th>
			<td>${alba.grade.grName }</td>
		</tr>
		<tr>	
			<th>자격증</th>
			<td>
				<c:forEach items="${alba.mylicList}" var="mylic">
	                ${mylic.licence.licName}
	                <br>
	            </c:forEach>
			</td>
		</tr>
		<tr>
			<th>경력사항</th>
			<td>${alba.alCareer }</td>
		</tr>
	</table>
</body>
</html>