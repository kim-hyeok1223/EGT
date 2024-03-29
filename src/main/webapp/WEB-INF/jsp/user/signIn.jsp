<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<div class="shadow-box m-5">
		<div class="d-flex justify-content-center m-5">
		
			<form id="loginForm" action="/user/sign-in" method="post">
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text">email</span>
					</div>
					<input type="text" class="form-control" name="email">
				</div>
				
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text">PW</span>
					</div>
					<input type="password" class="form-control" name="password">
				</div>
				
				<input type="submit" class="btn btn-block btn-info" value="로그인">
				<a class="text-warning d-flex justify-content-center mt-3" href="/user/sign-up-view">회원가입하러가기</a>
			</form>
		</div>
	</div>
</div>

<script>
	$(document).ready(function() {
		$('#loginForm').submit(function(e) {
			e.preventDefault();
			
			var email = $('input[name=email]').val();
			if(email=='') {
				alert("이메일을 입력해주세요.");
				return;
			}
			
			var password = $('input[name=password]').val();
			if (password == '') {
				alert("비밀번호를 입력해주세요.")
				return;
			}
			
			var url = $(this).attr("action");
			var data = $(this).serialize();
			
			$.post(url,data) 
			.done(function(data){
				if(data.result=="성공"){
					location.href="/egt/io";
				} else{
					alert("로그인에 실패했습니다.")
				}
			});
			
		});
	});

</script>
