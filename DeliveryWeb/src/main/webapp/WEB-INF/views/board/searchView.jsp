<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Clean Blog - Start Bootstrap Theme</title>
  
  <!-- Bootstrap core CSS -->
  <%@ include file="../../include/header.jsp" %>
  
  	<style type="text/css">
	.errormsg {
		color: red;
	}
	</style>

</head>

<body>

  <!-- Navigation -->
  <%@ include file="../../include/nav.jsp" %>

  <!-- Page Header -->
  <header class="masthead" style="background-image: url('${pageContext.request.contextPath}/resources/img/tEST.jpeg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="page-heading">
            <h1>운송장 조회</h1>
            <span class="subheading">This is what I do.</span>
          </div>
        </div>
      </div>
    </div>
  </header>

  <!-- Main Content -->
  <div class="container">
  	<div class="row">
  		<div class="col-lg-12 col-md-12 mx-auto">
  		 <div class="col">
            <ul class="nav nav-tabs nav-justified" id="mytab">
              <li class="nav-item">
                <a class="nav-link active" data-toggle="tab" href="#waybill_tab">운송장 번호로 조회</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#resNum_tab">예약번호로 조회</a>
              </li>
            </ul>
            <div class="tab-content">
              <div class="tab-pane show active" id="waybill_tab">
<%-- 		        	<input class="form-control" type="text" placeholder="예: 01234567890, '-'를 제외한 숫자 11자리" maxlength="11" id="waybill" name="waybill" <c:if test="${!empty waybillNum}">value="${waybillNum}"</c:if>> --%>
				    <form:form modelAttribute="searchDto" id="searchForm" method="post" action="${pageContext.request.contextPath}/board/search">
					<div class="control-group">
						<div class="form-group controls">
		              		<form:input type="text" cssClass="form-control" placeholder="예: 01234567890, '-'를 제외한 숫자 11자리" path="waybillNum" id="waybillNum" value="${waybillNum}" maxlength="11"/>
		<!--               		<p class="help-block text-danger"></p> -->
							<small><form:errors path="waybillNum" cssClass="errormsg" /></small>
							<form:hidden path="clickPage" value="searchView"/>
							<form:hidden path="type" value="waybillNum"/>
		            	</div>
		          	</div>
		          	<button class="btn btn-primary" id="btnWaybillNumLookup" style="width: 100%;">조회</button>
		          	</form:form>
              </div>
              <div class="tab-pane" id="resNum_tab">
                <form:form modelAttribute="searchDto" id="searchForm" method="post" action="${pageContext.request.contextPath}/board/search">
					<div class="control-group">
						<div class="form-group controls">
		              		<form:input type="text" cssClass="form-control" placeholder="예: 01234567890, '-'를 제외한 숫자 12자리" path="reservationNum" id="reservationNum" maxlength="12"/>
		<!--               		<p class="help-block text-danger"></p> -->
							<small><form:errors path="reservationNum" cssClass="errormsg" /></small>
							<form:hidden path="clickPage" value="searchView"/>
							<form:hidden path="type" value="reservationNum"/>
		            	</div>
		          	</div>
		          	<button class="btn btn-primary" id="btnResNumLookup" style="width: 100%;">조회</button>
		          	</form:form>
              </div>
            </div>
            <div id="infoDiv"></div>
            <div id="stepImg"></div>
            <div id="stateDiv"></div>
        </div>
  		</div>
  	</div>
    <div class="row">
    	<h5>테이블있음</h5>
      <div class="col-lg-12 col-md-12 mx-auto">
		<c:if test="${!empty responseSearch}">
        <h5>조회결과</h5>
		<table class="table">
     	<thead class="thead-dark">
      	<tr>
      		<th>운송장 번호</th>
      		<th>보내는 분</th>
      		<th>받는 분</th>
      		<th>상품 정보</th>
      		<th>수량</th>
       	</tr>
      	</thead>
      	<tbody>
      	<tr>
       	</tr>
	    </tbody>
		</table>
		</c:if>
      </div>
    </div>
  </div>

  <hr>
  <%@ include file="../../include/footer.jsp" %>
  <script type="text/javascript">
	//wire up shown event
	$(document).ready(function() {
		if(localStorage.getItem("sw") != "true"){
			localStorage.setItem("sw", "false");
			console.log('스위치 초기화');
		}
	});
	
	$("#btnResNumLookup").click(function(e) {
		localStorage.setItem("sw", "true");
		var tab_switch = localStorage.getItem("sw");
	});
	
	if(localStorage.getItem("sw") == "true"){
	$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
	    console.log("tab shown...");
	    localStorage.setItem('activeTab', $(e.target).attr('href'));
	});
	// read hash from page load and change tab
	var activeTab = localStorage.getItem('activeTab');
	if(activeTab){
		console.log(activeTab);
	    $('.nav-tabs a[href="' + activeTab + '"]').tab('show');
	    localStorage.removeItem("sw");
	}
	}
	</script>
</body>
</html>
