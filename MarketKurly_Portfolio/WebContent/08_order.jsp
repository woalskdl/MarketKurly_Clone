<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${ empty sessionScope.id }">
	<script>
		alert("로그인이 필요합니다.");
	</script>
	<meta http-equiv="Refresh" content="0;url=/MarketKurly_Portfolio/login.do">
</c:if>

	<div align="center">
		<h2>주문서</h2>
		<hr size="2" color="purple" width="300">
		
		<form method="post" action="/MarketKurly_Portfolio/insertOrderList.do">
			<table>
				<tr height="50">
					<td colspan="4"><h3 align="left">구매상품확인</h3></td>
				</tr>
				<tr height="20">
					<td width="200" align="center"><b>번호</b></td>
					<td width="100" align="center"><b>이미지</b></td>
					<td width="400" align="center"><b>상품명</b></td>
					<td width="100" align="center"><b>수량</b></td>
				</tr>
				<tr height="5">
					<td colspan="4"><hr size="1" color="gray" width="800"></td>
				</tr>
				<c:set var="number" value="${ 0 }"/>
				<c:forEach var="order" items="${ orderList }">
					<tr height="50">
						<td width="200" align="center">
							<c:set var="number" value="${ number + 1 }"/>
							<c:out value="${ number }"/>
						</td>
						<td width="100" align="center">
							<img src="/MarketKurly_Portfolio/img/${ order.getItem_image() }" height="50">
						</td>
						<td width="400" align="center">
							<font size="3">${ order.getItem_name() }</font>
						</td>
						<td width="100" align="center">
							<font size="3">${ order.getBuy_count() }</font>
						</td>
					</tr>
					<tr>
						<td colspan="4"><hr size="1" color="gray" width="750"></td>
					</tr>
				</c:forEach>
			</table>
			
			<table>
				<c:set var="customer" value="${ customer }"/>
					<tr height="50">
						<td colspan="2">
							<h3 align="left">구매자 정보</h3>
						</td>
					</tr>
					<tr height="5">
						<td colspan ="2">
							<hr size="1" color="gray" width="800">
						</td>
					</tr>
					<tr height = "50">
						<td width = "200" align="center">
							<font size="2"><b>이름</b></font>
						</td>
						<td width = "600">
							<input type="text" name = "buyerName" value="${customer.getName()}" style="width:200px; height:30px">
						</td>
					</tr>
					<tr height = "50">
						<td width = "200" align="center">
							<font size="2"><b>전화번호</b></font>
						</td>
						<td width = "600">
							<input type="text" name = "buyerTel" value="${customer.getTel()}" style="width:200px; height:30px">
						</td>
					</tr>
					<tr height = "50">
						<td width = "200" align="center">
							<font size="2"><b>주소</b></font>
						</td>
						<td width = "600">
							<input type="text" name = "buyerAddress" value="${customer.getAddress()}" style="width:300px; height:30px">
						</td>
					</tr>
			</table>
			
			<br>
			
			<table>
				<tr height="50">
					<td colspan = "2">
						<h3 align = "left">결제방법</h3>
					</td>
				</tr>
				<tr height="5">
					<td colspan ="2">
						<hr size="1" color="gray" width="800">
					</td>
				</tr>
				<tr height="50">
					<td width="200" align="center">
						<font size="2"><b>결제수단</b></font>
					</td>
					<td width="600">
						<select name="howPay">
							<option value="1">계좌이체</option>
							<option value="2">신용카드</option>
						</select>
					</td>
				</tr>
			</table>
			
			<table>
				<tr height="50">
					<td width="800">
						<h3 align = "left">결제금액</h3>
					</td>
				</tr>
				<tr height="5">
					<td width="800">
						<hr size="1" color="gray" width="800">
					</td>
				</tr>
				<c:set var="total" value="${ total }"/>
				<tr height="50">
					<td align = "right" width="800">
						<h3><fmt:formatNumber value="${ total }" pattern="#,###"/>원</h3>
					</td>
				</tr>
				<tr height="50">
					<td align="center" width="800">
						<input type="image" src = "/MarketKurly_Portfolio/img/pay.PNG" name="submit" value = "submit" style="height:50px">
						<input type="hidden" name="id" value="${sessionScope.id}">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>