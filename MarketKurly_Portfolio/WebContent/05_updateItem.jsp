<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form method="post" action="/MarketKurly_Portfolio/updateItemPro.do" enctype="multipart/form-data" accept-charset="UTF-8">
			<c:forEach var="update" items="${ beanForUpdate }">
				<table border="1" style="border-collapse : collapse;">
					<tr height="30">
						<td width="150" align="center">번호</td>
						<td width="300"> ${ update.getItem_number() }</td>
					</tr>
					<tr height="30">
						<td width="150" align="center">카테고리</td>
						<td width="300">
							<select name="category">
								<option value="100" <c:if test="${ update.getItem_category() == 100 }">selected</c:if>>채소</option>
								<option value="200" <c:if test="${ update.getItem_category() == 200 }">selected</c:if>>해산물</option>
								<option value="300" <c:if test="${ update.getItem_category() == 300 }">selected</c:if>>육류</option>
								<option value="400" <c:if test="${ update.getItem_category() == 400 }">selected</c:if>>채소</option>
							</select>
						</td>
					</tr>
					<tr height="30">
						<td width="150" align="center">상품명</td>
						<td width="300"><input type="text" name="name" value="${ update.getItem_name() }"></td>
					</tr>
					<tr height="30">
						<td width="150" align="center">가격</td>
						<td width="300"><input type="text" name="price" value="${ update.getItem_price() }"></td>
					</tr>
					<tr height="30">
						<td width="150" align="center">재고</td>
						<td width="300"><input type="text" name="stock" value="${ update.getItem_stock() }"></td>
					</tr>
					<tr height="30">
						<td width="150" align="center">이미지</td>
						<td width="300"><img src="/MarketKurly_Portfolio/img/${ update.getItem_image() }" height="30"><input type="file" name="image" value="업로드"></td>
					</tr>
					<tr height="30">
						<td width="150" align="center">상품 정보</td>
						<td width="300"><input type="text" name="info" value="${ update.getItem_info() }"></td>
					</tr>
					<tr height="30">
						<td width="150" align="center">할인율</td>
						<td width="300"><input type="text" name="discount_rate" size="3" value="${ update.getDiscount_rate() }">%</td>
					</tr>
					<tr height="30">
						<td width="150" align="center">등록일</td>
						<td width="300">${ update.getReg_date() }</td>
					</tr>
					<tr height="30">
						<td width="150" align="center">판매량</td>
						<td width="300">${ update.getSold() }</td>
					</tr>
					<tr height="30">
						<td width="450" align="center" colspan="2">
						 	<input type="submit" value="수정하기">&nbsp;
						 	<input type="hidden" name="item_number" value="${update.getItem_number()}">
						 	<input type="reset" value="다시작성">
						</td>
					</tr>
				</table>
			</c:forEach>
		</form>
	</div>
</body>
</html>