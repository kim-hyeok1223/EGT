<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<header>
<!-- jquery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- bootstrap 4 -->
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <!-- fullcalendar -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.css">
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.js"></script>


    <script type="text/javascript">
        document.addEventListener('DOMContentLoaded', function () {
            var calendarEl = document.getElementById('calendar');
            var calendar = new FullCalendar.Calendar(calendarEl, {
                timeZone: 'UTC',
                locale: 'ko',
                initialView: 'dayGridMonth', 
                events: [
                    <c:forEach items="${eventList}" var="event">
                        {
                            title: '${event.content}',
                            start: '${event.date}',
                            routineId: '${event.routineId}'
                        },
                    </c:forEach>
                ],
                headerToolbar: {
                    center: 'addEventButton'
                },
                customButtons: {
                    addEventButton: {
                        text: "일정 추가",
                        click: function () {
                        	location.href = "/mypage/calendar";
                        }
                    }
                },
                editable: true, // false로 변경 시 draggable 작동 x 
                displayEventTime: false // 시간 표시 x
            });
            calendar.render();
        });
    </script>
     <style>
        #calendarBox{
            width: 100%;
     
        }

    </style>
     
</header>
<body>
	
	
    <div id="calendarBox">
        <div id="calendar"></div>
    </div>

    <!-- modal 추가 -->
    <div class="modal fade" id="calendarModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">일정을 입력하세요.</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="content" class="col-form-label">일정 내용</label>
                        <input type="text" class="form-control" id="content" name="content">
                        <label for="date" class="col-form-label">날짜</label>
                        <input type="date" class="form-control" id="date" name="date">
                        <label for="routine" class="col-form-label">루틴</label>
                        <div>
							<c:if test="${empty routineList}">
								<p>루틴 목록이 비어 있습니다.</p>
							</c:if>
							
							<select id="routine" class="form-control form-select-lg">
								<option selected>루틴을 선택하세요.</option>
								<c:forEach items="${routineList}" var="routine">
									<option value="${routine.id}">${routine.subject}</option>
								</c:forEach>
							</select>
						</div>
                        
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-warning" id="addCalendar">추가</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal"
                        id="sprintSettingModalClose">취소</button>
                </div>
    
            </div>
        </div>
    </div>
</body>