<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<meta charset="utf-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src = "/MarketKurly_Portfolio/js/jquery-1.11.0.min.js"></script>

<style>
	ul li{
		list-style : none;
	}
</style>
<div id="mList">
<c:if test="${ empty sessionScope.id }">
	<p>로그인이 필요한 페이지 입니다.
</c:if>
<c:if test="${ !empty sessionScope.id }">
	<c:set var="memberCnt" value="${ memberCnt }"/>
	<c:set var="itemCnt" value="${ itemCnt }"/>
	<c:set var="orderCnt" value="${ orderCnt }"/>
	
	<h2># 현황</h2>
	<h3>회원 수 : ${ memberCnt }명</h3>
	<h3>등록된 상품 수 : ${ itemCnt }개</h3>
	<h3>누적 주문량 : ${ orderCnt }건</h3>
</c:if>
</div>