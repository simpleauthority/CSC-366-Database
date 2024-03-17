package edu.calpoly.csc366.teamdatabase.supplier;
import edu.calpoly.csc366.teamdatabase.manager.Store;


import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "shipment")
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

    private String deliveryCompany;
    @ManyToOne
    @JoinColumn(name = "supplierId", nullable = false)
    private Supplier supplier;

    private String trackingNumber;

    private Double weight;

    private Double shippingCost;

    private Double orderCost;

//    @ManyToOne
//    @JoinColumn(name = "storeId")
//    private Store destinationStore;

    @OneToMany(mappedBy = "shipment")
    private List<ProductOrdered> productOrderedList;

    public Shipment() {
    }

    public Shipment(Date shipmentDate, Date expectedDeliveryDate, Date actualDeliveryDate, Supplier supplier, String deliveryCompany, String trackingNumber, Double weight, Double shippingCost, Double orderCost) {
        this.shipmentDate = shipmentDate;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.actualDeliveryDate = actualDeliveryDate;
        this.deliveryCompany = deliveryCompany;
        this.trackingNumber = trackingNumber;
        this.weight = weight;
        this.shippingCost = shippingCost;
        this.orderCost = orderCost;
        this.supplier = supplier;
        this.productOrderedList = new ArrayList<>();
    }

    public List<ProductOrdered> getProductOrderedList() {
        return productOrderedList;
    }

    public void setProductOrderedList(List<ProductOrdered> productOrderedList) {
        this.productOrderedList = productOrderedList;
    }

    public void addProductOrdered(ProductOrdered productOrdered) {
        this.productOrderedList.add(productOrdered);
    }

    public void removeProductOrdered(ProductOrdered productOrdered) {
        this.productOrderedList.remove(productOrdered);
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

//    public Store getDestinationStore() {
//        return destinationStore;
//    }
//
//    public void setDestinationStore(Store destinationStore) {
//        this.destinationStore = destinationStore;
//    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public Date getActualDeliveryDate() {
        return actualDeliveryDate;
    }

    public void setActualDeliveryDate(Date actualDeliveryDate) {
        this.actualDeliveryDate = actualDeliveryDate;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Double getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(Double orderCost) {
        this.orderCost = orderCost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Shipment other = (Shipment) obj;
        return Objects.equals(orderNumber, other.orderNumber);
    }
}