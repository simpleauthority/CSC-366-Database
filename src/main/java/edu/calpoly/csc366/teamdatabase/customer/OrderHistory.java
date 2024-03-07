package edu.calpoly.csc366.teamdatabase.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

import edu.calpoly.csc366.teamdatabase.supplier.SuppliedProduct;

@Entity
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}