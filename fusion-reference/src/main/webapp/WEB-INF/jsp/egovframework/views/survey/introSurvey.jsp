<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="/css/survey/introSurvey.css?after" />
    
    <title>Document</title>
<title>Insert title here</title>
</head>
<body>
	 <div id="survey_container" class="container">
      <div class="input-form-backgroud row">
        <div class="form-control">
            <div id="intro">
                퓨전소프트 회원분들을 대상으로 만족도 조사를 진행합니다.<br/>
                응답하신 내용은 통계법 제 33조(비밀의 보호)에 의거 비밀이 보장 되며,
                서비스 개선을 위한 자료 외에 어떠한 목적으로도 사용되지 않음을 약속드립니다.
                많은 참여 부탁드리며, 앞으로도 교육정책 및 교육과정 정보를 보다 빠르게 활용하실 수 있도록 더욱 노력하겠습니다.    
            </div>
	            <div id="detail_info">
	                <ul id="detail_list">
	                    <li>조사주관 : 퓨전소프트</li>
	                    <li>참여대상 : 
	                    	<c:if test="${introInfo.participant == 1}">
	                        	회원만
	                        </c:if>
	                        <c:if test="${introInfo.participant == 0}">
	                        	제한없음
	                        </c:if>
	                        <input id="participant" type="hidden" value="${introInfo.participant }">
	                    	<input id="userId" type="hidden" value="${id }">
	                    </li>
	                    <li>참여기간 : ${introInfo.startPeriod } ~ ${introInfo.endPeriod }, 총 ${introInfo.surveyPeriod}일
	                    	<input type="hidden" value="${introInfo.endDt }" id="endDate">
	                    	<input type="hidden" value="${introInfo.startDt }" id="startDate">
	                    	
	                    </li>
	                    <li>
	                        <div class="text1">참여방법 </div> 
	                        <div class="text2">하단의 설문시작 버튼을 클릭하여 총 동적개의 문항에 답변을 마치면 응모 완료</div>
	                    </li>
	                    <li>당첨자 발표 : ${introInfo.winDt }, 퓨전소프트 공지사항 게시판</li>
	                </ul>
	            </div>
	            <div id="alert_info">
	              <p id="alert_info_title">※ 유의사항<br/>
	              <p id="alert_info_text">- 당첨자 선정은 응답 내용의 성실성 등을 고려하여 선정됩니다.<br/>
	                                      - 1인 ${introInfo.participantCnt }회에 한하여 참여 가능합니다.
	            </div>
        </div>
      </div>
      
       <div id="list_container" class="row">
	       <div id="list_wrap">
	            <table class="table" id="article-table">
	                <thead>
	                    <tr>
	                    	<th class="boardNum col-1" style="text-align:center"> 회차</th>
	                        <th class="title col-5"><a>제목</a></th>
	                        <th class="joinDt  col-2"><a>참여일</a></th>
	                        <th class="endDt col-1"></th>
	                    </tr>
	                </thead>
	                <tbody>
		                <c:forEach items = "${myList }" var="myListInfo">
		                    <tr>
		                    	<td class="boardNum" style="text-align:center">${myListInfo.boardNum }</td>
		                        <td class="title">${myListInfo.surveyTitle }</td>
		                        <td class="joinDt">${myListInfo.registDt }</td>
		                        <td>
	                				<button type="button" id="go_upd" class="btn btn-outline-primary" onclick="location.href ='/survey/updPage.do?surveyId=${myListInfo.surveyId}&surveyLogId=${myListInfo.surveyLogId}'">수정</button>
	                				<input type="hidden" class="myListCnt" value=${myListInfo.myListCount }>
	                				<input type="hidden" class="participantCnt" value=${myListInfo.participantCnt }>
		                        </td>
		                    </tr>
		                </c:forEach>
	                </tbody>
	            </table>
	            
	            <div class="row">
	            	<div id="btn_container" class="d-grid gap-2 d-md-flex justify-content-md-end">
	                	<a role="button" id="go_list" class="btn btn-outline-primary">목록</a>               			
	             		<c:choose>
	             			<c:when test="${id eq null && surveyResCnt != 0 }">
	             			</c:when>
	             			<c:otherwise>
	             				<a class="btn btn-outline-primary" role="button" id="write-article">등록</a>
	             			</c:otherwise>
	             		</c:choose>
               		</div>
            	</div> 
        	</div>
    	</div>
    </div>
</body>
 <script>
	const urlParams = new URL(location.href).searchParams;
	const surveyId = urlParams.get('surveyId');
	
	$(document).ready(function(){
		let myListCnt = $('.myListCnt').val();
		let participantCnt = $('.participantCnt').val();
		
		console.log(myListCnt);
		console.log(participantCnt)
		
		if(myListCnt >= participantCnt){
			$('#write-article').css("display","none")
		}
	
	})
 
 	$('#go_list').click(function(){
		location.href = '/survey/surveyList.do';
 	})
 	
 	$('#write-article').click(function(){
 		var today = new Date();

 		var year = today.getFullYear();
 		var month = ('0' + (today.getMonth() + 1)).slice(-2);
 		var day = ('0' + today.getDate()).slice(-2);

 		var dateString = year + '-' + month  + '-' + day;
	 	
 		console.log(dateString)
		
 		let endDate = $('#detail_list').find('#endDate').val();
 		let startDate = $('#detail_list').find('#startDate').val();
 		
 		
 		if(endDate < dateString){
 			alert('이미 종료된 설문조사입니다.')
				return false;
 		}
 		if(startDate > dateString){
 			alert('아직 시작하지 않은 설문조사입니다.')
				return false;

 		}
 		
 		let participant = $('#participant').val()
 		let userId = $('#userId').val();
 		if(participant == 1){
 			if(userId == null || userId == ''){
 				alert('회원만 참여할 수 있습니다.')
 				return false;
 			}
 		}
 		
 		
 		
		location.href = '/survey/doSurvey.do?surveyId=' + surveyId;

 	
 	})

 
 </script>


</html>