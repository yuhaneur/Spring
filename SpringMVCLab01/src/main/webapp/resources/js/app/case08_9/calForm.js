/**
 * 
 */

document.calForm.addEventListener("submit",function(e){
		console.log("e",e)
		e.preventDefault();
		let form = e.target;
		let url = form.action;
		let method = form.method;
		let headers = {
			'Accept' : 'application/json',
			'Content-Type': 'application/json'
		}
		let target = {
			leftOp : form.leftOp.value,
			rightOp :form.rightOp.value,
			operator : form.operator.value
		};
		
		let body = JSON.stringify(target);

		fetch(url,{
			method : method,
			headers : headers,
			body : body
		}).then(resp=>resp.json())
		.then(cv=>console.log(cv));
	})