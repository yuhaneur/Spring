/**
 * 
 */
alert("DUMMY");

let divTag = document.getElementById("mainArea");
let handler = function(event){
	let target = event.target;
	console.log(target === divTag)
	target.style.backgroundColor= "green";
}
divTag.addEventListener("click",handler)
