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

@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int offerId;

    @NotNull
    private String offerName;

    @NotNull
    private String description;

    @NotNull
    @Temporal(value = TemporalType.DATE)
    private Date startDate;

    @NotNull
    @Temporal(value = TemporalType.DATE)
    private Date endDate;

    @NotNull
    private boolean redeemed;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "accountId")
    private CustomerAccount account;

    public Offer(int offerId, String offerName, String description, Date startDate, Date endDate, boolean redeemed, CustomerAccount account) {
        this.offerId = offerId;
        this.offerName = offerName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.redeemed = redeemed;
        this.account = account;
    }

    public Offer() {

    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isRedeemed() {
        return redeemed;
    }

    public void setRedeemed(boolean redeemed) {
        this.redeemed = redeemed;
    }

    public CustomerAccount getAccount() {
        return account;
    }

    public void setAccount(CustomerAccount account) {
        this.account = account;
    }
}
