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
 <link rel="stylesheet" type="text/css" href="/css/imgBoard/imgBoardList.css?after" />

</head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<ul style="list-style:none">
        <c:forEach items="${imgInfo}" var="imgInfo">
             <li style="font-size:20px; margin-bottom:10px; display:flex; display:inline-block">
				<img src="${imgInfo.imgSavePath}/${imgInfo.imgSaveName}">
				<div style="display:flex; flex-direction:column;">
					<a href="${imgInfo.imgSavePath}/${imgInfo.imgSaveName}" class="btn_downImg" style="text-decoration:none; font-size:15px; margin-top:10px;">${imgInfo.imgSaveName}</a>
					<input class="saveName" type="hidden" value="${imgInfo.imgSaveName }">
				
				<%-- <span class="cnt_download">다운로드수</span> --%>
				<div class="cnt_contaienr">
					<span>다운로드 수 :</span>
					<c:forEach items="${downLogInfo }" var="downLogInfo">
				
						<c:if test="${downLogInfo.imgSaveName == imgInfo.imgSaveName }">
						 ${downLogInfo.downCnt } 
								
						</c:if>
					</c:forEach>
				</div>
				</div>
              </li>
         </c:forEach>	
     </ul>
	
</body>

<script>
//다운로드 카운트
	// 다운로드 카운트
	$('.btn_downImg').click(function(){
		let imgSaveName = $(this).next().val();
		
		//이미지 save배열로 넘겨주기
		   $.ajax({
			   type:"POST",
               url : '/imgBoard/logCount.do',
               data: {
	            	   "imgBoardId": imgBoardId,
	            	   "imgSaveName" : imgSaveName
               		 },
         	   dataType : "html",
               success : function(result) {
            	   if(result = "success"){
            		   location.href="/imgBoard/detailPage.do?imgBoardId=" + imgBoardId	   
            	   }
    			   
           }
       })
	})

</script>
</html>