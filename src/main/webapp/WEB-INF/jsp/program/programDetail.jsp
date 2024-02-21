<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<div class="container">
	<div class="m-5">
		<h1>${exercise.subject}</h1>
	</div>
	<div class="m-5">
		<p style="white-space: pre-line;">${exercise.content}</p>
	</div>
	<c:if test="${not empty exercise.imagePath}">
		<div class="m-5">
			<img src="${exercise.imagePath}" alt="이미지" width="500">
		</div>
	</c:if>
</div>