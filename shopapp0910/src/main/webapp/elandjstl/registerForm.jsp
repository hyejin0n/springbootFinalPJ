<%@ page language = "java" 
		 contentType = "text/html;
		 charset=UTF-8" pageEncoding="UTF-8"%> 
		 
<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="UTF-8">
		<title> registerForm </title>
	</head>
	<body>
		<h2> registerForm </h2>
		<form action="registerProc" method="get">
			<p>
				등록이름 : <input type="text" name="name">
			</p>
			<p>
				이메일 : <input type="text" name="email">
			</p>
			<p>
				취미 : 
				<input type="checkbox" name="hobby" value="swimming"> 수영
				<input type="checkbox" name="hobby" value="tennis"> 테니스
				<input type="checkbox" name="hobby" value="basketball"> 농구
			</p>
			
			<input type="submit" value="등록">
	</body>
</html>