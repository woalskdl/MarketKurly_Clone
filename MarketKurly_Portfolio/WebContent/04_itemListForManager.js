
function edit(editBtn){
	var str = editBtn.name;
	var query = "/MarketKurly_Portfolio/updateItem.do?item_number="+str;
	window.location.href=query;
}
function del(delBtn){
	var str = delBtn.name;
	var query = "/MarketKurly_Portfolio/deleteItemPro.do?item_number="+str;
	window.location.href=query;
}