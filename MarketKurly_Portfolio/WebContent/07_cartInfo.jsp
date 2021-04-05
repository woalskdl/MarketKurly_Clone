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
<script src="/MarketKurly_Portfolio/07_cartInfo.js"></script>
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

<c:if test="${ empty sessionScope.id }">
	<script>
		alert("로그인이 필요합니다.");
	</script>
	<meta http-equiv="Refresh" content="0;url=/MarketKurly_Portfolio/login.do">
</c:if>

<div id="cart" align="center">
	<h2>장바구니</h2>
	<hr size="2" color="purple" width="300">
	<c:if test="${cnt == 0 }">
		<h3>장바구니에 담겨있는 상품이 없습니다.</h3>
	</c:if>
	<c:if test="${ cnt > 0 }">
		<table>
			<tr height="40">
				<td width="50" align="center"><b>번호</b></td>
				<td width="100" align="center"><b></b></td>
				<td width="300"><b>상품명</b></td>
				<td width="100" align="center"><b>수량</b></td>
				<td width="100" ><b>금액</b></td>
				<td width="40" align="center"><b>삭제</b></td>
			</tr>
		</table>
		<hr size="2" color="gray" width="680">
		<c:set var="number" value="${ 0 }"/>
		<c:forEach var="cart" items="${ cartList }">
			<table>
				<tr height="40">
					<td width="50" align="center">
						<c:set var="number" value="${ number + 1 }"/>
						<c:out value="${ number }"/>
					</td>
					<td width="100" align="center">
						<img src="/MarketKurly_Portfolio/img/${ cart.getItem_image() }" height="40">
					</td>
					<td width="300">
						<font size="3"><b>${ cart.getItem_name() }</b></font>
					</td>
					<td width="100" align="center">
						<font size="3"><b>${ cart.getBuy_count() }</b></font>
					</td>
					<td width="100" >
						<font size="3"><b><fmt:formatNumber value="${ cart.getBuy_price() * cart.getBuy_count() }" pattern="#,###"/>원</b></font>
					</td>
					<td width="40" align="center">
						<button id="delCart" name="${ cart.getCart_number() }" onclick="delCart(this)"><img src="/MarketKurly_Portfolio/img/delete.png" height="18"></button>
					</td>
				</tr>
			</table>
			
			<hr size="1" color="gray" width="680">
			<c:set var="total" value="${ total + cart.getBuy_count() * cart.getBuy_price() }"/>
			<c:set var="deliveryfee" value="3000"/>
		</c:forEach>
		
		<table>
			<tr height="30">
				<td align="right" width="480" align="right">
					<h4>총 상품금액</h4>
				</td>
				<td align="right" width="200" align="right">
					<h4><fmt:formatNumber value="${ total }" pattern="#,###"/>원</h4>
				</td>
			</tr>
			<tr height="30">
				<td align="right" width="480" align="right"><h4>배송비 </h4></td>
				<td align="right" width="200" align="right">
					<c:if test="${ total < 40000 }">
						<h4><fmt:formatNumber value="${ deliveryfee }" pattern="#,###"/>원</h4>
						<font size="2" color="purple">
							<fmt:formatNumber value="${ 40000 - total }" pattern="#,###"/>원 추가주문 시, 무료배송
						</font>
					</c:if>
					<c:if test = "${ total >= 40000 }">
						<h4>0원</h4>
					</c:if>
				</td>
			</tr>
			<tr height="40">
				<td align="right" width="480" align="right"><h3>총 결제금액 </h3></td>
				<td align="right" width="200" align="right">
					<c:set var="deliveryfee" value="3000"/>
					<c:if test="${ total < 40000 }">
						<c:set var="total" value="${ total + deliveryfee }"/>
					</c:if>
					<h3><b><fmt:formatNumber value="${ total }" pattern="#,###"/>원</b></h3>
				</td>
			</tr>
			<tr height="30">
				<td align="right" colspan="2">
					<input type="hidden" id="total" value="${ total }">
					<input type="hidden" id="buyer" value="${ sessionScope.id }">
					<button id="order"><img src="/MarketKurly_Portfolio/img/order.PNG" height="50"></button>
				</td>
			</tr>
		</table>
	</c:if>
</div>

</body>
</html>