package edu.calpoly.csc366.teamdatabase.regulator_auditor_taxAuth;

import edu.calpoly.csc366.teamdatabase.manager.Store;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;
import java.util.Objects;

@Entity
public class Permit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int permitId;

    @ManyToOne
    @JoinColumn(name = "storeId")
    private Store store;

    @Temporal(TemporalType.DATE)
    private Date issueDate;

    @Temporal(TemporalType.DATE)
    private Date renewalDate;

    private String type;

    public Permit(int permitId, Store store, Date issueDate, Date renewalDate, String type) {
        this.permitId = permitId;
        this.store = store;
        this.issueDate = issueDate;
        this.renewalDate = renewalDate;
        this.type = type;
    }

    public Permit() {

    }

    public int getPermitId() {
        return permitId;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(Date renewalDate) {
        this.renewalDate = renewalDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permit permit = (Permit) o;
        return permitId == permit.permitId
                && store.equals(permit.store)
                && Objects.equals(issueDate, permit.issueDate)
                && Objects.equals(renewalDate, permit.renewalDate)
                && type.equals(permit.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permitId);
    }

    @Override
    public String toString() {
        return "Permit{" +
                "permitId=" + permitId +
                ", store='" + store + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", renewalDate='" + renewalDate + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}