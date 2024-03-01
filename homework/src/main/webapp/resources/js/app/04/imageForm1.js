/**
 * 
 */
/*document.forms[0].addEventListener("submit",(event)=>{
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
});*/

document.forms[0].addEventListener("submit",(event)=>{
	event.preventDefault();
	let url = event.target.action;
	let imageName = event.target.name.value;
	fetch(`${url}?name=${imageName}`)
	    .then((response) => {
			alert("이미지 데이터 : ",response);
	        return response.blob(); 
	    })
	    .then((imageData) => {
	        alert(imageData);
			let imageURL = URL.createObjectURL(imageData);
			let img = document.createElement("img");
			img.src = imageURL;
			document.body.appendChild(img);
			URL.revokeObjectURL(imageData);
	    })
	    .catch((error) => {
	        console.error('Error fetching image:', error);
	    });
});