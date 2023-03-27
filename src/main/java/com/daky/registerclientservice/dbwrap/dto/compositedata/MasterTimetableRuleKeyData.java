package com.daky.registerclientservice.dbwrap.dto.compositedata;

public class MasterTimetableRuleKeyData {
    private long masterID;
    private String workday;

    public MasterTimetableRuleKeyData() {
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
