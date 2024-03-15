/**
 * 
 */
console.log(window['mbti-form']);
window['mbti-form'].addEventListener("submit",(e)=>{
	e.preventDefault();
	let form = e.target;
	let url= form.action;
	let method = form.method;
	let headers = {
		"Content-Type" : form.enctype,
			"Accept" : "text/html"
	}
	let data = new FormData(form);
	let queryString = new URLSearchParams(data).toString();
	let body = queryString;	
	fetch(url,{
		method : method,
		headers : headers,
		body : body
	}).then(resp=>resp.text())
	.then(html=>{
		//let newDocument = new DOMParser().parseFromString(html,headers.Accept);
		//let element = newDocument.querySelector("pre");
		//window['mbti-area'].append(element);
		window['mbti-area'].innerHTML=html;
	})
	.catch();
});