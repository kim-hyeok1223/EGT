package com.egt.exercise.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.egt.common.FileManagerService;
import com.egt.exercise.domain.Exercise;
import com.egt.exercise.mapper.ExerciseMapper;

@Service
public class ExerciseBO {

	@Autowired
	private ExerciseMapper exerciseMapper;
	
	@Autowired
	private FileManagerService fileManagerService;
	
	public void addExercise(String userName ,String exerciseNm ,MultipartFile file) {
		
		String imagePath = null;
		
		
		if (file != null) {
			imagePath = fileManagerService.saveFile(userName, file);
		}
		
		exerciseMapper.insertExercise(exerciseNm, imagePath);
	}
	
	public List<Exercise> getExerciseList() {
		return exerciseMapper.selectExercise();
	}
}
