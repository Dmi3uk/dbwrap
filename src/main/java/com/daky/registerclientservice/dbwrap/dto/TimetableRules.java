package com.daky.registerclientservice.dbwrap.dto;

import java.time.LocalDateTime;

public class TimetableRules {

    private String workday;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public TimetableRules() {
    }

    public TimetableRules(String workday, LocalDateTime startTime, LocalDateTime endTime) {
        this.workday = workday;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getWorkday() {
        return workday;
    }

    public void setWorkday(String workday) {
        this.workday = workday;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
