package com.fridge_raid.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "INGREDIENT")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INGREDIENT_ID")
    private Long ingredientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ING_TYPE_ID", nullable = false)
    private IngredientType ingTypeId;

    @Column(name = "NAME", length = 100, nullable = false, unique = true)
    private String name;
    
}
