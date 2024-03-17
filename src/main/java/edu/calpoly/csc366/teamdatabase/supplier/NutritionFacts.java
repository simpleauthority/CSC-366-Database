package edu.calpoly.csc366.teamdatabase.supplier;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "nutritionFacts")
public class NutritionFacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nutritionFactId;
    private String ingredient;
    private Double quantity;
    private String quantityUnit;

    @ManyToOne
    @JoinColumn(name = "productId")
    private SuppliedProduct product;


    public NutritionFacts() {}

    public NutritionFacts(String ingredient, Double quantity, String quantityUnit, SuppliedProduct product) {
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.quantityUnit = quantityUnit;
        this.product = product;
    }

    public SuppliedProduct getProduct() {
        return product;
    }
    
    public void setProduct(SuppliedProduct product) {
        this.product = product;
    }

    public int getNutritionFactId() {
        return nutritionFactId;
    }

    public void setNutritionFactId(int nutritionFactId) {
        this.nutritionFactId = nutritionFactId;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getQuantityUnit() {
        return quantityUnit;
    }

    public void setQuantityUnit(String quantityUnit) {
        this.quantityUnit = quantityUnit;
    }
}