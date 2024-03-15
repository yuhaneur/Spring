/**
 * 
 */
const contextPath = document.body.dataset.contextPath;
const SessionTimer = function(timeout,element){
	this.timeout = timeout;
	this.element = element;
	this.timer = this.timeout;
	this.element.innerHTML= this.timeout;
	let obj = this;
	this.intervalId= setInterval(()=>{
		if(obj.timer>0){
			obj.timer --;
		}else{
			clearInterval(obj.intervalId);			
		}
		obj.element.innerHTML = obj.timer;
	},100)
}
document.querySelectorAll("[data-ts-timeout]").forEach(element=>{
	let timeout = element.dataset['tsTimeout'];
	console.log(timeout);
	new SessionTimer(timeout,element);
});