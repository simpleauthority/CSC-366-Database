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

@Entity                   // this class maps to a database table
@Table(name = "supplierContract", uniqueConstraints = @UniqueConstraint(columnNames = {"contractName", "supplier", "signDate", "expirationDate"}))
// (may be omitted for default table naming)
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

    public static class SupplierContractId implements Serializable {
        private Long supplierId;
        private String contractName;
        private Date signDate;
        private Date expirationDate;
    }
}
