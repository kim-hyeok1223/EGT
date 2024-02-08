<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center ml-5">
	<div class="sign-up-box">
		<div class="d-flex justify-content-center ">
			<h1 class="m-4 font-weight-bold">회원가입</h1>
		</div>	
		<form id="signUpForm" method="post" action="/user/sign-up">
			<div class="d-flex justify-content-center">
				<div class="w-100 ml-5">
					<span class="sign-up-word">email</span>
					<div class="d-flex ml-3 mt-3">
						<input type="text" id="email" name="email" class="form-control col-6" placeholder="email을 입력해주세요">
						<button type="button" id="emailCheckBtn" class="btn btn-success">중복확인</button>
					</div>
					
					  
					<div class="ml-3 mb-3">
						<div id="emailFormCheck" class="small text-danger d-none">이메일 형식을 확인해주세요.</div>
						<div id="emailDuplicated" class="small text-danger d-none">이미 사용중인 email입니다.</div>
						<div id="emailCheckOk" class="small text-success d-none">등록 가능한 email 입니다.</div>
					</div>
					
					<span class="sign-up-word">Password</span>
					<div class="m-3">
						<input type="password" name="password" class="form-control col-6" placeholder="비밀번호를 입력하세요">
					</div>
		
					<span class="sign-up-word">Confirm password</span>
					<div class="m-3">
						<input type="password" name="confirmPassword" class="form-control col-6" placeholder="비밀번호를 입력하세요">
					</div>
		
					<span class="sign-up-word">Nickname</span>
					<div class="m-3">
						<input type="text" name="name" class="form-control col-6" placeholder="닉네임을 입력하세요">
					</div>
					
					<br>
					<div class="d-flex justify-content-center m-3">
						<button type="submit" id="signUpBtn" class="btn btn-info">가입하기</button>
					</div>
				</div>
			</div>	
		</form>
	</div>
</div>

<script>
$(document).ready(function() {
	$("#emailCheckBtn").on('click', function() {		
		// 경고 문구
		$('#emailFormCheck').addClass('d-none');
		$('#emailDuplicated').addClass('d-none');
		$('#emailCheckOk').addClass('d-none');
		
		let email = $('#email').val();
		if (!email.includes('@')) {
			$('#emailFormCheck').removeClass('d-none');
			return;
		}
		
		$.ajax({
			url:"/user/is-duplicated-email"
			, data: {"email":email}
		
			, success: function(data) {
				if (data.is_duplicated_email) {
					$('#emailDuplicated').removeClass('d-none');
				} else {
					$('#emailCheckOk').removeClass('d-none');
				}
			}
			, error: function(request, status, error) {
				alert("중복확인에 실패했습니다.");
			}
		});
	});
	
	$('#signUpForm').on('submit', function(e) {
		e.preventDefault(); // submit 자동 수행 중단
		
		let email = $('input[name=email]').val();
		if (email == '') {
			alert("이메일을 입력해주세요.");
			return false;
		}
		
		let password = $('input[name=password]').val();
		if (password == '') {
			alert("비밀번호를 입력해주세요.");
			return false;
		}
		
		let url = $(this).attr("action");
		let data = $(this).serialize();
		
		$.post(url, data)
		.done(function(data) {
			if (data.result == "성공") {
				location.href="/egt/io"; 
			} else {
				alert("로그인에 실패했습니다. 다시 시도해주세요.");
			}
		});
	});
});

</script>