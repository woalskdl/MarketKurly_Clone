function showItem(btn){
	var str = btn.name;
	var query = "/MarketKurly_Portfolio/showOneItem.do?item_num="+str;
	window.location.href=query;
}

$(document).ready(function(){
	$("#search").click(function(){
		var category = $("#category").val();
    	var query = "/MarketKurly_Portfolio/showCategory.do?category=" + category;
 		window.location.href=query;
		
	});
});