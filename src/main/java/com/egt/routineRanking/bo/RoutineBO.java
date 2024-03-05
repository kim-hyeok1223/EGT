package com.egt.routineRanking.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egt.mypage.domain.Routine;
import com.egt.mypage.mapper.RoutineMapper;


@Service
public class RoutineBO {
	
	@Autowired
	private RoutineMapper routineMapper;

	public List<Routine> getRoutineList() {
		return routineMapper.selectRoutine();
	}
	
	public List<Routine> getRoutineListByUserId(int userId) {
		return routineMapper.selectRoutineListByUserId(userId);
	}
}
