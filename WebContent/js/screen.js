let count=0;
function sidebar(){
	let sidebar = document.querySelector('.main-bar');
	let container = document.querySelector('.main-content');
	let bar = document.querySelector('.main-bar .sidebar'); 
	console.log(bar);
	count = count + 1;
	// console.log(count);
	if(count%2==1){
		sidebar.style.width = '0px';
		container.style.marginLeft = '0px';	
		bar.style.display = 'none';
	}else{
		sidebar.style.width = '200px';
		container.style.marginLeft = '200px';
		bar.style.display= 'block';
	}

}