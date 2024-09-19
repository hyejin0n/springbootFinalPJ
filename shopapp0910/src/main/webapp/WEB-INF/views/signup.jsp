<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- 부트스트랩 CSS 라이브러리 포함 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- 부트스트랩 js 라이브러리 포함 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <style>
        .my_container {
            max-width: 600px;
            margin-top: 40px;
            padding: 32px;
            background-color: white;
            border-radius: 20px;
        }
    </style>
    <title>회원가입</title>
</head>
<body>
    <div class="container my_container">
        <p class="fs-2 text-center"> 회원가입 </p>
        <form action="signupProc.do" method="post">
            <div class="mb-3">
                <label for="exampleInputEmail" class="form-label">이메일</label>
                <input type="email" class="form-control" id="exampleInputEmail" name="email" required>
                <div id="emailHelp" class="form-text">유효한 이메일 주소를 입력하세요.</div>
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword" class="form-label">비밀번호</label>
                <input type="password" class="form-control" id="exampleInputPassword" name="password" required>
                <div id="passwordHelp" class="form-text">비밀번호를 입력하세요.</div>
            </div>
            <div class="mb-3">
                <label for="exampleInputConfirmPassword" class="form-label">비밀번호 확인</label>
                <input type="password" class="form-control" id="exampleInputConfirmPassword" name="confirmPassword" required>
                <div id="confirmPasswordHelp" class="form-text">비밀번호를 다시 입력하세요.</div>
            </div>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button type="submit" class="btn btn-primary">회원가입</button>
            </div>
        </form>
    </div>
</body>
</html>
