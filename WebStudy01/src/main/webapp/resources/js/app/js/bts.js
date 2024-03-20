/**
 * 
 */

console.log("asdfsadfasdf")
document.btsForm.addEventListener("submit",function(event){
	event.preventDefault();
	console.log(event.target);
	let form = event.target;
	let url = form.action;
	let method = form.method;
	let headers = {
		"content-type" : form.enctype,
		"accept" : "text/html"
	} 
	let formData = new FormData(form);
	let body = new URLSearchParams(formData).toString();
	fetch(url,{
		method:method,
		headers : headers,
		body : body
	})
	.then(res=>res.text())
	.then(txt => window['result-area'].innerHTML=txt)
	.catch(e=>console.error(e))
})