package edu.calpoly.csc366.teamdatabase.supplier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import javax.validation.constraints.NotNull;

@Entity                   // this class maps to a database table
@Table(name = "shipment")   // (may be omitted for default table naming)
public class Shipment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderNumber;

    @Temporal(value = TemporalType.DATE)
	private Date shipmentDate;

    @Temporal(value = TemporalType.DATE)
    private Date expectedDeliveryDate;

    @Temporal(value = TemporalType.DATE)
    private Date actualDeliveryDate;

    private String deliveryCompany;

    private String trackingNumber;

    private Double weight;

    private Double shippingCost;

    private Double orderCost;

}
