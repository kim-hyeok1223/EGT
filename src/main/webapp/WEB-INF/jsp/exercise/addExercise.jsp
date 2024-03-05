<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="d-flex justify-content-center mt-4 mb-4">
<div class="w-50">
	<h1>운동추가하기</h1>
		
	<input type="text" id="exerciseNm" class="form-control" placeholder="운동이름을 입력하세요">
		
	<div class="d-flex justify-content-end my-3">
		<input type="file" id="file" accept=".jpg, .png, .gif, .jpeg">
	</div>
		
	<!-- 여기는 나중에 운동목록 보여주는 view로 이동 버튼
	<div class="d-flex justify-content-between">
		<button type="button" id="programListBtn" class="btn btn-warning">운동 목록</button>
	 -->		
		<div>
			<button type="button" id="saveBtn" class="btn btn-success">저장</button>
		</div>
	</div>
</div>
</div>
	
<script>
$(document).ready(function() {
	
	$("#saveBtn").on('click', function() {
		let exerciseNm = $("#exerciseNm").val();
		let fileName = $("#file").val();

		if (!exerciseNm) {
			alert("운동제목을 입력하세요.");
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
		formData.append("exerciseNm", exerciseNm); 
		formData.append("file", $("#file")[0].files[0]);
		
		$.ajax({
			type:"POST"
			, url:"/admin/exercise/add"
			, data:formData
			, enctype:"multipart/form-data" 
			, processData:false 
			, contentType:false 
			
			, success:function(data) {
				if (data.code == 200) {
					alert("프로그램이 추가되었습니다.");
					location.href = "/admin/egt/io";
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