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
                <tr>
                    <th>상품명</th>
                    <th>가격</th>
                    <th>수량</th>
                    <th>합계</th>
                    <th>삭제</th>
                </tr>
            </thead>
            <tbody id="cartItems">
                <!-- 장바구니 아이템이 여기에 들어갑니다. -->
            </tbody>
        </table>
    </div>
</main>
</body>
</html>