package com.daky.registerclientservice.dbwrap.entries;

import com.daky.registerclientservice.dbwrap.entries.compositekeys.OrderKey;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @EmbeddedId
    private OrderKey id;

    @ManyToOne
    @JsonIgnore
    @MapsId("masterID")
    @JoinColumn(name = "order_master_id")
    private Master master;

    @ManyToOne
    @JsonIgnore
    @MapsId("clientID")
    @JoinColumn(name = "order_client_id")
    private Client client;

    @ManyToOne
    @JsonIgnore
    @MapsId("skillID")
    @JoinColumn(name = "order_skill_id")
    private Skill skill;

    @ManyToOne
    @JsonIgnore
    @MapsId("statusID")
    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    public OrderKey getId() {
        return id;
    }

    public void setId(OrderKey id) {
        this.id = id;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
