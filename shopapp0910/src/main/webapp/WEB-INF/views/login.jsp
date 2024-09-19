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
			}
		</style>

	    <title>HelloJSP</title>
	</head>
	<body>

		<div class="container my_container">
			<p class="fs-2 text-center"> 로그인 </p>

			<form action="loginProcBoard.do" method="get">


				  <div class="mb-3">

  				    <label for="exampleInputWriter" class="form-label">
  						이메일
  					</label>

  				    <input type="text"
  					       class="form-control"
  						   id="exampleInputEmail"
  						   name="email">
  					<div id="emailHelp" class="form-text">이메일 주소를 입력하세요.</div>
  				  </div>

				  <div class="mb-3">

				    <label for="exampleInputContent" class="form-label">
						비밀번호
					</label>

				    <input type="text"
					       class="form-control"
						   id="exampleInputPassword"
						   name="passWord">
					<div id="emailHelp" class="form-text">비밀번호를 입력하세요.</div>
				   </div>

				  <div class="d-grid gap-2 d-md-flex justify-content-md-end">
					  <button type="submit" class="btn btn-primary">로그인</button>
					  <button type="button" class="btn btn-danger"
					   onclick="location.href='signup'">회원가입</button>
				  </div>

				</form>
		</div>


	</body>
</html>