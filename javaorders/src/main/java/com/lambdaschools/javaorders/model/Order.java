package com.lambdaschools.javaorders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)// it handles the id
    private long ordNum;


    private double ordAmount;
    private double advancedAmount;
    private String orderDescription;

    @ManyToOne  // getting the foreign key
    @JoinColumn(name = "customerCode",
            nullable = false)
    @JsonIgnoreProperties ("orders")
    private Customer customer;

    public Order() {

    }

    public Order(double ordAmount, double advancedAmount, String orderDescription, Customer customer) {
        this.ordAmount = ordAmount;
        this.advancedAmount = advancedAmount;
        this.orderDescription = orderDescription;
        this.customer = customer;
    }

    public long getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(long ordNum) {
        this.ordNum = ordNum;
    }

    public double getOrdAmount() {
        return ordAmount;
    }

    public void setOrdAmount(double ordAmount) {
        this.ordAmount = ordAmount;
    }

    public double getAdvancedAmount() {
        return advancedAmount;
    }

    public void setAdvancedAmount(double advancedAmount) {
        this.advancedAmount = advancedAmount;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
