package edu.calpoly.csc366.teamdatabase.supplier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Table;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;

import javax.validation.constraints.NotNull;

@Entity                   // this class maps to a database table
@Table(name = "productTag")   // (may be omitted for default table naming)
public class ProductTag {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    @ManyToOne
    @JoinColumn(name = "productId")
	private SuppliedProduct suppliedProduct;

	private String category;

	private Double price;
    private Double cost;

    @Temporal(value = TemporalType.DATE)
    private Date date;

}