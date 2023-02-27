package com.daky.registerclientservice.dbwrap.dto;

import com.daky.registerclientservice.dbwrap.entries.Master;
import com.daky.registerclientservice.dbwrap.entries.Skill;
import com.daky.registerclientservice.dbwrap.entries.compositekeys.MasterSkillKey;

public class MasterSkillPriceData {
    private MasterSkillKey id;
    private Master master;
    private Skill skill;
    private int price;

    public MasterSkillKey getId() {
        return id;
    }

    public void setId(MasterSkillKey id) {
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
