package com.daky.registerclientservice.dbwrap.entries;

import com.daky.registerclientservice.dbwrap.entries.compositekeys.MasterTimetableRulesKey;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Entity
@Table(name = "master_timetable_rules")
public class MasterTimetableRules {

    @EmbeddedId
    private MasterTimetableRulesKey id;

    @ManyToOne
    @JsonIgnore
    @MapsId("masterID")
    @JoinColumn(name="mtr_master_id")
    private Master master;

    @Column(name="workday", insertable = false, updatable = false)
    private String workday;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public MasterTimetableRules() {
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
