package com.lambdaschools.javaorders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
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
    private String grade;
    private double openingAmt;
    private double receiveAmt;
    private double outstandingAmt;
    private String phone;

// one to many relationship
    // one restaurant to many menus
    // we do that with a field that is an array list
    @OneToMany(mappedBy = "customers",
            cascade = CascadeType.ALL,
            orphanRemoval = true)// tells java that the next field is a one to many relationship
    //its also tells it what field to working with
    @JsonIgnoreProperties("customers")
private Agent agent;

}
