<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  
  <style>
  	/*datepicer 버튼 롤오버 시 손가락 모양 표시*/
	.ui-datepicker-trigger{cursor: pointer;}
	/*datepicer input 롤오버 시 손가락 모양 표시*/
	.hasDatepicker{cursor: pointer;}
	.modal-lg{max-width: 1200px;}
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
      	<div class="control-group">
			<div class="form-group floating-label-form-group controls">
              	<form:input type="text" cssClass="form-control w-50" placeholder="시작날짜" id="startDate" path="startDate" style="float: left;"/>
              	<form:input type="text" cssClass="form-control w-50" placeholder="종료날짜" id="endDate" path="startDate" style="float: left;"/>
              	<small><form:errors path="startDate" cssClass="errormsg" /></small>
              	<small><form:errors path="endDate" cssClass="errormsg" /></small>
            </div>
		</div>
		<div class="btn-group btn-group-toggle" data-toggle="buttons">
		<label class="btn btn-light" for="mr-1">
			<input type="radio" class="radio-value" name="momentRadio" id="mr-1" value="1week"> 1주일
		</label>
		<label class="btn btn-light" for="mr-2">
			<input type="radio" class="radio-value" name="momentRadio" id="mr-2" value="1month"> 1개월
		</label>
		<label class="btn btn-light" for="mr-3">
			<input type="radio" class="radio-value" name="momentRadio" id="mr-3" value="3month"> 3개월
		</label>
		<label class="btn btn-light active" for="mr-4">
			<input type="radio" class="radio-value" name="momentRadio" id="mr-4" checked="checked" value="all"> 전체시기
		</label>
		</div>
		<button type="button" class="btn btn-info" id="lookupBtn">조회</button>
		</form:form>
	    
	    
	 	
		<table class="table" id="lookupTable">
		<tr id="tableHeader">
			<th>상품이름</th>
			<th>송장번호</th>
			<th>보내는 분</th>
			<th>배송일자</th>
			<th>배송상태</th>
		</tr>
	</table>
      </div>
    </div>
  </div>

  <hr>
  
  <!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">상세정보</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <!-- Modal body -->
        <div class="modal-body">
        <table class="table">
        	<tr id="infoTr">
        		<th>운송장번호</th>
        		<th>보내는 분</th>
        		<th>받는 분</th>
        		<th>상품 정보</th>
        		<th>수량</th>
        	</tr>
        </table>
        <table class="table">
        	<tr id="stepTr">
	       		<th>단계</th>
	       		<th>처리</th>
	       		<th>상품상태</th>
	       		<th>담당점소</th>
        	</tr>
        </table>
        </div>
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
  
  <%@ include file="../../include/footer.jsp" %>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  
	function modalShow(e) {
		var sendData = JSON.stringify({waybill_Num:e.getAttribute('id')});
		console.log(sendData);
		$('.infoSub').remove();
		$('.stepSub').remove();
		ajaxConnectionDetail(sendData);
	}
	
	$(function() {
		
       	$('label.btn.btn-light').on('change',function(){
			if($('input[name="momentRadio"]:checked').val() == '1week'){
				alert("1주일");
	             $('#startDate').datepicker('setDate', '-7D'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
	             $('#endDate').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
			}else if($('input[name="momentRadio"]:checked').val() == '1month'){
				alert("1개월");
				$('#startDate').datepicker('setDate', '-1M'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
	            $('#endDate').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
			}else if($('input[name="momentRadio"]:checked').val() == '3month'){
				alert("3개월");
				$('#startDate').datepicker('setDate', '-3M'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
	            $('#endDate').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
			}else if($('input[name="momentRadio"]:checked').val() == 'all'){
				alert("전체");
				$('#startDate').datepicker('setDate', null); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
	            $('#endDate').datepicker('setDate', null); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
			}
		});
           //input을 datepicker로 선언
           $("#startDate").datepicker({
               dateFormat: 'yy-mm-dd' //Input Display Format 변경
               ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
               ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
               ,changeYear: true //콤보박스에서 년 선택 가능
               ,changeMonth: true //콤보박스에서 월 선택 가능                
//          ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
//          ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
               ,buttonImageOnly: true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
               ,buttonText: "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
               ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
               ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
               ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
               ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
               ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
               ,minDate: "-1Y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
               ,maxDate: "-1D" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)                
           });                 
           
           $("#endDate").datepicker({
               dateFormat: 'yy-mm-dd' //Input Display Format 변경
               ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
               ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
               ,changeYear: true //콤보박스에서 년 선택 가능
               ,changeMonth: true //콤보박스에서 월 선택 가능                
//          ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
//          ,buttonImage: "http://jqueryui.com/resources/demos/datepicker2/images/calendar.gif" //버튼 이미지 경로
               ,buttonImageOnly: true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
               ,buttonText: "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
               ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
               ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
               ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
               ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
               ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
               ,minDate: "-1Y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
               ,maxDate: "today" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)                
           });
	});
           //초기값을 오늘 날짜로 설정
//      $('#datepicker').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
//      $('#datepicker2').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
           $('#lookupBtn').click(function() {
	           	var sendData = JSON.stringify({startDate:$('input[id="startDate"]').val(), endDate:$('input[id="endDate"]').val()});
	           	$.ajax({
	   				type : 'post',
	   				url : '/mypage/deliveryDetail',
	   				data : sendData,
	   				dataType : 'json',
	   				contentType:'application/json;charset=UTF-8',
	   				success : function (data) {
	   					console.log(data);
	   					varTr = '';
	   					
	   					$.each(data.result, function(key,value){
	   						if(value != null){
	   							varTr+='<td>'+value+'</td>';
	   						}
	   					});
	   					$('#infoTr').after('<tr class="infoSub">'+varTr+'</tr>');
	   					
	   					$.each(data.resultList, function(index1){
	   						var valTr2 = '';
	   						$.each(data.resultList[index1], function(key,value){
	   							if(value != '0' && value != null){
	   								valTr2+='<td>'+value+'</td>';
	   							}
	   						});
	   						$('#stepTr').after('<tr class="stepSub">'+valTr2+'</tr>');
	   					});
	   					$("#myModal").modal('show');
	   				},
	   				error : function (request,status,error) {
	   					alert('실패');
	   				}
	   			});
 			});
</script>
</body>
</html>