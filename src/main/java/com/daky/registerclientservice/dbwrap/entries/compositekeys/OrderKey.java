package com.daky.registerclientservice.dbwrap.entries.compositekeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderKey implements Serializable {

    @Column(name = "order_master_id")
    private long masterID;

    @Column(name = "order_client_id")
    private long clientID;

    @Column(name = "order_skill_id")
    private long skillsID;

    @Column(name = "order_status_id")
    private long statusID;

    public OrderKey() {
    }

    public OrderKey(long masterID, long clientID, long skillsID, long statusID) {
        this.masterID = masterID;
        this.clientID = clientID;
        this.skillsID = skillsID;
        this.statusID = statusID;
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
