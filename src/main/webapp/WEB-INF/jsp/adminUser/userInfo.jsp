<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="d-flex justify-content-center">
    <div class="w-50">
        <h1 class="mt-3 mb-3">유저 목록</h1>
        
        <table class="table">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>이름</th>
                    <th>이메일</th>
                    <th>가입날짜</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${userList}" var="user" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${createdAtList[status.index]}</td>  <!-- zonedatetime과 date 문제로 fmt 오류남 -->
                    <td><button type="button" id="deleteBtn" class="btn btn-danger" data-user-id="${user.id}">삭제</button></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        
        
    </div>
</div>

<script>
	$(document).ready(function() {
		$("#deleteBtn").on('click', function() {
			let userId = $(this).data("user-id");
			//alert(postId);
			
			$.ajax({
				type:"DELETE"
				, url:"/admin/userInfo/delete"
				, data:{"userId":userId}
				, success:function(data) {
					if (data.code == 200) {
						location.href = "/admin/userInfo";
					} else {
						alert(data.error_message);
					}
				}
				, error:function(request, status, error) {
					alert("유저 삭제 하는데 실패했습니다.");
				}
			});
		});
	});	
</script>	
