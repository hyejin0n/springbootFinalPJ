<%@ page language = "java" 
		 contentType = "text/html;
		 charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		 
<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="UTF-8">
		<!--
			ctrl + shift + /
			부트스트랩 CSS 라이브러리 포함
		-->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		
		<!-- 부트스트랩 js 라이브러리 포함 -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
		
		<title> 전체 게시판 </title>
		<style>
			.my_container {
				max-width: 1000px;
				margin-top: 40px;
				padding: 32px;
				background-color: white;
				/* 가장자리 둥글게.. */
				border-radius: 20px;
				box-shadow: 0 0px 30px 0 rgba(0,0,255,0.5);
				
			}
		</style>
	</head>
	<body>
		<div class="container my_container">
			<p class="fs-2 text-center"> 전체 게시판 </p>
			
			<!-- 게시판 내용 추가 버튼 -->
			<button type="submit" 
				class="btn btn-outline-primary"
				onclick="location.href='insertBoard.do'">게시판 추가</button>
			
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Title</th>
			      <th scope="col">Writer</th>
			      <th scope="col">Content</th>
				  <th scope="col">Modify/Delete</th>
			    </tr>
			  </thead>
			  <tbody>
				
				<c:forEach var="board" items="${bList}">					
					<tr>
				      <th scope="row">${board.seq}</th>
				      <td>${board.title}</td>
				      <td>${board.writer}</td>
				      <td>${board.content}</td>
					  <td>
						<button type="submit" 
				class="btn btn-outline-primary"
				onclick="location.href='modifyBoard.do?seq=${board.seq}'">Modify</button>
					<button type="submit" 
					class="btn btn-outline-danger"
					onclick="location.href='deleteBoard.do?seq=${board.seq}'">Delete</button>
						
				  	  </td>
				    </tr>	
				</c:forEach>	
			   
				 
			   
			  </tbody>
			</table>
			
		</div>
					
		
		
	</body>
</html>