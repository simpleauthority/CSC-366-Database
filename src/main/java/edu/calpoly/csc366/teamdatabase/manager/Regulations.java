package edu.calpoly.csc366.teamdatabase.manager;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Regulations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int regulationId;
    private String title;
    private Regs regulations;
    @Temporal(TemporalType.DATE)
    private Date effectiveDate;
    @Temporal(TemporalType.DATE)
    private Date lastUpdated;

    public enum Regs {
        EMPLOYMENT,
        ENVIRONMENTAL,
        CORPORATE,
        CONSUMER,
        INDUSTRY
    }


    public Regulations() {}
    public Regulations(int regulationId, String title, Regs regulations, Date effectiveDate, Date lastUpdated) {
        this.regulationId = regulationId;
        this.title = title;
        this.regulations = regulations;
        this.effectiveDate = effectiveDate;
        this.lastUpdated = lastUpdated;
    }

    public int getRegulationId() {
        return regulationId;
    }

    public void setRegulationId(int regulationId) {
        this.regulationId = regulationId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Regs getRegulations() {
        return regulations;
    }

    public void setRegulations(Regs regulations) {
        this.regulations = regulations;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Regulations that = (Regulations) o;
        return regulationId == that.regulationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(regulationId);
    }

    @Override
    public String toString() {
        return "Regulations{" +
                "regulationId=" + regulationId +
                ", title='" + title + '\'' +
                ", regulations=" + regulations +
                ", effectiveDate=" + effectiveDate +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
