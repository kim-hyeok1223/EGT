package com.egt.exercise.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.egt.exercise.domain.Exercise;

@Mapper
public interface ExerciseMapper {

	public void insertExercise(
			@Param("exerciseNm") String exerciseNm, 
			@Param("imagePath") String imagePath);
	
	public List<Exercise> selectExercise();
}
