<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Homepage - Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet" />
          <link href="<%=request.getContextPath()%>/css/board.css" rel="stylesheet" />
           <link href="<%=request.getContextPath()%>/css/memberform.css" rel="stylesheet" />
           <link href="<%=request.getContextPath()%>/css/login.css" rel="stylesheet" />
           <link href="<%=request.getContextPath()%>/css/shopbasket.css" rel="stylesheet" />
    
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
            
                <a class="navbar-brand" href="index">Bootstrap</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="index">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="board">게시판</a></li>
                        <%

String login = (String)session.getAttribute("id");
if(login==null) {
	
%>
						 <li class="nav-item"><a class="nav-link" href="loginForm">로그인</a></li>
						 <li class="nav-item"><a class="nav-link" href="MemberInput">회원가입</a></li>
						 <%}else{ %>
						 <li class="nav-item"><a class="nav-link" href="memberinfo">[<%=login%>]&nbsp;&nbsp;회원정보</a></li>
						 <li class="nav-item"><a class="nav-link" href="shopbasket">장바구니</a></li>
						 <li class="nav-item"><a class="nav-link" href="memberlogout">로그아웃</a></li>
						  <%} %>
                            </ul>                   
                </div>
            </div>
        </nav>
        <!-- Header-->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">Shop in style</h1>                    
                </div>
            </div>
        </header>
       
   