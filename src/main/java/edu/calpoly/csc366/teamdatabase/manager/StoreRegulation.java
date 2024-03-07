package edu.calpoly.csc366.teamdatabase.manager;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "StoreRegulation")
public class StoreRegulation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storeRegulationsId;
    private Date date;
    private boolean current;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeId", nullable = false)
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regulationId", nullable = false)
    private Regulations regulations;

    public StoreRegulation() {

    }

    public StoreRegulation(int storeRegulationsId, Date date, boolean current, Store store, Regulations regulations) {
        this.storeRegulationsId = storeRegulationsId;
        this.date = date;
        this.current = current;
        this.store = store;
        this.regulations = regulations;
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
    public String toString() {
        return "StoreRegulation{" +
                ", date=" + date +
                ", current=" + current +
                '}';
    }
}
