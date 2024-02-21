package com.egt.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/mypage")
@Controller
public class MyPageController {

	@GetMapping("/calendar")
	public String CalendarView(Model model) {
		model.addAttribute("viewName", "calendar/calendar");
		return "template/layout";
	}
	
	@GetMapping("/calendar/popup")
	public String PopupView() {
		return "calendar/popup";
	}
}
