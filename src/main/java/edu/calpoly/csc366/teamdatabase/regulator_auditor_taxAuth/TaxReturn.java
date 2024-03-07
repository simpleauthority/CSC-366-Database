package edu.calpoly.csc366.teamdatabase.regulator_auditor_taxAuth;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;
import java.util.Objects;

@Entity
public class TaxReturn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int returnId;

    @Temporal(TemporalType.DATE)
    private Date filingDate;

    private String country;
    private String region;
    private String type;

    public TaxReturn(int returnId, Date filingDate, String country, String region, String type) {
        this.returnId = returnId;
        this.filingDate = filingDate;
        this.country = country;
        this.region = region;
        this.type = type;
    }

    public TaxReturn() {

    }

    public int getReturnId() {
        return returnId;
    }

    public Date getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(Date filingDate) {
        this.filingDate = filingDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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
        TaxReturn taxReturn = (TaxReturn) o;
        return returnId == taxReturn.returnId
                && Objects.equals(filingDate, taxReturn.filingDate)
                && country.equals(taxReturn.country)
                && region.equals(taxReturn.region)
                && type.equals(taxReturn.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(returnId);
    }

    @Override
    public String toString() {
        return "TaxReturn{" +
                "returnId=" + returnId +
                ", filingDate='" + filingDate + '\'' +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
