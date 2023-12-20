<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<header>
    <div class="container">
        <h1>장바구니</h1>
        <nav>
            <a href="#">홈</a>
            <a href="#">제품 목록</a>
            <a href="#">장바구니</a>
            <span id="cartItemCount">0</span>
        </nav>
    </div>
</header>

<main>
    <div class="container">
        <h2>장바구니 목록</h2>
        <table class="table">
            <thead>         
            <tr><td>상품번호</td><td>${mem.jno}</td>
                <td>상품</td><td>${mem.jname}</td>
                <tr>         
            </thead>
           </table>
    </div>
</main>
</body>
</html>