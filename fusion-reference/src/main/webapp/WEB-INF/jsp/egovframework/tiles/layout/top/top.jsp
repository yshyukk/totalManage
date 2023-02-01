<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
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
	crossorigin="anonymous">
</script>
<script src="https://code.jquery.com/jquery-3.6.1.js"
	integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
	crossorigin="anonymous">
</script>
</head>
<style>
	#total_search{display:flex;}
	#search-value{width:30%;}
	#logo{width: 10%}
</style>
<body>
	<div id="nav_container">
       	<div class="card card-margin search-form">
	        <div class="row no-gutters" id="total_search">
	        <img id="logo" src="/image/logo.png"/>
               <div class="col-lg-8 col-md-6 col-sm-12 p-0" style="display:flex; margin-left:300px;">
                    <label for="search-value" hidden>검색어</label>
                    <input type="text" placeholder="검색어..." class="form-control" id="search-value"
                           name="searchValue">
                	<div class="col-lg-1 col-md-3 col-sm-12 p-0" style="display:inline-block;">
                     <button type="button" class="btn btn-base" id="totalSearch">
                         <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                              viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
                              stroke-linecap="round" stroke-linejoin="round"
                              class="feather feather-search">
                             <circle cx="11" cy="11" r="8"></circle>
                             <line x1="21" y1="21" x2="16.65" y2="16.65"></line>
                         </svg>
                     </button>
                	</div>
                </div>  
             </div>
	        <div class="card-body p-0">
	            <form id="search-form">
	                <div class="row">
	                    <div class="col-12">
	                        <nav class="navbar navbar-expand-lg navbar-light bg-light">
	                            <div class="container-fluid">
		                            <a class="navbar-brand" href="#">Navbar</a>
		                            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		                                <span class="navbar-toggler-icon"></span>
		                            </button>
		                            <div class="collapse navbar-collapse" id="navbarNav">
		                                <ul class="navbar-nav">
											<c:forEach items="${menuList }" var="menuInfo">
												<li class="nav-item">
		                                    		<a class="nav-link active" id="${menuInfo.menuOrder }" aria-current="page" href="${menuInfo.menuPath}">${menuInfo.menuName }</a>		                                    		
		                                    		<input type="hidden" value="${menuInfo.accessRole }">
		                                		</li>
											</c:forEach>		                                
		                                </ul>
		                            </div>
	                            </div>		
	                             <div class="upper_right">
									<div class="upper_right">
										<div id="login_menu" class="d-grid gap-2 d-md-flex justify-content-md-end">
						                    <c:if test="${id eq null }">
							                    <a class="btn btn-primary me-md-2" role="button" id="write-article" onclick="location.href='/user/loginForm.do?'">로그인</a>
							                    <a class="btn btn-primary me-md-2" role="button" id="write-article" onclick="location.href='/user/registerPage.do'">회원가입</a>
						                    </c:if>
						                    <c:if test="${id ne null }">
						                    	<a class="btn btn-primary me-md-2" role="button" id="write-article" onclick="location.href='/user/logout.do'">로그아웃</a>
						                	</c:if>
										</div>
									</div>
								</div>
	                        </nav>
	                    </div>
	                </div>
	            </form>
	        </div>
   	  	</div>		
    </div>
</body>

<script>
	$('#totalSearch').click(function(){
		let searchText = $('#search-value').val();	
		console.log("searchText")
		location.href="/admin/totalSerach.do?searchText="+searchText;
			
		})
	
	
	
	
</script>
</html>