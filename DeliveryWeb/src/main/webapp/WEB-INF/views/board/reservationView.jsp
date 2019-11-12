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

</head>

<body>

  <!-- Navigation -->
  <%@ include file="../../include/nav.jsp" %>

  <!-- Page Header -->
  <header class="masthead" style="background-image: url('${pageContext.request.contextPath}/resources/img/contact-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="page-heading">
            <h1>택배예약</h1>
            <span class="subheading">Have questions? I have answers.</span>
          </div>
        </div>
      </div>
    </div>
  </header>

  <!-- Main Content -->
  <div class="container">
    <div class="row">
    <div class="col-lg-10 col-md-12 mx-auto">
    <form name="reservationDTO" id="reservationForm" method="post" action="${pageContext.request.contextPath}/board/reservation">
      <div class="col-lg-12 col-md-12 mx-auto">
      <div class="card" style="border: none; margin-bottom: 40px; font-weight: 800;">
        <div class="card-header">
			보내는 분
        </div>
        <div class="control-group">
			<div class="form-group floating-label-form-group controls">
              	<label>이름</label>
              	<input type="text" class="form-control" placeholder="이름" id="senderName">
            </div>
		</div>
		<div class="control-group">
			<div class="form-group floating-label-form-group controls">
			<label>전화번호</label>
			<input type="text" class="form-control" placeholder="전화번호" name="senderPhone">
            </div>
		</div>
		<div class="control-group">
			<div class="form-group floating-label-form-group controls">
				<label>주소</label>
					<div class="input-group" style="margin-bottom: 5px; width: 60%;">
					<input type="text" class="form-control" placeholder="우편번호" readonly="readonly">
					<span class="input-group-btn">
						<button class="btn btn-warning" type="button" style="padding: 11px 25px;">우편번호 찾기</button>
		      		</span>
				</div>
			<input type="text" class="form-control" placeholder="주소" name="senderPhone" readonly="readonly" style="margin-bottom: 5px;">
			<input type="text" class="form-control" placeholder="상세주소" name="senderPhone">
            </div>
		</div>
	  </div>
	  </div>
	  
	  <div class="col-lg-12 col-md-12 mx-auto">
      <div class="card" style="border: none; margin-bottom: 40px; font-weight: 800;">
        <div class="card-header">
			받는 분
        </div>
        <div class="control-group">
			<div class="form-group floating-label-form-group controls">
              	<label>이름</label>
              	<input type="text" class="form-control" placeholder="이름" id="senderName">
            </div>
		</div>
		<div class="control-group">
			<div class="form-group floating-label-form-group controls">
			<label>전화번호</label>
			<input type="text" class="form-control" placeholder="전화번호" name="senderPhone">
            </div>
		</div>
		<div class="control-group">
			<div class="form-group floating-label-form-group controls">
				<label>주소</label>
				<div class="input-group" style="margin-bottom: 5px; width: 60%;">
					<input type="text" class="form-control" placeholder="우편번호" readonly="readonly">
					<span class="input-group-btn">
						<button class="btn btn-warning" type="button" style="padding: 11px 25px;">우편번호 찾기</button>
		      		</span>
				</div>
			<input type="text" class="form-control" placeholder="주소" name="senderPhone" readonly="readonly" style="margin-bottom: 5px;">
			<input type="text" class="form-control" placeholder="상세주소" name="senderPhone">
            </div>
		</div>
	  </div>
	  </div>
	  
	  <div class="col-lg-12 col-md-12 mx-auto">
      <div class="card" style="border: none; font-weight: 800; margin-bottom: 40px;">
        <div class="card-header">
			 상품정보
        </div>
        <div class="control-group">
			<div class="form-group floating-label-form-group controls">
			    <label for="exampleFormControlSelect1">택배회사</label>
			    <select class="form-control" id="exampleFormControlSelect1" style="width: 50%;">
					<option selected="selected" value="0">택배회사 선택</option>
					<option value="1">CJ대한통운</option>
					<option value="2">로젠택배</option>
					<option value="3">우체국</option>
			    </select>
            </div>
		</div>
		<div class="control-group">
			<div class="form-group floating-label-form-group controls">
			    <label for="exampleFormControlSelect2">방문날짜</label>
			    <select class="form-control" id="exampleFormControlSelect2" style="width: 50%;">
					<option selected="selected" value="0">방문날짜 선택</option>
					<option value="1">날짜1</option>
			    </select>
            </div>
		</div>
		<div class="control-group">
			<div class="form-group floating-label-form-group controls">
			    <label for="exampleFormControlSelect3">운임방식</label>
			    <select class="form-control" id="exampleFormControlSelect2" style="width: 50%;">
					<option selected="selected" value="0">운임 선택</option>
					<option value="1">선불</option>
					<option value="2">후불</option>
			    </select>
            </div>
		</div>
        <div class="control-group">
			<div class="form-group floating-label-form-group controls">
              	<label>상품명</label>
              	<input type="text" class="form-control" placeholder="상품명" id="senderName">
            </div>
		</div>
		<div class="control-group">
			<div class="form-group floating-label-form-group controls">
			<label>상품가격</label>
			<input type="text" class="form-control" placeholder="상품가격" name="senderPhone">
            </div>
		</div>
		<div class="control-group">
			<div class="form-group floating-label-form-group controls">
			    <label for="exampleFormControlSelect4">상품부피</label>
			    <select class="form-control" id="exampleFormControlSelect4" style="width: 50%;">
					<option selected="selected" value="0">상품부피 선택</option>
					<option value="1">극소</option>
					<option value="2">소</option>
					<option value="3">중</option>
					<option value="4">대</option>
			    </select>
            </div>
		</div>
		<div class="control-group">
			<div class="form-group floating-label-form-group controls">
				<label>예상운임</label>
				<div class="input-group" style="margin-bottom: 5px; width: 60%;">
					<input type="text" class="form-control col-sm-6" placeholder="예상운임" readonly="readonly">
					<span class="input-group-btn">
						<button class="btn btn-warning" type="button" style="padding: 11px 25px;">예상운임 계산</button>
		      		</span>
				</div>
            </div>
		</div>
	  </div>
	  <button class="btn btn-primary w-100" style="font-size: 20px;" type="button">택배예약</button>
	  </div>
	  
	</form>
	</div>
    </div>
  </div>

  <hr>
  <%@ include file="../../include/footer.jsp" %>
  <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
  </script>
</body>
</html>