<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/MarketKurly_Portfolio/js/jquery-1.11.0.min.js"></script>
<script src="/MarketKurly_Portfolio/08_showBoardContent.js"></script>

<div align="center">
	<table border="1" style="border-collapse : collapse;">
		<c:forEach var="bean" items="${ bean }">
			<tr height="40">
				<td align="center" width="120"> 글번호 </td>
				<td align="center" width="180"> ${ bean.getNum() } </td>
				<td align="center" width="120"> 조회수 </td>
				<td align="center" width="180"> ${ bean.getReadcount() } </td>
			</tr>
			<tr height="40">
				<td align="center" width="120"> 작성자 </td>
				<td align="center" width="180"> ${ bean.getWriter() } </td>
				<td align="center" width="120"> 작성일 </td>
				<td align="center" width="180"> ${ bean.getReg_date() } </td>
			</tr>
			<tr height="40">
				<td align="center" width="120"> 제목 </td>
				<td align="center" colspan="3"> ${ bean.getTitle() } </td>
			</tr>
			<tr height="80">
				<td align="center" width="120"> 글 내용 </td>
				<td align="center" colspan="3"> ${ bean.getContent() } </td>
			</tr>
			<tr height="40">
				<td align="center" colspan="4">
					<c:set var="viewer" value="${ sessionScope.id }"/>
					<c:set var="writer" value="${ bean.getWriter() }"/>
					<c:if test="${ viewer == writer }">
						<button id="edit" name="${ bean.getNum() }" onclick="edit(this)">수정하기</button>
						<button id="del" name="${ bean.getNum() }" onclick="del(this)">삭제하기</button>
					</c:if>
					<button id="list">목록보기</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>