package edu.calpoly.csc366.teamdatabase.manager;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
public class CustomerFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedbackId;
    private int customerId;
    private polarity polarity;
    private String comment;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeId", nullable = false)
    private Store store;

    public CustomerFeedback() {
    }

    public CustomerFeedback(int feedbackId, int customerId, CustomerFeedback.polarity polarity, String comment, Date date, Store store) {
        this.feedbackId = feedbackId;
        this.customerId = customerId;
        this.polarity = polarity;
        this.comment = comment;
        this.date = date;
        this.store = store;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public CustomerFeedback.polarity getPolarity() {
        return polarity;
    }

    public void setPolarity(CustomerFeedback.polarity polarity) {
        this.polarity = polarity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerFeedback that = (CustomerFeedback) o;
        return feedbackId == that.feedbackId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackId);
    }

    @Override
    public String toString() {
        return "CustomerFeedback{" +
                "feedbackId=" + feedbackId +
                ", customerId=" + customerId +
                ", polarity=" + polarity +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }

    public enum polarity {
        POSITIVE,
        NEGATIVE
    }
}
