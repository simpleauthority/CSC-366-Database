package edu.calpoly.csc366.teamdatabase.manager;

import edu.calpoly.csc366.teamdatabase.supplier.SuppliedProduct;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "Inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inventoryId;

    @OneToOne
    @JoinColumn(name = "productId", nullable = false)
    private SuppliedProduct product;
    private int quantity;
    private int restockLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeId", nullable = false)
    private Store store;

    public Inventory() {
    }

    public Inventory(int inventoryId, SuppliedProduct product, int quantity, int restockLevel, Store store) {
        this.inventoryId = inventoryId;
        this.product = product;
        this.quantity = quantity;
        this.restockLevel = restockLevel;
        this.store = store;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public SuppliedProduct getProduct() {
        return product;
    }

    public void setProduct(SuppliedProduct product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRestockLevel() {
        return restockLevel;
    }

    public void setRestockLevel(int restockLevel) {
        this.restockLevel = restockLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return inventoryId == inventory.inventoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryId);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", product=" + product +
                ", quantity=" + quantity +
                ", restockLevel=" + restockLevel +
                ", store=" + store +
                '}';
    }
}
