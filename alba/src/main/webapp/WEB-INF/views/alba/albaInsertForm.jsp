<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="alba" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th>이름</th>
				<td>
					<form:input type="text" path="alName"/>
					<form:errors element="span" path="alName"/>
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>
					<form:input type="text" path="alAge"/>
					<form:errors element="span" path="alAge"/>
				</td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td>
					<form:input type="text" path="alZip"/>
					<form:errors element="span" path="alZip"/>
				</td>
			</tr>
			<tr>
				<th>기본주소</th>
				<td>
					<form:input type="text" path="alAddr1"/>
					<form:errors element="span" path="alAddr1"/>
				</td>
			</tr>
			<tr>
				<th>상세주소</th>
				<td>
					<form:input type="text" path="alAddr2"/>
					<form:errors element="span" path="alAddr2"/>
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<form:input type="text" path="alHp"/>
					<form:errors element="span" path="alHp"/>
				</td>
			</tr>
			<tr>
				<th>학력</th>
				<td>
				<select name="grCode">
					<option value="G001">고졸</option>
					<option value="G002">초대졸</option>
					<option value="G003">대졸</option>
					<option value="G004">대학원졸</option>
					<option value="G005">석사</option>
					<option value="G006">박사</option>
				</select>
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<form:input type="text" path="alGen"/>
					<form:errors element="span" path="alGen"/>
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<form:input type="mail" path="alMail"/>
					<form:errors element="span" path="alMail"/>
				</td>
			</tr>
			<tr>
				<th>경력</th>
				<td>
					<form:input type="text" path="alCareer"/>
					<form:errors element="span" path="alCareer"/>
				</td>
			</tr>
			<tr>
				<th>특기</th>
				<td>
					<form:input type="text" path="alSpec"/>
					<form:errors element="span" path="alSpec"/>
				</td>
			</tr>
			<tr>
				<th>비고</th>
				<td>
					<form:input type="text" path="alDesc"/>
					<form:errors element="span" path="alDesc"/>
				</td>
			</tr>
			<tr>
				<th>이미지</th>
				<td colspan="2">
					<form:input type="file" path="alImage"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">등록하기</button>
				</td>
			</tr>
		</table>
		
	</form:form>

</body>
</html>