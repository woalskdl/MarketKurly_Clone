<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="/MarketKurly_Portfolio/js/jquery-1.11.0.min.js"></script>
<script src="/MarketKurly_Portfolio/04_showItems.js"></script>
<style>
	button{
		border : none;
		outline : none;
		background-color : rgba(0,0,0,0);
		cursor : pointer;
	}
</style>
</head>
<body>

	<%
		String categoryName = (String) request.getAttribute("categoryName");
		if(categoryName == null)
			categoryName = "전체상품";
	%>
	
	<div>
		<h3>상품 카테고리 검색</h3>
		<select id="category">
			<option value = "100" <c:if test="${ category ==100}"> selected </c:if>>채소</option>
			<option value = "200" <c:if test="${ category == 200}" > selected </c:if>>해산물</option>
			<option value = "300" <c:if test="${ category == 300}" > selected </c:if>>육류</option>
			<option value = "400" <c:if test="${ category == 400}" > selected </c:if>>전자제품</option>
		</select>
		<button id="search"><img src="img/findcate.png" width="30px"></button>
	</div>
	<hr size = "1" color = "purple" width = "300">
	<br>
	<h1><%= categoryName %></h1>
	<div align="center">
		<c:set var="i" value="0"/>
		<c:set var="j" value="3"/>
		<table>
			<c:forEach var="item" items="${ itemList }">
				<c:if test="${ i % j == 0 }">
					<tr height="250">
				</c:if>
				<td width="300" align="center">
					<c:if test="${ item.getItem_stock() == 0 }">
						<img src="/MarketKurly_Portfolio/img/${ item.getItem_image() }" width="280" style="opacity : 40%">
					</c:if>
					<c:if test="${ item.getItem_stock() > 0 }">
						<button id="showItem" name="${ item.getItem_number() }" onclick="showItem(this)">
							<img src="/MarketKurly_Portfolio/img/${ item.getItem_image() }" width="280">
						</button>
					</c:if>
					<p><font size="5"><b>${ item.getItem_name() }</b></font></p>
					<c:if test="${ item.getItem_stock() > 0 }">
						<c:set var="price" value="${ item.getItem_price() }"/>
						<c:set var="realprice" value="${ item.getItem_price() - item.getItem_price() * item.getDiscount_rate() / 100 }"/>
						<c:if test="${ price > realprice }">
							<p>
								<font size="3"><del><fmt:formatNumber value="${ item.getItem_price() }" pattern="#,###"/>원</del></font>
								<font size="4" color="purple"><b><fmt:formatNumber value="${ realprice }" pattern="#,###"/>원</b></font>
							</p>
						</c:if>
						<c:if test="${ price == realprice }">
							<p>
								<font size="4"><fmt:formatNumber value="${ item.getItem_price() }" pattern="#,###"/>원</font>
							</p>
						</c:if>
					</c:if>
					<c:if test="${ item.getItem_stock() == 0 }">
						<p><font size="3" color="red"><b>품절</b></font></p>
					</c:if>
					<p><font size = "2" color="gray">${ item.getItem_info() }</font></p>
				</td>
				<c:set var="i" value="${ i+1 }"/>
			</c:forEach>
		</table>
	</div>
</body>
</html>
