<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/shopping.css">
	<script src="script/product.js"></script>
</head>
<body>
	<div id="wrap">
		<h2>상품 리스트 - 관리자 페이지</h2>
		<form name="frm" method="post" enctype="multipart/form-data" >
			<table>
				<tr>
					<th>상품명</th>
					<td><input type="text" name="name" ></td>
				</tr>	
				
				<tr>
					<th>가격</th>
					<td><input type="text" name="price">원</td>
				</tr>	
				
				<tr>
					<th>사진</th>
					<td><input type="file" name="pictureurl"></td>
				</tr>	
				
				<tr>
					<th>설명</th>
					<td><textarea cols="80" cols="10" name="description"></textarea></td>
				</tr>	
	
			</table>
			<div style="text-align: center">
			
				<input type="submit" value="등록" onclick="return productCheck()">
				<input type="reset" value="다시작성">
				<input type="button" value="목록" onclick="location.href='productList.do'">
				
			</div>
		</form>
	</div>
</body>
</html>