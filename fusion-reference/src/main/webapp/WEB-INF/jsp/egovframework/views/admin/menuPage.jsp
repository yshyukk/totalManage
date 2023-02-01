<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

</head>
<body>
	  <div class=" col-md-12 mb-3">
		  <div class="sel_container col-md-4 mb-4" style="display:inline-block">
	          <label for="menuName">게시판 이름</label>	
	          <select id="addMenu" class="form-select form-select-lg mb-2" style="height:50px;"aria-label=".form-select-lg example">
	              <option value="1" selected>게시판</option>
	              <option value="2">앨범 게시판</option>
	              <option value="0">링크 게시판</option>
	          </select>
          </div>
          
          	<div class="sel_container col-md-12 mb-4" id="boardInfo">
	          	<label for="boardName">게시판 이름</label>	
		        <input type="text" class="form-control" id="boardName" style="width:100%">
	        </div>
	        <div id="link_container" class="col-md-12 mb-4" style="display:inline-block;">
	          	<label for="link">링크</label>	
		        <input type="text" class="form-control" id="link" style="width:100%">	        
	        </div>
	        <div id="role_container" class="col-md-12" style="display:inline-block;">
	        	<label for="addRole">접근 권한</label>	
		        <select id="addRole" class="form-select form-select-lg mb-2" style="height:50px;" aria-label=".form-select-lg example">
		        	<option value="1" selected>관리자</option>
		            <option value="2">회원</option>
		            <option value="3">비회원</option>
		        </select>
	        </div>
	       
          <div id="addMenu" class="col-md-12 mb-2" style="margin-left:10px; display:inline-block;">
          	<button type="button" id="btn_addMenu" class="btn btn-outline-primary" style="height:50px">생성</button>
          </div>
      </div>
      <div class=" col-md-12 mb-3">
      		<div id="upd_container">
      			<table class="table table-borderless" style="width:1000px;">
				  <thead>
					    <tr>
					      <th scope="col">#</th>
					      <th scope="col">메뉴</th>
					      <th scope="col">접근 권한</th>
					      <th scope="col"></th>
					      <th scope="col"></th>
					    </tr>
				  </thead>
				  <tbody>
				  	 <c:forEach items="${ menuList}" var="menuInfoList">
					    <tr>
					      <td scope="row">#</td>
					      <td>${menuInfoList.menuName}</td>
					      <td>${menuInfoList.role}</td>
					      <td><button type="button" class="btn_upd btn btn-outline-primary" onclick="upd_menu(${menuInfoList.menuId})">수정</button></td>
					      <td><button type="button" class="btn_del btn btn-outline-primary" onclick="del_menu(${menuInfoList.menuId})">삭제</button></td>
					    </tr>
				    </c:forEach>
				  </tbody>
				</table>
      		</div>
      </div>
</body>

<script>
	$(document).ready(function(){
		$('#link_container').hide();
	})

	$('#addMenu').change(function(){
		 let changeMenu = $(this).val();
		 console.log(changeMenu)
		 if(changeMenu == 0){
			 $('#link_container').show();
		 }else{
			 $('#link_container').hide();
		 }
	})
	
	$('#btn_addMenu').click(function(){
		let menuType = $('#addMenu').val();
		let menuName = $('#boardName').val();
		let link = $('#link').val();
		let role = $('#addRole').val();
		let menuPath;
		
		if(menuType == 0){
			menuPath = link+'?menuId=';
		}else if(menuType ==1 ){
			menuPath = '/board/boardList.do?accessRole='+role+'&menuId=';
		}else if(menuType ==2){
			menuPath = '/imgBoard/imgBoardList.do?viewPage=1&search=&searchText=&pageFilter=10&accessRole='+role+'&menuId=';
		}		
		
		let data= {
				"menuType" : menuType
			,	"menuName" : menuName
			,   "link" : link
			,   "accessRole" : role
			,   "menuPath" : menuPath
		}
		$.ajax({
			 type  : "POST",
	      	 url   : '/admin/insMenu.do',
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
		console.log(list);
	})
	
	function upd_menu(menuId){
		window.open(
		       	'/admin/updMenuPage.do?menuId=' + menuId,
		       	'show_detail',
		       	'resizable=yes'						    		       	
			);
	}
	function del_menu(menuId){
		
		let data = {
				"menuId" : menuId
		}
		
		$.ajax({
			 type  : "POST",
	      	 url   : '/admin/delMenu.do',
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
	}
</script>
</html>