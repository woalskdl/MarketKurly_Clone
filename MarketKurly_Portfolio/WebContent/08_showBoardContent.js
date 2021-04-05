function edit(btn){
	var num = btn.name;
	var query = "/MarketKurly_Portfolio/update.do?num="+num;
	window.location.href=query;
}

function del(btn){
	var num = btn.name;
	var query = "/MarketKurly_Portfolio/delete.do?num="+num;
	window.location.href=query;
}

$(document).ready(function(){
	$("#list").click(function(){
		window.location.href="/MarketKurly_Portfolio/showBoardListForCustomer.do";
	});
});