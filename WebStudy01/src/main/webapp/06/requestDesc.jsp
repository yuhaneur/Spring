<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06/requestDesc.jsp</title>
</head>
<body>
	<h4>request(HttpServletRequest)</h4>
	<form action="" method="post" >
		<input type="text" name="param1" value="VALUE1">
		<input type="text" name="param2" value="한글값">
		<input type="file" name="sendFile" >
		<button type="submit">전송</button>
	</form>
	<pre>
		: http 프로토콜로 패키징된 요청에 대한 정보와 해당 요청을 발생시킨 클라이언트에 대한 정보를 가진 객체.
		
		HTTP(Hyper Text Transfer Protocol) : HTML 문서 전송시 패키징 규칙성에 대한 정의
		규칙 :
		-> Request Line - 수신자의 대한 정보 (주소와 메서드)
			Request URL(명사,자원에 대한 식별자): http://localhost/WebStudy01/06/requestDesc.jsp
			Request Method(자원에 대한 행위를 표현하는 동사) : 요청의 목적(의도)과 패키징 구조에 대한 표현
				- GET-R (클라이언트가 사용하는 기본 method) : 서버의 자원을 조회
				- POST-C : 새로운 자원 등록
				- PUT/PATCH -U : 기존 자원의 수정
				- DELETE -D : 기존 자원의 삭제
				- OPTION : preFlight 요청에 사용됨. (서버의 상태를 확인)
				- HEAD : response body 가 없는 linr과 header로만 구성된 response 받ㄱ시 ㅏ
				 
				
				RESTful URI 구조. 
		-> Request Header - 메타정보가들어간곳 : 클라이언트의 요청을 부가적으로 수식해주는 메타데이터의 영역.
			header name : header value
			Accept-*
			Accept : response content-type 을 표현
				ex) text/html
					application/json
					
			Accept-Language : response language 표현
				ex) ko_KR,en_US
			Accept-Encoding : response data compress 방식 표현 (압축)
				ex) gzip
				
			Content-* : POST 요쳥으로 request body 가 있음.
			Content-Type : request body content mime type 설정.
				ex) application/x-www-form-urlencoded
					multipart/form-data
			Content-length : body content length 표현
			
			User-Agent : 클라이언트가 사용하고 있는 시스템이나 브라우저 랜더링 엔진에 대한 표현.
		-> Request body(Content Body, Message Body) - (JSON,FILE,TEXT ,Parmeter 등등)
				: POST 요청에서만 형성되는 영역으로 전송 컨텐츠의 영역
			1) request parameter : application/x-www-form-urlencoded MIME 에 따라 
					전송 가능한 직렬화된 문장으로 데이터가 전송됨.
					ex) name=value&name=value
					파라미터 형태의 전송데이터는 BODY가 없는 경우, 제한적으로 request line 을 통해 전송되기도 함.
					---> Query String 의 형태로 전송
					GET : URL?
			2) multipart data : multipart/form-data MIME 에 따라
					body영역이 여러개의 part 로 분리되고, 각 part 에 입력 데이터가 포함되어 전송됨.
			3) object payload : application/json MIME 에 따라
					body 영역을 통해 json 이나 xml 페이로드를 전송하게 됨. 
	</pre>
</body>
</html>