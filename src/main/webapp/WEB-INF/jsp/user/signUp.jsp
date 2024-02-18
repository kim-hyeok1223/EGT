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
					<div class="d-flex m-3">
						<input type="text" id="name" name="name" class="form-control col-6" placeholder="닉네임을 입력하세요">
						<button type="button" id="nameCheckBtn" class="btn btn-success">닉네임 사용 가능 확인</button>
					</div>
					
					<div class="ml-3 mb-3">
						<div id="nameDuplicated" class="small text-danger d-none">이미 사용중인 닉네임입니다.</div>
						<div id="nameCheckOk" class="small text-success d-none">사용 가능한 닉네임입니다.</div>
						<div id="nameLength" class="small text-danger d-none">닉네임은 12자 이내로 설정해주세요.</div>
					</div>
					
					<div class="d-flex">
						<span class="sign-up-word">키</span>
						<input type="number" name="height" class="mt-3 form-control col-3" placeholder="키를 입력하세요">
						<span class="mt-4">cm</span>
						<span class="sign-up-word">몸무게</span>
						<input type="number" name="weight" class="mt-3 form-control col-3" placeholder="몸무게를 입력하세요">
						<span class="mt-4">kg</span>
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
	
	$("#nameCheckBtn").on('click', function() {
		
		$('#nameDuplicated').addClass('d-none');
		$('#nameCheckOk').addClass('d-none');
		$('#nameLength').addClass('d-none');
		
		let name = $('#name').val();
		
		if(name.length > 13) {
			$('#nameLength').removeClass('d-none');
			return;
		}
		
		$.ajax({
			url:"/user/is-duplicated-name"
			,data: {"name":name}
		
			,success:function(data) {
				if (data.is_duplicated_name) {
					$('#nameDuplicated').removeClass('d-none');
				} else {
					$('#nameCheckOk').removeClass('d-none');
				}
			}
			,error:function(request, status, error) {
				alert("닉네임 중복확인에 실패했습니다.");
			}
		});
	});
	
	$('#signUpForm').on('submit', function(e) {
		e.preventDefault(); 
		
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
		
		let height = $('input[name=height]').val();
		if (height == '') {
			alert("키를 입력해주세요.");
			return false;
		}
		
		let weight = $('input[name=weight]').val();
		if (weight == '') {
			alert("몸무게를 입력해주세요.");
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