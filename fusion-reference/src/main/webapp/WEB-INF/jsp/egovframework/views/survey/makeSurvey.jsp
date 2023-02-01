<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/insSurvey.css">
    <script src="https://code.jquery.com/jquery-3.6.1.js"
	integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
	crossorigin="anonymous"></script>
	 <link rel="stylesheet" type="text/css" href="/css/survey/makeSurvey.css?after" />
	
    <title>Document</title>
</head>
<body>
<div id="survey_container" class="container">
        <div class="input-form-backgroud row">
            <div class="input-form col-md-12 mx-auto">
                <h4 class="mb-3">설문지 작성</h4>
                <form class="validation-form" id="survey_frm">
                    <div class="survey_info col-md-12 mb-3">
                        
                        <div class="survey_info_container form-control" id="survey_info_container">
                            <div id="survey_title col-md-12 mb-3">
                                <label for="surveyTitle">설문지 제목</label>
                                <input type="text" class="form-control" name="surveyTitle">
                            </div>
                            <div class="join_limit col-md-12 mb-3"  style="margin-top: 10px;">
                                <div class=" col-md-3 mb-3">
                                    <label for="choice_joinLimit">참여대상</label>
                                    <select class="choice_joinLimit form-select form-select-lg mb-2" aria-label=".form-select-lg example">
                                        <option value="0" selected>제한 없음</option>
                                        <option value="1">회원만</option>
                                    </select>
                                </div>
                                <div class="col-md-2 mb-2" style="margin-left:10px;">
                                    <label for="participantCnt">1인당 참여횟수</label>
                                    <input type="number" min="1" class="form-control" name="participantCnt" placeholder="" value="">
                                </div>
                            </div>
                            
                            <div class="date_container">
                                <div class="mb-3">
                                    <label for="winDate">당첨일</label>
                                    <input name="winDate" class="form-control" type="date">
                                </div>
                                <div class="mb-3" style="margin-left: 20px;">
                                    <label for="startDate">시작일</label>
                                    <input name="startDate" type="date" class="form-control">
                                </div>
                                <div class="mb-3" style="margin-left: 20px;">
                                    <label for="endDate">종료일</label>
                                    <input name="endDate" type="date" class="form-control">
                                </div>            
                            </div> 
                        </div>
                    </div>       
                    <br/>
                    <div class="content_container form-control" id="content_container">
                        <div class="survey_content0">
                            <div class="row">
                                <div class="que_container col-md-3 mb-3">
                                    <label for="queLimit">필수질문인지 여부</label>
                                    <select class="queLimit form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                                        <option value="Y" selected>필수</option>
                                        <option value="">자율</option>
                                    </select>
                                </div>
                                <div class="col-md-3 mb-3">
                                    <label for="que_type">질문유형</label>
                                    <select class="queCategory form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                                        <c:forEach items="${categoryList }" var="categoryInfo">
                                        		<option value="${categoryInfo.categoryId }">${categoryInfo.queCategory }</option>
                                        	<c:if test="${categoryInfo.queCategory eq null} ">
                                        		<option value="${categoryInfo.categoryId }" selected>선택안함</option>
                                        	</c:if>
                                        </c:forEach>
                                       <%-- <option value="selfInput">직접입력</option> --%> 
                                    </select>
                                </div>
                                <%-- <div class="queType_container col-md-3 mb-3">
                                    <label for="addCategory">유형추가</label>
                                    <input type="text" class="form-control" name="addCategory" placeholder="" value="">
                                </div>--%>
                                <div class="col-md-12 mb-3">
                                    <label for="queContent">질문</label>
                                    <input type="text" class="form-control" name="queContent" placeholder="" value="">
                                </div>
                            </div>
                            <div class="select_container">
                                <div class="row">
                                    <div class="col-md-3 mb-3">
                                        <label for="selType">선택지 유형</label>
                                        <select class="selType form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                                            <option value="0" selected>만족도</option>
                                            <option value="1">체크박스</option>
                                            <option value="2">텍스트</option>
                                        </select>
                                    </div>
                                    <div class="limitCnt_container col-md-3 mb-3">
                                        <label for="queLimitCnt">필수 선택 갯수</label>
                                        <input type="number" min="0" class="queLimitCnt form-control" id="que_select" placeholder="" value="">
                                    </div>
                                    <div class="selContent_container col-md-3 mb-3">
                                        <label for="selContent">선택지 입력</label>
                                        <input type="text" class="selContent form-control" id="selContent" placeholder="" value="">
                                    </div>
                                    <div class="col-md-3 mb-3">
                                    		<button type="button" class="selContent_submit btn btn-outline-primary" style="margin-top:25px; display:none">선택지 등록</button>
                                  	</div>
                                </div>
                                <div class="showSelList mb-3" style="border:1px solid lightgray">
                                </div>
                            </div>
                            <div class="button_container">
                                <button type="button" class="btn btn-outline-primary" id="add_question">추가</button>
                                <button type="button" class="btn btn-outline-primary" id="del_question">삭제</button>
                            </div>
                        </div>
                    </div>
                </form>
                <button type="button" id="btn_submit" class="btn btn-outline-primary">설문지 등록</button>
            </div>    
        </div>
    </div>
</body>
<script>
let count =0;

$(document).ready(function(){
    $('.queCategory').change(function(){
         let parent = $(this).parent().parent();
         let target = parent.find('.queType_container');
         let selectOpt = $(this).val();
         if(selectOpt != "selfInput"){
             target.hide();
         }else{
             target.show();
         }
    })
    
     $('.selType').change(function(){
        let parent = $(this).parent().parent();
        let target = parent.find('.selContent_container');
        let target2 = parent.find('.selContent_submit')
        let selContent = $(this).val();
        if(selContent == 1){
        	target.show();
        	target2.show();
        }else{
        	target.hide();
        	target2.hide();
        }
      
        let queLimitVal = parent.parent().parent().find('.queLimit').val();
        let queLimitCnt = parent.find('.queLimitCnt').val();
        if(selContent == 2 && queLimitVal == 'Y'){
    	//parent.find('.limitCnt_container').hide();
        	parent.find('.queLimitCnt').val(0);
        	//parent.find('.queLimitCnt').prop('readonly',true);
        }
        console.log(queLimitCnt)
        
        
    })
    
    $('.queLimit').change(function(){
    	
    	let targetParent = $(this).parent().parent().next();
    	let target = targetParent.find('.limitCnt_container')
    	let queLimitVal = $(this).val();
    	console.log(targetParent);
    	if(queLimitVal != 'Y'){
    		target.hide();
    	}else{
    		target.show();
        }
    })
 })
 

$('#add_question').on("click", function(){

	count++;
	
	let contentContainer = $('#content_container');
    let surveyContent = $('#content_container').children().eq(0);
    let tagClone = surveyContent.clone(true)
    
    tagClone.attr('class','survey_content'+count);
    
    let selContentBtn = tagClone.find('.selContent_submit');
    //selContentBtn.attr('class','selContent_submit'+count +' btn btn-outline-primary');
   
    tagClone.find('input').val('');
	tagClone.find('.showSelList').empty();
	let selType = tagClone.find('.selType');
	
	let selContainer = tagClone.find('.selContent_container')
	selContainer.hide();
	
	let selContentSubmit = tagClone.find('.selContent_submit')
	selContentSubmit.hide();
	
	selType.val(0);
	
	let queLimit = tagClone.find('.queLimit')
	let limitCntContainer = tagClone.find('.limitCnt_container')
	
	queLimit.val('Y');
	limitCntContainer.show();

	contentContainer.append(tagClone);
    
   
})

$('#del_question').on("click",function(){
	
    let removeTarget = $(this).parent().parent();
    console.log(removeTarget);
    if(removeTarget.parent().children().length > 1){
        removeTarget.remove();
    }
})
 $('.selContent_submit').click(function(){
	 
	 let parent = $(this).parent().parent().parent();
	 let selList = parent.find('.showSelList');
	
	 let inputVal = parent.find('.selContent').val();
	 
	 let div = $('<div class="span_conatainer"><span class="span_inputVal">'+inputVal+'</span><button type="button" class="delInputVal">X</button></div>')
	          	 
	 selList.append(div);
	 $('.delInputVal').css({"border":"none", "background-color":"transparent"})
	 $('.span_inputVal').css({"font-size":"20px", "margin-left":"20px"})
	 $('.span_conatainer').css({"display":"inline-block"})

	 parent.find('.selContent').val('');
	 
 })

$(document).on("click",".delInputVal", function(){
	$(this).parent().remove();
}) 
 
$('#btn_submit').click(function(){

	var list = new Array();
	// 설문지 정보 등록
	let title = $('input[name="surveyTitle"]').val();
	let participant = $('.choice_joinLimit').val();
	let participantCnt = $('input[name="participantCnt"]').val();
	let winDate = $('input[name="winDate"]').val();
	let startDate = $('input[name="startDate"]').val();
	let endDate = $('input[name="endDate"]').val();

	list.push({
			"title" : title
		,	"participant":participant
		,	"participantCnt":participantCnt
		,	"winDate":winDate
		,   "startDate":startDate
		,   "endDate":endDate
	}) 
	
	//문제 + 선택지 정보 담기
	for(let i=0; i<count+1; i++){
		var queArr = new Array();
		let surveyContent = $('.survey_content'+i);
		if (surveyContent.length != 0){
			let queLimit = surveyContent.find('.queLimit').val();
			
			let queCategory=surveyContent.find('.queCategory').val();
			/*if(queCategory == 'selfInput'){
				queCategory = surveyContent.find('input[name="addCategory"]').val();
			}*/
			let addCategory = surveyContent.find('input[name="addCategory"]').val();
			let queContent = surveyContent.find('input[name="queContent"]').val();
			let selType = surveyContent.find('.selType').val();
			let queLimitCnt = surveyContent.find('.queLimitCnt').val();
			//showSelList에 선택지로 입력한 값들 array로 받아서 list에 queArr에 push
			let showSelList = surveyContent.find('.showSelList');
			let selContent =  showSelList.find('span');
			let selContentArr = [];
			if(queContent == null || queContent == ''){
				alert('질문을 입력해주세요')
				return false;
			}
			if(queContent == null || queContent == ''){
				alert('질문은 최대 500자까지 입력가능합니다.')
				return false;
			}
			
			for(let i=0; i<selContent.length; i++){
				selContentArr.push($(selContent[i]).text())
			}
			list.push({
					"queLimit":queLimit
				,	"queCategory":queCategory
				,	"addCategory":addCategory
				,	"queContent":queContent
				,	"selType":selType
				,	"queLimitCnt":queLimitCnt
				,	"selContentArr":selContentArr	
			})
		}
		console.log(list)
	}
	
	//유효성
	if(title == null || title == ''){
		alert('설문지 제목은 필수 입력 사항입니다.')
		return false
	}
	if(title.length > 50){
		alert('제목은 최대 50자까지 입력할 수 있습니다.');
		return false
	}
	if(participantCnt == null || participantCnt == ''){
		alert('1인당 참여횟수는 필수 입력 사항입니다.')
		return false
	}
	
	if(winDate == null || winDate == ''){
		alert('당첨일을 입력해주세요.')
		return false
	}
	if(startDate == null || startDate == ''){
		alert('시작일을 입력해주세요.')
		return false
	}
	if(endDate == null || endDate == ''){
		alert('종료일을 입력해주세요.')
		return false
	}
	if(startDate > endDate){
		alert('시작일이 종료일보다 빠릅니다.')
		return false
	}
	if(winDate < startDate){
		alert('당첨일이 시작일보다 빠릅니다.')
		return false
	}
	if(winDate < endDate){
		alert('당첨일이 종료일 보다 빠릅니다.')
		return false
	}

	$.ajax({
		  type  : "POST",
	      url   : '/survey/registSurvey.do',
	      data: JSON.stringify(list),
	      contentType : "application/json",
	      success: function(result){
	    	  if(result == "success"){
		    	  location.href = '/survey/surveyList.do';
	    	  }
	      },
	      error: function(xhr, status, error) {
	      	alert("erro" ,xhr, status, error);
	      }  
	})
	
	
})




</script>
</html>