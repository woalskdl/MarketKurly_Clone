<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/MarketKurly_Portfolio/js/jquery-1.11.0.min.js"></script>
<script src="/MarketKurly_Portfolio/01_join.js"></script>
</head>
<body>
	<div align="center">
		<h1>회원가입</h1>
		<hr width="700" color="black" size="3"/>
		<br>
		<table>
			<tr height="50">
				<td width="150"><b>아이디</b></td>
				<td width="300" align="center">
					<input type="text" id="id" name="id" placeholder="6자 이상의 영문 혹은 영문과 숫자를 조합" style="width:300px; height:40px">
				</td>
				<td width="75"><button id="checkDoubleId">중복확인</button></td>
			</tr>
			<tr height="50">
				<td width="150"><b>비밀번호</b></td>
				<td width="300" align="left" colspan="2">
					<input type="password" id="pw" name="pw" placeholder="비밀번호를 입력해주세요" style="width:300px; height:40px">
				</td>
			</tr>
			<tr height="50">
				<td width="150"><b>이름</b></td>
				<td width="300" align="left" colspan="2">
					<input type="text" id="name" name="name" placeholder="이름을 입력해주세요" style="width:300px; height:40px">
				</td>
			</tr>
			<tr height = "50">
				<td width="150">
					<b>휴대폰</b>
				</td>
				<td width = "300" align="left" colspan="2">
					<input type="text" id="tel" name="tel" placeholder="(-)없이 입력"  style="width:300px; height:40px">
				</td>
			</tr>
			<tr height = "50">
				<td width="150">
					<b>주소</b>
				</td>
				<td width = "300" align="left" colspan="2">
					<input type="text" id="address" name="address" placeholder="주소를 입력해주세요"  style="width:300px; height:40px">
				</td>
			</tr>
			<tr height = "50">
				<td width="150">
					<b>이메일</b>
				</td>
				<td width = "300" align="center">
					<input type="email" id ="email" name="email" placeholder="예:marketkurly@kurly.com"  style="width:300px; height:40px">
				</td>
				<td width="75">
					<button id="checkDoubleEmail">중복확인</button>
				</td>
			</tr>
			<tr height="50">
				<td colspan="3" align="center">
					<br>
					<button id="join">가입하기</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>