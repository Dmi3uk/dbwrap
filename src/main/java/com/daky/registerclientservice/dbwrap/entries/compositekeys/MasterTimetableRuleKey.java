package com.daky.registerclientservice.dbwrap.entries.compositekeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MasterTimetableRuleKey implements Serializable {

    @Column(name = "mtr_master_id")
    private long masterID;

    @Column(name = "workday")
    private String workday;

    public MasterTimetableRuleKey() {
    }

    public MasterTimetableRuleKey(long masterID, String workday) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MasterTimetableRuleKey that = (MasterTimetableRuleKey) o;
        return masterID == that.masterID && Objects.equals(workday, that.workday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(masterID, workday);
    }
}
