<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
	<h2>상품등록 - 관리자페이지</h2>
	<form action="productWrite.do" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>상품명</th>
				<td><input type="text" name="name"></td>
			</tr>	
			
			<tr>
				<th>가격</th>
				<td><input type="number" name="price"></td>
			</tr>	
			
			<tr>
				<th>이미지</th>
				<td><input type="file" name="pictureurl"></td>
			</tr>	
			
			<tr>
				<th>설명</th>
				<td><input type="text" name="description"></td>
			</tr>	
			
			<tr>
				<th>상품명</th>
				<td><input type="text" name="name"></td>
			</tr>	

		</table>
		<input type="submit" value="등록">
				<input type="reset" value="다시작성">
	</form>
</body>
</html>