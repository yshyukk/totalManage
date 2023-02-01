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
 <link rel="stylesheet" type="text/css" href="/css/survey/surveyList.css?after" />

</head>
<meta charset="UTF-8">
</head>
<body>
    <div id="list_container" class="row" style="margin-top:100px;">
        <div id="list_wrap">
            <div class="row">
                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <c:if test="${id eq  'admin'}">
                    <a class="btn btn-primary me-md-2" role="button" id="make_survey" href="/survey/makeSurvey.do">등록</a>
                </c:if>
                </div>
            </div>       
            <table class="table" id="article-table">
                <thead>
                    <tr>
                    	<th class="boardNum col-1" style="text-align:center"> 번호</th>
                        <th class="title col-5"><a>제목</a></th>
                        <th class="participant col-1"><a>대상</a></th>
                        <th class="startDt  col-2"><a>시작일</a></th>
                        <th class="endDt col-2" ><a>마감일</a></th>
                        <th class="endDt col-1"></th>
                    </tr>
                </thead>
                <tbody>
	                <c:forEach items = "${SuveyListInfo }" var="listInfo">
	                    <tr>
	                    	<td class="boardNum" style="text-align:center">${listInfo.boardNum }</td>
	                        <td class="title"><a>${listInfo.surveyTitle }</a></td>
	                        <c:if test="${listInfo.participant == 1}">
	                        	<td class="participant">회원만</td>
	                        </c:if>
	                        <c:if test="${listInfo.participant == 0}">
	                        	<td class="participant">제한없음</td>
	                        </c:if>
	                        <td class="startDt">${listInfo.startDt }</td>
	                        <td class="endDt">${listInfo.endDt }    
	                        </td>
	                        <td style="display:flex; width:200px;">
	                        	<a role="button" href="/survey/introSurvey.do?surveyId=${listInfo.surveyId }" class="btn btn-outline-primary">참여</a>
	                        	<c:if test="${id eq  'admin'}">
		                        	<a role="button" class="upd_btn btn btn-outline-primary" style="margin-left:10px">수정</a>
		                        	<input type="hidden" value="${listInfo.updLimit }" class="${listInfo.updLimit }">
		                        	<input type="hidden" value="${listInfo.surveyId }" class="${listInfo.surveyId }">
	                        	</c:if>
	                        </td>
	                    </tr>
	                </c:forEach>
                </tbody>
            </table>
         
        
            <div class="row">
                <nav id="pagination" aria-label="Page navigation">
                    <ul class="pagination justify-content-center">
                        <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">Next</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</body>
<script>
	$('.upd_btn').click(function(){
		let updLimit = $(this).next().val();
		let surveyId = $(this).next().next().val();
		
		if(updLimit > 0){
			alert('참여한 회원이 있어 수정할 수 없습니다.')
			return false;
		}
		location.href="/survey/surveyUpdPage.do?surveyId="+surveyId;

	})
</script>
</html>