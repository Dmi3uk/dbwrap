package com.daky.registerclientservice.dbwrap.dto.compositedata;

public class MasterTimetableRulesKeyData {
    private long masterID;

    private String workday;

    public MasterTimetableRulesKeyData() {
    }

    public MasterTimetableRulesKeyData(long masterID, String workday) {
        this.masterID = masterID;
        this.workday = workday;
    }

    public long getMasterID() {
        return masterID;
    }

    public void setMasterID(long masterID) {
        this.masterID = masterID;
    }

    public String getWorkday() {
        return workday;
    }

    public void setWorkday(String workday) {
        this.workday = workday;
    }
}
