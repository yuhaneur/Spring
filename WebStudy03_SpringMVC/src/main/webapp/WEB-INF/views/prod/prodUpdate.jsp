<%@page import="kr.or.ddit.prod.controller.ProdUpdateController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form modelAttribute="<%=ProdUpdateController.MODELNAME %>"
	action="${pageContext.request.contextPath }/prod/prodUpdate.do"
	method="post"
	enctype="multipart/form-data">
	<table class="table table-bordered table-striped">
		<tr>
			<th>상품코드</th>
			<td><form:input type="text" path="prodId" required="true"
					class="form-control" />
				<form:errors path="prodId" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>상품명</th>
			<td><form:input type="text" path="prodName" required="true"
					class="form-control" />
				<form:errors path="prodName" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>상품분류</th>
			<td><form:input type="hidden" path="prodLgu" required="true"
					class="form-control" />
				<form:errors path="prodLgu" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>거래처</th>
			<td><form:input type="hidden" path="prodBuyer" required="true"
					class="form-control" />
				<form:errors path="prodBuyer" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>구매가</th>
			<td><form:input type="number" path="prodCost" required="true"
					class="form-control" />
				<form:errors path="prodCost" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>판매가</th>
			<td><form:input type="number" path="prodPrice" required="true"
					class="form-control" />
				<form:errors path="prodPrice" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>세일가</th>
			<td><form:input type="number" path="prodSale" required="true"
					class="form-control" />
				<form:errors path="prodSale" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>요약정보</th>
			<td><form:input type="text" path="prodOutline" required="true"
					class="form-control" />
				<form:errors path="prodOutline" cssClass="text-danger"
					element="span" /></td>
		</tr>
		<tr>
			<th>상세정보</th>
			<td><form:input type="text" path="prodDetail"
					class="form-control" />
				<form:errors path="prodDetail" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>이미지</th>
			<td>
				<input type="file" name="prodImage"/>
				<form:hidden  path="prodImg" required="true"
					class="form-control" />
				<form:errors path="prodImg" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>총재고</th>
			<td><form:input type="number" path="prodTotalstock"
					required="true" class="form-control" />
				<form:errors path="prodTotalstock" cssClass="text-danger"
					element="span" /></td>
		</tr>
		<tr>
			<th>입고일</th>
			<td><form:input type="date" path="prodInsdate"
					class="form-control" />
				<form:errors path="prodInsdate" cssClass="text-danger"
					element="span" /></td>
		</tr>
		<tr>
			<th>적정재고</th>
			<td><form:input type="number" path="prodProperstock"
					required="true" class="form-control" />
				<form:errors path="prodProperstock" cssClass="text-danger"
					element="span" /></td>
		</tr>
		<tr>
			<th>크기</th>
			<td><form:input type="text" path="prodSize" class="form-control" />
				<form:errors path="prodSize" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>색상</th>
			<td><form:input type="text" path="prodColor"
					class="form-control" />
				<form:errors path="prodColor" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>배송방법</th>
			<td><form:input type="text" path="prodDelivery"
					class="form-control" />
				<form:errors path="prodDelivery" cssClass="text-danger"
					element="span" /></td>
		</tr>
		<tr>
			<th>단위</th>
			<td><form:input type="text" path="prodUnit" class="form-control" />
				<form:errors path="prodUnit" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>입고량</th>
			<td><form:input type="number" path="prodQtyin"
					class="form-control" />
				<form:errors path="prodQtyin" cssClass="text-danger" element="span" /></td>
		</tr>
		<tr>
			<th>단위</th>
			<td><form:input type="number" path="prodQtysale"
					class="form-control" />
				<form:errors path="prodQtysale" cssClass="text-danger"
					element="span" /></td>
		</tr>
		<tr>
			<th>마일리지</th>
			<td><form:input type="number" path="prodMileage"
					class="form-control" />
				<form:errors path="prodMileage" cssClass="text-danger"
					element="span" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="수정하기"></td>
		</tr>
		<tr>
			<th>구매자 정보</th>
			<td>
				<table class="table table-bordered table-striped">
					<thead class="table-dark">
						<tr>
							<th>구매자명</th>
							<th>이메일주소</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${not empty prod.cartList }">
							<c:forEach items="${prod.cartList }" var="cart">
								<tr>
									<c:set value="${cart.member }" var="member" />
									<td>${member.memName}</td>
									<td>${member.memMail}</td>
								</tr>
							</c:forEach>
						</c:if>
						<c:if test="${empty prod.cartList }">
							<tr>
								<td colspan="2">구매자가 없습니다.</td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</td>
		</tr>

	</table>
</form:form>
<script
	src="${pageContext.request.contextPath}/resources/js/member/memberList.js"></script>