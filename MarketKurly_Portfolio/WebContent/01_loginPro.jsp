<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${ check == 1 }">
	<c:set var="id" value="${ id }" scope="session"/>
	<script>
		location.href = '/MarketKurly_Portfolio/index.do';
	</script>
</c:if>

<c:if test="${ check != 1 }">
	<script>
		alert("아이디와 비밀번호를 확인하세요.");
		history.go(-1);
	</script>
</c:if>