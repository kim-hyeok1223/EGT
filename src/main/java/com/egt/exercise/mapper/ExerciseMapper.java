package com.egt.exercise.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ExerciseMapper {

	public void insertProgram(
			@Param("userId") int userId, 
			@Param("subject") String subject, 
			@Param("content") String content, 
			@Param("imagePath") String imagePath);
}
