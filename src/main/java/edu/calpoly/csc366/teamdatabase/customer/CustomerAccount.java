package edu.calpoly.csc366.teamdatabase.customer;

import edu.calpoly.csc366.teamdatabase.manager.Store;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;

@Entity
public class CustomerAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    @NotNull
    @Size(min=5, max=15)
    @Column(unique=true)
    private String username;
    
    @NotNull
    @Column(columnDefinition = "int default 0")
    private int starBalance;

    @NotNull
    @OneToOne
    @JoinColumn(name = "customerInfoId")
    private CustomerPersonalInfo customerInfo;

    @NotNull
    @OneToOne
    @JoinColumn(name = "storeId")
    private Store preferredStore;

    @NotNull
    @OneToOne
    @JoinColumn(name = "preferenceId")
    private Preferences preferences;

    public CustomerAccount(int accountId, CustomerPersonalInfo customerInfo, Store preferredStore, Preferences preferences) {
        this.accountId = accountId;
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
