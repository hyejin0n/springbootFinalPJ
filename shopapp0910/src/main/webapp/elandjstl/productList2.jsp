<%@ page language = "java" 
		 contentType = "text/html;
		 charset=UTF-8" pageEncoding="UTF-8"%> 
		 
<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="UTF-8">
		<title> productList </title>
	</head>
	<body>
		<h2> productList </h2>
		<form action="productSel" method="get">
			
			<!-- ProductDo 클래스를 이용하여 product 이름의 객체 생성 -->
			<jsp:useBean id="product"
						 class="com.springboot.webapp.model.ProductDo">
			</jsp:useBean>
			
			<p> 상품 : 
				
				<select name="item">
					
					<c:forEach var="prod" items="${product.getProductList()}">
								<p> ${prod} </p>								
								<option> ${prod} </option>
					</c:forEach>
							
					<!--
					<%
						for(String item : product.getProductList()) {
					%>
							<option> <%= item%> </option>
					<%		
						}
					%>
					-->
				</select>
			</p>
			
			<p> 가격 : <input type="text" name="price"> </p>
			<p> 개수 : <input type="text" name="num"> </p>
			<p>
				<input type="submit" value="주문">
			</p>
		</form>
	</body>
</html>