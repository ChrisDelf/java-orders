package com.lambdaschools.javaorders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    //adding the fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)// it handles the id
    private long customerCode;


    @Column(unique = true, // we must have a unique name and it cannot be null
            nullable = false) // only affects the field that is below it.
// our fields will become columns
    private String customName;

    private String city;
    private String workingArea;
    private String custCountry;
    private String grade;
    private double openingAmt;
    private double receiveAmt;
    private double paymentAmt;
    private double outstandingAmt;
    private String phone;



    @ManyToOne
    @JoinColumn(name = "agentCode",
            nullable = false)
    @JsonIgnoreProperties("customers")
    private Agent agent;

    // one to many relationship
    // one restaurant to many menus
    // we do that with a field that is an array list
    @OneToMany(mappedBy = "customers",
            cascade = CascadeType.ALL,
            orphanRemoval = true)// tells java that the next field is a one to many relationship
    //its also tells it what field to working with
    @JsonIgnoreProperties("customers")
    private List<Order> orders = new ArrayList<>();




    public Customer() {

    }

    public Customer(String customName, String city, String workingArea, String custCountry, String grade, double openingAmt, double receiveAmt, double paymentAmt, double outstandingAmt, String phone, Agent agent) {
        this.customName = customName;
        this.city = city;
        this.workingArea = workingArea;
        this.custCountry = custCountry;
        this.grade = grade;
        this.openingAmt = openingAmt;
        this.receiveAmt = receiveAmt;
        this.paymentAmt = paymentAmt;
        this.outstandingAmt = outstandingAmt;
        this.phone = phone;
        this.agent = agent;
    }

    public long getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(long customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWorkingArea() {
        return workingArea;
    }

    public void setWorkingArea(String workingArea) {
        this.workingArea = workingArea;
    }

    public String getCustCountry() {
        return custCountry;
    }

    public void setCustCountry(String custCountry) {
        this.custCountry = custCountry;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getOpeningAmt() {
        return openingAmt;
    }

    public void setOpeningAmt(double openingAmt) {
        this.openingAmt = openingAmt;
    }

    public double getReceiveAmt() {
        return receiveAmt;
    }

    public void setReceiveAmt(double receiveAmt) {
        this.receiveAmt = receiveAmt;
    }

    public double getPaymentAmt() {
        return paymentAmt;
    }

    public void setPaymentAmt(double paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public double getOutstandingAmt() {
        return outstandingAmt;
    }

    public void setOutstandingAmt(double outstandingAmt) {
        this.outstandingAmt = outstandingAmt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
