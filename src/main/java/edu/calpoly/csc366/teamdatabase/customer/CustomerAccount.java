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
public class CustomerAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountId;

    private int starBalance;

    @OneToOne
    @JoinColumn(name = "customerInfoId")
    private CustomerPersonalInfo customerInfo;

    @OneToOne
    @JoinColumn(name = "storeId")
    private Store preferredStore;


    @OneToOne
    @JoinColumn(name = "preferenceId")
    private Preferences preferences;

    
}
