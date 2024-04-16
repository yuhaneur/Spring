<%@page import="kr.or.ddit.member.controller.MemberInsertControllerServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<form:form modelAttribute="${MemberInsertControllerServlet.MODELNAME }" method="post" enctype="application/x-www-form-urlencoded">
	<table class="table table-bordered">
		<tr>
			<th>회원번호</th>
			<td><form:input type="text" path="memId" required="true"
					class="form-control" />
				<form:errors path="memId" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>암호</th>
			<td><form:input type="text" path="memPass" required="true"
					class="form-control" />
				<form:errors path="memPass" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>회원명</th>
			<td><form:input type="text" path="memName" required="true"
					class="form-control" />
				<form:errors path="memName" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>앞자리주민</th>
			<td><form:input type="text" path="memRegno1"
					class="form-control" />
				<form:errors path="memRegno1" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>뒷자리주민</th>
			<td><form:input type="text" path="memRegno2"
					class="form-control" />
				<form:errors path="memRegno2" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td><form:input type="date" path="memBir" class="form-control" />
				<form:errors path="memBir" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>우편번호</th>
			<td><form:input type="text" path="memZip" required="true"
					class="form-control" />
				<form:errors path="memZip" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>기본주소</th>
			<td><form:input type="text" path="memAdd1" required="true"
					class="form-control" />
				<form:errors path="memAdd1" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>상세주소</th>
			<td><form:input type="text" path="memAdd2" required="true"
					class="form-control" />
				<form:errors path="memAdd2" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>집전화</th>
			<td><form:input type="text" path="memHometel"
					class="form-control" />
				<form:errors path="memHometel" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>컴텔</th>
			<td><form:input type="text" path="memComtel"
					class="form-control" />
				<form:errors path="memComtel" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>핸드폰번호</th>
			<td><form:input type="text" path="memHp" class="form-control" />
				<form:errors path="memHp" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>메일주소</th>
			<td><form:input type="text" path="memMail" required="true"
					class="form-control" />
				<form:errors path="memMail" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>직업</th>
			<td><form:input type="text" path="memJob" class="form-control" />
				<form:errors path="memJob" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>취미</th>
			<td><form:input type="text" path="memLike" class="form-control" />
				<form:errors path="memLike" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>기념일</th>
			<td><form:input type="text" path="memMemorial"
					class="form-control" />
				<form:errors path="memMemorial" cssClass="text-danger"
					element="span" /></td>
		</tr>
		<tr>
			<th>메모리얼데이</th>
			<td><form:input type="date" path="memMemorialday"
					class="form-control" />
				<form:errors path="memMemorialday" cssClass="text-danger"
					element="span" /></td>
		</tr>
		<tr>
			<th>마일리지</th>
			<td><form:input type="number" path="memMileage"
					class="form-control" />
				<form:errors path="memMileage" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>삭제여부</th>
			<td><form:input type="text" path="memDelete"
					class="form-control" />
				<form:errors path="memDelete" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="submit">저장</button>
				<button type="reset">취소</button>
			</td>
		</tr>
	</table>
</form:form>













