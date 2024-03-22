package edu.calpoly.csc366.teamdatabase.manager;

import edu.calpoly.csc366.teamdatabase.employee.Employee;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storeId;
    private String address;
    private int size;
    private int salesTarget;
    private String region;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", nullable = false)
    private Manager manager;

    public Store() {
    }

    public Store(String address, int size, int salesTarget, String region) {
        this.address = address;
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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
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
                ", size=" + size +
                ", salesTarget=" + salesTarget +
                ", region='" + region + '\'' +
                '}';
    }
}
