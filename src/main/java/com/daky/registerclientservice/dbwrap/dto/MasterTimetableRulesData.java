package com.daky.registerclientservice.dbwrap.dto;

import com.daky.registerclientservice.dbwrap.entries.Master;
import com.daky.registerclientservice.dbwrap.entries.compositekeys.MasterTimetableRulesKey;

import java.time.LocalDateTime;

public class MasterTimetableRulesData {

    private MasterTimetableRulesKey id;
    private Master master;
    private String workday;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public MasterTimetableRulesData() {
    }

    public MasterTimetableRulesKey getId() {
        return id;
    }

    public void setId(MasterTimetableRulesKey id) {
        this.id = id;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
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
