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

    public static class ProductOrderedId implements Serializable {
        private Shipment shipment;
        private SuppliedProduct suppliedProduct;
    }
}