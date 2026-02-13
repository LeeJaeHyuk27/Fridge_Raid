package com.fridge_raid.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RecipeTagId implements Serializable {
    @Column(name = "RECIPE_ID")
    private Long recipeId;

    @Column(name = "TAG_ID")
    private Long tagId;

    public RecipeTagId() {}
    public RecipeTagId(Long recipeId, Long tagId) {
        this.recipeId = recipeId;
        this.tagId = tagId;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeTagId)) return false;
        RecipeTagId that = (RecipeTagId) o;
        return Objects.equals(recipeId, that.recipeId) && Objects.equals(tagId, that.tagId);
    }
    @Override public int hashCode() { return Objects.hash(recipeId, tagId); }
}
