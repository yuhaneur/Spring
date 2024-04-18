<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- SSR방식 -->
<!-- View : BootStrap, Jquery -->
<table class="table table-bordered table-striped"> <!-- 부트스트랩 적용 -->
	<thead class="table-dark">
		<tr>
			<th>일련번호</th>
			<th>상품코드</th>
			<th>거래처코드(거래처명)</th>
			<th>분류코드(분류명)</th>
			<th>상품명</th>
			<th>구매가</th>
			<th>판매가</th>
			<th>마일리지</th>
			<th>입고일</th>
		</tr>
	</thead>
	
	<tbody>
	
		<c:if test="${not empty prodList }">
			<c:forEach items="${prodList }" var="prod">
				<tr>
					<td>${prod.rnum }</td>
					<td>
<!-- 					/prod/prodDetail.do?what=P101000001 -->
					<c:url value="/prod/prodDetail.do" var="detailUrl">
						<c:param name="what" value="${prod.prodId}" />
					</c:url>
					<a href="${detailUrl }">${prod.prodName }</a>
					</td>
					<td>${prod.buyer.buyerName }</td>
					<td>${prod.lprod.lprodNm }</td>
					<td>${prod.prodName }</td>
					<td>${prod.prodCost }</td>
					<td>${prod.prodPrice }</td>
					<td>${prod.prodMileage }</td>
					<td>${prod.prodInsdate }</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty prodList }">
			<tr>
				<td colspan="8">상품 정보가 없습니다.</td>
			</tr>
		</c:if>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="8">
				<div id="searchUI">
					<select name="searchType">
						<option value>전체</option>
						<option value="prodBuyer">거래처</option>
						<option value="prodLgu">분류</option>
						<option value="prodName">상품명</option>
					</select>
					<input type="text" name="searchWord"/>
					<button id="searchBtn">검색</button>
				</div>
				${pagingHTML }
			</td>
		</tr>
	</tfoot>
</table>
<form action="<c:url value='/prod/prodList.do'/>" id="searchForm">
	<input type="text" name="searchType"/>
	<input type="text" name="searchWord"/>
	<input type="text" name="currentPage"/>
</form>

<script>
	$("[name='searchType']").val("${condition.searchType}")
	$("[name='searchWord']").val("${condition.searchWord}")

	function paging(page){
// 		location.href ="?currentPage="+page;
		searchForm.currentPage.value = page;
		$searchForm.submit();
	}
	
// 	searchBtn을 클릭하면, searchUI가 가진 모든 입력값을 searchForm 으로 복사하고, searchFrom을 전송
	const $searchForm = $("#searchForm");

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