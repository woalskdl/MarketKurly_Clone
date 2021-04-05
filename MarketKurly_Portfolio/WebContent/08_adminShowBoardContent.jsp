<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/MarketKurly_Portfolio/js/jquery-1.11.0.min.js"></script>
<script src="/MarketKurly_Portfolio/08_adminShowBoardContent.js"></script>
<div align="center">
	<table border="1" style="border-collapse : collapse">
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
				<td align="center" width="180"> ${ bean.getReg_date() }</td>
			</tr>
			<tr height="40">
				<td align="center" width="120"> 제목 </td>
				<td align="center" colspan="3"> ${bean.getTitle()}</td>
			</tr>
			<tr height="80">
				<td align="center" width="120"> 글 내용 </td>
				<td align="center" colspan="3"> ${bean.getContent()}</td>
			</tr>
			<tr height="40">
				<td align="center" colspan="4">
					<button id="reply" name="${ bean.getNum() }" onclick="reply(this)">답글쓰기</button>
					<button id="boardList">목록보기</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
