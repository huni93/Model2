
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
    
 
    
    <body>  
      
        <!-- Section-->    
      <div><br><br><br>
        <form action="memberUpdatePro" method="POST" class="joinForm" onsubmit="DoJoinForm__submit(this); return false;">                                                                                     
      <h2>회원정보수정</h2>
      <div class="textForm">
        <input  type="text" class="id" placeholder="아이디" name="id" readonly
        value="${mem.id}">   
      </div>
      <div class="textForm">
        <input  type="password" class="pw" placeholder="비밀번호" name="password">
      </div>
      <div class="textForm">
        <input  type="text" class="name" placeholder="이름" name="name"
        value="${mem.name}">
      </div>
       <div class="textForm">
        <input  type="text" class="email" placeholder="이메일" name= "email"
        value="${mem.email}">
      </div>
      <div class="textForm">
        <input  type="text" class="nickname" placeholder="닉네임" name="nickname"
        value="${mem.nickname}">
      </div>
      <div class="textForm">
        <input  type="number" class="cellphoneNo" placeholder="전화번호" name="tel"
        value="${mem.tel}">
      </div>
      <input type="submit" class="btn" value="회원정보수정"/>
    </form> 
    </div>
 <br><br><br><br><br><br><br><br><p>
        <!-- Footer-->
      <div>
        <footer class="py-5 bg-dark">
            <div class="container" ><p class="m-0 text-center text-white" >Website 2023</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script></div>
        
        
     </body>
</html>