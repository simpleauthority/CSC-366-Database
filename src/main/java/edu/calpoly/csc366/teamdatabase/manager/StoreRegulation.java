package edu.calpoly.csc366.teamdatabase.manager;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name="StoreRegulation")
public class StoreRegulation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int storeId;
    private int regulationId;
    private Date date;
    private boolean current;

    public StoreRegulation() {

    }
    public StoreRegulation(int storeId, int regulationId, Date date, boolean current) {
        this.storeId = storeId;
        this.regulationId = regulationId;
        this.date = date;
        this.current = current;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getRegulationId() {
        return regulationId;
    }

    public void setRegulationId(int regulationId) {
        this.regulationId = regulationId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreRegulation that = (StoreRegulation) o;
        return storeId == that.storeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId);
    }

    @Override
    public String toString() {
        return "StoreRegulation{" +
                "storeId=" + storeId +
                ", regulationId=" + regulationId +
                ", date=" + date +
                ", current=" + current +
                '}';
    }
}
