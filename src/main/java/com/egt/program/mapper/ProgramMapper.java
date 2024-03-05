package com.egt.program.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.egt.program.domain.Program;

@Mapper
public interface ProgramMapper {

	public void insertProgram(
			@Param("userId") int userId, 
			@Param("subject") String subject, 
			@Param("content") String content, 
			@Param("imagePath") String imagePath);
	
	public List<Program> selectProgram();
	
	public Program selectPostByPostId(int postId);
}
