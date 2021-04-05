$(document).ready(function(){
	$("#upForm1").ajaxForm({
		success: function(data, status){
   			window.location.href="/MarketKurly_Portfolio/itemListForManager.do";
   		}
    });
});