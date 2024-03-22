/**
 * 
 */
// 오른쪽 파일 태그만 대상으로 클릭했을떄 비동기 요청으로 path를 통해서  uri값을 통해서 파일 크기를 (논리주소 > 물리주소) 알아본다.
// 
const log = console.log;

document.querySelectorAll("li.folder>a").forEach(a=>{
	a.addEventListener("click",e=>{
		e.preventDefault();
		let type = a.dataset.click;
		let url = `${a.href}&type=${type}`;
		let method = "get";
		let headers = {
			"accept" :"application/json"			
		};
		fetch(url,{
			method : method,
			headers : headers
		}).then(resp=>resp.json())
		.then(jsonObj=>{
			log("jsonObj.wrapperList",jsonObj.wrapperList);
			//['1','2'].map(ele=>ele+"번째").join("\n") // ele 란 이름으로 1이랑 2가 하나싞드어옴 >> join에 모아놓음
			//`${jsonObj.map(data=>`<li id="${data.path}" class="${data.file? 'file' : 'folder' }">
			//					${data.name}
			//				</li>`).join('\n')}`
			let html = `<ul class="col-6">`;
			for(let data of jsonObj.wrapperList){
				html +=	`
						
							<li data-name="${data.name}" id="${data.path}" class="${data.file? 'file' : 'folder' }" onclick='fileClick(this)'">
								${data.name}
							</li>
						
						`;
			}
			html +=	`</ul>`;
			window['right-area'].innerHTML = html;
			//document.querySelector('.card.col-6').innerHTML = html;
		}).catch(e=>console.error(e));
	});
	a.addEventListener("dblclick",e=>{
		e.preventDefault();
		let type = a.dataset.dblclick;
		let url = `${a.href}&type=${type}`;
		window.location.href = `${url}`;
		
	});
});

function fileClick(li){
	if(!li.classList.contains("file"))return false;
	let cPath = document.body.dataset.cPath;
	let data = li.id;
	let url = `${cPath}/case2/fileInfo?path=${data}`;

	let headers = {
			"accept" :"application/json"			
		};
	log("data : ",data,"url : ",url)
	fetch(url,{
		headers : headers
	}).then(resp=>resp.json())
	.then(size=>{log("size",size.fileSize)
		let txt = `${li.dataset.name} ${size.fileSize} byte`;
		li.innerHTML = txt;
		//li.append(size.fileSize+"byte");
		//li.innerHTML=li.innerHTML +"," + size.fileSize;
	})
}