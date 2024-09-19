<%@ page language = "java" 
		 contentType = "text/html;
		 charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="UTF-8">
		<title> jstlEx </title>
	</head>
	<body>
		<h2> jstlEx </h2>
		<hr>
		<h3> c:out 연습 </h3>
		<%
			int i = 10;
			request.setAttribute("i", i);
		%>
		
		<c:out value="${i}"> </c:out>
		<hr>
		<h3> c:set 연습 </h3>
		<c:set value="20" var="j" />
		<c:set value="40" var="k" />
		
		<p> j : <c:out value="${j}" />
		<p> k : <c:out value="${k}" />
			
		<!-- 객체 생성하여 멤버변수에 접근 -->
		<jsp:useBean id="product" class="com.springboot.webapp.model.ProductDo" />
		<p> num : ${product.num} </p>
		<p> price : ${product.price} </p> 
		<c:set value="200" target="${product}" property="num" />	
		<c:set value="20000" target="${product}" property="price" />
		<p> num : ${product.num} </p>
		<p> price : ${product.price} </p>
		
		<hr>
		<h3> c:if 연습 </h3>
		<c:set value="hong" var="user" />
		<c:if test="${user == 'gil'}" var="res" >
			<p> result : ${res} </p>	
		</c:if>		
		
		<hr>
		<h3> c:forEach 연습 </h3>
		
		<c:forEach var="i" begin="1" end="10">
			<p> i : ${i} </p>
		</c:forEach>
		
		<hr>
		<c:forEach var="j" begin="0" end="10" step="${j+1}">
			<p> j : ${j} </p>
		</c:forEach>
		
		<hr>		
		<c:forEach var="i" begin="0" end="3">
			<!-- 공백 출력 -->
			<c:forEach var="j" begin="${i+1}" end="3">
				&nbsp		
			</c:forEach>
			
			<!-- 별표 출력 -->
			<c:forEach var="j" begin="1" end="${(i*2)+1}">
				*		
			</c:forEach>
			<br>
		</c:forEach>
		
		<hr>
		<!-- 배열데이터 forEach 이용 출력 -->
		<jsp:useBean id="product2" 
				 class="com.springboot.webapp.model.ProductDo" />
		<select> 
			<c:forEach var="prod" items="${product2.getProductList()}">
						<option> ${prod} </option>
			</c:forEach>
		</select> 			 
				 
		
		
		
		
		
		
		
		
		 
								
		
		
		
		
	</body>
</html>
