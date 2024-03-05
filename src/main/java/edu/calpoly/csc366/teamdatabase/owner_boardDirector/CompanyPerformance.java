package main.java.edu.calpoly.csc366.teamdatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringJoiner;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.util.Date;

@Entity
public class CompanyPerformance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int performanceID;

    @Temporal(TemporalType.DATE)
    private Date performanceDate;
    private int revenue;
    private int profitMargin;
    private float growthRate;

    // Default constructor
    public CompanyPerformance() {
    }

    // Parameterized constructor
    public CompanyPerformance(Date performanceDate, int revenue, int profitMargin, float growthRate) {
        this.performanceDate = performanceDate;
        this.revenue = revenue;
        this.profitMargin = profitMargin;
        this.growthRate = growthRate;
    }

    // Getters and setters
    public int getPerformanceID() {
        return performanceID;
    }

    public void setPerformanceID(int performanceID) {
        this.performanceID = performanceID;
    }

    public Date getPerformanceDate() {
        return performanceDate;
    }

    public void setPerformanceDate(Date performanceDate) {
        this.performanceDate = performanceDate;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(int profitMargin) {
        this.profitMargin = profitMargin;
    }

    public float getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(float growthRate) {
        this.growthRate = growthRate;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanyPerformance)) return false;
        CompanyPerformance that = (CompanyPerformance) o;
        return getPerformanceID() == that.getPerformanceID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPerformanceID());
    }

    // toString() method
    @Override
    public String toString() {
        return "CompanyPerformance{" +
                "performanceID=" + performanceID +
                ", performanceDate=" + performanceDate +
                ", revenue=" + revenue +
                ", profitMargin=" + profitMargin +
                ", growthRate=" + growthRate +
                '}';
    }
}
