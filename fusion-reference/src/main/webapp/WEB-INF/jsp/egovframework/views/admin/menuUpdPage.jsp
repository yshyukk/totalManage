<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="/css/board/boardList.css?after" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous">
</script>
<script src="https://code.jquery.com/jquery-3.6.1.js"
	integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
	crossorigin="anonymous">
</script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
</head>
<body>
          

<div class=" col-md-12 mb-3">
		  <div class="sel_container col-md-4 mb-4" style="display:inline-block">
	         
	          <select id="addMenu" class="form-select form-select-lg mb-2" style="height:50px;"aria-label=".form-select-lg example">
	              <option value="1" <c:if test="${menuInfo.menuType == 1 }">selected</c:if>>게시판</option>
	              <option value="2" <c:if test="${menuInfo.menuType == 2 }">selected</c:if>>앨범 게시판</option>
	              <option value="0" <c:if test="${menuInfo.menuType == 0 }">selected</c:if>>링크 게시판</option>
	          </select>
          </div>
          	<div class="sel_container col-md-12 mb-4" id="boardInfo">
	          	<label for="menuName">게시판 이름</label>	
		        <input type="text" class="form-control" id="menuName" style="width:100%" value="${menuInfo.menuName }">
	        </div>
	        <c:if test="${menuInfo.menuType == 0 }">
		        <div id="link_container" class="col-md-12 mb-4" style="display:inline-block;">
		          	<label for="link">링크</label>	
			        <input type="text" class="menuPath form-control" id="link" style="width:100%" value="${menuInfo.link }">	        
		        </div>
	        </c:if>
	        <input type="hidden" id="menuPath" class="menuPath" value="${menuInfo.menuPath }">
	        <input type="hidden" id="menuType" class="menuType" value="${menuInfo.menuType }">
	        <div id="role_container" class="col-md-12" style="display:inline-block;">
	        	<label for="updRole">접근 권한</label>	
		        <select id="updRole" class="form-select form-select-lg mb-2" style="height:50px;" aria-label=".form-select-lg example">
		        	<option value="0" <c:if test="${menuInfo.accessRole == 0 }">selected</c:if>>슈퍼 관리자</option>
		        	<option value="1" <c:if test="${menuInfo.accessRole == 1 }">selected</c:if>>일반 관리자</option>
		            <option value="2"<c:if test="${menuInfo.accessRole == 2 }">selected</c:if>>회원</option>
		            <option value="3"<c:if test="${menuInfo.accessRole == 3 }">selected</c:if>>비회원</option>
		        </select>
	        </div>
	       
          <div id="updMenu" class="col-md-12 mb-1" style="margin-left:10px; display:inline-block;">
          	<button type="button" id="btn_updMenu" class="btn btn-outline-primary" style="height:50px">수정</button>
          	<input id="menuId" type="hidden" value="${menuInfo.menuId }">
          </div>
      </div>
</body>
<script>
	$('#btn_updMenu').click(function(){
		let accessRole = $('#updRole').val();
		let menuName = $('#menuName').val();
		let menuPath = $('.menuPath').val();
		let menuType = $('#menuType').val();
		let menuId = $('#menuId').val();
		let data = {
				"accessRole":accessRole,
				"menuName":menuName,
				"menuPath":menuPath,
				"menuType":menuType,
				"menuId":menuId
		}
		console.log(data);
		$.ajax({
			 type  : "POST",
	      	 url   : '/admin/updMenu.do',
		     data: JSON.stringify(data),
		     contentType : "application/json",
		     success: function(result){
		    	  if(result == "success"){
			    	  location.href = '/admin/menuPage.do?accessRole=0&menuId=6';
		    	  }
		     },
		     error: function(xhr, status, error) {
		      	alert("erro" ,xhr, status, error);
	     	}  
		})
	})
		

</script>
</html>