<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  
<!DOCTYPE html>
  
  <body>    <!-- Section-->
      <section> 
                <h2> 게시판 </h2>
 
<hr class ="hr1" noshade> 

<form>
  <span class="right">
    <span class="grey" id="strong">SELECT</span>
    <select id="searchOption">
      <option value="subject">제목</option>
      <option value="name">작성자</option>
    </select>
    <input type="text" id="searchText">
    <input type="button" name="검색" class="gradient" value="검색" onclick="performSearch()">
  </span>
</form>
<table height="40%">
   <thead>
      <tr>
        <th>번호</th>
        <th>작성자</th>
        <th>제목</th>
        <th>날짜</th>
        <th>조회수</th>
        <th>파일</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="b" items="${li}">  
      <tr>
        <td>${b.num}</td>
        <td>${b.name}</td>
        <td><a href="boardInfo?num=${b.num}">${b.subject}</a></td>
        <td>${b.regdate}</td>
        <td>${b.readcnt}</td>
        <td>${b.file1}</td>
      </tr>
      </c:forEach>  
    </tbody>
</table>
</br>

<div class="center" >
    <a href  = "!#">◀ 이전</a> 
    <a href  = "!#">1</a>  
    <a href  = "https://www.daum.net/">다음 ▶</a>
</div>

<span class="right">
  <input type="button" value="목록" class="greylist">
  <a href="boardForm"><input type="button" value="글쓰기" class="gradient"></a>
</span>                
        </section>
    </body>
</html>