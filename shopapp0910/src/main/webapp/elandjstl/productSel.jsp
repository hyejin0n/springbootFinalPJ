<%@ page language = "java" 
		 contentType = "text/html;
		 charset=UTF-8" pageEncoding="UTF-8"%> 
		 
<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="UTF-8">
		<title> productSel </title>
	</head>
	<body>
		<h2> productSel </h2>
		<p> 품목 : ${param.item} </p>
		<p> 가격 : ${param.price} </p>
		<p> 개수 : ${param.num} </p>
		<p> 선택한 제품의 가격 : ${param.num * param.price} </p>
	</body>
</html>