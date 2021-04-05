<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="utf-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<script src="/MarketKurly_Portfolio/js/jquery-1.11.0.min.js"></script>
<script src="/MarketKurly_Portfolio/04_itemListForManager.js"></script>

<c:if test="${empty sessionScope.id}">
	<meta http-equiv="Refresh" content="0;url=/MarketKurly_Portfolio/managerMain.do">
</c:if>

<div align="center">
	<c:if test="${ cnt == 0 }">
		<ul>
			<li>등록된 상품이 없습니다.
		</ul>
	</c:if>
	<c:if test ="${ cnt > 0 }">
		<br>
		<table border="1" style = "border-collapse : collapse;">
			<tr height = "50">
				<td width = "50" align="center"><b>번호</b></td>
				<td width = "100" align = "center"><b>카테고리</b></td>
				<td width = "100" align = "center"><b>상품명</b></td>
				<td width = "100" align = "center"><b>가격</b></td>
				<td width = "50" align = "center"><b>재고</b></td>
				<td width = "50" align = "center"><b>이미지</b></td>
				<td width = "200" align = "center"><b>상품정보</b></td>
				<td width = "50" align = "center"><b>할인률</b></td>
				<td width = "100" align = "center"><b>등록일</b></td>
				<td width = "50" align = "center"><b>판매량</b></td>
				<td width = "100" align = "center" colspan="2"><b>수정/삭제</b></td>
			</tr>
			<c:set var="number" value="${ 0 }"/>
			<c:forEach var = "item" items = "${ registeredItemList }">
				<tr height = "50">
					<td width = "50" align = "center">
						<c:set var="number" value="${ number + 1 }"/>
						<c:out value="${ number }"/>
					</td>
					<td width = "100" align="center">
						<c:if test="${ item.getItem_category() == '100' }">채소</c:if>
						<c:if test="${ item.getItem_category() == '200' }">해산물</c:if>
						<c:if test="${ item.getItem_category() == '300' }">육류</c:if>
						<c:if test="${ item.getItem_category() == '400' }">전자제품</c:if>
					</td>
					<td width="100" align="center">${ item.getItem_name() }</td>
					<td width="100" align="center">${ item.getItem_price() }</td>
					<td width="50" align="center">${ item.getItem_stock() }</td>
					<td width="50" align="center">
						<img src = "/MarketKurly_Portfolio/img/${ item.getItem_image() }" height="50">
					</td>
					<td width = "200" align = "center">${item.getItem_info()}</td>
					<td width = "50" align = "center">${item.getDiscount_rate()}</td>
					<td width = "100" align = "center">${item.getReg_date()}</td>
					<td width = "50" align = "center">${item.getSold()}</td>
					
					<td width="50" align = "center">
						<button id="edit" name="${ item.getItem_number() }" onclick="edit(this)">수정</button>
					</td>
					<td width="50" align = "center">
						<button id="del" name="${ item.getItem_number() }" onclick="del(this)">삭제</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</div>