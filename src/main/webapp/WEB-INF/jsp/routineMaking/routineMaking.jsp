<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="d-flex justify-content-center mt-4 mb-4">
    <div class="w-50">
        <h1>${userName}님의 루틴만들기</h1>
        <!-- 제목 입력란 -->
        <input type="text" id="subject" name="subject" class="form-control" placeholder="제목을 입력하세요">
        <input class="d-flex justify-content-end btn" type="button" value="추가" onclick="add_div()"><br/>
        <div id="room_type" style="display: none;">
            <div class="form-group">
                <!-- 운동 이름, 무게, 세트 수  -->
                <div class="select-box mt-3 mb-3">
                    <select class="form-control form-select-lg">
                        <option selected>운동 종목을 선택하세요.</option>
                        <c:forEach items="${exerciseList}" var="ex">
                            <option value="${ex.id}">${ex.exerciseNm}</option>
                        </c:forEach>
                    </select>
                    <input type="number" class="form-control" placeholder="무게를 입력하세요.      kg"></input>
                    <input type="number" class="form-control" placeholder="세트 수를 입력하세요.       set"></input>
                </div>
            </div>
            <input class="d-flex justify-content-end btn" type="button" value="삭제" onclick="remove_div(this)">
        </div>
        <div id="field"></div>
        <div class="d-flex justify-content-end">
            <button type="button" id="saveBtn" class="btn btn-success">저장</button>
        </div>
    </div>
</div>

<script>
    function add_div() {
        var uuid = generateUUID(); // UUID 생성
        var div = document.createElement('div');
        div.id = uuid; // 고유한 ID 설정
        div.innerHTML = document.getElementById('room_type').innerHTML;
        document.getElementById('field').appendChild(div);
        div.style.display = "block"; 
    }

    function remove_div(obj) {
        document.getElementById('field').removeChild(obj.parentNode);
    }

    $(document).ready(function() {
        $("#saveBtn").on('click', function() {
            
            let subject = $("#subject").val();

            if (!subject) {
                alert("제목을 입력하세요.");
                return;
            }
            
            let routines = [];
            $("#field > div").each(function(index, element) {
                let ex = $(element).find('select').val();
                let weight = $(element).find('input[type=number]').eq(0).val();
                let set = $(element).find('input[type=number]').eq(1).val();

                let routine = {
                    exerciseId: parseInt(ex),
                    weight: parseInt(weight),
                    set: parseInt(set)
                };

                routines.push(routine);
            });
            
            $.ajax({
                type: "POST",
                url: "/mypage/routineMaking/create",
                contentType: "application/json", 
                data: JSON.stringify({
                    "subject": subject,
                    "routines": routines
                }), 
                success: function(data) {
                    if (data.code == 200) {
                        alert("루틴이 추가되었습니다.");
                        location.href = "/mypage/routineMaking";
                    } else {
                        alert(data.error_message);
                    }
                },
                error: function(request, status, error) {
                    alert("프로그램 추가에 실패했습니다.");
                }
            });
            
        });
    });

    // UUID 생성 함수
    function generateUUID() { 
        var d = new Date().getTime();
        var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
            var r = (d + Math.random()*16)%16 | 0;
            d = Math.floor(d/16);
            return (c=='x' ? r : (r&0x3|0x8)).toString(16);
        });
        return uuid;
    }
</script>