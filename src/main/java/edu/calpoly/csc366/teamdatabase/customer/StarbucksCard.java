package edu.calpoly.csc366.teamdatabase.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class StarbucksCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int starbucksCardId;
    
    @NotNull
    @Min(0)
    private int balance;

    @NotNull
    private boolean autoReload;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "accountId")
    private CustomerAccount account;

    public StarbucksCard(int starbucksCardId, int balance, boolean autoReload, CustomerAccount account) {
        this.starbucksCardId = starbucksCardId;
        this.balance = balance;
        this.autoReload = autoReload;
        this.account = account;
    }

    public StarbucksCard() {

    }

    public int getStarbucksCardId() {
        return starbucksCardId;
    }

    public void setStarbucksCardId(int starbucksCardId) {
        this.starbucksCardId = starbucksCardId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isAutoReload() {
        return autoReload;
    }

    public void setAutoReload(boolean autoReload) {
        this.autoReload = autoReload;
    }

    public CustomerAccount getAccount() {
        return account;
    }

    public void setAccount(CustomerAccount account) {
        this.account = account;
    }
}