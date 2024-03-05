package com.egt.mypage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.egt.mypage.domain.Routine;

@Mapper
public interface RoutineMapper {

    public void insertRoutine(
        @Param("userId") int userId,
        @Param("subject") String subject,
        @Param("exerciseId") int exerciseId,
        @Param("weight") int weight,
        @Param("set") int set);

	public List<Routine> selectRoutine();
	
	public List<Routine> selectRoutineListByUserId(int userId);

}
