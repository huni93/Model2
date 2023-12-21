<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Homepage - Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
          <link href="${pageContext.request.contextPath}/css/board.css" rel="stylesheet" />
           <link href="${pageContext.request.contextPath}/css/memberform.css" rel="stylesheet" />
           <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" />
  
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
            
                <a class="navbar-brand" href="${pageContext.request.contextPath}/member/index">Bootstrap</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                     
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/member/index">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/board/boardForm">게시판</a></li>
                         <c:if test = "${sessionScope.id==null}">          
						 <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/loginForm">로그인</a></li>
						 <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/MemberInput">회원가입</a></li>
						 </c:if>
						 <c:if test = "${sessionScope.id!=null}">
						 <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/memberinfo">[${sessionScope.id}]&nbsp;&nbsp;회원정보</a></li>
						 <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/jumun/jumunList">장바구니</a></li>
						 <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/memberlogout">로그아웃</a></li>
						  </c:if>
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
       
   