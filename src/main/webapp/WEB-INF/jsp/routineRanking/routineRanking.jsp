<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--  타이틀 시작 -->
<div class = "workout-front mb-4 d-flex justify-content-center align-items-center">
		<div>
			<h2 class="text-white mt-5"><b>나만의 운동루틴을 공유해보세요!</b></h2>
			<h4 class="text-white">다른 사람과의 루틴공유를 통해 다양한 운동루틴을 경험해보세요.</h4>
		</div>
</div>

<!--  타이틀 끝 / 프로그램 포스팅 시작-->

<div class="container">
	<c:forEach items="${routineList}" var="routine">
	<a href="/exercise/program/program-detail-view?routineId=${routine.id}">
	<div class="program-box">
		<div class="program-box d-flex justify-content-center">
			<h3 class="text-dark mt-5"><b>${userName}님의 ${routine.subject}</b> </h3>
		</div>
	</div>
	</a>
	</c:forEach>
</div>

<div class="m-5 d-flex justify-content-end">
	<a href="/mypage/routineMaking">
		<button type="button" id="addProgramBtn" class="btn btn-success">루틴 추가하기</button>
	</a>
</div>	