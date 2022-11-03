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
	<form method="post" action="movieUpdate.do" enctype="multipart/form-data">
	<table>
		<tr>
			<input type="hidden" name="poster" value="${vo.poster}">
			<input type="hidden" name="code" value="${vo.code}">
			<td><img src="img/${vo.poster}"></td>
		
			<td>
				<table>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title" value="${vo.title}"></td>
					</tr>
					
					<tr>
						<th>가격</th>
						<td><input type="text" name="price" value="${vo.price}"></td>
					</tr>
					
					<tr>
						<th>감독</th>
						<td><input type="text" name="director" value="${vo.director}"></td>
					</tr>
					
					<tr>
						<th>배우</th>
						<td><input type="text" name="actor" value="${vo.actor}"></td>
					</tr>
					
					<tr>
						<th>설명</th>
						<td><textarea cols="80" rows="10" name="synopsis">${vo.synopsis}</textarea></td>
					</tr>
					
					<tr>
						<th>사진</th>
						<td><input type="file" name="re_poster">(포스터 바꿀시에만 사진을 넣어주세요)</td>
					</tr>
					
					<tr>
						<td cols="2">
							<input type="submit" value="수정하기">
							<input type="reset" value="다시쓰기">
						</td>
					</tr>
				
				</table>
			</td>
		</tr>
		
	</table>
	</form>
	
	</div>
</body>
</html>