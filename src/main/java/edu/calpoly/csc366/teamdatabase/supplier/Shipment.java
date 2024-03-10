package edu.calpoly.csc366.teamdatabase.supplier;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity                   // this class maps to a database table
@Table(name = "shipment")   // (may be omitted for default table naming)
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNumber;

    @Temporal(value = TemporalType.DATE)
    private Date shipmentDate;

    @Temporal(value = TemporalType.DATE)
    private Date expectedDeliveryDate;

    @Temporal(value = TemporalType.DATE)
    private Date actualDeliveryDate;

    @ManyToOne
    @JoinColumn(name = "supplierId", nullable = false)
    private Supplier deliveryCompany;

    private String trackingNumber;

    private Double weight;

    private Double shippingCost;

    private Double orderCost;

}
