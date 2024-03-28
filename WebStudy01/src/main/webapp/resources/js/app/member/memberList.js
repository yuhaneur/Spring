/**
 * 
 */



const cPath = document.body.dataset.path;
let modal = document.getElementById("staticBackdrop");
console.log("modal",modal)
document.addEventListener("DOMContentLoaded",()=>{
	modal.addEventListener("show.bs.modal",function(event){
		let tr = event.relatedTarget;
		let memId = tr.dataset.memId;
		console.log("memId",memId)
		let url = `${cPath}/member/memberDetail.do?who=${memId}`;
		let method = 'get';
		let headers = {
			"accept" : "application/json"
		}
		
		fetch(url,{
			method : method,
			headers : headers
		}).then(res=>res.json())
		.then(member=>{
			console.log("member",member)
			let memVO = member.memVo
			modal.querySelectorAll('td[id]').forEach(function(td){
				let propName = td.id;
				td.innerHTML = memVO[propName];
			})
		}).catch(err=>console.log(err.status))
	})
	
	modal.addEventListener('hidden.bs.modal',function(event){
		modal.querySelectorAll('td[id]').forEach(function(td){
				let propName = td.id;
				td.innerHTML = "";
		})
	})
	
	$('tr[data-mem-id].active').trigger('click');
})

//$(function(){
//	const $modal = $('#staticBackdrop').on('show.bs.modal',function(event){
//		let tr = event.relatedTarget;
//		let memId = $(tr).data('memId');
//		console.log("memId",memId)
//		let url = `${cPath}/member/memberDetail.do`;
//		let method = 'get';
//		$.ajax({
//			url : url,
//			method : method,
//			dataType:'json',
//			data:{
//				who:memId
//			}, success : function({memVo}, status, jqXHR){
//				console.log("memVo",memVo)
//				console.log("ddd",memVo?.memId);
//				$modal.find("td[id]").each(function(index,td){
//					let propName = td.id;
//					td.innerHTML = memVo[propName];
//				})
//			}, error : function(jqXHR,status, errorText){
//				console.log("에러 : ",jqXHR, status, errorText);
//			}
//			
//			
//			
//		});
//	}).on('hidden.bs.modal',function(event){
//		$modal.find('td[id]').html("");
//	})
////	$(document).on('click','tr[data-mem-id]',function(){
////	})	
//});