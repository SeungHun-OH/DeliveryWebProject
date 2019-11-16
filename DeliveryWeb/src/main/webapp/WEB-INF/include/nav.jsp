<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/">Start Bootstrap</a>
      <c:if test="${empty login}">
	  <!--  아이콘 참조     https://fontawesome.com/icons/sign-in-alt?style=solid -->
      <p style="margin: 0px 0px 0px 0px;"><a class="navbar-brand" href="${pageContext.request.contextPath}/user/login" style="font-size: 15px; text-decoration: underline;"><i class="fas fa-sign-in-alt"></i> LOGIN</a></p>
      </c:if>
      <c:if test="${not empty login}">
      <p class="navbar-brand" style="margin: 0px 0px 0px 0px; font-size: 15px;">오승훈님 반갑습니다.</p>
      </c:if>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/board/search">Search</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/board/reservation">Reservation</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/post">Sample Post</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/contact">Contact</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>