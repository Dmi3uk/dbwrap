package com.daky.registerclientservice.dbwrap.entries;

import com.daky.registerclientservice.dbwrap.entries.compositekeys.MasterSkillKey;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "master_skill_prices")
public class MasterSkillPrice {

    @EmbeddedId
    private MasterSkillKey id;

    @ManyToOne
    @JsonIgnore
    @MapsId("masterID")
    @JoinColumn(name = "msp_master_id")
    private Master master;

    @ManyToOne
    @JsonIgnore
    @MapsId("skillID")
    @JoinColumn(name = "msp_skill_id")
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
