/**
 *   fetch ==> promise ==> resolve (then) reject(catch)
 */
document.getElementById("lyricBtn").addEventListener("click",function(){
	fetch("../eta")
	.then(resp=>{
		if(resp.ok){
			return resp.text();
		}else{
			throw new Error("처리 실패");
		}
	}).then(res=>{str = res.replaceAll("\n","<br>"); lyricArea.innerHTML=str})
	.catch((err)=>console.log(err));
	
})