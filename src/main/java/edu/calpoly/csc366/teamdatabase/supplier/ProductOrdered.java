package edu.calpoly.csc366.teamdatabase.supplier;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.io.Serializable;

@Entity
@Table(name = "productOrdered", uniqueConstraints = @UniqueConstraint(columnNames = {"orderNumber", "productId"}))
@IdClass(ProductOrdered.ProductOrderedId.class)
public class ProductOrdered {
    @Id
    @ManyToOne
    @JoinColumn(name = "orderNumber")
    private Shipment shipment;

    @Id
    @OneToOne
    @JoinColumn(name = "productId")
    private SuppliedProduct suppliedProduct;

    private Double quantity;

    private String quantityUnit;

    public ProductOrdered() {
    }

    public ProductOrdered(Shipment shipment, SuppliedProduct suppliedProduct, Double quantity, String quantityUnit) {
        this.shipment = shipment;
        this.suppliedProduct = suppliedProduct;
        this.quantity = quantity;
        this.quantityUnit = quantityUnit;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public SuppliedProduct getSuppliedProduct() {
        return suppliedProduct;
    }

    public void setSuppliedProduct(SuppliedProduct suppliedProduct) {
        this.suppliedProduct = suppliedProduct;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getQuantityUnit() {
        return quantityUnit;
    }

    public void setQuantityUnit(String quantityUnit) {
        this.quantityUnit = quantityUnit;
    }

    public static class ProductOrderedId implements Serializable {
        private Shipment shipment;
        private SuppliedProduct suppliedProduct;
    }
}