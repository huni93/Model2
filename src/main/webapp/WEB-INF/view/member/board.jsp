<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  
<!DOCTYPE html>

        <!-- Section-->
        <section>
                <h2> 게시판 </h2>

<hr class ="hr1" noshade> 

<form>
<span> ▷ 총 3개의 게시물이 있습니다. </span>
<span class="right";> 
            <span class="grey"; id="strong";>SELECT</span>
    <select>
    <option value="제목"; name="제목"; >제목</option>
    <option value="글쓴이";name="글쓴이";>글쓴이</option>
    </select>
<input type="text";> <input type="button" name="검색" class="gradient" value="검색" >
</span>
</form>


<table height="40%">
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>글쓴이</th>
        <th>일시</th>
        <th>조회수</th>
    </tr>
    <tr>
        <td class="center">1</td>
        <td class="left">게시글 1 입니다.</td>
        <td class="center">홍길동</td>
        <td class="center">2023-11-03</td>
        <td class="center">2772</td>   
    </tr>
    <tr>
        <td class="center">2</td>
        <td class="left">게시글 2 입니다.</td>
        <td class="center">홍길동</td>
        <td class="center">2023-11-03</td>
        <td class="center">2772</td>   
    </tr>
    <tr>
        <td class="center">3</td>
        <td class="left">게시글 3 입니다.</td>
        <td class="center">홍길동</td>
        <td class="center">2023-11-03</td>
        <td class="center">2772</td>   
    </tr>
</table>
</br>

<div class="center" >
    <a href  = "!#">◀ 이전</a> 
    <a href  = "!#">1</a>  
    <a href  = "https://www.daum.net/">다음 ▶</a>
</div>

<span class="right";>
<input type="button" value="목록" class="greylist";>
<input type="button" value="글쓰기"  class="gradient";>
</span>                 
        </section>
    </body>
</html>