package com.fridge_raid.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "INGREDIENT_TYPE")
public class IngredientType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ING_TYPE_ID")
    private Long id;

    @Column(name = "ING_TYPE_NAME", length = 50, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
    private List<Ingredient> ingredients = new ArrayList<>();

}