<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
 <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
 <link rel="stylesheet" type="text/css" href="/css/imgBoard/imgBoardList.css?after">

</head>
<body>
<div id="content_wrap">
   <c:if test="${fn:length(imgBoardList) != 0 }">	
         <c:forEach items="${imgBoardList }" var="list" >
            <div class="content_container" >
            
                <div class="content_img">
                	<!-- ${list} -->
             		<a href="/imgBoard/detailPage.do?imgBoardId=${list.imgBoardId}">
                  		<img src="${list.thumbNailName}">
             		</a>			
                </div>
            		<div id="like_container2" style="border-bottom: 1px solid lightgray">
			            <input type="hidden" value="${list.liked }" name="ynVal">
		                <input type="hidden" value="${list.imgBoardId }">
		                <button  name="like_btn" type="button" style="width:50px; height:50px; border:none; background-color:transparent">
              				<c:choose>
	                		<c:when test="${list.liked  == 'Y'}">
	                		   <img src="/image/like.png" style="width:35px; height:35px;background-color:transparent;">
	                		   <span>${list.likeCnt }</span>
	                  		</c:when>
	                  		<c:otherwise>
	                  			<img src="/image/heart.png" style="width:30px; height:30px;background-color:transparent;">	
	                  			<span>${list.likeCnt }</span>
	                  		</c:otherwise>
	                	</c:choose>
		                </button>
	            	</div>
 	
                <div class="title">
                    ${list.title }
                </div>  
               <c:forEach items="${hashTagList}" var="hashTagList">
              		<c:if test="${list.imgBoardId == hashTagList.imgBoardId}">
                		 <a class="move_hashTag" href="/imgBoard/imgBoardList.do?viewPage=1&search=tag&searchText=${hashTagList.tag }&pageFilter=10"><span class="span_tagVal">${hashTagList.tag }</span></a>
                	</c:if>
               </c:forEach>
            </div>
      	 </c:forEach>
         <div id="paging_container">
         	현재 ${param.viewPage }페이지입니다.
             
  			<nav aria-label="...">
				<ul class="pagination pagination-lg" >	
					<c:if test="${(param.viewPage != 1)}">
						<li class="page-item">
							<a class="page-link"
			   	   			   href="../imgBoard/imgBoardList.do?viewPage=${(param.viewPage-1) }&search=${(param.search)}&searchText=${(param.searchText)}&pageFilter=${(pagingInfo.pageFilter)}">Previous</a>
						</li>
					</c:if>
					<c:forEach var="i" begin="1" end="${pagingInfo.totalPage }">
						<li class="page-item"><a class="page-link"
							href="/imgBoard/imgBoardList.do?viewPage=${i }&search=${(param.search)}&searchText=${(param.searchText)}&pageFilter=${(pagingInfo.pageFilter)}">${i }</a>
						</li>
					</c:forEach>
					<c:if test="${(param.viewPage != pagingInfo.totalPage) }">
						<li class="page-item"><a class="page-link" 
							href="/imgBoard/imgBoardList.do?viewPage=${(param.viewPage+1) }&search=${(param.search)}&searchText=${(param.searchText)}&pageFilter=${(pagingInfo.pageFilter)}">Next</a>
						</li>
					</c:if>
				</ul>
			</nav>
         </div>   
     </c:if>
     </div>
     <div id="rank_container">
		   		<div class="rank_div">
		   			<nav class="navbar navbar-expand-lg navbar-light bg-light">
					  <div class="container-fluid">				
					    <div class="collapse navbar-collapse" id="navbarNav">
					      <ul class="navbar-nav">
					        <li class="nav-item" style="font-weight:bolder">
					          <a class="nav-link active" aria-current="page" href="#" >순위보기</a>
					        </li>
					        <li class="nav-item">
					          <a id="rank_like" class="nav-link" href="#">좋아요</a>
					        </li>  
					        <li class="nav-item">
					          <a id="rank_down" class="nav-link" href="#" style="font-weight:bolder">다운로드</a>
					        </li>
					          
					      </ul>
					    </div>
					  </div>
					</nav>
		   			
		   			<table id="like_table" class="table" >
			   			<tr style="text-align:center">
			   				<th scope="col" style="width:100px;">순위</th>
			   				<th scope="col" style="width:100px;">다운수</th>
			   				<th scope="col" id="th_board" style="width:350px">게시글</th>
			   			</tr>
			   			<c:forEach items="${likeRank }" var="likeRank">
				   			<tr class="like_tr table-primary">
				   				<td scope="row" class="table-light" style="text-align:center">${likeRank.ranking }</td>
				   				<td class="table-light" style="text-align:center">${likeRank.likeCnt }</td>
				   				<td class="table-light" style="text-align:center">
				   					<a class="move_likeBoard" href="/imgBoard/detailPage.do?imgBoardId=${likeRank.imgBoardId}">
				   						${likeRank.title }
				   					</a>
				   				</td>
				   				<%-- <td class="table-primary">${likeRank.imgBoardId }</td>--%>
				   			</tr>
		   				</c:forEach>
		   			</table>
		   			<table id="down_table" class="table" style="display:none">
			   			<tr style="text-align:center">
			   				<th scope="col">순위</th>
			   				<th scope="col">다운수</th>
			   				<th scope="col">파일</th>
			   			</tr>
			   			<c:forEach items="${downRank }" var="downRank">
				   			<tr class="down_tr table-primary">
				   				<td scope="row" class="table-light" style="text-align:center">${downRank.ranking }</td>
				   				<td class="table-light" style="text-align:center">${downRank.downCnt }</td>
				   				<td class="table-light" >
				   					<a class="move_fileBoard" href="/imgBoard/detailPage.do?imgBoardId=${downRank.imgBoardId}">
				   						${downRank.imgSaveName }
				   					</a>
				   				</td>
				   			</tr>
			   			</c:forEach>
		   			</table>
		   		</div>
		   	</div>
   	<c:if test="${fn:length(imgBoardList) == 0}">
			검색결과가 없습니다
   	</c:if>
   		<!-- On tables -->
	   
</body>
<script>
	
	$(document).ready(function() {
		
	});
	$('#rank_down').click(function(){
		$('#down_table').css('display','block')
		$('#like_table').css('display','none')
	
	})
	$('#rank_like').click(function(){
		$('#down_table').css('display','none')
		$('#like_table').css('display','block')
	})
	
	
	/*$('.btn_write').click(function(){
		window.open(
	       	'/imgBoard/insPageImgBoard.do',
	       	'opneIns',
	       	'resizable=yes'						    		       	
		)
	})*/
	
</script>
</html>