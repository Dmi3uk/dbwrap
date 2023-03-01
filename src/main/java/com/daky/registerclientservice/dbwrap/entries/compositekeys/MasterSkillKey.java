package com.daky.registerclientservice.dbwrap.entries.compositekeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MasterSkillKey implements Serializable {

    @Column(name = "master_id")
    private long masterID;

    @Column(name = "skill_id")
    private long skillID;

    public MasterSkillKey() {
    }

    public MasterSkillKey(long masterID, long skillID) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MasterSkillKey that = (MasterSkillKey) o;
        return masterID == that.masterID && skillID == that.skillID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(masterID, skillID);
    }
}
