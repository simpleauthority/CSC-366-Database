package edu.calpoly.csc366.teamdatabase.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
public class eGiftHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public eGiftHistory(int giftId, String recipientName, String recipientEmail, int amount, String message, Date dateSent, CustomerAccount account) {
        this.giftId = giftId;
        this.recipientName = recipientName;
        this.recipientEmail = recipientEmail;
        this.amount = amount;
        this.message = message;
        this.dateSent = dateSent;
        this.account = account;
    }

    public eGiftHistory() {

    }

    public int getGiftId() {
        return giftId;
    }

    public void setGiftId(int giftId) {
        this.giftId = giftId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateSent() {
        return dateSent;
    }

    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }

    public CustomerAccount getAccount() {
        return account;
    }

    public void setAccount(CustomerAccount account) {
        this.account = account;
    }
}