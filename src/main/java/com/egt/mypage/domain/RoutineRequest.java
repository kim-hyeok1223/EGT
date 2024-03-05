package com.egt.mypage.domain;

import java.util.List;

public class RoutineRequest {

    private String subject;
    private List<RoutineDTO> routines;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<RoutineDTO> getRoutines() {
        return routines;
    }

    public void setRoutines(List<RoutineDTO> routines) {
        this.routines = routines;
    }
}