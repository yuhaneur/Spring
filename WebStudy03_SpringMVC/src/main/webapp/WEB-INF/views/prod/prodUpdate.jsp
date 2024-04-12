<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="${pageContext.request.contextPath }/prod/prodUpdate.do" method="post">
<table class="table table-bordered table-striped">
	<tr>
		<th>상품명</th>
		<td>${prod.prodName }</td>
	</tr>
	<tr>
		<th>제조사정보</th>
		<td>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>제조사명</th>
						<th>소재지</th>
						<th>담당자명</th>
						<th>연락처</th>
						<th>팩스번호</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${prod.buyer.buyerName}</td>
						<td>${prod.buyer.buyerAdd1}</td>
						<td>${prod.buyer.buyerCharger}</td>
						<td>${prod.buyer.buyerTelext}</td>
						<td>${prod.buyer.buyerFax}</td>
					</tr>
				</tbody>
			</table>
		</td>
	</tr>

	<tr>
		<th>상품코드</th>
		<td><input type="hidden" name="prodId" required
			value="${prod.prodId}" class="form-control" /><span
			class="text-danger">${errors.prodId}</span></td>
	</tr>
	<tr>
		<th>상품명</th>
		<td><input type="text" name="prodName" required
			value="${prod.prodName}" class="form-control" /><span
			class="text-danger">${errors.prodName}</span></td>
	</tr>
	<tr>
		
		<input type="hidden" name="lprodNm" value="${prod.prodLgu }"/>
		<th>상품분류</th>
		<td>${prod.lprod.lprodNm}</td>
	</tr>
	<tr>
		<input type="hidden" name="prodLgu" value="${prod.prodBuyer }"/>
		<th>거래처</th>
		<td>${prod.buyer.buyerName}</td>
	</tr>
	<tr>
		<th>구매가</th>
		<td><input type="number" name="prodCost" required
			value="${prod.prodCost}" class="form-control" /><span
			class="text-danger">${errors.prodCost}</span></td>
	</tr>
	<tr>
		<th>판매가</th>
		<td><input type="number" name="prodPrice" required
			value="${prod.prodPrice}" class="form-control" /><span
			class="text-danger">${errors.prodPrice}</span></td>
	</tr>
	<tr>
		<th>세일가</th>
		<td><input type="number" name="prodSale" required
			value="${prod.prodSale}" class="form-control" /><span
			class="text-danger">${errors.prodSale}</span></td>
	</tr>
	<tr>
		<th>요약정보</th>
		<td><input type="text" name="prodOutline" required
			value="${prod.prodOutline}" class="form-control" /><span
			class="text-danger">${errors.prodOutline}</span></td>
	</tr>
	<tr>
		<th>상세정보</th>
		<td><input type="text" name="prodDetail"
			value="${prod.prodDetail}" class="form-control" /><span
			class="text-danger">${errors.prodDetail}</span></td>
	</tr>
	<tr>
		<th>이미지</th>
		<td><input type="text" name="prodImg" required
			value="${prod.prodImg}" class="form-control" /><span
			class="text-danger">${errors.prodImg}</span></td>
	</tr>
	<tr>
		<th>총재고</th>
		<td><input type="number" name="prodTotalstock" required
			value="${prod.prodTotalstock}" class="form-control" /><span
			class="text-danger">${errors.prodTotalstock}</span></td>
	</tr>
	<tr>
		<th>입고일</th>
		<td><input type="date" name="prodInsdate"
			value="${prod.prodInsdate}" class="form-control" /><span
			class="text-danger">${errors.prodInsdate}</span></td>
	</tr>
	<tr>
		<th>적정재고</th>
		<td><input type="number" name="prodProperstock" required
			value="${prod.prodProperstock}" class="form-control" /><span
			class="text-danger">${errors.prodProperstock}</span></td>
	</tr>
	<tr>
		<th>크기</th>
		<td><input type="text" name="prodSize" value="${prod.prodSize}"
			class="form-control" /><span class="text-danger">${errors.prodSize}</span></td>
	</tr>
	<tr>
		<th>색상</th>
		<td><input type="text" name="prodColor" value="${prod.prodColor}"
			class="form-control" /><span class="text-danger">${errors.prodColor}</span></td>
	</tr>
	<tr>
		<th>배송방법</th>
		<td><input type="text" name="prodDelivery"
			value="${prod.prodDelivery}" class="form-control" /><span
			class="text-danger">${errors.prodDelivery}</span></td>
	</tr>
	<tr>
		<th>단위</th>
		<td><input type="text" name="prodUnit" value="${prod.prodUnit}"
			class="form-control" /><span class="text-danger">${errors.prodUnit}</span></td>
	</tr>
	<tr>
		<th>입고량</th>
		<td><input type="number" name="prodQtyin"
			value="${prod.prodQtyin}" class="form-control" /><span
			class="text-danger">${errors.prodQtyin}</span></td>
	</tr>
	<tr>
		<th>단위</th>
		<td><input type="number" name="prodQtysale"
			value="${prod.prodQtysale}" class="form-control" /><span
			class="text-danger">${errors.prodQtysale}</span></td>
	</tr>
	<tr>
		<th>마일리지</th>
		<td><input type="number" name="prodMileage"
			value="${prod.prodMileage}" class="form-control" /><span
			class="text-danger">${errors.prodMileage}</span></td>
	</tr>
	<tr>
		<td>
			<input type="submit" value="수정하기">
		</td>
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
</form>
<script
	src="${pageContext.request.contextPath}/resources/js/member/memberList.js"></script>