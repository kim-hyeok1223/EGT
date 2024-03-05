package com.egt.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.egt.user.bo.UserBO;

@RequestMapping("/admin")
@RestController
public class AdminRestController {

	@Autowired
	private UserBO userBO;
	
	@DeleteMapping("/userInfo/delete")
	public Map<String, Object> delete(
			@RequestParam("userId") int userId) {
		
		
		// db delete
		userBO.deleteUserByUserId(userId);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
}
