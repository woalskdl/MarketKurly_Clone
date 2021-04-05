<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<meta charset="UTF-8">
<title>마켓컬리 :: 내일의 장보기</title>
<style>
	a{
	 color : black;
	 text-decoration : none;
	
	}
	a:hover{
		color : purple;
	}
	#auth{
		right:10px;
	}
</style>
</head>
<body>
	<div id="header">
		<c:if test="${ type == 0 }">
			<div id="auth" class="box" align="right">
				<jsp:include page="01_managerLogin.jsp"/>
			</div>
			<div id="top" class="box" align="center">
				<a href="/MarketKurly_Portfolio/index.do">
					<img src="/MarketKurly_Portfolio/img/logo.png" id="logo" height="80">
				</a>
			</div>
			<br>
			<div id="mainMenuDiv" align="center">
				<table>
					<tr height="50">
						<td width="180" align="center" id="dropdown">
							<font size="3" color="black"><a href="/MarketKurly_Portfolio/managerMain.do"><b>관리자 메인</b></a></font>
						</td>
						<td width="10" align = "center">
							<img alt="" src="img/top1.jpg">
						</td>
						<td width="180" align="center">
							<font size="3" color="black"><a href="/MarketKurly_Portfolio/addNewItem.do"><b>신상품등록</b></a></font>
						</td>
						<td width="10" align = "center">
							<img alt="" src="img/top1.jpg">
						</td>
						<td width = "180" align = "center">
							<font size="3" color="black"><a href = "/MarketKurly_Portfolio/itemListForManager.do"><b>상품 수정/삭제</b></a></font>
						</td>
						<td width="10" align = "center">
							<img alt="" src="img/top1.jpg">
						</td>
						<td width = "180" align = "center">
							<font size="3" color="black"><a href = "/MarketKurly_Portfolio/checkOrderList.do"><b>주문현황</b></a></font>
						</td>
						<td width="10" align = "center">
							<img alt="" src="img/top1.jpg">
						</td>
						<td width = "180" align = "center">
							<font size="3" color="black"><a href = "/MarketKurly_Portfolio/adminShowBoardList.do"><b>Q&A</b></a></font>
						</td>
					</tr>
				</table>
			</div>
		</c:if>
		<c:if test="${ type == 1 }">
			<div id="auth" class="box" align="right">
				<jsp:include page="00_topMenu.jsp"/>
			</div>
			<div id="top" class="box" align="center">
				<a href="/MarketKurly_Portfolio/index.do">
					<img src="/MarketKurly_Portfolio/img/logo.png" id="logo" height="80"/>
				</a>
			</div>
			<br>
			<div id="mainMenuDiv" align="center">
				<table>
					<tr height="50">
						<td width="180" align="center" id="dropdown">
							<font size="3" color="black"><a href="/MarketKurly_Portfolio/showAllItem.do"><b>전체상품 보기</b></a></font>
						</td>
						<td width="180" align="center">
							<font size="3" color="black"><a href="/MarketKurly_Portfolio/showNewItem.do"><b>신상품</b></a></font>
						</td>
						<td width="10" align = "center">
							<img alt="" src="img/top1.jpg">
						</td>
						<td width = "180" align = "center">
							<font size="3" color="black"><a href = "/MarketKurly_Portfolio/showBestItem.do"><b>베스트</b></a></font>
						</td>
						<td width="10" align = "center">
							<img alt="" src="img/top1.jpg">
						</td>
						<td width = "180" align = "center">
							<font size="3" color="black"><a href = "/MarketKurly_Portfolio/showDiscountedItem.do"><b>알뜰쇼핑</b></a></font>
						</td>
						<td width="10" align = "center">
							<img alt="" src="img/top1.jpg">
						</td>
						<td width = "180" align = "center">
							<font size="3" color="black"><a href = "#" style="text-decoration: none"><b>이벤트</b></a></font>
						</td>
						<td width = "40" align = "center">
							<a href = "/MarketKurly_Portfolio/cartInfo.do"><img alt="" src="img/cart.png" width="30"></a>
						</td>
					</tr>
				</table>
			</div>
		</c:if>
	</div>
	<div id="content" class="box2" align="center">
		<jsp:include page = "${ cont }"/>
	</div>
	<br>
	<div id="footer" align="center">
		<hr color = "lightgray" size="1">
		<table>
			<tr height="50">
				<td align="center" width="50">
					<img alt="" src="img/bottom(1).png" width="40" height="40">
				</td>
				<td width="250">
					<font size="1" color="gray">
					[인증범위]마켓컬리 쇼핑몰 서비스 개발ㆍ운영<br>
					[유효기간]2019.04.01~2022.03.31
					</font>
				</td>
				
				<td align="center" width="50">
					<img alt="" src="img/bottom(3).png" width="40" height="40">
				</td>
				<td width="250">
					<font size="1" color="gray">
					개인정보보호 우수 웹사이트<br>
					개인정보처리시스템 인증(ePRIVACY PLUS)
					</font>
				</td>
				
				<td align="center" width="150">
					<img alt="" src="img/bottom(2).png" width="150" >
				</td>
				<td width="350">
					<font size="1" color="gray">
					고객님의 안전거래를 위해 현금 등으로 결제 시 저희 쇼핑몰에서 가입한 <br/>
					토스 페이먼츠 구매안전(에스크로) 서비스를 이용하실 수 있습니다.
					</font>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>