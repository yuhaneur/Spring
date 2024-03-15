<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>11/sessionDesc.jsp</title>
</head>
<body data-context-path="<%=request.getContextPath()%>">
<h4>session(HttpSession)</h4>
<pre>
	세션 
	connectFull : connection과 session 이 동일한 의미로 통로로 정의됨.
	connectLess(HTTP) : 시간으로 정의됨.
				한세션이 시작되고, 해당 세션내에서 더이상의 명령이 발생하지 않을떄까지의 기간.
				timeout 이란, 마지막 요청이 발생하고, 이후 새로운 요청이 발생할때까지 시간의 간격.
				
	세션의 생명주기
	시작 : 특정 클라이언트가 최초의 요청을 발생시키면 세션 시작. ==> 세션 아이디가 부여됨.
		세션 아이디 : <%=session.getId() %>
		세션 생성 시점 : <%=new Date(session.getCreationTime()) %>
		세션 timeout : <%=session.getMaxInactiveInterval() %>s
		세션 내에서 마지막 요청 시점 : <%= new Date(session.getLastAccessedTime()) %>
		유지방법(tracking mode) : 클라이언트와 서버가 동일한 세션 아이디를 공유.
			1) COOKIE
			2) URL : <a href="sessionDesc.jsp;jsessionid=<%=session.getId()%>">엣지(쿠키없음)에서 세션 유지</a>
			3) SSL : secure socket layer 구조를 이용해 전송되는 모든 데이터를 암호화하는 방식.
	종료
		timeout 이내에 새로운 요청이 발생하지 않는 경우. ==> dummy session 이 남게됨.
		직접 세션을 invalidation 시키는 경우 (*****)
		<%--
			session.invalidate();
		--%>
</pre>
<form action="" id="frm">
<h4>세션 타이머 : <span id="time-area" data-ts-timeout="<%=session.getMaxInactiveInterval()%>"></span></h4>
	<div id="msg-area">
		<p>세션 시간 추가 ?</p>
		<button class="control" id="yesBtn">예</button>
		<button class="control" id="noBtn">아니오</button>
	</div>
</form>
<script src="<%=request.getContextPath()%>/resources/js/app/11/sessionDesc.js"></script>
</body>

<script type="text/javascript">
<%-- 	let startTime = <%=session.getMaxInactiveInterval()%> --%>
// 	let timer = window['time-area'];
// 	let msg = window['msg-area'];
// 	msg.style.display="none";
// 	console.log("timer",timer);
// 	setInterval(() => {
// 		startTime--;
// 		//console.log("startTime",startTime)
// 		timer.innerHTML= startTime;
// 		if(startTime==60){
// 			msg.style.display="block"
// 		}
// 		if(startTime==0){
// 			alert("세션이 만료되었습니다.")
// 		}
// 	}, 1000);
// 	yesBtn.addEventListener("click",function(){
// 		let url = frm.action;
// 		fetch(url)
// 		.then(res=>{console.log("aaa")})
// 	})
// 	noBtn.addEventListener("click",function(){
// 		let url = frm.action;
// 		fetch(url)
// 		.then(res=>{console.log("aaa")})
// 	})
</script>
</html>