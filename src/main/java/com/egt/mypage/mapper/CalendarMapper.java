package com.egt.mypage.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.egt.mypage.domain.Event;

@Mapper
public interface CalendarMapper {

	public void insertEvent(
			@Param("userId") int userId,
			@Param("content") String content,
			@Param("date") Date date,
			@Param("routineId") int routineId);
	
	List<Event> getEvents(@Param("userId") int userId);
}
