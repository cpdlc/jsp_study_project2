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
	<form method="post" action="moviedelete.do" enctype="multipart/form-data">
	<table>
		<tr>

			<td><input type="text" name="code" value="${vo.code}" ></td>
			<td><img src="img/${vo.poster}"></td>
		
			<td>
				<table>
					<tr>
						<th>제목</th>
						<td>${vo.title}</td>
					</tr>
					
					<tr>
						<th>가격</th>
						<td>${vo.price}</td>
					</tr>
					
					<tr>
						<th>감독</th>
						<td>${vo.director}</td>
					</tr>
					
					<tr>
						<th>배우</th>
						<td>${vo.actor}</td>
					</tr>
					
					<tr>
						<th>설명</th>
						<td>${vo.synopsis}</td>
					</tr>
					

					
					<tr>
						<td>
							<input type="submit" value="삭제하기">
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