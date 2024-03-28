<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/inculdee/preScript.jsp"></jsp:include>
<style type="text/css">
	tr[data-mem-id]{
		cursor: pointer;
	}
	.modal-dialog{
		
	}
	
</style>
</head>
<body data-path=${pageContext.request.contextPath }>
<table class="table table-bordered table-striped">
	<thead class="table-dark">
		<tr>
			<th>이름</th>
			<th>휴대폰</th>
			<th>주소</th>
			<th>이메일</th>
			<th>마일리지</th>
		</tr>
	</thead>
	<tbody>
	
		<c:if test="${not empty memList }">
			<c:forEach var="mem" items="${memList }">
<!-- 			onclick="memDetail(this)" -->
				<c:set value="${mem.memId eq lastCreated.memId ? 'active' : ''}" var="clzValue"/>
				<tr class="${clzValue }" data-mem-id="${mem.memId }"  data-bs-toggle="modal" data-bs-target="#staticBackdrop">
					<td>${mem.memName }</td>
					<td>${mem.memHp }</td>
					<td>${mem.memAdd1 } ${mem.memAdd2 }</td>
					<td>${mem.memMail }</td>
					<td>${mem.memMileage }</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty memList }">
			<tr>
				<td colspan="6">회원 정보 없음.</td>
			</tr>
		</c:if>
		<c:remove var="lastCreated" scope="session"/>
	</tbody>
</table>

<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="staticBackdropLabel">Modal title</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      	<table>
      		<tr><th>회원번호</th><td id="memId"></td></tr>
			<tr><th>암호</th><td id="memPass"></td></tr>
			<tr><th>회원명</th><td id="memName"></td></tr>
			<tr><th>앞자리주민</th><td id="memRegno1"></td></tr>
			<tr><th>뒷자리주민</th><td id="memRegno2"></td></tr>
			<tr><th>생년월일</th><td id="memBir"></td></tr>
			<tr><th>우편번호
			</th><td id="memZip"></td></tr>
			<tr><th>기본주소</th><td id="memAdd1"></td></tr>
			<tr><th>상세주소</th><td id="memAdd2"></td></tr>
			<tr><th>집전화</th><td id="memHometel"></td></tr>
			<tr><th></th><td id="memComtel"></td></tr>
			<tr><th>핸드폰번호</th><td id="memHp"></td></tr>
			<tr><th>메일주소</th><td id="memMail"></td></tr>
			<tr><th>직업</th><td id="memJob"></td></tr>
			<tr><th>취미</th><td id="memLike"></td></tr>
			<tr><th>기념일</th><td id="memMemorial"></td></tr>
			<tr><th></th><td id="memMemorialday"></td></tr>
			<tr><th>마일리지</th><td id="memMileage"></td></tr>
			<tr><th>삭제여부</th><td id="memDelete"></td></tr>
      	</table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Understood</button>
      </div>
    </div>
  </div>
</div>
</body>
<jsp:include page="/WEB-INF/inculdee/postScript.jsp"></jsp:include>
<script src="<c:url value="/resources/js/app/member/memberList.js"/>"></script>
<%-- <script src="<c:url value="/resources/js/app/member/memberDetail.js"/>"></script> --%>
</html>