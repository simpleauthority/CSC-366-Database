package edu.calpoly.csc366.teamdatabase.manager;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "rent")
public class CustomerFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedbackId;
    private int storeId;
    private int customerId;
    private polarity polarity;
    private String comment;
    private Date date;

    public enum polarity {
        POSITIVE,
        NEGATIVE
    }
    public CustomerFeedback () {}
    public CustomerFeedback(int feedbackId, int storeId, int customerId, CustomerFeedback.polarity polarity, String comment, Date date) {
        this.feedbackId = feedbackId;
        this.storeId = storeId;
        this.customerId = customerId;
        this.polarity = polarity;
        this.comment = comment;
        this.date = date;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
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
                ", storeId=" + storeId +
                ", customerId=" + customerId +
                ", polarity=" + polarity +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }
}
