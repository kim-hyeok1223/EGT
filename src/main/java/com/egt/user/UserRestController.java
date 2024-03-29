package com.egt.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.egt.common.EncryptUtils;
import com.egt.user.bo.UserBO;
import com.egt.user.entity.UserEntity;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/user")
@RestController
public class UserRestController {

	@Autowired
	private UserBO userBO;
	
	// 이멜 중복
		@RequestMapping("/is-duplicated-email")
		public Map<String, Object> isDuplicatedEmail(@RequestParam("email") String email) {
			
			Map<String, Object> result = new HashMap<>();
			result.put("is_duplicated_email", false);
			
			UserEntity user = userBO.getUserEntityByEmail(email);
			result.put("code", 200);
			
			if (user != null) {
				result.put("is_duplicated_email", true);
			}
			
			return result;
		}
		
		// 닉네임
		@RequestMapping("/is-duplicated-name")
		public Map<String, Object> isDuplicatedName(@RequestParam("name") String name) {
			
			Map<String, Object> result = new HashMap<>();
			result.put("is_duplicated_name", false);
			
			UserEntity user = userBO.getUserEntityByName(name);
			result.put("code", 200);
			
			if (user != null) {
				result.put("is_duplicated_name", true);
			}
			
			return result;
		}
	
	
	
	
	// 회원가입
	@PostMapping("/sign-up")
	public Map<String, Object> signUp(
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("height") int height,
			@RequestParam("weight") int weight) {
		
		String hashedPassword = EncryptUtils.md5(password);

		Integer userId = userBO.addUser(email, hashedPassword, name, height, weight);

		
		Map<String, Object> result = new HashMap<>();
		if (userId != null) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "가입에 실패했습니다.");
		}

		return result;
	}
	
	// 로그인
	@PostMapping("/sign-in")
	public Map<String, Object> signIn(
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			HttpServletRequest request) {
		
		String hashedPassword = EncryptUtils.md5(password);

		UserEntity user = userBO.getUserEntityByEmailPassword(email, hashedPassword);
		
		Map<String, Object> result = new HashMap<>();
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getId());
			session.setAttribute("userEmail", user.getEmail());
			session.setAttribute("userName", user.getName());
			session.setAttribute("userHeight", user.getHeight());
			session.setAttribute("userWeight", user.getWeight());
			
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "로그인에 실패했습니다.");
		}
		return result;
	}
	
	
}
