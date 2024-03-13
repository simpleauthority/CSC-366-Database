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

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int creditCardId;

    @NotNull
    @Size(min=16, max=16)
    @Column(unique=true)
    private int cardNumber;

    @NotNull
    @Size(min=3, max=4)
    private int cvv;

    @NotNull
    @Temporal(value = TemporalType.DATE)
    private Date expirationDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "accountId")
    private CustomerAccount account;

    public CreditCard(int creditCardId, int cardNumber, int cvv, Date expirationDate, CustomerAccount account) {
        this.creditCardId = creditCardId;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
        this.account = account;
    }

    public CreditCard() {

    }

    public int getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(int creditCardId) {
        this.creditCardId = creditCardId;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public CustomerAccount getAccount() {
        return account;
    }

    public void setAccount(CustomerAccount account) {
        this.account = account;
    }
}
