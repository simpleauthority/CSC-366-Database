package edu.calpoly.csc366.teamdatabase.supplier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;

import javax.validation.constraints.NotNull;

@Entity                   // this class maps to a database table
@Table(name = "nutritionFacts")  // (may be omitted for default table naming)
public class NutritionFacts {

    @ManyToMany(mappedBy = "productId")
    private HashSet<SuppliedProduct> product = new HashSet<>();

	private String ingredient;

	private Double quantity;

	private String quantityUnit;

}
