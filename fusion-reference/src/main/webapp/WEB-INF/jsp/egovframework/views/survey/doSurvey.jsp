<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	crossorigin="anonymous"></script>
<style>
#progress {
    appearance: none;
    width : 100%;
}
#progress::-webkit-progress-bar {
    background:#f0f0f0;
    border-radius:10px;
    box-shadow: inset 3px 3px 10px #ccc;
}
#progress::-webkit-progress-value {
    border-radius:10px;
    background: #1D976C;
    background: -webkit-linear-gradient(to right, #93F9B9, #1D976C);
    background: linear-gradient(to right, #93F9B9, #1D976C);

}
</style>
</head>
<body>
	<div id="survey_wrap" style="position: relative">
		<form style="position: absolute; left: 50%; transform: translate(-50%)">
		<progress id="progress" min="0" max="100"></progress>		
			<c:set var="total" value="0" />
			<c:forEach begin="0" items="${ surveyContent}" var="content" varStatus="status">
				<fmt:parseNumber var="paging" integerOnly="true" value="${status.index /5 }" />
				<input type="hidden" value="${paging }" id="pagingClassNum">
				<div id="question_container" class="pageNum${paging} page" style="margin-top: 50px;">
					<div class="question">
						<span> 
							<c:if test="${content.queRef eq 0 }">
									<input class="queId" id="queId+${content.queOrder }"
										type="hidden" value="${content.queOrder }">
									문항 ${content.queOrder }.
							</c:if> 
							<c:if test="${content.queRef != 0 }">
								<span style="margin-left: 20px"> 문항 ${content.queOrder }-${content.childOrder }.</span>
							</c:if> 
							<c:if test="${content.queCategory ne null }">
									[${content.queCategory }]
							</c:if> 
							<input name="queRef" type="hidden" value="${content.queRef }">
						</span> 
						<span> ${content.queContent }
							<c:if test="${content.queLimitCnt > 1 }">
									(${content.queLimitCnt }개 선택)
							</c:if>
							<c:if test="${content.queLimit eq null }">
								(자율)
							</c:if>
							<c:if test="${content.queLimit eq 'Y' && content.queType == 2 }">
								(필수)
							</c:if>
						</span>
					</div>
					<c:choose>
						<c:when test="${content.queRef eq 0 }">
							<div id="select${content.queId }" class="choice_container"
								style="margin-top: 10px;">
								<c:forEach var="choice" items="${content.selectList }">
									<c:if test="${content.queType < 2}">
										<input class="selNum" type="hidden" value="${choice.selNum}">
										<input class="checkVal" type="checkbox"
											style="width: 15px; height: 15px;" data-queLimit="${content.queLimit }" data-checkVal="${choice.selContent }">
										<c:choose>
											<c:when test="${choice.selContent eq '기타'}">
												<input type="hidden" value="${choice.selNum }">
												<span>${choice.selContent }</span>
												<input class="etcVal" type="text" style="width:200px;">
											</c:when>
											<c:otherwise>
												<input type="hidden" value="${choice.selNum }">
												<span>${choice.selContent }</span>
											</c:otherwise>
										</c:choose>
									</c:if>
									<input type="hidden" value="${content.queLimit }" name="queLimit" class="queLimit">
								</c:forEach>
							
								<c:if test="${content.queType == 2 }">
									<textarea style="width: 500px" onchange="textChange()" data-textLimit="${content.queLimit }"></textarea>
									<input class="selNum" type="hidden" value="${choice.selNum}">
								</c:if>
								<input type="hidden" value="${content.queLimitCnt}"
									class="queLimitCnt">
								<input type="hidden" value="${choice.selNum }">
							</div>
							
						</c:when>
						<c:otherwise>
							<div id="select${content.queId }" class="choice_container"
								style="margin-left: 20px; margin-top: 10px;">
								<c:forEach var="choice" items="${content.selectList }">
									<c:if test="${content.queType != 2 }">
									
									<input class="selNum" type="hidden" value="${choice.selNum}">
										<input class="checkVal" type="checkbox"
											style="width: 15px; height: 15px;" data-queLimit="${content.queLimit }" data-checkVal="${choice.selContent }">
										<c:choose>
											<c:when test="${choice.selContent eq '기타'}">
												<input type="hidden" value="${choice.selNum }">
												<span>${choice.selContent }</span>
												<input class="etcVal" type="text"
													style="width: 200px">
											</c:when>
									
											<c:otherwise>
												<input type="hidden" value="${choice.selNum }">
												<span>${choice.selContent }</span>
											</c:otherwise>
										</c:choose>
									</c:if>
									<input type="hidden" value="${content.queLimit }" name="queLimit" class="queLimit">
									
								</c:forEach>
								<c:if test="${content.queType == 2}">
									<textarea style="width: 100%" onchange="textChange()" data-textLimit="${content.queLimit }"></textarea>
								</c:if>
								<input type="hidden" value="${content.queLimitCnt}"
									class="queLimitCnt">
							</div>
						</c:otherwise>
					</c:choose>
				</div>
				<c:set var="total" value="${total + content.queLimitCnt }"/>
			</c:forEach>
			<input type="hidden" id="limitCntTotal" value="${total }">
			<div class="btn_paging"
				style="margin-top: 100px; position: absolute; right: 0">
				<button type="button" id="btn_prev" class="btn btn-outline primary">이전</button>
				<button type="button" id="btn_next" class="btn btn-outline primary">다음</button>
				<button type="button" id="btn_submit"
					class="btn btn-outline primary">제출</button>
				<button type="button" id="go_list"
					class="btn btn-outline primary">돌아가기</button>	
			</div>
		</form>
	</div>
</body>

<script>
const urlParams = new URL(location.href).searchParams;
const surveyId = urlParams.get('surveyId');

 let pagingNum = 0;
 let totPageNum = Math.ceil(Number('${surveyContent.size()}') / 5);
 let totalCnt = $('#limitCntTotal').val();

	$(document).ready(function(){
		
		$('.page').hide();
		$('.pageNum0').show();
		//$('#progress').val(calcPercent);
	})
	
	$('.checkVal').click(function(){
		
		let choiceContainer = $(this).parent();
		let checkBox = choiceContainer.find('.checkVal')
		let queLimitCnt = choiceContainer.find('.queLimitCnt').val()

		//체크된 애 갯수
		let selectCnt = choiceContainer.find('.checkVal:checked').length;
		//체크한 체크박스 값 가져오기
		let checkVal = $(this).next().next().text();
		
		let noChoice = choiceContainer.find('span:contains("없음")');
		let etcChoice = choiceContainer.find('span:contains("기타")');
		if(selectCnt > queLimitCnt && queLimitCnt != 0 && checkVal != '없음'){
			checkBox.not(this).prop('checked',false)
			this.prop('checked',true)
			
			return false;	
		}
		
		if(checkVal == '없음'){
			checkBox.not(this).prop('checked',false)
			let parent = $(this).parent();
			parent.find('.etcVal').val("");
		}else if(checkVal != '없음'){
			noChoice.prev().prev().prop('checked',false)
		}
		
		if(checkVal == '기타'){
			if(etcChoice.prev().prev().is(':checked') == true){
				etcChoice.next().prop('readonly', false)
				console.log(etcChoice.next().val())
				
			}else{
				etcChoice.next().prop('readonly', true)
				etcChoice.next().val('');	
			}	
		}
		
		let queLimit = choiceContainer.find('.queLimit').val();
		let checkedStatus = choiceContainer.find('.checkVal').is(":checked");
			
		progress();
	})
		
	let checkedCnt = 0;
	let selCnt = 0;
	
	function progress(){
		 let totalCnt = $('#limitCntTotal').val();
		 let checkedBox = $('input:checkbox:checked');	 
		 let plus = 0;
		 let minus = 0;
		
		 for(let i=0; i<checkedBox.length; i++){
			 if($(checkedBox[i])[0].dataset.quelimit== 'Y' ){
				if($(checkedBox[i])[0].dataset.checkval== '없음'){
					plus++	
				}
			 }else{
				 minus--
			 }
		 }
		 let textArr = $('textarea');
		 console.log(textArr.length)
		 for(let j=0; j<textArr.length; j++){
			 if($(textArr[j])[0].dataset.textlimit == 'Y' && textArr.val() != ''){
				 plus++
			 }
		 }
		 selCnt = checkedBox.length+plus+minus;
		 let calcPercent = Math.ceil(((checkedBox.length+plus+minus)/totalCnt)*100);
		 $('#progress').val(calcPercent);	 
	}
	
	function textChange(){
		progress()
	}
	
	$('#btn_next').click(function(){
		if(pagingNum < totPageNum-1){
			pagingNum ++;
		}
		$('.page').hide();
		$('.pageNum'+ pagingNum + '').show();
	})
	
	$('#btn_prev').click(function(){
		if(pagingNum > 0){
			pagingNum--;
		}
		$('.page').hide();
		$('.pageNum'+ pagingNum + '').show();
	})
	
	 $('#go_list').click(function(){
		location.href = '/survey/introSurvey.do?surveyId=' + surveyId;
 	})
	
	$('#btn_submit').click(function(){
		var list = new Array();
		
		<c:forEach items="${surveyContent}" var="content">
			list.push({"surveyId":${content.surveyId}
					   ,"queId":${content.queId}
					   ,"childOrder":${content.childOrder}	
					   ,"queType":${content.queType}
					 });
		</c:forEach>
		
		var idList = new Array();
		
		<c:forEach items="${surveyContent}" var="content">
			idList.push({
					   "queId":${content.queId}
					  ,"queType":${content.queType}
					 });
		</c:forEach>
		
		//selectValues를 담을 배열을 만들어서 question[[매우만족,매우 불만족]] 형태로 2차원 배열만든다음 loop돌려서 위에서 만든 list에 담아서 컨트롤러로 전달
		var checkedNum = new Array();
		var etcValues = new Array();
		
		
		for(let i=0; i<idList.length; i++){
			var selectNumList = new Array();	
	
			let selContainer = $('#select'+idList[i].queId);
			let checkedBox = selContainer.find('.checkVal:checked');
			
			for(let j=0; j<checkedBox.length; j++){
				if($(checkedBox[j]).next().next().text() == '기타'){
					etcVal = selContainer.find('.etcVal').val();
					list[i].etcVal = etcVal;
				}
				selectNumList.push($(checkedBox[j]).next().val())
			}
			let textArea = selContainer.find('textarea')
			
			if(textArea.length != 0 && textArea.val()){
				let textAreaVal = textArea.val();
				list[i].textAreaVal = textAreaVal;
			}
		checkedNum.push(selectNumList)
		list[i].checkedVal = checkedNum[i];
		}
		
		//필수 체크 요소 갯수 비교하기
	
		
		if(selCnt == totalCnt ){
			$.ajax({
				  type  : "POST",
			      url   : '/survey/insSurvey.do',
			      data: JSON.stringify(list),
			      contentType : "application/json",
			      success: function(result){
			    	  if(result == "success"){
			    		  alert('등록이 완료되었습니다.')
				    	  location.href = '/survey/introSurvey.do?surveyId=' + surveyId;
			    	  }
			      },
			      error: function(xhr, status, error) {
			      	alert("erro" ,xhr, status, error);
			      }  
			})
		}else if(selCnt < totalCnt){
			alert(totalCnt - selCnt + '개의 필수 답변을 작성하지 않았습니다.')
			return false;
		}		
	})
	
	
	
</script>
</html>