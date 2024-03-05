package edu.calpoly.csc366.teamdatabase.supplier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;

import javax.validation.constraints.NotNull;

@Entity                   // this class maps to a database table
@Table(name = "supplierContract",
       uniqueConstraints = @UniqueConstraint(columnNames={"contractName", "supplier", "signDate", "expirationDate"}))   // (may be omitted for default table naming)

public class SupplierContract {
    @NotNull
    private String contractName;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "supplier")
    private Supplier supplier;

    @NotNull
    @Temporal(value = TemporalType.DATE)
	private Date signDate;

    @Temporal(value = TemporalType.DATE)
	private Date expirationDate;

}
