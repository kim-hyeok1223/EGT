<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div class ="h-100 header bg-warning d-flex justify-content-between">
	<!--  로고 -->
	<a href="/egt/io">
		<div class="logo d-flex align-items-center">
			<h1 class="text-white ml-3"><b>E</b>nd of the<br><b>G</b>ym for<br><b>T</b>oday</h1>
		</div>
	</a>
	<div class="d-flex align-items-center mr-5">
		<c:if test="${empty userId}">
			<a href="/user/sign-in-view" class="ml-2 text-white font-weight-bold">로그인</a>
		</c:if>
		<c:if test="${not empty userId}">
			<span><b>${userName} 님</b></span>
			<a href="/user/sign-out" class="ml-2 text-white font-weight-bold">로그아웃</a>
		</c:if>
	</div>	
</div>