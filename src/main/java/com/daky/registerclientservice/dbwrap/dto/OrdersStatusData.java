package com.daky.registerclientservice.dbwrap.dto;

public class OrdersStatusData {
    private long id;
    private String status;

    public OrdersStatusData() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
