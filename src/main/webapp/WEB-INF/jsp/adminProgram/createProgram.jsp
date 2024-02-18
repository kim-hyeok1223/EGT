<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="d-flex justify-content-center mt-4 mb-4">
<div class="w-50">
	<h1>글쓰기</h1>
		
	<input type="text" id="subject" class="form-control" placeholder="제목을 입력하세요">
	<textarea id="content" class="form-control" placeholder="내용을 입력하세요" rows="10"></textarea>
		
	<div class="d-flex justify-content-end my-3">
		<input type="file" id="file" accept=".jpg, .png, .gif, .jpeg">
	</div>
		
	<div class="d-flex justify-content-between">
		<button type="button" id="programListBtn" class="btn btn-warning">목록</button>
			
		<div>
			<button type="button" id="clearBtn" class="btn btn-danger">모두 지우기</button>
			<button type="button" id="saveBtn" class="btn btn-warning">저장</button>
		</div>
	</div>
</div>
</div>
	
<script>
$(document).ready(function() {
	$("#programListBtn").on('click', function() {
		location.href = "admin/exercise/program";
	});
	
	$("#clearBtn").on('click', function() {
		$("#subject").val("");
		$("#content").val("");
	});
	
	$("#saveBtn").on('click', function() {
		let subject = $("#subject").val();
		let content = $("#content").val();
		let fileName = $("#file").val();

		if (!subject) {
			alert("제목을 입력하세요.");
			return;
		}
		
		if (!content) {
			alert("내용을 입력하세요.");
			return;
		}
		
		if (fileName) {
			let extension = fileName.split(".").pop().toLowerCase();
			
			if ($.inArray(extension, ['jpg', 'png', 'gif', 'jpeg']) == -1) {
				alert("이미지 파일만 업로드 할 수 있습니다.");
				$("#file").val("");
				return;
			}
		}
		
		let formData = new FormData();
		formData.append("subject", subject); 
		formData.append("content", content);
		formData.append("file", $("#file")[0].files[0]);
		
		$.ajax({
			type:"POST"
			, url:"/admin/exercise/program/create"
			, data:formData
			, enctype:"multipart/form-data" 
			, processData:false 
			, contentType:false 
			
			, success:function(data) {
				if (data.code == 200) {
					alert("프로그램이 추가되었습니다.");
					location.href = "/admin/egt/exercise/program";
				} else {
					alert(data.error_message);
				}
			}
			, error: function(request, status, error) {
				alert("프로그램 추가에 실패했습니다.");
			}
		});
	});
});
</script>