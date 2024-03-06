package edu.calpoly.csc366.teamdatabase.manager;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Maintence")
public class Maintence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int serviceId;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String description;
    private String provider;
    private float cost;
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    private String Note;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeId", nullable = false)
    private Store store;
    public Maintence() {}

    public Maintence(int serviceId, Date date, String description, String provider, float cost, Date dueDate, Date paymentDate, String note, Store store) {
        this.serviceId = serviceId;
        this.date = date;
        this.description = description;
        this.provider = provider;
        this.cost = cost;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        Note = note;
        this.store = store;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Maintence maintence = (Maintence) o;
        return serviceId == maintence.serviceId && Objects.equals(paymentDate, maintence.paymentDate) && Objects.equals(Note, maintence.Note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, paymentDate, Note);
    }

    @Override
    public String toString() {
        return "Maintence{" +
                "serviceId=" + serviceId +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", provider='" + provider + '\'' +
                ", cost=" + cost +
                ", dueDate=" + dueDate +
                ", paymentDate=" + paymentDate +
                ", Note='" + Note + '\'' +
                '}';
    }
}
