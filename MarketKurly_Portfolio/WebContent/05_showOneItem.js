$(document).ready(function(){
	$("#insertCart").click(function(){
		if($("#buyer").val()){
			var query = {
					buyCnt : $("#buyCnt").val(),
					item_number: $("#item_number").val(),
					buyer : $("#buyer").val()
			};
			
			var buyer = $("#buyer").val();
			
			$.ajax({
				type: "POST",
				url: "/MarketKurly_Portfolio/insertCart.do",
				data: query,
				success: function(data){
					alert("상품을 장바구니에 담았습니다.");
					location.href="/MarketKurly_Portfolio/cartInfo.do?id=" + buyer;
				}
			});
		}else{
			alert("로그인이 필요합니다.");
			window.location.href = "/MarketKurly_Portfolio/login.do";
		}
	});
});