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
public class HealthInspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int healthInspectionId;

    @ManyToOne
    @JoinColumn(name = "storeId")
    private Store store;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String grade;

    public HealthInspection(int healthInspectionId, Store store, Date date, String grade) {
        this.healthInspectionId = healthInspectionId;
        this.store = store;
        this.date = date;
        this.grade = grade;
    }

    public HealthInspection() {

    }

    public int getHealthInspectionId() {
        return healthInspectionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthInspection inspection = (HealthInspection) o;
        return healthInspectionId == inspection.healthInspectionId
                && store.equals(inspection.store)
                && Objects.equals(date, inspection.date)
                && grade.equals(inspection.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(healthInspectionId);
    }

    @Override
    public String toString() {
        return "HealthInspection{" +
                "HealthInspectionId=" + healthInspectionId +
                ", date=" + date +
                ", store='" + store + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
