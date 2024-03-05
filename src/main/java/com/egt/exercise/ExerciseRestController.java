package com.egt.exercise;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.egt.exercise.bo.ExerciseBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/admin/exercise")
@RestController
public class ExerciseRestController {

	@Autowired
	private ExerciseBO exerciseBO;
	
	@PostMapping("/add")
	public Map<String, Object> create(
			@RequestParam("exerciseNm") String exerciseNm,
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpSession session) {
		
		String userName = (String)session.getAttribute("userName");
		
		exerciseBO.addExercise(userName, exerciseNm, file);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
}
