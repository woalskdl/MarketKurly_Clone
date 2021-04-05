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
	<c:if test="${ empty sessionScope.id }">
		<script>
			alert("로그인이 필요합니다.");
		</script>
		<meta http-equiv="Refresh" content="0;url=/MarketKurly_Portfolio/login.do">
	</c:if>
	<div align="center">
		<form action="/MarketKurly_Portfolio/writePro.do" method="post" accept-charset="UTF-8">
			<table border="1" style="border-collapse : collapse;">
				<tr height="50">
					<c:set var="writer" value="${ sessionScope.id }"/>
					<td width="200" align="center"><b>작성자</b></td>
					<td width="400">
						<input type = "text" name="writer" value="${ writer }" readonly>
					</td>
				</tr>
				<tr height="50">
					<td width="200" align="center"><b>제목</b></td>
					<td width="400">
						<input type="text" name="title" size="50">
					</td>
				</tr>
				<tr height="150">
					<td width="200" align="center"><b>글내용</b></td>
					<td width="400">
						<textarea cols="50" rows="10" name="content"></textarea>
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="글쓰기">&nbsp;
			<input type="reset" value="다시쓰기">
		</form>
	</div>
</body>
</html>