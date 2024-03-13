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
    private int orderId;
    @Temporal(value = TemporalType.DATE)
    private Date date;
    @ManyToOne
    @JoinColumn(name = "accountId")
    private CustomerAccount account;
    @ManyToOne
    @JoinColumn(name = "productId")
    private SuppliedProduct product;

    public OrderHistory(int orderId, Date date, CustomerAccount account, SuppliedProduct product) {
        this.orderId = orderId;
        this.date = date;
        this.account = account;
        this.product = product;
    }

    public OrderHistory() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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