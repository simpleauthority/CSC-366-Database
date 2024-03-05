package edu.calpoly.csc366.teamdatabase.manager;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int storeId;
    private String address;
    @Column(unique=true)
    private int managerId;
    private int size;
    private int salesTarget;
    private String region;
    public Store() {}

    public Store(int storeId, String address, int managerId, int size, int salesTarget, String region) {
        this.storeId = storeId;
        this.address = address;
        this.managerId = managerId;
        this.size = size;
        this.salesTarget = salesTarget;
        this.region = region;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSalesTarget() {
        return salesTarget;
    }

    public void setSalesTarget(int salesTarget) {
        this.salesTarget = salesTarget;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    // equals and hashCodes
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return storeId == store.storeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId);
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeId=" + storeId +
                ", address='" + address + '\'' +
                ", managerId=" + managerId +
                ", size=" + size +
                ", salesTarget=" + salesTarget +
                ", region='" + region + '\'' +
                '}';
    }
}
