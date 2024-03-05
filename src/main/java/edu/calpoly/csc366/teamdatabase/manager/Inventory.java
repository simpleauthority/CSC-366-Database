package edu.calpoly.csc366.teamdatabase.manager;

import jakarta.persistence.*;


import java.util.Objects;

@Entity
@Table(name = "Inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int inventoryId;
    private int storeId;
    private int productId;
    private int quantity;
    private int restockLevel;
    public Inventory() {}

    public Inventory(int inventoryId, int storeId, int productId, int quantity, int restockLevel) {
        this.inventoryId = inventoryId;
        this.storeId = storeId;
        this.productId = productId;
        this.quantity = quantity;
        this.restockLevel = restockLevel;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
                ", storeId=" + storeId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", restockLevel=" + restockLevel +
                '}';
    }
}