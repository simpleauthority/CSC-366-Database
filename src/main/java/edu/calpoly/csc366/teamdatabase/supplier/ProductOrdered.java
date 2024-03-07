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

@Entity                   // this class maps to a database table
@Table(name = "productOrdered", uniqueConstraints = @UniqueConstraint(columnNames = {"orderNumber", "productId"}))
// (may be omitted for default table naming)
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
        private Long orderNumber;
        private Long productId;
    }
}