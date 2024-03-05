package com.egt.mypage.domain;

public class RoutineDTO {

    private int exerciseId;
    private int weight;
    private int set;

    public RoutineDTO() {
    }

    public RoutineDTO(int exerciseId, int weight, int set) {
        this.exerciseId = exerciseId;
        this.weight = weight;
        this.set = set;
    }

  
    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }
}