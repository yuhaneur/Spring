<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h4>입력 양식 구성</h4>

<form:form modelAttribute="addr">
	<form:input path="adrsNo" placeholder="주소번호"  />
	<form:errors path="adrsNo" />
	<form:input path="memId" placeholder="회원아이디"  />
	<form:errors path="memId" />
	<form:input path="adrsName" placeholder="이름"  />
	<form:errors path="adrsName" />
	<form:input path="adrsTel"  placeholder="전화번호"  />
	<form:errors path="adrsTel" />
	<form:input path="adrsAdd"  placeholder="개설일"  />
	<form:errors path="adrsAdd" />
	<button type="submit">전송</button>
</form:form>
