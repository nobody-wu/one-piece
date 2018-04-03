//导航下拉栏点击效果变化
$('.dropdown-item').each(function(){
	if($(this).attr('href') == window.location.pathname){
		$(this).addClass('active');
		$(this).parent().parent().addClass('active');
	}
})
//导航栏点击效果变化
$('.nav-item .nav-link').each(function(){
	if($(this).attr('href') == window.location.pathname){
		$(this).parent().addClass('active');
	}
})
