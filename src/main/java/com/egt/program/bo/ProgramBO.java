package com.egt.program.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.egt.common.FileManagerService;
import com.egt.program.domain.Program;
import com.egt.program.mapper.ProgramMapper;

@Service
public class ProgramBO {
	
	@Autowired
	private ProgramMapper exerciseMapper;
	
	@Autowired
	private FileManagerService fileManagerService;

	public void addProgram(int userId, String userName, 
			String subject, String content, MultipartFile file) {
		
		String imagePath = null;
		
	
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
