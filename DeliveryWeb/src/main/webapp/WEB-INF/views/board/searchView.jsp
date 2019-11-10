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
		        	<input class="form-control" type="text" placeholder="예: 01234567890, '-'를 제외한 숫자 11자리" maxlength="11" id="waybill" name="waybill" <c:if test="${!empty waybillNum}">value="${waybillNum}"</c:if>>
				    <form:form modelAttribute="searchDto" id="searchForm" method="post" action="/board/search">
					<div class="control-group">
						<div class="form-group controls">
		              		<form:input type="text" cssClass="form-control" placeholder="예: 01234567890, '-'를 제외한 숫자 11자리" path="waybillNum" id="waybillNum" value="${waybillNum}"/>
		<!--               		<p class="help-block text-danger"></p> -->
							<small><form:errors path="waybillNum" cssClass="errormsg" /></small>
		            	</div>
		          	</div>
		          	<button class="btn btn-primary" id="btnWaybillNumLookup" style="width: 100%;">조회</button>
		          	</form:form>

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
              <div class="tab-pane" id="resNum_tab">
                <input type="text" placeholder="예약번호 12자리 입력" id="reservation_Num" name="reservation_Num">
                <div>
                	<button id="btnResNumLookup">조회</button>
                </div>
              </div>
            </div>
            <div id="infoDiv"></div>
            <div id="stepImg"></div>
            <div id="stateDiv"></div>
        </div>
  		</div>
  	</div>
    <div class="row">
      <div class="col-lg-12 col-md-12 mx-auto">

      </div>
    </div>
  </div>

  <hr>
  <%@ include file="../../include/footer.jsp" %>
</body>
</html>
