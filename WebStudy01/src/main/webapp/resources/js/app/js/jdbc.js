/**
 * 
 */
document.addEventListener("DOMContentLoaded",()=>{
	console.log("asdfasfd");
	let url = "";
	let headers = {
		"Accept":"application/json"
	}
	// json data 를 수신하고 CSR 방식으로 HTML 태그 만들기
	fetch(url,{
		headers : headers
	}).then(resp=>resp.json())
	.then(data => {
		console.log(data.proList)
		let text = "";
		text +=`<tr>`;
		for(proName of data.propsName){
			text+=`<th>${proName }</th>`;
		}
		text +=`</tr>`;
		window['head-area'].innerHTML = text;
		let txt = "";
		for(proNames of data.proList){
			txt +=`<tr>
				<td>${proNames.propertyName }</td>
				<td>${proNames.propertyValue }</td>
				<td>${proNames.description }</td>
			</tr>`
		}
		window['data-area'].innerHTML=txt;
	})
	.catch(err=>console.error(err));
})
