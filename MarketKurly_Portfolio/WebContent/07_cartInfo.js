function delCart(btn){
	var num = btn.name;
	var query = "/MarketKurly_Portfolio/deleteCart.do?cart_number="+num;
	window.location.href=query;
}

$(document).on('click', '#order', function(){
	
	var total = $("#total").val();
    var buyer = $("#buyer").val();
   	var query = "/MarketKurly_Portfolio/order.do?total=" + total + "&buyer=" + buyer;
	window.location.href=query;
	
});
