package edu.calpoly.csc366.teamdatabase.customer;

import edu.calpoly.csc366.teamdatabase.supplier.SuppliedProduct;
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
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int offerId;
    private String offerName;
    private String description;
    @Temporal(value = TemporalType.DATE)
    private Date startDate;
    @Temporal(value = TemporalType.DATE)
    private Date endDate;
    private boolean redeemed;
    @ManyToOne
    @JoinColumn(name = "accountId")
    private CustomerAccount account;
    @ManyToOne
    @JoinColumn(name = "productId")
    private SuppliedProduct product;

    public OrderHistory(int offerId, String offerName, String description, Date startDate, Date endDate, boolean redeemed, CustomerAccount account, SuppliedProduct product) {
        this.offerId = offerId;
        this.offerName = offerName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.redeemed = redeemed;
        this.account = account;
        this.product = product;
    }

    public OrderHistory() {

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

    public SuppliedProduct getProduct() {
        return product;
    }

    public void setProduct(SuppliedProduct product) {
        this.product = product;
    }
}