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
		<h2>고객센터</h2>
		<hr size="1" color="purple" width="300">
		<br>
		
		<table border="1" style="border-collapse:collapse;">
			<tr height="30">
				<td width="50" align="center">번호</td>
				<td width = "400" align="center">제목</td>
				<td width = "200" align="center">작성자</td>
				<td width = "200" align="center">작성일</td>
				<td width = "50" align="center">조회수</td>
			</tr>
			<c:set var="number" value="${ number }"/>
			<c:set var="reff" value="${ board.getRe_step() }"/>
			<c:forEach var="board" items="${ boardList }">
				<tr height="30">
					<td width="50" align="center">${ number }</td>
					<c:set var="number" value="${ number - 1 }"/>
					<td width="400" align="left">
						<c:if test="${ board.getRe_step() > 1 }">
							<c:forEach var="j" begin="0" end="${ reff }">
								&nbsp;
							</c:forEach>
						</c:if>
						<a href="/MarketKurly_Portfolio/adminShowBoardContent.do?num=${ board.getNum() }" style="text-decoration:none">${board.getTitle()}</a>
					</td>
					<td width="200" align="center">${ board.getWriter() }</td>
					<td width="200" align="center">${ board.getReg_date() }</td>
					<td width="50" align="center">${ board.getReadcount() }</td>
				</tr>
			</c:forEach>
		</table>
		<p>
		<c:if test="${ count > 0 }">
			<c:if test="${ startPage > 10 }">
				<a href="/MarketKurly_Portfolio/adminShowBoardList.do?pageNum=${ startPage - 10 }">[이전]</a>
			</c:if>
			<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
				<c:if test="${ i != curPage }">
					<a href="/MarketKurly_Portfolio/adminShowBoardList.do?pageNum=${ i }"> [${ i }] </a>
				</c:if>
				<c:if test="${ i == curPage }">
					<font color="purple"><b> [${ i }] </b></font>
				</c:if>
			</c:forEach>
			<c:if test="${ endPage < pageCount }">
				<a href="/MarketKurly_Portfolio/adminShowBoardList.do?pageNum=${ startPage + 10 }">[다음]</a>
			</c:if>
		</c:if>
	</div>
</body>
</html>