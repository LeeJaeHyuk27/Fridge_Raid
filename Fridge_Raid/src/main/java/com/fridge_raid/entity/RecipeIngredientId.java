package com.fridge_raid.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RecipeIngredientId implements Serializable {
	
    @Column(name = "RECIPE_ID")
    private Long recipeId;

    @Column(name = "INGREDIENT_ID")
    private Long ingredientId;

    public RecipeIngredientId() {}
    public RecipeIngredientId(Long recipeId, Long ingredientId) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeIngredientId)) return false;
        RecipeIngredientId that = (RecipeIngredientId) o;
        return Objects.equals(recipeId, that.recipeId) && Objects.equals(ingredientId, that.ingredientId);
    }
    @Override public int hashCode() { return Objects.hash(recipeId, ingredientId); }
}