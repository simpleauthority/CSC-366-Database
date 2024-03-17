package edu.calpoly.csc366.teamdatabase.supplier;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "supplierContract", uniqueConstraints = @UniqueConstraint(columnNames = {"contractName", "supplier", "signDate", "expirationDate"}))
@IdClass(SupplierContract.SupplierContractId.class)
public class SupplierContract {
    @Id
    @ManyToOne
    @JoinColumn(name = "supplier")
    private Supplier supplier;

    @Id
    private String contractName;

    @Id
    @Temporal(value = TemporalType.DATE)
    private Date signDate;

    @Id
    @Temporal(value = TemporalType.DATE)
    private Date expirationDate;

    public SupplierContract() {
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public static class SupplierContractId implements Serializable {
        private Supplier supplier;
        private String contractName;
        private Date signDate;
        private Date expirationDate;
    }
}