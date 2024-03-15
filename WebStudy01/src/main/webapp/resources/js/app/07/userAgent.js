/**
 * 
 */
window['ua-btn'].addEventListener("click",(e)=>{
	let agent = window.navigator.userAgent;
	const BrowserInfo= {
		EDG:"엣지",
	    CHROME:"크롬",
	    WHALE:"웨일",
	    OTHER:"기타",
		findBrowserName:function(agent){
			agent = agent.toUpperCase();
			let browserName = this.OTHER;
			for(let prop in this){
				if(agent.indexOf(prop)>=0){
					browserName=this[prop];
					
					break;
				}
			}
			return browserName;
		}
	}
	BrowserInfo['SAFARI'] = "사파리";
	
	let brName = BrowserInfo.findBrowserName(agent);
	msgArea.innerHTML = brName;
	
});

document.addEventListener("click",(e)=>{
	if(! e.target.classList.contains("asyncA"))return false;
	e.preventDefault();
	let aTag = e.target;
	let url = aTag.href;
	let method = aTag.dataset.method ?? "get"; // 널 병합 연산자 앞에있는 데이터가 있으면 그값 그대로 없으면 뒤에 값 사용
	let headers ={
		"accept" : "text/html"		
	}
	let options = {
		method : method,
		headers : headers
	}
	fetch(url,options)
	.then(resp=>{
		if(resp.ok){
			return resp.text();
		}else{
			throw new Error(`처리 실패 상태코드 : ${resp.status}`);
		}
	}).then(html=>{
		msgArea.innerHTML = html;
	})
	.catch()
})

function aa(){
	console.log("aaaaa")
	let browserInfo = window.navigator.userAgent
	console.log("browserInfo",browserInfo)
	
	let res="";
	
	if((browserInfo.toUpperCase().includes("EDG"))) {
		res = "엣지";
	}else if((browserInfo.toUpperCase().includes("WHALE"))) {
		res = "웨일";
	}else if((browserInfo.toUpperCase().includes("CHROME"))) {
		res = "크롬";
	}else if((browserInfo.toUpperCase().includes("SAFARI"))){
		res = "사파리";
	}else {
		res ="기타";
	}
	let txt = `<h1>당신의 브라우저는 ${res} 입니다.</h1>`;
	msgArea.innerHTML= txt;
	
}

/*let aTags =  document.querySelectorAll("a");
	aTags.forEach(v=>{
		v.addEventListener("click",function(e){
			e.preventDefault();
			console.log("a태그")
			let url = e.target.href
			let options ={
					method: "post",
					headers:{
						"Accept":"text/html"
					}
				};
			fetch(url,options)
			.then(res=>{
				if(res.ok){
					console.log("res",res);
					return res.text();
				}else{
					throw new Error(`요청 처리 실패, 상태코드: ${res.status}`)
				}
			})
			.then(data=>{
				console.log("data",data);
				str = "";
				str += `"<h4>당신의 브라우저는 ["${data}"] 입니다.</h4> "`;
				msgArea.innerHTML= str;
			})
			.catch(error=>{
				console.log(error);
			})
		})
	})*/