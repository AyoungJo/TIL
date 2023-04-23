<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
	String contextPath = request.getContextPath();
--%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
  <style>

    #personal {
      margin-top: 5px;
      padding: 20px 0px;
    }

    #personal h1 {
      padding: 5px;
      text-align: center;
    }

    #personal form{
      display: block;
      width: 100%;
      height: 220px;
      border: 1px solid lightgrey;
      padding: 40px;
    }

    #personal .form-item{
      margin-bottom: 10px;
    }

    #personal .form-item label{
      display: inline-block;
      width: 150px;
      font-size: 18px;
    }

    #personal .form-item input{
      display: inline-block;
      width: 250px;
      font-size: 18px;
    }

	/* BE_HW_01 추가, 변경 */
    #menuWrapper{
      margin-top: 10px;
      padding: 20px;
      width: 200px;
      font-size: 18px;
    }  
    
    #menuWrapper ul {
	  list-style-type: none;
	  margin: 0;
	  padding: 0;
	}
	
    #menuWrapper li{
      color: darkgoldenrod;
      cursor: pointer;
    }   
 
 	#menuWrapper li:hover{
      color: dodgerblue;
    }
    
    #changePasswordWrapper{
    	margin-top: 10px;
    }
    
    #changePasswordWrapper button{
      margin-top: 10px;
      padding: 5px;
      float: right;
      width: 100px;
      font-size: 18px;
    } 
    
    .hide{
    	display: none;
    }
  </style>
  <title>IT's KB - 개인</title>
</head>
<body>
  <div id="container">
 
  	<jsp:include page="../navbar.jsp" flush="true"/>
  	
    <div id="banner">지금 당신의 행복! IT's KB Life!</div>
    <div id="personal">
      <h1>개인 고객</h1>
      <hr>
      	<div id="menuWrapper">
      		<ul>
      			<li class="menu" id="menuShowChangePassword">비밀번호 변경하기</li>
      		</ul>
      	</div>
	<hr>
        <div id="changePasswordWrapper" class="hide">
        <form id="passChangeForm">
          <div class="form-item">
            <label for="password">현재 비밀번호</label>
            <input type="password" id="password" name="password">
          </div>
          <div class="form-item">
            <label for="passwordNew">새 비밀번호</label>
            <input type="password" id="passwordNew" name="passwordNew">
          </div>
  
          <div class="form-item">
            <label for="passwordNew2">새 비밀번호 확인</label>
            <input type="password" id="passwordNew2" name="passwordNew2">
          </div>
          <button id="btnChangePassword" type="button">변경하기</button>
        </form>
        </div>        
    </div>
    <footer>
			<ul>
				<li>서울시 강남구 선릉역</li>
				<li>02-999-1234</li>
			</ul>
		</footer>
		
    <!-- <div id="footer">
      <ul>
        <li class="address">12345 address 1 address 2 address 3</li>
        <li class="phone">02-0000-0000</li>
      </ul>
    </div> -->
  </div>
  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/common.js"></script>
   <script type="text/javascript">
     $(function(){
    	// common.js 에 앴는 function 호출
         getBanner('${pageContext.request.contextPath}');
         
         //비밀번호 변경하기를 클릭했을때 변경폼 보이기
         $("#menuShowChangePassword").click(function(){
         	$("#changePasswordWrapper").show();
         });         
         
         //변경하기를 클릭하면  
       $("#btnChangePassword").click(function(){
    	   let state=true;
    	   $("[type='password']").each(function(index, item){
    		   if(state){
    		     if(validateCheck(item) ){
    			   state=false;
    			   return false;
    		     }  
    		   }
    	   });//eachEnd
    	   
    	 
    	   if(state){
     	       let password = $("#password").val();
               let passwordNew = $("#passwordNew").val();
               let passwordNew2 = $("#passwordNew2").val();

               console.log(password);
               console.log(passwordNew);
               console.log(passwordNew2);
           
             $.ajax({       	 
            	  
	       	   url:"${pageContext.request.contextPath}/user?job=changePassword",
       		   type:"post",
       		   dataType:"json",
       		   data: $("#passChangeForm").serialize() ,
       		   success: function(data, status, xhr){
       			console.log("login data = " + data);
       			
       			if(data.result=="success"){
       				alert("비밀번호를 변경하였습니다.");
       		    	$("#changePasswordWrapper").hide();
       			}else{
           			alert("비밀번호 변경에 실패했습니다.");  
       			}    			
       		  },
       		  error : function(jqXHR, textStatus, errorThrown){
       			alert("문제 발생 : " + jqXHR.status);
         	 }	
       	    });//ajaxEnd
    	}
           
       });//버튼 클릭End
       
     //유효성 체크 (input요소를 객체로 전달받아 값 입력 체크 없으면 커서 놓기 )
   	function validateCheck(obj){
   		if(obj.value===""){
   			alert("값을 입력해주세요.");
   			obj.focus();
   			return true;
   		}else{
             return false;
   		}
   	}
       
       
   });//readyEnd
   </script>
  

</body>
</html>
