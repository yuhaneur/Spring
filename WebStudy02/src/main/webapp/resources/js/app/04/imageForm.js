/**
 * 폼을 전송할때 페이지가 전환되는 걸 중단하고, 선택한 이미지를 페이지의 하단에(body append 구조)에 출력.
1. submit 이벤트 중단
2. 선택한 option value 확보
3. 새로운 img 태그 생성
4. img 태그의 src 속성을 선택한 이미지로 대체.
5. body 에 new img를 추가(append)
 */

document.forms[0].addEventListener("submit",(event)=>{
//1. submit 이벤트 중단
	event.preventDefault(); 
	let url = event.target.action
//2.선택한 option value 확보
	let imageName = event.target.name.value;
//3. 새로운 img 태그 생성
	let newImg = document.createElement("img");
	newImg.src=`${url}?name=${imageName}`;
	document.body.appendChild(newImg);
})
