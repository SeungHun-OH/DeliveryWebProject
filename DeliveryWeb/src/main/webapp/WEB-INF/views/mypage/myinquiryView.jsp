<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  
  <style>
  	/*datepicer 버튼 롤오버 시 손가락 모양 표시*/
	.ui-datepicker-trigger{cursor: pointer;}
	/*datepicer input 롤오버 시 손가락 모양 표시*/
	.hasDatepicker{cursor: pointer;}
	.modal-lg{max-width: 1200px;}
	.errormsg {
		color: red;
	}
	.btnSubmit{
		background: #FFB843;
	}
	.btnSubmit:hover{
		background: #E3A538;
	}
  </style>
	
</head>

<body>

  <!-- Navigation -->
  <%@ include file="../../include/nav.jsp" %>

  <!-- Page Header -->
  <header class="masthead" style="background-image: url('${pageContext.request.contextPath}/resources/img/about-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="page-heading">
            <h1>나의 배송내역</h1>
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
      	<form:form modelAttribute="myDelivery" id="myDeliveryForm" method="post" action="${pageContext.request.contextPath}/mypage/mydelivery">
		
		<table class="table table-hover table-bordered" style="margin-top: 20px; text-align: center;">
		<thead class="thead-light">
			<tr>
				<th>문의유형</th>
				<th>제목</th>
				<th>운송장번호</th>
				<th>문의날짜</th>
				<th>문의상태</th>
			</tr>
		</thead>
		<tbody>
		<c:choose>
		<c:when test="${!empty responseList}">
		<c:forEach items="${responseList}" var="response">
			<tr style="font-size: 15px;">
				<td>${response.inquiryType}</td>
				<td>${response.title}</td>
				<td>${response.waybillNumber}</td>
				<td><fmt:formatDate value="${response.regDate}" pattern="YYYY년 M월 d일"/></td>
				<td>${response.inquiryStatus}</td>
			</tr>
		</c:forEach>
		</c:when>
		<c:when test="${empty responseList}">
			<tr id="noTr">
				<td colspan="5" style="font-size: 35px; text-align: center;">배송정보가 없습니다.</td>
			<tr>
		</c:when>
		</c:choose>
		</tbody>
		</table>
		</form:form>
      </div>
    </div>
  </div>

  <hr>
  
  <%@ include file="../../include/footer.jsp" %>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 
</body>
</html>