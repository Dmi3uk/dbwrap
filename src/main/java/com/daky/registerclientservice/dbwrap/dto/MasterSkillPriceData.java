package com.daky.registerclientservice.dbwrap.dto;

import com.daky.registerclientservice.dbwrap.dto.compositedata.MasterSkillKeyData;
import com.daky.registerclientservice.dbwrap.entries.Master;
import com.daky.registerclientservice.dbwrap.entries.Skill;

public class MasterSkillPriceData {
    private MasterSkillKeyData id;
    private Master master;
    private Skill skill;
    private int price;

    public MasterSkillPriceData() {
    }

    public MasterSkillKeyData getId() {
        return id;
    }

    public void setId(MasterSkillKeyData id) {
        this.id = id;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
