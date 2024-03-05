package com.egt.mypage.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egt.mypage.domain.Event;
import com.egt.mypage.domain.RoutineDTO;
import com.egt.mypage.mapper.CalendarMapper;
import com.egt.mypage.mapper.RoutineMapper;

@Service
public class MypageBO {

    @Autowired
    private RoutineMapper routineMapper;
    
    @Autowired
    private CalendarMapper calendarMapper;

    public void addRoutine(int userId, String subject, List<RoutineDTO> routines) {
        for (RoutineDTO routine : routines) {
            routineMapper.insertRoutine(
                userId,
                subject,
                routine.getExerciseId(),
                routine.getWeight(),
                routine.getSet()
            );
        }
    }
    
    public void addEvent(int userId, String content, Date date, int routineId) {
    	calendarMapper.insertEvent(userId, content, date, routineId);
    }
    
    public List<Event> getEvents(int userId) {
        return calendarMapper.getEvents(userId);
    }
}