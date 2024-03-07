package edu.calpoly.csc366.teamdatabase.supplier;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "nutritionFacts")
public class NutritionFacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int nutritionFactId;
    private String ingredient;
    private Double quantity;
    private String quantityUnit;
}
