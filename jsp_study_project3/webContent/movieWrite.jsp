<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="contentWrap">
	<form method="post" action="moviewrite.do" enctype="multipart/form-data">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			
			<tr>
				<th>가격</th>
				<td><input type="text" name="price"></td>
			</tr>
			
			<tr>
				<th>감독</th>
				<td><input type="text" name="director"></td>
			</tr>
			
			<tr>
				<th>배우</th>
				<td><input type="text" name="actor"></td>
			</tr>
			
			<tr>
				<th>설명</th>
				<td><textarea cols="80" rows="10" name="description"></textarea></td>
			</tr>
			
			<tr>
				<th>사진</th>
				<td><input type="file" name="poster"></td>
			</tr>
			
			<tr>
				<td>
					<input type="submit" value="전송">
					<input type="reset" value="다시쓰기">
				</td>
			</tr>
		
		</table>
	</form>
	
	</div>
</body>
</html>