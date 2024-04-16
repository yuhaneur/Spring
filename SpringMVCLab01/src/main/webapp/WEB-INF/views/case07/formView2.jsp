<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<pre>
검증 대상 : ${adrs}
검증 결과 : ${requestScope["org.springframework.validation.BindingResult.adrs"] }
</pre>
<form:form modelAttribute="adrs">
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
