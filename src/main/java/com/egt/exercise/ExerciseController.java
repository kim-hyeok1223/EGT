package com.egt.exercise;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/exercise")
@Controller
public class ExerciseController {

	@GetMapping("/chest")
	public String chestView(Model model) {
		model.addAttribute("viewName", "body/chest");
		return "template/layout";
	}
	
	@GetMapping("/back")
	public String backView(Model model) {
		model.addAttribute("viewName", "body/back");
		return "template/layout";
	}
	
	@GetMapping("/bottom")
	public String bottomView(Model model) {
		model.addAttribute("viewName", "body/bottom");
		return "template/layout";
	}
	
	@GetMapping("/shoulder")
	public String shoulderView(Model model) {
		model.addAttribute("viewName", "body/shoulder");
		return "template/layout";
	}
	
	@GetMapping("/arms")
	public String armsView(Model model) {
		model.addAttribute("viewName", "body/arms");
		return "template/layout";
	}
}
