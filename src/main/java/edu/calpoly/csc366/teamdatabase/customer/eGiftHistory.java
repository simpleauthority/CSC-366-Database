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

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class eGiftHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int giftId;

    @NotNull
    private String recipientName;

    @NotNull
    @Email
    private String recipientEmail;

    @NotNull
    @Min(1)
    private float amount;

    @NotNull
    private String message;

    @NotNull
    @Temporal(value = TemporalType.DATE)
    private Date dateSent;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "accountId")
    private CustomerAccount account;

    public eGiftHistory(int giftId, String recipientName, String recipientEmail, float amount, String message, Date dateSent, CustomerAccount account) {
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

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
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