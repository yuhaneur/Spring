/**
 * 
 */
function logout(){
	event.preventDefault();
	console.log("fdsf")
	frm.action = event.target.href;
	document.frm.requestSubmit();
}