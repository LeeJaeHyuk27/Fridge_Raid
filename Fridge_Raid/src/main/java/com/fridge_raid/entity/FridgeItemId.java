package com.fridge_raid.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FridgeItemId implements Serializable {
    @Column(name = "USER_ID", length = 50)
    private String userId;

    @Column(name = "INGREDIENT_ID")
    private Long ingredientId;

    public FridgeItemId() {}
    public FridgeItemId(String userId, Long ingredientId) {
        this.userId = userId;
        this.ingredientId = ingredientId;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FridgeItemId)) return false;
        FridgeItemId that = (FridgeItemId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(ingredientId, that.ingredientId);
    }
    @Override public int hashCode() { return Objects.hash(userId, ingredientId); }
}