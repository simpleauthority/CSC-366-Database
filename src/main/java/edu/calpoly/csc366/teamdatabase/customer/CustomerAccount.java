package edu.calpoly.csc366.teamdatabase.customer;

import edu.calpoly.csc366.teamdatabase.manager.Store;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class CustomerAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public CustomerAccount(int accountId, int starBalance, CustomerPersonalInfo customerInfo, Store preferredStore, Preferences preferences) {
        this.accountId = accountId;
        this.starBalance = starBalance;
        this.customerInfo = customerInfo;
        this.preferredStore = preferredStore;
        this.preferences = preferences;
    }

    public CustomerAccount() {

    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getStarBalance() {
        return starBalance;
    }

    public void setStarBalance(int starBalance) {
        this.starBalance = starBalance;
    }

    public CustomerPersonalInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerPersonalInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public Store getPreferredStore() {
        return preferredStore;
    }

    public void setPreferredStore(Store preferredStore) {
        this.preferredStore = preferredStore;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }
}
