package com.egt.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/egt")
@Controller
public class MainController {

	@GetMapping("/io")
	public String MainView(Model model) {
		model.addAttribute("viewName", "main/main");
		return "template/layout";
	}
}
