/**
 * 
 */
const cpath= $('body').data('path')
function memDetail(mem){
	console.log('memdata',$(mem).data('mem-id'));
	console.log('cpath',$('body').data('path'));
	let memId=$(mem).data('mem-id');
	let modal = $(".modal-dialog");
	console.log("modal",modal)
	$.ajax({
		type :'get',
		url :`${cpath}/member/memberDetail.do`,
		dataType : 'json',
		data : {
			'who' : memId
		},
		success : function(res){
			console.log("res",res.memVo);
			let mem = res.memVo;
			let txt = "";
			txt +=`
			<table class="table table-bordered table-striped">
					<tr>
						<th>회원번호</th>
						<td>${mem.memId }</td>
					</tr>
					<tr>
						<th>회원명</th>
						<td>${mem.memName }</td>
					</tr>
					<tr>
						<th>생년월일</th>
						<td>${mem.memBir }</td>
					</tr>
					<tr>
						<th>우편번호</th>
						<td>${mem.memZip }</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>${mem.memAdd1 } ${mem.memAdd2 }</td>
					</tr>
					<tr>
						<th>집전화</th>
						<td>${mem.memHometel }</td>
					</tr>
					<tr>
						<th>핸드폰번호</th>
						<td>${mem.memHp }</td>
					</tr>
					<tr>
						<th>메일주소</th>
						<td>${mem.memMail }</td>
					</tr>
					<tr>
						<th>직업</th>
						<td>${mem.memJob }</td>
					</tr>
					<tr>
						<th>취미</th>
						<td>${mem.memLike }</td>
					</tr>
					<tr>
						<th>기념일</th>
						<td>${mem.memMemorialday }</td>
					</tr>
					<tr>
						<th>마일리지</th>
						<td>${mem.memMileage }</td>
					</tr>
				`
				txt +=`</table>`
			let modalView = $('.modal-body');
			console.log("modalView",modalView);
			modalView.html(txt);
			modalView.show();
				;
		},
		error : function(err){
			console.log(err.status);
		}
	})
}

$('sf').on('click',function(){
	
})