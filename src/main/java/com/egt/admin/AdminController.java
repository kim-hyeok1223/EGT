package com.egt.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/admin")
@Controller
public class AdminController {

	@GetMapping("/egt/io")
	public String adminMainView(Model model, HttpSession session) {
		
		String email = (String)session.getAttribute("userEmail");
		String name = (String)session.getAttribute("userName");
		String adminEmail = "admin@admin";
		String adminName = "admin";
		
		if (email == null || name == null) {
			model.addAttribute("viewName", "main/main");
			return "template/layout";
		}
		
		if (email.equals(adminEmail) && name.equals(adminName)) { 
			model.addAttribute("viewName", "adminMain/main");
			return "adminTemplate/layout";
		} else {
			model.addAttribute("viewName", "main/main");
			return "template/layout";
		}
	}
	
	@GetMapping("/exercise/chest")
	public String adminChestView(Model model, HttpSession session) {
		
		String email = (String)session.getAttribute("userEmail");
		String name = (String)session.getAttribute("userName");
		String adminEmail = "admin@admin";
		String adminName = "admin";
		if (email.equals(adminEmail) && name.equals(adminName)) { 
			model.addAttribute("viewName", "adminBody/chest");
			return "adminTemplate/layout";
		} else {
			model.addAttribute("viewName", "body/chest");
			return "template/layout";
		}
	}
	
	@GetMapping("/exercise/back")
	public String adminBackView(Model model, HttpSession session) {
		
		String email = (String)session.getAttribute("userEmail");
		String name = (String)session.getAttribute("userName");
		String adminEmail = "admin@admin";
		String adminName = "admin";
		if (email.equals(adminEmail) && name.equals(adminName)) { 
			model.addAttribute("viewName", "adminBody/back");
			return "adminTemplate/layout";
		} else {
			model.addAttribute("viewName", "body/back");
			return "template/layout";
		}
	}
	
	@GetMapping("/exercise/bottom")
	public String adminBottomView(Model model, HttpSession session) {
		
		String email = (String)session.getAttribute("userEmail");
		String name = (String)session.getAttribute("userName");
		String adminEmail = "admin@admin";
		String adminName = "admin";
		if (email.equals(adminEmail) && name.equals(adminName)) { 
			model.addAttribute("viewName", "adminBody/bottom");
			return "adminTemplate/layout";
		} else {
			model.addAttribute("viewName", "body/bottom");
			return "template/layout";
		}
	}
	
	@GetMapping("/exercise/shoulder")
	public String adminShoulderView(Model model, HttpSession session) {
		
		String email = (String)session.getAttribute("userEmail");
		String name = (String)session.getAttribute("userName");
		String adminEmail = "admin@admin";
		String adminName = "admin";
		if (email.equals(adminEmail) && name.equals(adminName)) { 
			model.addAttribute("viewName", "adminBody/shoulder");
			return "adminTemplate/layout";
		} else {
			model.addAttribute("viewName", "body/shoulder");
			return "template/layout";
		}
	}
	
	@GetMapping("/exercise/arms")
	public String adminArmsView(Model model, HttpSession session) {
		
		String email = (String)session.getAttribute("userEmail");
		String name = (String)session.getAttribute("userName");
		String adminEmail = "admin@admin";
		String adminName = "admin";
		if (email.equals(adminEmail) && name.equals(adminName)) { 
			model.addAttribute("viewName", "adminBody/arms");
			return "adminTemplate/layout";
		} else {
			model.addAttribute("viewName", "body/amrs");
			return "template/layout";
		}
	}
	
	@GetMapping("/egt/exercise/program")
	public String adminProgramView(Model model, HttpSession session) {
		
		String email = (String)session.getAttribute("userEmail");
		String name = (String)session.getAttribute("userName");
		String adminEmail = "admin@admin";
		String adminName = "admin";
		if (email.equals(adminEmail) && name.equals(adminName)) { 
			model.addAttribute("viewName", "adminProgram/workout");
			return "adminTemplate/layout";
		} else {
			model.addAttribute("viewName", "program/workout");
			return "template/layout";
		}
	}
	
	@GetMapping("/exercise/program/create")
	public String adminProgramCreateView(Model model, HttpSession session) {
		
		String email = (String)session.getAttribute("userEmail");
		String name = (String)session.getAttribute("userName");
		String adminEmail = "admin@admin";
		String adminName = "admin";
		if (email.equals(adminEmail) && name.equals(adminName)) { 
			model.addAttribute("viewName", "adminProgram/createProgram");
			return "adminTemplate/layout";
		} else {
			model.addAttribute("viewName", "program/workout");
			return "template/layout";
		}
	}
	

	
}
