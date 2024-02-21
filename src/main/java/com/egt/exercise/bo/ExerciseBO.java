package com.egt.exercise.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.egt.common.FileManagerService;
import com.egt.exercise.domain.Program;
import com.egt.exercise.mapper.ExerciseMapper;

@Service
public class ExerciseBO {
	
	@Autowired
	private ExerciseMapper exerciseMapper;
	
	@Autowired
	private FileManagerService fileManagerService;

	public void addProgram(int userId, String userName, 
			String subject, String content, MultipartFile file) {
		
		String imagePath = null;
		
		// 업로드할 이미지가 있을 때 업로드
		if (file != null) {
			imagePath = fileManagerService.saveFile(userName, file);
		}
		
		exerciseMapper.insertProgram(userId, subject, content, imagePath);
	}
	
	public List<Program> getProgramList() {
		return exerciseMapper.selectProgram();
	}
	
	public Program getPostByPostId(int postId) {
		return exerciseMapper.selectPostByPostId(postId);
	}
	
}
