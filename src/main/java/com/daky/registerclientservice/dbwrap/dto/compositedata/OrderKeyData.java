package com.daky.registerclientservice.dbwrap.dto.compositedata;

public class OrderKeyData {

    private long masterID;
    private long clientID;
    private long skillsID;
    private long statusID;

    public OrderKeyData() {
    }

    public long getMasterID() {
        return masterID;
    }

    public void setMasterID(long masterID) {
        this.masterID = masterID;
    }

    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

    public long getSkillsID() {
        return skillsID;
    }

    public void setSkillsID(long skillsID) {
        this.skillsID = skillsID;
    }

    public long getStatusID() {
        return statusID;
    }

    public void setStatusID(long statusID) {
        this.statusID = statusID;
    }
}
