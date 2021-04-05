<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/MarketKurly_Portfolio/js/jquery-1.11.0.min.js"></script>
<script src="/MarketKurly_Portfolio/05_showOneItem.js"></script>
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
	<div align="center">
	<br>
		<table>
			<c:forEach var="item" items="${ dto }">
				<tr height="80">
					<td rowspan="6" width="350" align="center">
						<img alt="" src="/MarketKurly_Portfolio/img/${ item.getItem_image() }" height="350">
					</td>
					<td width="400" colspan="2">
						<font size="5"><b>${item.getItem_name() }</b></font><br>
						<font size="2"><b>${item.getItem_info() }</b></font>
					</td>
				</tr>
				<tr height="70">
					<td width="400" colspan="2">
						<font size="3"><b><del>${ item.getItem_price() }원</del></b></font> →
						<font size="4" color="purple"><b><fmt:formatNumber value="${ item.getItem_price() - item.getItem_price() * item.getDiscount_rate()/100 }" pattern="#,###"/>원</b></font><br>
						<font size="2" color="purple">로그인 후 적립혜택이 적용됩니다.</font>
					</td>
				</tr>
				<tr height="50">
					<td width="100">
						<font size="2"><b>판매단위</b></font>
					</td>
					<td width="300">
						<font size="2">1개</font>
					</td>
				</tr>
				<tr height="50">
					<td width = "100">
						<font size="2"><b>배송방법</b></font>
					</td>
					<td width = "300">
						<font size="2">샛별배송/택배배송</font>
					</td>
				</tr>
				<tr height="50">
					<td width = "100">
						<font size="2"><b>포장타입</b></font>
					</td>
					<td width = "300">
						<font size="2">상온/종이포장</font><br>
						<font size="1">택배배송은 에코포장이 스티로폼으로 대체됩니다.</font>
					</td>
				</tr>
				<tr height="50">
					<td width = "100">
						<font size="2"><b>구매수량</b></font>
					</td>
					<td width = "300">
						<input type ="number" id="buyCnt" min="0" max="100" size = "100" value = "1">
					</td>
				</tr>
				<tr height="35">
					<td colspan="3" align="right">
						<input type="hidden" id="id" value="${ request.getParameter('id') }">
						<input type="hidden" id="item_number" value="${ item.getItem_number() }">
						<input type="hidden" id="buyer" value="${ sessionScope.id }">
						<button id="insertCart"><img src="/MarketKurly_Portfolio/img/sendcart.PNG" height="50"></button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>