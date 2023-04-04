package com.daky.registerclientservice.dbwrap.dto;

import com.daky.registerclientservice.dbwrap.dto.compositedata.OrderKeyData;
import com.daky.registerclientservice.dbwrap.entries.Client;
import com.daky.registerclientservice.dbwrap.entries.Master;
import com.daky.registerclientservice.dbwrap.entries.OrderStatus;
import com.daky.registerclientservice.dbwrap.entries.Skill;

import java.time.LocalDateTime;

public class OrderData {

        private OrderKeyData id;
        private Master master;
        private Client client;
        private Skill skill;
        private OrderStatus orderStatus;
        private LocalDateTime startTime;
        private LocalDateTime endTime;

        public OrderData() {
        }

        public OrderData(OrderKeyData id, Master master, Client client, Skill skill, OrderStatus orderStatus, LocalDateTime startTime, LocalDateTime endTime) {
                this.id = id;
                this.master = master;
                this.client = client;
                this.skill = skill;
                this.orderStatus = orderStatus;
                this.startTime = startTime;
                this.endTime = endTime;
        }

        public OrderKeyData getId() {
                return id;
        }

        public void setId(OrderKeyData id) {
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
