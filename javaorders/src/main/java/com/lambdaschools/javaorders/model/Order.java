package com.lambdaschools.javaorders.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)// it handles the id
    @Column(nullable = false)
    private long ordnum;


    private double ordamount;
    private double advancedamount;

    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
    @JsonIgnoreProperties("customers")
    private Customer customer;

    private String orderDescription;

    public Order() {
    }

    public Order(double ordamount, double advancedamount, Customer customer, String orderDescription) {
        this.ordamount = ordamount;
        this.advancedamount = advancedamount;
        this.customer = customer;
        this.orderDescription = orderDescription;

    }

    public long getOrdnum() {
        return ordnum;
    }

    public void setOrdnum(long ordnum) {
        this.ordnum = ordnum;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvancedamount() {
        return advancedamount;
    }

    public void setAdvancedamount(double advancedamount) {
        this.advancedamount = advancedamount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }
}
