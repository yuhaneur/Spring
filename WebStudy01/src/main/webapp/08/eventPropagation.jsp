<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.top{
		border: 3px solid black;
		width: 400px;
		height: 400px;
		text-align: center;
	}
	.middle{
		border: 3px solid red;
		width: 200px;
		height: 200px;
	}
	:focus {
		border: 3px solid bule;
	}
</style>
</head>
<body>
<pre>
	DOM 트리구조의 노드로 구성되는 HTML 엘리먼트를 대상으로 발생하는 이벤트
	해당 엘리먼트의 부모나 자식 노드쪽으로 이벤트가 전파(propagation)되는 구조를 가짐.
	bubbling propagation : 자식 노드에서 부모 노드쪽으로 전파되는 구조.
	capturing propagation : 부모 노드에서 자식 노드쪽으로 전파되는 구조.
</pre>
<div id="bubbleTop" class="top bubbling" tabindex="-1">
	<div id="bubbleMiddle" class="middle bubbling" tabindex="-2">
		<button id="bubbleBottom" class="bubbling" tabindex="-3">최하위 자식버튼- Event Bubbling</button>
	</div>
</div>
<div id="captureTop" class="top capturing" tabindex="">
	<div id="captureMiddle" class="middle capturing" tabindex="">
		<button id="captureBottom" class="capturing" tabindex="">최하위 자식버튼- Event Capturing</button>
	</div>
</div>
<script>
	document.querySelectorAll(".bubbling").forEach((be)=>{
		be.addEventListener("click",(e)=>{
			console.log("click bubbling to ",be.id, " target : ",e.target.id);
			//e.preventDefault();
// 			e.stopPropagation(); // 이벤트 전파 막는함수
		});
		be.addEventListener("focus",(e)=>{
			console.log("focus bubbling to ",be.id, " target : ",e.target.id);
			//e.preventDefault();
// 			e.stopPropagation(); // 이벤트 전파 막는함수
		});
	});
	document.querySelectorAll(".capturing").forEach((ce)=>{
		ce.addEventListener("click",(e)=>{
			console.log("click capturing from ",ce.id, " target : ",e.target.id);
// 			e.stopPropagation();
		},true);
		ce.addEventListener("focus",(e)=>{
			console.log("click capturing from ",ce.id, " target : ",e.target.id);
// 			e.stopPropagation();
		},true);
	});
</script>
</body>
</html>








