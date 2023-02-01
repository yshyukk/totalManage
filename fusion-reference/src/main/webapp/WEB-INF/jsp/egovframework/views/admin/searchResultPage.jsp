<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    
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
<link rel="stylesheet" type="text/css" href="/css/board/boardList.css?after"/>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous"></script>
</head>

<style>
.aaa {border:1px solid 1px;}
</style>
<body>
	<c:forEach var="menu" items="${menuList}">
		<c:if test="${menu.menuType == 1}">	
		${menu.menuName }							
			<div id="list_container" class="card-body">
				<table id="board_list" class="table table-hover table-striped">
					<thead>
						<tr>
							<th width="100px">글번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>조회수</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
<%-- 					<c:set var = "length" value = "${fn:length(menu.menuPath)}"/> --%>
						<c:forEach items="${boardList}" var="board">							
<%-- 							<fmt:parseNumber var = "i" type = "number" value = "${fn:substring(menu.menuPath, length-1, length)" /> --%>
							<c:if test="${menu.boardNum == board.board_num}">
							<tr>		
								<td>${board.board_num}</td>
								<td class="move_content" onclick="openDetail(${board.board_id})">
									${board.title}
								</td>
								<td class="boardId">${board.id}</td>
								<td>${board.board_cnt}</td>
								<td>${board.regist_dt}</td>										
							</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>
	</c:forEach>
   <div id="content_wrap">
   ${imgList }		
   	<c:if test="${fn:length(imgList) != 0 }">   	
         <c:forEach items="${imgList }" var="list" >
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
  	 </c:if>      
      	 
   </div>
   <c:if test="${fn:length(imgBoardList) == 0}">
		검색결과가 없습니다
  </c:if>
</body>
</html>