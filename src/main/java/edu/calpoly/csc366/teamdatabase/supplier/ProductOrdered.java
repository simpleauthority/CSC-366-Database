package edu.calpoly.csc366.teamdatabase.supplier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;

import javax.validation.constraints.NotNull;

@Entity                   // this class maps to a database table
@Table(name = "productOrdered",
uniqueConstraints = @UniqueConstraint(columnNames={"orderNumber", "productId"}))  // (may be omitted for default table naming)
public class ProductOrdered {
	@ManyToOne
    @JoinColumn(name = "orderNumber")
	private Shipment shipment;

    @OneToOne
    @JoinColumn(name = "productId")
	private SuppliedProduct suppliedProduct;

	@NotNull
	private Double quantity;

    @NotNull
    private String quantityUnit;

}