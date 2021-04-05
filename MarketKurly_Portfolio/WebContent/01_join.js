$(document).ready(function(){

	var stId = false;
	var stEmail = false;

	$("#checkDoubleId").click(function(){
		if($("#id").val()){
			$.ajax({
				type : "POST",
				url : "/MarketKurly_Portfolio/checkDoubleId.do",
				contentType : "application/x-www-form-urlencoded;charset=UTF-8",
				data : {
					'id' : $("#id").val()
				},
				
				success : function(data){
					var str = '<p id="ck">';
			    	var loc = data.indexOf(str);
			    	var len = str.length;
			    	var check = data.substr(loc+len,1);
					if(check == "1"){
						alert("중복된 아이디입니다.");
						$("#id").val("");
					}else{
						alert("사용할 수 있는 아이디 입니다.");
						id=$("#id").val();
						stId = true;
					}
				}
			});
		}else{
			alert("사용할 아이디를 입력하세요.");
			$("#id").focus();
		}
	});
	
	$("#checkDoubleEmail").click(function(){
		if($("#email").val()){
			$.ajax({
			     type: "POST",
			     url: "/MarketKurly_Portfolio/checkDoubleEmail.do",
			     data: {
			    	 'email' : $("#email").val()
			     },

			     success: function(data){
			    	 var str = '<p id="ck">';
			    	 var loc = data.indexOf(str);
			    	 var len = str.length;
			    	 var check = data.substr(loc+len,1);
			    	 if(check == "1"){
			    		 alert("중복된 이메일입니다");
			    		 $("#email").val("");
			    	 }else{
			    	    alert("사용할 수 있는 이메일입니다");
			    	    email=$("#email").val();
			    	    stEmail = true;
			        }
			     }
			});
		}else{
			  alert("사용할 이메일을 입력하세요.");
			  $("#email").focus();
		}
	});
	
	$("#join").click(function(){
		if(!stId){
			alert("아이디 중복확인이 필요합니다.");
		}else if(!stEmail){
			alert("이메일 중복확인이 필요합니다.");
		}else{
			var stEmpty = checkIt();
			
			if(stEmpty){
				var query = {
						id : $("#id").val(),
						pw : $("#pw").val(),
						name : $("#name").val(),
						tel : $("#tel").val(),
						address : $("#address").val(),
						email : $("#email").val()
				};
				
				$.ajax({
					type : "POST",
					url : "/MarketKurly_Portfolio/joinPro.do",
					data : query,
					
					success : function(data){
						alert("회원가입이 완료되었습니다.");
						window.location.href = "/MarketKurly_Portfolio/index.do";
					},
					error : function(data){
						alert("오류가 발생했습니다.")
					}
				});
			}
		}
	});
	
});

function checkIt() {
	
    if(!$("#id").val()) {
        alert("아이디를 입력하세요");
        $("#id").focus();
        return false;
    }
    
    if(!$("#pw").val()) {
        alert("비밀번호를 입력하세요");
        $("#passwd").focus();
        return false;
    }
    
    if(!$("#name").val()) {
        alert("사용자 이름을 입력하세요");
        $("#name").focus();
        return false;
    }
    if(!$("#tel").val()) {
        alert("전화번호를 입력하세요");
        $("#tel").focus();
        return false;
    }  
    if(!$("#address").val()) {
        alert("주소를 입력하세요");
        $("#address").focus();
        return false;
    }
    if(!$("#email").val()) {
        alert("이메일을 입력하세요");
        $("#email").focus();
        return false;
    }
    
    return true;
    
}