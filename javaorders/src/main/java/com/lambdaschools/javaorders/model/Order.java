package com.lambdaschools.javaorders.model;



import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)// it handles the id
    @Column(nullable = false)
    private long ordNum;


    private double ordAmount;
    private double advancedAmount;

    @ManyToOne  // getting the foreign keys
    @JoinColumn(name = "customCode",
            nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "agentCode")
    private Agent agentCode;

    private String orderDescription;

    public Order(double ordAmount, double advancedAmount, Customer customer, Agent agentCode, String orderDescription) {
        this.ordAmount = ordAmount;
        this.advancedAmount = advancedAmount;
        this.customer = customer;
        this.agentCode = agentCode;
        this.orderDescription = orderDescription;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Agent getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(Agent agentCode) {
        this.agentCode = agentCode;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }


}
