<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
  <header class="masthead" style="background-image: url('${pageContext.request.contextPath}/resources/img/post-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-12 col-md-12 mx-auto">
          <div class="post-heading">
            <h1>공지사항</h1>
          </div>
        </div>
      </div>
    </div>
  </header>

  <!-- Post Content -->
  <article>
    <div class="container">
      <div class="row">
      	<div class="col-lg-12 col-md-12 mx-auto">
      	<form:form modelAttribute="notice" id="noticeModifyForm" method="post" action="${pageContext.request.contextPath}/board/search">
	      	<table class="table" style="text-align: center;">
				<tbody>
					<tr style="background: #FFB843; border-top: 2px solid #212529;">
						<th width="10%">
							<span style="font-size: 26px; color: #fff; width: 10%;">${notice.noticeNo}</span>
						</th>
						<th width="auto" style="vertical-align: middle; font-size: 26px;">
							<form:input cssClass="form-control" path="title" id="title" value="${notice.title}"/>
							<small><form:errors path="title" cssClass="errormsg" /></small>
						</th>
					</tr>
					<tr style="font-size: 18px;">
						<th colspan="2" style="text-align: left">
							<form:select class="form-control" path="division" id="division" style="width: auto;">
								<option value="공지사항" <c:if test="${notice.division eq '공지사항'}">selected="selected"</c:if>>공지사항</option>
								<option value="이벤트" <c:if test="${notice.division eq '이벤트'}">selected="selected"</c:if>>이벤트</option>
							</form:select>
							<small><form:errors path="division" cssClass="errormsg" /></small>
						</th>
					</tr>
					<tr>
						<td colspan="2" style="padding: 60px 30px 60px 30px;">
							<form:textarea rows="5" cssClass="form-control" path="contents" id="contents" value="${notice.contents}"></form:textarea>
							<small><form:errors path="contents" cssClass="errormsg" /></small>
						</td>
					</tr>
				</tbody>
			</table>
			<form role="form" method="post">
				<input type="hidden" name="noticeNo" value="${notice.noticeNo}">
				<input type="hidden" name="page" value="${criteria.page}">
				<input type="hidden" name="perPageNum" value="${criteria.perPageNum}">
			</form>
			<div style="text-align: right;">
				<button type="submit" class="btn" id="listBtn">목록</button>
				<button type="submit" class="btn" id="modBtn">수정</button>
				<button type="submit" class="btn" id="canBtn">취소</button>
			</div>
		</form:form>
      	</div>
      </div>
    </div>
  </article>

  <hr>
  <%@ include file="../../include/footer.jsp" %>
  
  <script>
  var formObj = $('form[role="form"]');

  $('#listBtn').on('click', function() {
	  self.location = '/notice/list?page=${criteria.page}&perPageNum=${criteria.perPageNum}';
  });
  $('#modBtn').on('click', function () {
	  formObj.submit();
  });
  $('#canBtn').on('click', function () {
	  history.go(-1);
  });
  </script>
</body>
</html>