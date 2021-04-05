$(document).ready(function(){
	$("#login").click(function(){
		var query = {
				id : $("#id").val(),
				pw : $("#pw").val()
		};
		
		$.ajax({
			type : "POST",
			url : "/MarketKurly_Portfolio/managerLoginPro.do",
			data : query,
			success : function(data){
				var str = '<p id="ck">';
		    	var loc = data.indexOf(str);
		    	var len = str.length;
		    	var check = data.substr(loc+len,1);
				if(check == "1"){
					window.location.href = "/MarketKurly_Portfolio/managerMain.do";
				}else{
					alert("아이디 또는 비밀번호를 확인하세요.");
					window.location.href = "/MarketKurly_Portfolio/managerLogin.do";
				}
			}
		});
	});
	
	$("#logout").click(function(){
		$.ajax({
			type : "POST",
			url : "/MarketKurly_Portfolio/managerLogout.do",
			success : function(data){
				window.location.href = "/MarketKurly_Portfolio/managerLogin.do";
			}
		});
	});
});
	
	
