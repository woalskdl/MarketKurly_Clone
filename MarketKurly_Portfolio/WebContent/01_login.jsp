<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="loginForm" align="center">
		<form method="post" action="/MarketKurly_Portfolio/loginPro.do">
			<table>
				<tr height="70">
					<td width="300" align="center"><h2>로그인</h2></td>
				</tr>
				<tr height="50">
					<td width="300" align="center">
						<input type="text" name="id" placeholder="아이디를 입력하세요" style="width:300px; height:30px">
					</td>
				</tr>
				<tr height = "50">
					<td width = "300" align="center">
						<input type="password" name = "pw" placeholder="비밀번호를 입력하세요" style="width:300px; height:30px">
					</td>
				</tr>
				
				<tr height = "50">
					<td width="300">
						<input type="image" src="img/login.PNG" id="submit" value="submit" style="width : 320px">
					</td>
				</tr>
				<tr height = "50">
					<td width="300">
						<img src="img/join.PNG" onclick="location.href='/MarketKurly_Portfolio/join.do'" width = "320">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>