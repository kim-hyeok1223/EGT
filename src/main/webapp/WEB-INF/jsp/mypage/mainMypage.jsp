<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<div class="container">
	<h1 class="mt-5">${userName} 님의 페이지</h1>
	 
	<div class="d-flex  justify-content-center mb-5">
		<div class="my-info w-50">
			<div class="d-flex mini-box">
				<div>
					<img class="m-4" alt="아이콘" src="/static/image/icon.png" width="180px;">
				</div>
				<div class="m-4">
					<h4>이름 : ${userName}</h4>
					<h4>이메일 : ${userEmail}</h4>
					<h4>키 : ${userHeight} cm</h4>
					<h4>몸무게 : ${userWeight} kg</h4>
				</div>
			</div>
			<div class="mini-box2">
				<table class="table">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>루틴 이름</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${routineList}" var="rt" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${rt.subject}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
			</div>
		</div>

		<div class="w-50 h-100">
			<jsp:include page="../calendar/mypageCalendar.jsp" />
		</div>

	</div>
	 		
</div>