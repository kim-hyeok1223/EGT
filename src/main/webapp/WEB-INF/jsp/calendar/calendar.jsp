<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
<!-- /mypage/calendar -->
<!--  fullcalendar css -->

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.css">
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>

<!--  언어 설정관련 script -->
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/locales-all.js"></script>
<script>
document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');
	var calendar = new FullCalendar.Calendar(calendarEl, {
		initialView : 'dayGridMonth', 
		headerToolbar : { 
			start : 'prev next today',
			center : 'title',
			end : 'dayGridMonth,dayGridWeek,dayGridDay'
		},
		titleFormat : function(date) {
			return date.date.year + '년 ' + (parseInt(date.date.month) + 1) + '월';
		},
		
		selectable : true, 
		droppable : true,
		editable : true,
		nowIndicator: true, 
		locale: 'ko',
		dateClick: function(info) {
		      //alert('clicked ' + info.dateStr); // 이거를 팝업으로 수정
			  const options = 'width=700, height=600, top=50, left=50, scrollbars=yes'
			 window.open('/mypage/calendar/popup','mypopup',options)
		}
	});
	calendar.render();
});
</script>
</header>
<body>
	<div id='calendar'></div>
</body>
<script>
	
</script>