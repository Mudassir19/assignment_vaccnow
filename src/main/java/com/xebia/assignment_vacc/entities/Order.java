package com.xebia.assignment_vacc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Entity
    @Table(name = "order_details")
    public class Order {

        @Id
        private Long customerId;
        private double price;
        private String userEmail;
        private String address;
        private String currency;
        private String method;
        private String intent;
        private String description;

    }

