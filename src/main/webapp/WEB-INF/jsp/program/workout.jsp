<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--  타이틀 시작 -->
<div class = "workout-front mb-4 d-flex justify-content-center align-items-center">
		<div>
			<h2 class="text-white mt-5"><b>운동 프로그램을 수행해 보세요!</b></h2>
			<h4 class="text-white">근성장을 더욱 빠르게, 3대 500을 찍어보고 싶나요? 이런분들을 위한 운동 프로그램을 소개합니다.</h4>
		</div>
</div>

<!--  타이틀 끝 / 프로그램 포스팅 시작-->

<div class="container">
	<c:forEach items="${exerciseList}" var="ex">
	<a href="/exercise/program/program-detail-view?postId=${ex.id}">
	<div class="program-box">
		<div class="program-box d-flex justify-content-center">
			<h3 class="text-dark mt-5"><b>${ex.subject}</b> </h3>
		</div>
	</div>
	</a>
	</c:forEach>
</div>

	