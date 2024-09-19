<%@ page language = "java" 
		 contentType = "text/html;
		 charset=UTF-8" pageEncoding="UTF-8"%> 
		 
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
		
		<style>
			.my_container {
				max-width: 600px;
				margin-top: 40px;
				padding: 32px;
				background-color: white;
				/* 가장자리 둥글게.. */
				border-radius: 20px;
				box-shadow: 0 0px 30px 0 rgba(0,0,255,0.5);
				
			}
		</style>
		
	    <title>HelloJSP</title>
	</head>
	<body>
		
		<div class="container my_container">
			<p class="fs-2 text-center"> 게시판 등록 </p>
			
			<form action="insertProcBoard.do" method="get">
				
				  <div class="mb-3">
					
				    <label for="exampleInputTitle" class="form-label"> 
						글제목(Title) 
					</label>
					
				    <input type="text"
					       class="form-control" 
						   id="exampleInputTitle"
						   name="title">
				  </div>
				  
				  <div class="mb-3">
				  					
  				    <label for="exampleInputWriter" class="form-label"> 
  						글쓴이(Writer) 
  					</label>
  					
  				    <input type="text"
  					       class="form-control" 
  						   id="exampleInputWriter"
  						   name="writer">
  				  </div>
				  
				  <div class="mb-3">
				  				  					
				    <label for="exampleInputContent" class="form-label"> 
						글내용(Content) 
					</label>
					
				    <input type="text"
					       class="form-control" 
						   id="exampleInputContent"
						   name="content">
				   </div>
				  
				  <div class="d-grid gap-2 d-md-flex justify-content-md-end">
					  <button type="submit" class="btn btn-primary">저장</button>
					  <button type="reset" class="btn btn-danger">취소</button>
				  </div>
				  
				</form>
		</div>
		
		
	</body>
</html>