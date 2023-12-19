<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   <script>
function passChk(form){	   	   
	   if(form.password.value==""){
	      alert("password")
	      form.password.focus()
	      return false
	      	   } 
	   if(form.passcheck.value==""){
	      alert("passcheck")
	      form.passcheck.focus()
	      return false      
	   } 
	   if(form.passcheck1.value==""){
	      alert("passcheck1")
	      form.passcheck1.focus()
	      return false
	   }	      
	   if(form.passcheck.value !==form.passcheck1.value){
	      alert("변경 비밀번호와 재입력 번호가 다릅니다.")
	      form.passcheck1.value="";
	      form.passcheck1.focus()
	      return false	      
	   }
	   return true;	   
	}

</script>

<body>
  <div class="main" >
    <p class="sign" align="center">비밀번호 변경</p>
    <form class="form1"  action="memberPassPro"
    onsubmit = "return passChk(this)" method="post">
    
     
      <input class="pass" type="password" align="center" 
             placeholder="Password"  name="password">
             
          
      <input class="pass" type="password" align="center" 
             placeholder="passcheck"  name="passcheck">
             
             
      <input class="pass" type="password" align="center" 
             placeholder="passcheck1"  name="passcheck1">
      
      <input type="submit"  class="submit" value="비밀번호 변경">
     
        </form>    
                
    </div>
     
</body>


</html>