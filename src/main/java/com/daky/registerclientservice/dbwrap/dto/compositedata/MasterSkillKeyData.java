package com.daky.registerclientservice.dbwrap.dto.compositedata;

public class MasterSkillKeyData {
    private long masterID;
    private long skillID;

    public MasterSkillKeyData() {
    }

    public MasterSkillKeyData(long masterID, long skillID) {
        this.masterID = masterID;
        this.skillID = skillID;
    }

    public long getMasterID() {
        return masterID;
    }

    public void setMasterID(long masterID) {
        this.masterID = masterID;
    }

    public long getSkillID() {
        return skillID;
    }

    public void setSkillID(long skillID) {
        this.skillID = skillID;
    }
}
