package com.daky.registerclientservice.dbwrap.dto;

public class SkillsPrices {
    private String description;
    private int price;

    public SkillsPrices() {
    }

    public SkillsPrices(String description, int price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
