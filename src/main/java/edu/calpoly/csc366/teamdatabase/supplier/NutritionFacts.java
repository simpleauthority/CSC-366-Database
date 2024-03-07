package edu.calpoly.csc366.teamdatabase.supplier;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.HashSet;

@Entity                   // this class maps to a database table
@Table(name = "nutritionFacts")  // (may be omitted for default table naming)
@IdClass(NutritionFacts.NutritionFactsId.class)
public class NutritionFacts {
    @ManyToMany(mappedBy = "productId")
    private HashSet<SuppliedProduct> product = new HashSet<>();

    @Id
    private String ingredient;

    @Id
    private Double quantity;

    @Id
    private String quantityUnit;

    public static class NutritionFactsId implements Serializable {
        private String ingredient;
        private Double quantity;
        private String quantityUnit;
    }
}
