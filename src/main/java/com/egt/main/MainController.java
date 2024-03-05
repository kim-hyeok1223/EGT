package com.egt.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.egt.mypage.bo.MypageBO;
import com.egt.mypage.domain.Event;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/egt")
@Controller
public class MainController {

	@Autowired
	private MypageBO mypageBO;
	
	@GetMapping("/io")
	public String MainView(Model model, HttpSession session) {
		
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			model.addAttribute("viewName", "main/main");
			return "template/layout";
		} else {
			List<Event> eventList = mypageBO.getEvents(userId);
			model.addAttribute("eventList", eventList);
			model.addAttribute("viewName", "main/main");
			return "template/layout";
		}
	}
}
