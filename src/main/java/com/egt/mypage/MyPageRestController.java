package com.egt.mypage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.egt.mypage.bo.MypageBO;
import com.egt.mypage.domain.Event;
import com.egt.mypage.domain.RoutineDTO;
import com.egt.mypage.domain.RoutineRequest;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/mypage")
@RestController
public class MyPageRestController {

    @Autowired
    private MypageBO mypageBO;
    
    @PostMapping("/routineMaking/create")
    public Map<String, Object> createRoutine(@RequestBody RoutineRequest request, HttpSession session) {
        String subject = request.getSubject();
        List<RoutineDTO> routines = request.getRoutines();
        
        int userId = (int) session.getAttribute("userId");
        String userName = (String) session.getAttribute("userName");
        
        try {
            mypageBO.addRoutine(userId, subject, routines);
            Map<String, Object> result = new HashMap<>();
            result.put("code", 200);
            result.put("result", "루틴이 추가되었습니다.");
            return result;
        } catch (Exception e) {
            e.printStackTrace(); 
            Map<String, Object> result = new HashMap<>();
            result.put("code", 500);
            result.put("error_message", "루틴 추가 중 오류가 발생했습니다.");
            return result;
        }
    }
    
    @PostMapping("/calendar/create")
    public Map<String, Object> createEvent(
            @RequestParam("content") String content,
            @RequestParam("date") String dateString, // 날짜를 String으로 받음
            @RequestParam("routineId") int routineId,
            HttpSession session) {

        int userId = (int) session.getAttribute("userId");

        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        mypageBO.addEvent(userId, content, date, routineId);

        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("result", "성공");
        return result;
    }
    
    @GetMapping("/calendar/events")
    public List<Event> getEvents(HttpSession session) {
    	
        int userId = (int) session.getAttribute("userId");
        
        
        return mypageBO.getEvents(userId);
    }
    
    
}


