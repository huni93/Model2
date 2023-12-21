<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<main>
    <div class="container">
        <h2>장바구니 목록</h2>
        <table height="40%">
        <thead>
        <tr>
        <th>유저</th>       
        <th>상품번호</th>
        <th>상품</th>
          <th>수량</th>
         <th>가격</th> 
        </tr></thead>
            <thead> <c:forEach var="j" items="${li}">        
            <tr>                
                <td>${j.userid}</td>
                <td>${j.itemid}</td>
                 <td>${j.jname}</td>
                <td>${j.qty}</td>
                <td>${j.price}</td>
                
               </tr> </c:forEach>    
            </thead>
           </table>
    </div>
</main>
</body>
</html>