<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>15/jdbcDesc.jsp</title>
</head>
<body>
<h4>JDBC(Java DataBase Connectivity) 프로그래밍 방법론</h4>
<pre>
	1. jdbc 드라이버를 빌드패스에 로딩.
		/WEB-INF/lib/ojdbc6.jar
	2. classloader 를 이용해 드라이버를 메모리에 로딩.
	3. 연결(Connection) 수립
	4. 쿼리 객체 생성
		- Statement
		- PreparedStatement
		- CallableStatement
	5. 쿼리 실행
		- ResultSet executeQuery (돌아오는 결과집합이있을때) : SELECT
		- int executeUpdate(돌아오는 결과집합 없을때)	: INSERT,UPDATE, DELETE
	
	6. 결과 집합 핸들링
	7. Conntection, Statement, ResultSet release
</pre>
<table border="1px">
	<thead id="head-area">
		<tr>
<%-- 			<c:forEach items="${headers }" var="colName"> --%>
<%-- 			<th>${colName }</th> --%>
<%-- 			</c:forEach> --%>
		</tr>
	</thead>
	<tbody id="data-area">
<%-- 		<c:forEach items="${proList }" var="propsMap"> --%>
<!-- 			<tr> -->
<%-- 				<c:forEach items="${propsName }" var="propName"> --%>
<%-- 					<td>${propsMap[propName] }</td> --%>
<%-- 				</c:forEach> --%>
<!-- 			</tr> -->
<%-- 		</c:forEach> --%>
	</tbody>
</table>
<script src="<c:url value='/resources/js/app/js/jdbc.js'/>"></script>
</body>
</html>