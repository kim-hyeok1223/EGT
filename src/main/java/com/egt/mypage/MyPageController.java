package com.egt.mypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.egt.exercise.bo.ExerciseBO;
import com.egt.exercise.domain.Exercise;
import com.egt.mypage.bo.MypageBO;
import com.egt.mypage.domain.Event;
import com.egt.mypage.domain.Routine;
import com.egt.routineRanking.bo.RoutineBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/mypage")
@Controller
public class MyPageController {

	@Autowired
	private ExerciseBO exerciseBO;
	
	@Autowired
	private RoutineBO routineBO;
	
	@Autowired
	private MypageBO mypageBO;
	
	@GetMapping("/calendar")
	public String CalendarView(Model model, HttpSession session) {
		
		int userId = (int)session.getAttribute("userId");
		String userName = (String)session.getAttribute("userName");
		
		List<Routine> routineList = routineBO.getRoutineListByUserId(userId);
		List<Event> eventList = mypageBO.getEvents(userId);

		model.addAttribute("routineList", routineList);
		model.addAttribute("eventList", eventList);
		model.addAttribute("viewName", "calendar/newCalendar");
		return "template/layout";
	}
	
//	@GetMapping("/calendar/popup")
//	public String PopupView() {
//		return "calendar/popup";
//	}
	
	@GetMapping("/routineMaking")
	public String routineMakingView(Model model) {
		
		List<Exercise> exerciseList = exerciseBO.getExerciseList();
		
		model.addAttribute("exerciseList", exerciseList);
		model.addAttribute("viewName", "routineMaking/routineMaking");
		return "template/layout";
	}
	
	@GetMapping("/mainPage")
	public String UserView(Model model, HttpSession session) {
			
			int userId = (int)session.getAttribute("userId");
			String userName = (String)session.getAttribute("userName");
			
			List<Routine> routineList = routineBO.getRoutineListByUserId(userId);
			List<Event> eventList = mypageBO.getEvents(userId);
	
			model.addAttribute("routineList", routineList);
			model.addAttribute("eventList", eventList);
			model.addAttribute("viewName", "mypage/mainMypage");
			return "template/layout";
		}
	
}
