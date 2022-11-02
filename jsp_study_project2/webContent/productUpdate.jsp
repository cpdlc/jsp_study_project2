<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/shopping.css">
	<script src="script/product.js"></script>
</head>
<body>	
	<div id="wrap" class="listWrap">
		<h2>상품수정 - 관리자 페이지</h2>
		<form method="post" enctype="multipart/form-data" name="frm">
			
			<input type="hidden" name="code" value="${product.code}" >
			<input type="hidden" name="nomakeImg" value="${product.pictureurl}" >
			
			<table>
				<tr>
					<td>
						<c:choose>
							<c:when test="${empty product.pictureurl}">
								<img src="upload/noimage.gif" style="width:200px;">
							</c:when>
							<c:otherwise>
								<img src="upload/${product.pictureurl}" style="width:200px;">
							</c:otherwise>
						</c:choose>
					</td>
					<td>
						<table>
							<tr>
								<th>상품명</th>
								<td><input type="text" name="name" value="${product.name}" ></td>
							</tr>	
							
							<tr>
								<th>가격</th>
								<td><input type="text" name="price" value="${product.price}">원</td>
							</tr>	
							
							<tr>
								<th>사진</th>
								<td><input type="file" name="pictureurl"><br/>
								(주의사항 : 이미지를 변경하고자 할때만 선택하세요)
								</td>
							</tr>	
							
							<tr>
								<th>설명</th>
								<td><textarea cols="80" cols="10" name="description">${product.description}</textarea></td>
							</tr>	
				
						</table>
					
					
					</td>
				</tr>
			
			</table>
			
			<div style="text-align: center">
			
				<input type="submit" value="수정" onclick="return productCheck()">
				<input type="reset" value="다시작성">
				<input type="button" value="목록" onclick="location.href='productList.do'">
				
			</div>
		</form>
	</div>
</body>
</html>