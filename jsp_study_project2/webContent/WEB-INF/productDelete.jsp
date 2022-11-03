<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>	
	<div id="wrap" class="listWrap">
		<h2>상품삭제 - 관리자 페이지</h2>
		<form method="post" enctype="multipart/form-data" name="frm">

			<input type="hidden" name="code" value="${product.code}">
			
			<table>
				<tr>
					<td style="width=20%;">
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
								<th style="100px;">상품명</th>
								<td>${product.name}</td>
							</tr>	
							
							<tr>
								<th>가격</th>
								<td>${product.price}원</td>
							</tr>	
							
							<tr>
								<th>설명</th>
								<td><div style="height:200px;width:100%;">${product.description}</div></td>
							</tr>	
				
						</table>
					
					
					</td>
				</tr>
			
			</table>
			
			<div style="text-align: center">
			
				<input type="submit" value="삭제">
				<input type="button" value="목록" onclick="location.href='productList.do'">
				
			</div>
		</form>
	</div>
</body>
</html>