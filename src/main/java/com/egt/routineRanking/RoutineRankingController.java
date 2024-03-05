package com.egt.routineRanking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.egt.mypage.domain.Routine;
import com.egt.routineRanking.bo.RoutineBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/routineRanking")
@Controller
public class RoutineRankingController {

	@Autowired
	private RoutineBO routineBO;
	
	@GetMapping("/list")
	public String routineListView(Model model, HttpSession session) {
		
		int userId = (int)session.getAttribute("userId");
		String userName = (String)session.getAttribute("userName");
		
		List<Routine> routineList = routineBO.getRoutineList();

		model.addAttribute("routineList", routineList);
		model.addAttribute("viewName", "routineRanking/routineRanking");
		return "template/layout";
	}
}
