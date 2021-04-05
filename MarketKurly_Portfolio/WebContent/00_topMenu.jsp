<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<script src="/MarketKurly_Portfolio/js/jquery-1.11.0.min.js"></script>
<style>
	#lStatus a{
		font-size : 0.8em;
	}
</style>

<div id="lStatus">
	<c:if test="${ empty sessionScope.id }">
		<a href="/MarketKurly_Portfolio/join.do" style="text-decoration : none">회원가입</a>&nbsp;
		<img alt="" src="/MarketKurly_Portfolio/img/top1.jpg"> &nbsp;
		<a href = "/MarketKurly_Portfolio/login.do" style="text-decoration: none">로그인</a>&nbsp;
	</c:if>
	<c:if test="${ !empty sessionScope.id }">
		${ sessionScope.id }님 &nbsp;
		<img alt="" src="/MarketKurly_Portfolio/img/top1.jpg"> &nbsp;
		<a href = "/MarketKurly_Portfolio/logout.do" style="text-decoration: none">로그아웃</a>&nbsp;
		<img alt="" src="/MarketKurly_Portfolio/img/top1.jpg"> &nbsp;
		<a href = "/MarketKurly_Portfolio/cartInfo.do?id=${sessionScope.id}" style="text-decoration: none">장바구니</a>&nbsp;
		<img alt="" src="/MarketKurly_Portfolio/img/top1.jpg"> &nbsp;
		<a href = "/MarketKurly_Portfolio/checkMyOrderList.do?id=${sessionScope.id}" style="text-decoration: none">구매내역</a>&nbsp;
	</c:if>
	<img alt="" src="/MarketKurly_Portfolio/img/top1.jpg"> &nbsp;
	<a href = "/MarketKurly_Portfolio/showBoardListForCustomer.do?id=${sessionScope.id}" style="text-decoration: none">고객센터</a>&nbsp;
</div>