package edu.calpoly.csc366.teamdatabase.supplier;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity                   // this class maps to a database table
@Table(name = "suppliedProduct")  // (may be omitted for default table naming)
public class SuppliedProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "nutritionFactId")
    private NutritionFacts nutritionFacts;
}
