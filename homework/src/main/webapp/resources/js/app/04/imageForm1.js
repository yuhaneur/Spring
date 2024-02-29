/**
 * 
 */
document.forms[0].addEventListener("submit",(event)=>{
	event.preventDefault();
	fetch("/case4/imageForm.do")
});

document.forms[0].addEventListener("submit",(event)=>{
	event.preventDefault();
	let url = event.target.action;
	let imageName = event.target.name.value;
	let newImg = document.createElement("img");
	newImg.src=`${url}?name=${imageName}`;
	document.body.appendChild(newImg)
});