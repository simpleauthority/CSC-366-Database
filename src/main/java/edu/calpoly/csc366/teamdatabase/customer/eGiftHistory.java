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
public class eGiftHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int giftId;
    private String recipientName;
    private String recipientEmail;
    private int amount;
    private String message;
    @Temporal(value = TemporalType.DATE)
    private Date dateSent;
    @ManyToOne
    @JoinColumn(name = "accountId")
    private CustomerAccount account;
}