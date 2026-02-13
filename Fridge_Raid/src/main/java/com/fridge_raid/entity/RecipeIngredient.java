package com.fridge_raid.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "RECIPE_INGREDIENT")
public class RecipeIngredient {

    @EmbeddedId
    private RecipeIngredientId id;

    @MapsId("recipeId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECIPE_ID", nullable = false)
    private Recipe recipe;

    @MapsId("ingredientId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INGREDIENT_ID", nullable = false)
    private Ingredient ingredient;

    @Column(name = "AMOUNT", length = 50)
    private String amount;

    @Column(name = "IS_OPTIONAL", nullable = false)
    private Boolean isOptional = false;
}