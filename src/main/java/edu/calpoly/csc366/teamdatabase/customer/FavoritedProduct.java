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
public class FavoritedProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int favoritedProductID;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "accountId")
    private CustomerAccount account;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "productId")
    private SuppliedProduct product;

    public FavoritedProduct(CustomerAccount account, SuppliedProduct product) {
        this.account = account;
        this.product = product;
    }

    public FavoritedProduct() {
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