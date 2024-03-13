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

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;


@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @NotNull
    @Temporal(value = TemporalType.DATE)
    private Date date;

    @NotNull
    @Min(0)
    private int price;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "accountId")
    private CustomerAccount account;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "productId")
    private SuppliedProduct product;

    public Order(int orderId, Date date, CustomerAccount account, SuppliedProduct product) {
        this.orderId = orderId;
        this.date = date;
        this.account = account;
        this.product = product;
    }

    public Order() {
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