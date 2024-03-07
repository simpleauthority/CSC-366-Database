package edu.calpoly.csc366.teamdatabase.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
public class StarbucksCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int starbucksCardId;

    private int balance;
    private boolean autoReload;

    @ManyToOne
    @JoinColumn(name = "accountId")
    private CustomerAccount account;
}