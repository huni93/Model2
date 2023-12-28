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
        <th>선택</th>
        <th>상품</th>
          <th>수량</th>
         <th>가격</th> 
        </tr></thead>
            <thead> <c:forEach var="j" items="${li}">        
            <tr>                
                <td><input type="checkbox" name="selectedItems" value="${j.itemid}"></td>
                 <td>${j.jname}</td>
                 <td><input type="number" name="qty" min="0" value="${j.qty}"></td>           
                <td>${j.price}</td> 
                              
               </tr> </c:forEach> 
               <tr>
                    <td colspan="5" style="text-align: center;">
                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/jumun/jumunList">구매</a>
                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/jumun/jumunList">삭제</a>         
                    </td>
                </tr>   
            </thead>           
           </table>          
    </div>
</main>
</body>
</html>