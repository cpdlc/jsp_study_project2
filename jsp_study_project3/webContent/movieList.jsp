<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="contentWrap">
	<h2>리스트</h2>
	<table>
		<p style="text-align: right"><a href="moviewrite.do">정보등록</a></p>
		<tr>
			<th>제목</th>
			<th>감독</th>
			<th>배우</th>
			<th>가격</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.title}</td>
				<td>${list.director}</td>
				<td>${list.actor}</td>
				<td>${list.price}</td>
				<td><a href="movieUpdate.do?code=${list.code}">정보 수정</a></td>
				<td><a href="moviedelete.do?code=${list.code}">정보 삭제</a></td>
			</tr>	
		</c:forEach>
	</table>
</body>
</html>