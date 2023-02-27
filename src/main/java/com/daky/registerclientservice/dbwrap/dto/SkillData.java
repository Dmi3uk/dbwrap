package com.daky.registerclientservice.dbwrap.dto;

import com.daky.registerclientservice.dbwrap.entries.MasterSkillPrice;

import java.util.Set;

public class SkillData {
    private long id;
    private String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
