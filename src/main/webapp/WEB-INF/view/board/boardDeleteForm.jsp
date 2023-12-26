<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<link rel="stylesheet" href="../webapp/css/login.css">
</head>
<body>
	 <div class="main">
                       
    <p class="sign" align="center">게시물 삭제</p>
       <form class="validation-form" novalidate    action="boardDeletePro">
         <input type="hidden" name="num" value="${num}">
      <input class="pass" type="password" align="center" name="pass" placeholder="Password">
      <input type="submit" class="submit"  align="center" value = "확인"></a>
      </form>                      
    </div>               
           </div>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>