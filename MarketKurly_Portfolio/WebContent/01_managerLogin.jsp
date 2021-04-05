<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/MarketKurly_Portfolio/js/jquery-1.11.0.min.js"></script>
<script src="/MarketKurly_Portfolio/01_managerLogin.js"></script>
<style>
	ul li{
		list-style : none;
	}
</style>
</head>
<body>
	<c:if test="${ empty sessionScope.id }">
		<div id="status">
			<ul>
				<li><label for="id">아이디</label>
				<input type="email" id="id" name="id" size="20" maxlength="50" placeholder="marketkurly">
				<label for="pw">비밀번호</label>
				<input type="password" id="pw" name="pw" size="20" placeholder="6~16자 숫자/문자" maxlength="16">
				<button id="login">로그인</button>
			</ul>
		</div>
	</c:if>
	<c:if test="${ !empty sessionScope.id }">
		<div id="status">
			<ul>
				<li>관리자님 접속중
				<button id="logout">로그아웃</button>
			</ul>
		</div>
	</c:if>

</body>
</html>