package com.egt.program;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.egt.program.bo.ProgramBO;
import com.egt.program.domain.Program;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/exercise")
@Controller
public class ProgramController {

	@Autowired
	private ProgramBO exerciseBO;
	
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
	
	@GetMapping("/program")
	public String programView(Model model) {
		
		List<Program> exerciseList = exerciseBO.getProgramList();

		model.addAttribute("exerciseList", exerciseList);
		model.addAttribute("viewName", "program/workout");
		return "template/layout";
	}
	
	@GetMapping("/program/program-detail-view")
	public String programDetailView(
			@RequestParam("postId") int postId,
			Model model,HttpSession session) {
		
		Program exercise = exerciseBO.getPostByPostId(postId);
		
		model.addAttribute("exercise", exercise);
		model.addAttribute("viewName", "program/programDetail");
		return "template/layout";
	}
	
	
}
