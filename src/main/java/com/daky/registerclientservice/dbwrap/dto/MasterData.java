package com.daky.registerclientservice.dbwrap.dto;

import java.util.Set;

public class MasterData {
    private long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String nickName;
    Set<MasterSkillPriceData> masterSkillPriceDataSet;
    Set<MasterTimetableRuleData> masterTimetableRuleDataSet;
    Set<OrderData> orderDataSet;

    public MasterData() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Set<MasterSkillPriceData> getMasterSkillPriceDataSet() {
        return masterSkillPriceDataSet;
    }

    public void setMasterSkillPriceDataSet(Set<MasterSkillPriceData> masterSkillPriceDataSet) {
        this.masterSkillPriceDataSet = masterSkillPriceDataSet;
    }

    public Set<MasterTimetableRuleData> getMasterTimetableRuleDataSet() {
        return masterTimetableRuleDataSet;
    }

    public void setMasterTimetableRuleDataSet(Set<MasterTimetableRuleData> masterTimetableRuleDataSet) {
        this.masterTimetableRuleDataSet = masterTimetableRuleDataSet;
    }

    public Set<OrderData> getOrderDataSet() {
        return orderDataSet;
    }

    public void setOrderDataSet(Set<OrderData> orderDataSet) {
        this.orderDataSet = orderDataSet;
    }
}
