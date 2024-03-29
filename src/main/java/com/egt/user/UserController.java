package com.egt.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.egt.aop.TimeTrace;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/user")
@Controller
public class UserController {

	/**
	 * 회원가입
	 * @param model
	 * @return
	 */
	@GetMapping("/sign-up-view")
	public String signUpView(Model model) {
		model.addAttribute("viewName", "user/signUp");
		return "template/layout";
	}
	
	/**
	 * 로그인
	 * @param model
	 * @return
	 */
	@TimeTrace
	@GetMapping("/sign-in-view")
	public String signInView(Model model) {
		model.addAttribute("viewName", "user/signIn");
		return "template/layout";
	}
	
	// 로그아웃
	@RequestMapping("/sign-out")
	public String signOutView(HttpSession session) {
		session.removeAttribute("userId");
		session.removeAttribute("userEmail");
		session.removeAttribute("userName");
		
		return "redirect:/user/sign-in-view";
	}
}
