$(document).ready(function(){
	$(".gn-menu li a").click(function(){
		var id = $(this).attr('data-src');
		var body = $(id).clone();
		$("header").html(body);
	})
})