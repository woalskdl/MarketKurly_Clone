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
		<form action="/MarketKurly_Portfolio/writeAnswerPro.do" method="post" accept-charset="UTF-8">
			<c:forEach var="bean" items="${ bean }">
				<table border="1" style="border-collapse:collapse;">
					<tr height="50">
						<td width="200" align="center"> 작성자 </td>
						<td width="400"> 관리자 </td>
					</tr>
					<tr height="50">
						<td width="200" align="center"> 제목 </td>
						<td width="400"> <input type="text" name="title" value="[답변] ${ bean.getTitle() }" size="50"></td>
					</tr>
					<tr height="50">
						<td width="200" align="center"> 내용 </td>
						<td width="400"> <textarea rows="10" cols="50" name="content">
						
						   re: ${ bean.getContent() }</textarea></td>
					</tr>
					
					<tr height="40">
						<td align="center" colspan="2">
							<input type="hidden" name="ref" value="${ ref }">
							<input type="hidden" name="re_step" value="${ re_step }">
							<input type="hidden" name="re_level" value="${ re_level }">
							<input type="hidden" name="writer" value="관리자">
							<input type="submit" value="답글쓰기"> &nbsp;
							<input type="reset" value="다시쓰기"> &nbsp;
							<input type="button" onclick="location.href='/MarketKurly_Portfolio/adminShowBoardList.do'" value="전체글보기" />
						</td>
					</tr>
				</table>
			</c:forEach>
		</form>
	</div>
</body>
</html>