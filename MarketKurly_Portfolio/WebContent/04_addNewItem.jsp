<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/MarketKurly_Portfolio/js/jquery-1.11.0.min.js"></script>
<script src="/MarketKurly_Portfolio/js/jquery.form.min.js"></script>
<script src="/MarketKurly_Portfolio/04_addNewItem.js"></script>

<c:if test="${ empty sessionScope.id }">
	<meta http-equiv="Refresh" content="0;url=/MarketKurly_Portfolio/managerMain.do">
</c:if>

<form method="post" id="upForm1" action="/MarketKurly_Portfolio/addNewItemPro.do" enctype="multipart/form-data" accept-charset="UTF-8">
	<table border="1" style="border-collapse : collapse;">
		<tr height="30">
			<td width="200">상품 카테고리</td>
			<td widht="500">
				<select name = "category">
					<option value = "100">채소</option>
					<option value = "200">해산물</option>
					<option value = "300">육류</option>
					<option value = "400">전자제품</option>
				</select>
			</td>
		</tr>
		<tr height="30">
			<td width="200">상품명</td>
			<td width = "500">
				<input type="text" name="name">
			</td>
		</tr>
		<tr height="30">
			<td width ="200">상품가격</td>
			<td width="500">
				<input type="text" name="price">원
			</td>
		</tr>
		<tr height="30">
			<td width="200">상품재고</td>
			<td width="500">
				<input type="text" name="stock">
			</td>
		</tr>
		<tr height="30">
			<td width="200">이미지</td>
			<td width="500">
				<input type="file" name="image">
			</td>
		</tr>
		<tr height="30">
			<td width="200">상품정보</td>
			<td width="500">
				<input type="text" name="info" size="50">
			</td>
		</tr>
		<tr height="30">
			<td width="200">할인율</td>
			<td width="500">
				<input type="text" name="discountRate">%
			</td>
		</tr>
	</table>
	<input type="submit" id="registItem" value="상품 추가하기">
</form>