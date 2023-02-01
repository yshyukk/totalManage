<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
 <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
 <link rel="stylesheet" type="text/css" href="<c:url value='/css/imgBoard/insPageImgBoard.css'/>" />
</head>
<body>
	<main class="mt-5 pt-5">
	<div class="container-fluid px-4">
		<h1 class="mt-4">게시글 상세조회</h1>
		<div class="card mb-4">
			<div class="card-body">
				<form name="form_contents " id="form_contents" method="post" enctype="multipart/form-data">
				
					<div class="mb-3">
						<label for="title" class="form-label">제목</label>
						<input type="text" class="form-control" id="title" name="title" value="${boardInfo.title }" disabled>
					</div>
					<div class="mb-3">
					<c:forEach items="${imgInfo }" var="imgInfo">
						<img src="${imgInfo.imgSavePath}/${imgInfo.imgSaveName}">	
					</c:forEach>
					</div>
					<div class="mb-3">
						<label for="content" class="form-label">내용</label>
						<textarea class="form-control" id="content" name="imgBoardContent" disabled >${boardInfo.imgBoardContent }</textarea>
					</div>
					<div class="mb-3" style="display:flex">
					 <c:forEach items="${hashTag}" var="hashTag">
						 <div id="show_hashTag" class="mb-3" style="display:flex; margin-right:10px" >
					   		<a href="/imgBoard/imgBoardList.do?viewPage=1&search=tag&searchText=${hashTag.tag }&pageFilter=10" style="font-size:20px; text-decoration:none">${hashTag.tag }</a>
						 </div>
					</c:forEach>
					</div>
					<div class="mb-3">
						<label for="imgBoardRegistDt" class="form-label">등록일</label>
						<input type="text" class="form-control" id="imgBoardRegistDt" name="imgBoardRegistDt" value="${boardInfo.imgBoardRegistDt}" disabled>
					</div>
					<div class="mb-3">
						<label for="writer" class="form-label">작성자</label>
						<input type="text" class="form-control" id="writer" name="imgBoardWriter" value="${boardInfo.imgBoardWriter }" disabled>
					</div>
                	<div id="upload_container" class="form-label" >
                    <div class="mb-3" id="down_container">다운로드
                   
                 	</div>
                        <div id="btn_img">
                            <button type="button"  class="btn btn-outline-primary" id="btn_golist">목록</button>
	                            <c:if test="${id eq boardInfo.imgBoardWriter}">	
	                            	<button type="button" class="btn btn-outline-success" id="btn_update">수정</button>
                        		    <button type="button" class="btn btn-outline-danger" id="btn_delete">삭제</button>
	                        	</c:if>
                        </div>
                      </div>
                    </form>
                </div>
			</div>
		</div>
	
	</main>
	
</body>
<script type="text/javascript">
	const urlParams = new URL(location.href).searchParams;
	const imgBoardId = urlParams.get('imgBoardId');

	
	$(document).ready(function() {
        getList()
        
    });
	
	function getList(){
		   $.ajax({
               url : '/imgBoard/downCntElement.do',
               data: {
	            	   "imgBoardId": imgBoardId,
               		 },
         	   dataType : "html",
               success : function(result) {
            	  $("#down_container").empty(); 
                  $("#down_container").append(result);     
           }
       })
	} 
	
	function emptyHashTag(){
		
			
	}

	
		
	$('#btn_golist').click(function(){
		location.href = 'http://localhost:8080/imgBoard/imgBoardList.do?viewPage=1&search=&searchText=&pageFilter=10';
	})
	
	$('#btn_update').click(function(){
		const urlParams = new URL(location.href).searchParams;
		const imgBoardId = urlParams.get('imgBoardId');
		console.log(imgBoardId)
		location.href = '/imgBoard/updatePageImgBoard.do?imgBoardId=' + imgBoardId; 
	})
	
		$('#btn_delete').click(function(){
		console.log(imgBoardId);
		let del_conf = confirm('삭제하시겠습니까?')
		let data = {
			"imgBoardId" : imgBoardId
		}
		if(del_conf == false){
			return false
		}
 		$.ajax({
  	      type  : "POST",
  	      url    : '/imgBoard/delImgBoard.do',
  	      contentType : "application/x-www-form-urlencoded;charset=UTF-8",
  	      data: data,
  	      
  	      success: function(result){
  	      
  	      alert("삭제가 완료되었습니다.")
  		  location.href = 'http://localhost:8080/imgBoard/imgBoardList.do?viewPage=1&search=&searchText=&pageFilter=10';
 	    	 	
  	      },
  	      error: function(xhr, status, error) {
  	      	alert("통신실패");
  	      }  
  	 	})  
		
	})
	
    $(document).ready(function() {
    })
	
</script>
</html>