/**
 * 
 */
setInterval(function(){
	clientArea.innerHTML= Date.now();
	fetch("../now")
	.then(resp=>resp.text())
	.then(n=>serverArea.innerHTML=n);
},1000);

/*$.ajax({
	url : "/WebStudy01/now", 
	success:function(res){
		console.log(res);
		$("#serverArea").html(res)
	},
	error:function(xhr){
		console.log(xhr.status);
	},
	dataType:"json"
	
})*/