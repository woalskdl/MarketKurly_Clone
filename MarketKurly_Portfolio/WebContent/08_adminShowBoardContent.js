
function reply(replyBtn){
	var num = replyBtn.name;
	var query = "/MarketKurly_Portfolio/writeAnswer.do?num="+num;
	window.location.href=query;
}

$(document).ready(function(){
	$("#boardList").click(function(){
		window.location.href="/MarketKurly_Portfolio/adminShowBoardList.do";
	});
});
